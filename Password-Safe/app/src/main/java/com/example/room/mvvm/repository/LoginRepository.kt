package com.example.room.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.room.mvvm.model.LoginTableModel
import com.example.room.mvvm.room.LoginDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginRepository {

    companion object {

        var loginDatabase: LoginDatabase? = null

        var loginTableModel: LiveData<LoginTableModel>? = null

        fun initializeDB(context: Context) : LoginDatabase {
            return LoginDatabase.getDataseClient(context)
        }

        fun insertData(context: Context, username: String, password: String) {

            loginDatabase = initializeDB(context)
            var dao = loginDatabase!!.loginDao()

            CoroutineScope(IO).launch {
                val loginDetails = LoginTableModel(username, password)

                dao.removeLoginDetails(username)
                dao.InsertData(loginDetails)
            }
        }

        fun getLoginDetails(context: Context, username: String) : LiveData<LoginTableModel>? {
            loginDatabase = initializeDB(context)
            var dao = loginDatabase!!.loginDao()

            loginTableModel = dao.getLoginDetails(username)

            return loginTableModel
        }
    }
}