package com.example.hangqrcoute

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hangqrcoute.databinding.ActivityListCellBinding

class ListAdapter(qrCodeArray : Array<QrCode>, listClickListener: OnListClickListener) : RecyclerView.Adapter<ListCellHolder>() {

    private val dataSource = qrCodeArray
    private val listener = listClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCellHolder {
        val qrCodeListCellBinding = ActivityListCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListCellHolder(qrCodeListCellBinding)
    }

    override fun onBindViewHolder(holder: ListCellHolder, position: Int) {
        holder.bindItems(dataSource[position])
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                listener.clickOnQrCode(dataSource[holder.adapterPosition])
            }
        })
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

}