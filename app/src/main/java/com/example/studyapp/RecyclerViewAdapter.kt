package com.example.studyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter( private val android:androidactivity?=null, private val kotlin:kotlinactivity?=null,private val study: List<Lessons>):RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data=study[position]


        holder.itemView.apply {
            textView2.text=data.title
            textView3.text=data.description


            cardview.setOnClickListener {
                if(android==null)
                {

                    if (kotlin != null) {
                        dialogAlert(kotlin,data.title , "details here")
                    }
                }
                else{

                    dialogAlert(android,data.title , "details here")
                }


            }

          delbtn.setOnClickListener(){
            android?.confirmAlert(data)
           kotlin?.confirmAlert(data)
                     }
                     editbtn.setOnClickListener {
           android?.customAlert(data)
            kotlin?.customAlert(data)
                 }
        }
    }

    override fun getItemCount() = study.size

}






