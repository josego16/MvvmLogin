package com.example.mvvmlogin.data.users.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmlogin.data.users.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM tblusers WHERE email = :email and password =:password")
    suspend fun login(email: String, password: String): UserEntity

    @Query("SELECT * FROM tblusers WHERE name = :name") // Para el registro (ver si ya existen usuarios con el mismo username)
    suspend fun getUserByUsername(name: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun register(vararg user: UserEntity)

}