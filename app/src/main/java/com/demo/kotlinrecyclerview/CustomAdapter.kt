package com.demo.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataset: List<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
       private val textViewUsername: TextView = view.findViewById(R.id.textViewUsername)
        private val textViewAddress: TextView= view.findViewById(R.id.textViewAddress)
        private val cardView: CardView= view.findViewById(R.id.cardView)

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_item, parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(user: User?) {
            textViewUsername.text = user?.name
            textViewAddress.text = user?.address
            cardView.setOnClickListener {
                Toast.makeText(it.context, "You Clicked ${user?.name}", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder.create(viewGroup)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset.get(position))
    }

    override fun getItemCount() = dataset.size

}