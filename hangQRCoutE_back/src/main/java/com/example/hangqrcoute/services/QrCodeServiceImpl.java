package com.example.hangqrcoute.services;

import com.example.hangqrcoute.entities.QrCodeEntity;
import com.example.hangqrcoute.repositories.QrCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class QrCodeServiceImpl implements QrCodeService {

    QrCodeRepository qrCodeRepository;

    @Override
    public List<QrCodeEntity> getQrCode(){
        return qrCodeRepository.findAll();
    }

    @Override
    public QrCodeEntity postQrCode(QrCodeEntity qrCode){
        return qrCodeRepository.saveAndFlush(qrCode);
    }
}
