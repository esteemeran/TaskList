package com.maskalor.recycler.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.maskalor.recycler.R
import com.maskalor.recycler.data.Task

class TaskListAdapter(): ListAdapter<Task, TaskListAdapter.MyViewHolder>(
    CallBack()
) {

    var onClick: ((Task) -> Unit)? = null
    var onLongClick: ((Task, Int) -> Boolean)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = when(viewType) {
            DEFAULT_TYPE -> {
                R.layout.task_item_layout
            }
            FAVORITE_TYPE -> {
                R.layout.task_favorite_item_layout
            }
            else -> {
                R.layout.task_item_layout
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return when(currentList[position].isFavorite) {
            false -> {
                DEFAULT_TYPE
            }
            else -> {
                FAVORITE_TYPE
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = currentList[position].name
        holder.itemView.setOnClickListener {
            onClick?.invoke(currentList[position])
        }

        holder.itemView.setOnLongClickListener{
            onLongClick?.invoke(currentList[position], position)
            true
        }
    }

    fun update(position: Int) {
        notifyItemChanged(position)
    }


    class MyViewHolder(view: View) : ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv)
    }

    class CallBack : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        private const val FAVORITE_TYPE = 101
        private const val DEFAULT_TYPE = 102
    }
}