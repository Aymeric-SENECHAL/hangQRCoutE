package com.example.hangqrcoute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hangqrcoute.databinding.FragmentListBinding
import com.example.tp1.WebServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListFragment(listener: OnListClickListener) : Fragment(){

    private lateinit var binding : FragmentListBinding
    private lateinit var allQrCode: Array<QrCode>
    private var listener = listener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)

        val retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val ws = retrofit.create(WebServiceInterface::class.java)

        val callGetQrCode = ws.getQrCode()
        callGetQrCode.enqueue(object : Callback<Array<QrCode>> {
            override fun onResponse(call: Call<Array<QrCode>>, response: Response<Array<QrCode>>) {
                allQrCode = response.body()!!

                binding.idRecyclerView.setHasFixedSize(true)

                val qrCodeListLayoutManager = LinearLayoutManager(context)

                binding.idRecyclerView.layoutManager = qrCodeListLayoutManager

                val qrCodeListAdapter = ListAdapter(allQrCode, listener)

                binding.idRecyclerView.adapter = qrCodeListAdapter
            }

            override fun onFailure(call: Call<Array<QrCode>>, t: Throwable) {
                println("Fail")
                println(t.message)
            }
        })

        return binding.root
    }

}

