package com.example.room.mvvm.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.room.mvvm.model.LoginTableModel

@Dao
interface DAOAccess {

    @Insert
    suspend fun InsertData(loginTableModel: LoginTableModel)

    @Update
    suspend fun UpdateData(loginTableModel: LoginTableModel)

    @Query("SELECT * FROM Credentials WHERE Username LIKE :username")
    fun getLoginDetails(username: String?) : LiveData<LoginTableModel>

    @Query("DELETE FROM Credentials WHERE Username LIKE :username")
    fun removeLoginDetails(username: String?)

}