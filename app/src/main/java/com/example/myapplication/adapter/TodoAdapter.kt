package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.NotesData
import com.example.myapplication.databinding.RecycleNotesBinding

class TodoAdapter(private var itemTodo: MutableList<NotesData>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    private lateinit var binding: RecycleNotesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RecycleNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemTodo[position])
    }

    override fun getItemCount(): Int {
        return itemTodo.size
    }

    inner class ViewHolder(itemView: RecycleNotesBinding) : RecyclerView.ViewHolder(itemView.root){
        fun bind(item: NotesData){
            binding.apply {
                cbDone.isChecked = item.isChecked
                tvTitle.text = item.title
            }
        }
    }
}