package com.example.hangqrcoute.dto;

import com.example.hangqrcoute.entities.QrCodeEntity;

public class QrCodeDTO {

    private int id_qrCode;
    private String name_qrCode;
    private String url_qrCode;

    public QrCodeDTO() {}

    public int getId_qrCode() {
        return id_qrCode;
    }

    public void setId_qrCode(int id_qrCode) {
        this.id_qrCode = id_qrCode;
    }

    public String getName_qrCode() {
        return name_qrCode;
    }

    public void setName_qrCode(String name_qrCode) {
        this.name_qrCode = name_qrCode;
    }

    public String getUrl_qrCode() {
        return url_qrCode;
    }

    public void setUrl_qrCode(String url_qrCode) {
        this.url_qrCode = url_qrCode;
    }

    public void entityToDTO(QrCodeEntity qrCodeEntity){
        this.id_qrCode = qrCodeEntity.getId_qrCode();
        this.name_qrCode = qrCodeEntity.getName_qrCode();
        this.url_qrCode = qrCodeEntity.getUrl_qrCode();
    }

}
