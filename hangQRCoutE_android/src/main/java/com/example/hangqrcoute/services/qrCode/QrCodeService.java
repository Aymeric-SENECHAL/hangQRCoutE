package com.example.hangqrcoute.services.qrCode;

import com.example.hangqrcoute.dto.QrCodeDTO;
import com.example.hangqrcoute.entities.QrCodeEntity;

import java.util.List;

public interface QrCodeService {

    List<QrCodeDTO> getQrCode();

    QrCodeDTO addQrCode(QrCodeEntity qrCodeToAdd);

}
