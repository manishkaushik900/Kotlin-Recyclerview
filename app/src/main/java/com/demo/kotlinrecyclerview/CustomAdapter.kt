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
        val textViewUsername: TextView
        val textViewAddress: TextView
        val cardView: CardView

        init {
            textViewUsername = view.findViewById(R.id.textViewUsername)
            textViewAddress = view.findViewById(R.id.textViewAddress)
            cardView = view.findViewById(R.id.cardView)
        }

        fun bind(user: User) {
            textViewUsername.setText(user.name)
            textViewAddress.setText(user.address)
            cardView.setOnClickListener {
                Toast.makeText(it.context, "You Clicked ${user.name}", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset.get(position))
//        holder.textViewUsername.setText(dataset.get(position).name)
//        holder.textViewAddress.setText(dataset.get(position).address)
//        holder.cardView.setOnClickListener{
//            Toast.makeText(it.context,"You Clicked ${dataset.get(position).name}", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount() = dataset.size

}