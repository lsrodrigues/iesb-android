package com.example.lucas.aluno_online.Entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
class User {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var mail: String? = null
    var password: String? = null
    var code: String? = null
    var phone: String? = null

    constructor() {}

    constructor(id: Int, mail: String, password: String, code: String, phone: String) {
        this.id = id
        this.mail = mail
        this.password = password
        this.code = code
        this.phone = phone
    }

    constructor(mail: String, password: String) {
        this.mail = mail
        this.password = password
    }

}