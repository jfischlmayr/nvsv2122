package com.example.room.mvvm.room

import android.content.Context
import androidx.room.*
import com.example.room.mvvm.model.LoginTableModel

@Database(entities = [LoginTableModel::class], version = 1)
abstract class LoginDatabase : RoomDatabase() {

    abstract fun loginDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: LoginDatabase? = null

        fun getDataseClient(context: Context) : LoginDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = null
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    LoginDatabase::class.java,
                    "Credentials"
                ).build()

                return INSTANCE!!

            }
        }
    }
}