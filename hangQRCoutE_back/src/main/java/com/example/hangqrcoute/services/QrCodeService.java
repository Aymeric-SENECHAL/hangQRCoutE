package com.example.hangqrcoute.services;

import com.example.hangqrcoute.entities.QrCodeEntity;

import java.util.List;

public interface QrCodeService {

    List<QrCodeEntity> getQrCode();

    QrCodeEntity postQrCode(QrCodeEntity newTask);

}
