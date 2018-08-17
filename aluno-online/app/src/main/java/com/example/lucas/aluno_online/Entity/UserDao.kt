package com.example.lucas.aluno_online.Entity

import android.arch.persistence.room.*

@Dao
interface UserDao {
    @get:Query("SELECT * FROM user")
    val all: List<User>

    @Query("SELECT * FROM user WHERE id IN (:id)")
    fun loadAllById(id: Int): User

    @Query("SELECT * FROM user WHERE mail = :mail AND password = :password")
    fun findUserByEmailAndPass(mail: String, password: String): User

    @Query("SELECT * FROM user WHERE mail = :mail")
    fun findUserByMail(mail: String): User

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)
}