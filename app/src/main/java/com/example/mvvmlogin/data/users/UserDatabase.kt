package com.example.mvvmlogin.data.users

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.data.users.entities.UserEntity

@Database(entities = [UserEntity::class], version = 3, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}