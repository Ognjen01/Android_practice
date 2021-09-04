package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rec_view.*

class recyclarView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec_view)

        var todoList = mutableListOf(
            Todo("Naloziti vatru", false),
            Todo("Otici u trgovinu", false),
            Todo("NAhraniti macku", false),
            Todo("Uciti matematiku", false),
            Todo("Oprati prozore", false),
            Todo("Srediti sobu", false),
            Todo("Follow AndroidDevs", false)
        )

        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo (title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}
