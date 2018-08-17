package com.example.lucas.aluno_online.Services

import com.example.lucas.aluno_online.Entity.New

class NewDatas {
    companion object {
        fun getAllNews(): List<New> {

            val title = "Title"
            val date = "08/08/2018"
            val image = "iesb"
            val description = "Existem muitas variações disponíveis de passagens de Lorem Ipsum, mas a maioria sofreu algum tipo de alteração, seja por inserção de passagens com humor, ou palavras aleatórias que não parecem nem um pouco convincentes. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

            return listOf(
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description),
                    New(title, date, image, description)
            )
        }
    }
}