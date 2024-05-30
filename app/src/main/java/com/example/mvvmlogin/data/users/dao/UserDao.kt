package com.example.mvvmlogin.data.users.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmlogin.data.users.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE name = :name AND password = :password") // Para el login
    suspend fun login(name: String, password: String) : UserEntity

    @Query("SELECT * FROM users WHERE name = :name") // Para el registro (ver si ya existen usuarios con el mismo username)
    suspend fun getUserByUsername(name: String) : UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun register(vararg user: UserEntity)
}