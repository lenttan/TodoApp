package com.ubaya.todoapp.view

import android.view.View
import android.widget.CompoundButton
import com.ubaya.todoapp.model.Todo

interface TodoCheckedChangeListener{
    fun onCheckChanged(cb: CompoundButton, isChecked:Boolean, obj: Todo)
}

interface TodoEditClickListener{
    fun onCLick(view:View)
}

interface TodoPriorityCLick{
    fun onRadioPriorityCLick(view: View, priority: Int, obj: Todo)
}

interface TodoSaveChangesListener{
    fun onSaveChanges(view:View, obj:Todo)
}