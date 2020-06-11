package com.example.googleproject2

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.googleproject2.model.LoginData

class DashboardAdapter (private val context: Context, private val mQuestions: List<LoginData>, private val mRowLayout: Int)
    : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

class ViewHolder(val view: View):RecyclerView.ViewHolder(view){

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}