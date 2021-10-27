package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ADDContent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcontent)


        var content=findViewById<EditText>(R.id.content)
        var describtion=findViewById<EditText>(R.id.describtion)
        var kotlin=findViewById<RadioButton>(R.id.radioButton2)
        var android=findViewById<RadioButton>(R.id.radioButton3)
        var addbtn=findViewById<Button>(R.id.button)

        var c=""

        addbtn.setOnClickListener {

            var cont=content.text.toString()
            var desc=describtion.text.toString()
            if(kotlin.isChecked){
                c="k"
             Toast.makeText(applicationContext,"Kotlin Added Successfully!!",Toast.LENGTH_SHORT).show()
            }
            else{
                c="a"
               Toast.makeText(applicationContext,"Android Added Successfully!!",Toast.LENGTH_SHORT).show()
            }
            val s = Lessons(0, cont,desc,c)



            CoroutineScope(IO).launch {
                LessonDatabse.getInstance(applicationContext).LessonDao().insertLesson(s)
            }
            Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
                .show();




            Toast.makeText(applicationContext,"$s", Toast.LENGTH_SHORT).show()
        }










    }
}