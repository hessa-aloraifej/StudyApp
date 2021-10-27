package com.example.studyapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class kotlinactivity : AppCompatActivity() {
    lateinit var myRV:RecyclerView
    lateinit var list:List<Lessons>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlinactivity)
        myRV=findViewById(R.id.rvMain)
        title = "Kotlin Topics For Review"
        CoroutineScope(IO).launch {
            list = LessonDatabse.getInstance(applicationContext).LessonDao().getKotlinLesson()
               withContext(Main){
                   updateRV(list)
               }
        }

    }

    fun updateRV(data: List<Lessons>){
        myRV.adapter = RecyclerViewAdapter(null,this,data)
        myRV.layoutManager = LinearLayoutManager(this)
    }


    fun remove(lesson:Lessons){
        LessonDatabse.getInstance(applicationContext).LessonDao().delete(lesson)
        updateRV(LessonDatabse.getInstance(applicationContext).LessonDao().getKotlinLesson())
    }
    fun edit(lesson:Lessons){
        LessonDatabse.getInstance(applicationContext).LessonDao().edit(lesson)
        updateRV(LessonDatabse.getInstance(applicationContext).LessonDao().getKotlinLesson())
    }
    fun customAlert(lesson: Lessons){


        val dialogBuilder = AlertDialog.Builder(this)
        val input = EditText(this)
        dialogBuilder.setMessage("Edit Your Note")
            .setPositiveButton("Ok", DialogInterface.OnClickListener {
                    dialog, id ->
                edit(Lessons(lesson.id, input.text.toString(),lesson.description,lesson.type))
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id ->dialog.cancel()
            })

        val alert = dialogBuilder.create()

        alert.setTitle("Edit Note")
        alert.setView(input)
        alert.show()
    }

    fun confirmAlert(lesson: Lessons){


        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Are You Sure To Delete This Note?")
            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id ->
                remove(lesson)
            })
            .setNegativeButton("No", DialogInterface.OnClickListener {
                    dialog, id ->dialog.cancel()
            })

        val alert = dialogBuilder.create()

        alert.setTitle("Confirmation")
        alert.show()
    }




}