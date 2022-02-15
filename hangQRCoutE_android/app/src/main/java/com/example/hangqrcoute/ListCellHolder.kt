package com.example.hangqrcoute

import androidx.recyclerview.widget.RecyclerView
import com.example.hangqrcoute.databinding.ActivityListCellBinding
import com.squareup.picasso.Picasso

class ListCellHolder(listCellBinding: ActivityListCellBinding) : RecyclerView.ViewHolder(listCellBinding.root) {

    private val binding = listCellBinding

    fun bindItems(qrCode: QrCode){
        binding.idTextView.text = qrCode.name_qrCode

        var url = "https://api.qrserver.com/v1/create-qr-code/?data=" + qrCode.url_qrCode
        Picasso.get().load(url).into(binding.idImageView)
    }

}