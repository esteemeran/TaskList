package com.example.TaskListKotlin.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.TaskListKotlin.R
import com.example.TaskListKotlin.domain.models.Task
import com.example.TaskListKotlin.presentation.view.TaskActivity

class TaskListAdapter : ListAdapter<Task, TaskListAdapter.MyViewHolder>(MyDiffUtil()) {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)

    }

    class MyDiffUtil : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.name.text = currentList[position].name

        val task = currentList[position]
        holder.name.text = task.name

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = TaskActivity.getIntent(context, task)
            context.startActivity(intent)
        }
    }

}