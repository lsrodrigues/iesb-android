package com.example.lucas.aluno_online.Controller

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.lucas.aluno_online.Entity.AppDatabase
import com.example.lucas.aluno_online.Entity.User
import com.example.lucas.aluno_online.R
import com.example.lucas.aluno_online.Validator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        createBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, NewUserActivity::class.java))
        }

        login.setOnClickListener {
            var u : User = User()
            u.mail = txt_email.text.toString()
            u.password = txt_senha.text.toString()

            if(u.mail.toString().isEmpty() || u.password.toString().isEmpty()){
                Toast.makeText(this, "Preencha o campo Email e/ou Senha", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var validator : Validator = Validator()
            if(!validator.validateEmail(u.mail.toString())){
                Toast.makeText(this, "Email inválido", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var db = Room.databaseBuilder(applicationContext,
                    AppDatabase::class.java, "alunonline").allowMainThreadQueries().build()


            var user: User = db.usuarioDao().findUserByEmailAndPass(u.mail.toString(), u.password.toString())
            if(user != null) {

                val it = Intent(this@LoginActivity, UserNewsListActivity::class.java)
                it.putExtra("email", u.mail)
                it.putExtra("senha", u.password)
                db.close()
                startActivity(it)
                finish()
            }else{
                Toast.makeText(this, "Verifique o email ou a senha", Toast.LENGTH_LONG).show()
                txt_email.text = Editable.Factory.getInstance().newEditable("")
            }
        }
    }
}
