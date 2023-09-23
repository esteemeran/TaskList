package com.example.TaskListKotlin.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.TaskListKotlin.domain.models.TaskList
import com.example.TaskListKotlin.presentation.view.TaskListFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val taskList:List<TaskList>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return taskList.count()
    }

    override fun createFragment(position: Int): Fragment {
        return TaskListFragment(taskList[position].id)
    }

}