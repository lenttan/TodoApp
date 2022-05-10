package com.ubaya.todoapp.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ubaya.todoapp.model.TodoDatabase

val DB_NAME = "newtododb"

fun buildDb(context: Context): TodoDatabase{
    val db = Room.databaseBuilder(context, TodoDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2, Migration_2_3)
        .build()

    return db
}

val MIGRATION_1_2 = object :Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("Alter table todo add column priority INTEGER Default 3 not null")
    }

}

val Migration_2_3 = object :Migration(2,3){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("Alter table todo add column is_done INTEGER Default 0 not null")
        //
    }
}