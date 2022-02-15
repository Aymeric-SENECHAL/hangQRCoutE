package com.example.tp1

import com.example.hangqrcoute.QrCode
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WebServiceInterface {

    @GET("/qrcode")
    fun getQrCode(): Call<Array<QrCode>>

    @POST("/qrcode")
    fun postQrCode(@Body qrCode: QrCode): Call<QrCode>

}