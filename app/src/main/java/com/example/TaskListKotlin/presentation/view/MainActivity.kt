package com.example.TaskListKotlin.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.TaskListKotlin.databinding.ActivityMainBinding
import com.example.TaskListKotlin.presentation.adapter.ViewPagerAdapter
import com.example.TaskListKotlin.presentation.viewModel.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var vpAdapter: ViewPagerAdapter
    lateinit var mainViewModel: MainViewModel

    var tabIndex: Int = 0
    var isNewApp : Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.taskLists.observe(this) {
            vpAdapter = ViewPagerAdapter(this, it)
            binding.viewPager.adapter = vpAdapter
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
                tab.text = it[pos].name
            }.attach()

        }

        if(binding.tabLayout.tabCount == 0) //just installed app
        {
            isNewApp = true;
            binding.addTaskInTaskListButton.visibility = View.GONE
            binding.removeTaskListButton.visibility = View.GONE
            binding.editTaskList.visibility = View.GONE
        }

        binding.addTaskListButton.setOnClickListener {
            startActivity(
                AddTaskListActivity.getIntent(this, isNewApp)
            )
        }

        binding.addTaskInTaskListButton.setOnClickListener {
            if(mainViewModel.taskLists.value?.isNotEmpty() == true)
                startActivity(
                mainViewModel.taskLists.value?.get(tabIndex)?.let { it1 ->
                    TaskActivity.getIntent(this, it1.id)
                }
            )
        }
        binding.editTaskList.setOnClickListener {
            if(mainViewModel.taskLists.value?.isNotEmpty() == true)
                startActivity(
                mainViewModel.taskLists.value?.get(tabIndex)?.let { it1 ->
                    AddTaskListActivity.getIntent(this, it1)
                }

            )
        }
        binding.removeTaskListButton.setOnClickListener {
            if(mainViewModel.taskLists.value?.isNotEmpty() == true)
            {
                val taskListId = mainViewModel.taskLists.value?.get(tabIndex)?.id
            mainViewModel.taskLists.value?.toMutableList()?.removeAt(tabIndex)
            taskListId?.let { it1 -> mainViewModel.removeTaskList(it1) }
        }
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(isNewApp) isNewApp = false;

                tabIndex = tab!!.position

                if (tabIndex == 0) {
                    binding.addTaskInTaskListButton.visibility = View.GONE
                    binding.removeTaskListButton.visibility = View.GONE
                    binding.editTaskList.visibility = View.GONE

                } else {
                    binding.addTaskInTaskListButton.visibility = View.VISIBLE
                    binding.removeTaskListButton.visibility = View.VISIBLE
                    binding.editTaskList.visibility = View.VISIBLE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                return
            }
        })
        mainViewModel.getAllTaskList()

    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getAllTaskList()
    }
}