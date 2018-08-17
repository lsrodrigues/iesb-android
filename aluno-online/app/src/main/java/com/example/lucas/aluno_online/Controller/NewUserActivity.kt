package com.example.lucas.aluno_online.Controller

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lucas.aluno_online.Entity.AppDatabase
import com.example.lucas.aluno_online.R
import com.example.lucas.aluno_online.Validator
import kotlinx.android.synthetic.main.activity_new_user.*
import com.example.lucas.aluno_online.Entity.User
import com.example.lucas.aluno_online.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class NewUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        createAccount.setOnClickListener {
            var validator =  Validator()

            if(txt_create_email.text.toString().isEmpty() || txt_create_senha.text.toString().isEmpty() || txt_confirma_senha.text.toString().isEmpty()){
                Toast.makeText(this, "Preencha os campos obrigatórios", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(!validator.validateConfirmPassword(txt_create_senha.text.toString(), txt_confirma_senha.text.toString())){
                Toast.makeText(this, "Senhas são diferentes", Toast.LENGTH_LONG).show()
                txt_create_senha.setText("")
                txt_confirma_senha.setText("")
                return@setOnClickListener
            }

            if(!validator.validatePassword(txt_create_senha.text.toString())){
                Toast.makeText(this, "A senha deve conter 6 dígitos, e conter pelo menos um caractere maiúsculo, um caractere especial e um número", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(!validator.validateEmail(txt_create_email.text.toString())){
                Toast.makeText(this, "Email inválido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var u = User(txt_create_email.text.toString(), txt_confirma_senha.text.toString())

            var db = Room.databaseBuilder(applicationContext,
                    AppDatabase::class.java, "alunonline").allowMainThreadQueries().build()

            var isRegistered = false
            val lista:List<User>? = db.usuarioDao().all
            if(lista != null) {
                for (p in lista) {

                    Log.i("Novou usuario: ", p.mail+" "+p.password+" ")

                    if(p.mail == u.mail){
                        isRegistered = true
                    }
                }
            }

            if(!isRegistered) {
                db.usuarioDao().insert(u)
                Toast.makeText(this, "Conta criada com sucesso", Toast.LENGTH_LONG).show()
                db.close()
                startActivity(Intent(this@NewUserActivity, LoginActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Existe usuário cadastrado com esse e-mail", Toast.LENGTH_LONG).show()
            }
        }

    }
}
