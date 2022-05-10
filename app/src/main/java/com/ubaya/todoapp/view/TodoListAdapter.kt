package com.ubaya.todoapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.todoapp.R
import com.ubaya.todoapp.databinding.LayoutTodoItemBinding
import com.ubaya.todoapp.model.Todo
import kotlinx.android.synthetic.main.layout_todo_item.view.*

class TodoListAdapter(val todoList: ArrayList<Todo>, val adapterOnClick: (Todo)->Unit) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>(), TodoCheckedChangeListener,TodoEditClickListener {
    class TodoViewHolder(var view:LayoutTodoItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = DataBindingUtil.inflate<LayoutTodoItemBinding>(inflater,R.layout.layout_todo_item, parent, false)
        val view = LayoutTodoItemBinding.inflate(inflater,parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.view.todo=todo
        holder.view.checkBoxListener = this
        holder.view.editListener=this

//        with(holder.view){
//            val priority = when (todo.priority) {
//                1 -> "Low"
//                2 -> "Medium"
//                else -> "HIGH"
//            }
//            checkTask.text = "[$priority] ${todo.title}"
//
//            checkTask.setOnCheckedChangeListener { compoundButton, b ->
//                if (b) adapterOnClick(todo)
//            }
//
//            btnEdit.setOnClickListener {
//                val action = TodoListFragmentDirections.actionEditTodo(todo.uuid)
//                Navigation.findNavController(it).navigate(action)
//            }
//        }

    }

    fun updateTodoList(new:List<Todo>){
        todoList.clear()
        todoList.addAll(new)
        notifyDataSetChanged()
    }

    override fun getItemCount()=todoList.size
    override fun onCheckChanged(cb: CompoundButton, isChecked: Boolean, obj: Todo) {
        if(isChecked){
            adapterOnClick(obj)
        }
    }

    override fun onCLick(view: View) {
        val action = TodoListFragmentDirections.actionEditTodo(view.tag.toString().toInt())
        Navigation.findNavController(view).navigate(action)
    }
}