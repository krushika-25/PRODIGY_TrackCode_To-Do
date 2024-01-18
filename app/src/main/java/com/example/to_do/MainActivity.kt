package com.example.to_do

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var taskEditText: EditText
    private lateinit var addButton: View
    private lateinit var taskListView: ListView
    private lateinit var tasks: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskEditText = findViewById(R.id.taskEditText)
        addButton = findViewById(R.id.addButton)
        taskListView = findViewById(R.id.taskListView)

        tasks = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks)
        taskListView.adapter = adapter

        addButton.setOnClickListener {
            addTask()
        }

        taskListView.setOnItemClickListener { _, _, position, _ ->
            editTask(position)
        }

        taskListView.setOnItemLongClickListener { _, _, position, _ ->
            deleteTask(position)
            true
        }
    }

    private fun addTask() {
        val task = taskEditText.text.toString().trim()
        if (task.isNotEmpty()) {
            tasks.add(task)
            adapter.notifyDataSetChanged()
            taskEditText.text.clear()
        } else {
            Toast.makeText(this, "Task cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }

    private fun editTask(position: Int) {
        val task = tasks[position]

        // Implement task editing logic, e.g., show a dialog with an EditText to edit the task
    }

    private fun deleteTask(position: Int) {
        tasks.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}



