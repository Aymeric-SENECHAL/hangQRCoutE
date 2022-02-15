package com.example.hangqrcoute

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class QrCode : Serializable {

    @SerializedName("id_qrCode")
    var id_qrCode : String = ""

    @SerializedName("name_qrCode")
    var name_qrCode : String = ""

    @SerializedName("url_qrCode")
    var url_qrCode : String = ""

    constructor(name_qrCode: String, url_qrCode: String) {
        this.name_qrCode = name_qrCode
        this.url_qrCode = url_qrCode
    }

}