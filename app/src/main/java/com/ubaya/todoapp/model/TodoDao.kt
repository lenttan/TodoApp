package com.ubaya.todoapp.model

import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg todo: Todo)

    @Query("Select * from todo order by priority DESC")
    suspend fun selectAllTodo(): List<Todo>

    @Query("Select * From todo where uuid = :id")
    suspend fun selectTodo(id: Int): Todo

    @Query("Update todo set title = :title, notes = :notes, priority = :priority Where uuid = :id")
    suspend fun update(id:Int,title:String,notes:String,priority:Int)

    @Delete
    suspend fun deleteTodo(todo: Todo)
}