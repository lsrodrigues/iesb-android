package com.example.lucas.aluno_online.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lucas.aluno_online.Entity.New
import com.example.lucas.aluno_online.R
import com.example.lucas.aluno_online.Services.NewDatas
import com.example.lucas.aluno_online.View.NewItem
import kotlinx.android.synthetic.main.activity_user_news_list.*

class UserNewsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_news_list)

        val bannerImagesIndex: Array<Int> = arrayOf(R.drawable.iesb, R.drawable.iesb, R.drawable.iesb)
        banner.photoResourcesIndex = bannerImagesIndex
        banner.transitionTime = 3000

        var news = NewDatas.getAllNews();
        for (new in news) {
            val newItem = NewItem(new.title, new.description, new.datePosted, new.image, this)
            newItem.setOnClickListener { goToNewDetail(new) }
            container.addView(newItem)
        }
    }

    private fun goToNewDetail(new: New) {
        val intent = Intent(this@UserNewsListActivity, NewDetailActivity::class.java)
        intent.putExtra("title",new.title)
        intent.putExtra("description",new.description)
        intent.putExtra("datePosted",new.datePosted)
        startActivity(intent)
    }


}
