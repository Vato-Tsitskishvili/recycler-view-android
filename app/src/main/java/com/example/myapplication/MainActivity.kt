package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.TodoAdapter
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listTodo = mutableListOf(
            NotesData("hello", false)
        )

        val adapter = TodoAdapter(listTodo)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.buttonAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = NotesData(title, false)
            listTodo.add(todo)
            adapter.notifyItemInserted(listTodo.size - 1)
        }

    }
}