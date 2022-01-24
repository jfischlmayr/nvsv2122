package com.example.room.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Credentials")
data class LoginTableModel (
    @ColumnInfo(name = "Username")
    var Username: String,
    @ColumnInfo(name = "Password")
    var Password: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null
}