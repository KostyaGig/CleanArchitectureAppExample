package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val TABLE_NAME = "mytable"

@Entity(tableName = TABLE_NAME)
data class Post(
    @ColumnInfo(name = "userId") @PrimaryKey val userId: Int,
    @ColumnInfo(name = "postId") val postId:Int,
    @ColumnInfo(name ="postTitle") val postTitle:String,
    @ColumnInfo(name = "postBody") val postBody:String,
    @ColumnInfo(name = "timeGettingPost") val gettingPostTime: String
) {
}
