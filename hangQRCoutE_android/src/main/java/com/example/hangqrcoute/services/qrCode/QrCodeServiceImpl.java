package com.example.hangqrcoute.services.qrCode;

import com.example.hangqrcoute.dto.QrCodeDTO;
import com.example.hangqrcoute.entities.QrCodeEntity;
import com.example.hangqrcoute.repositories.QrCodeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QrCodeServiceImpl implements QrCodeService{

    QrCodeRepository qrCodeRepository;

    public QrCodeServiceImpl(QrCodeRepository qrCodeRepository){
        this.qrCodeRepository = qrCodeRepository;
    }

    @Override
    public List<QrCodeDTO> getQrCode(){
        List<QrCodeEntity> listQrCode = qrCodeRepository.findAll();
        List<QrCodeDTO> listQrCodeToReturn = new ArrayList<>();

        for(QrCodeEntity qrCode: listQrCode){
            QrCodeDTO qrCodeDTO = new QrCodeDTO();
            qrCodeDTO.entityToDTO(qrCode);

            listQrCodeToReturn.add(qrCodeDTO);
        }

        return listQrCodeToReturn;
    }

    @Override
    public QrCodeDTO addQrCode(QrCodeEntity qrCodeToAdd){
        QrCodeEntity qrCodeAdded = qrCodeRepository.saveAndFlush(qrCodeToAdd);
        QrCodeDTO qrCodeToReturn = new QrCodeDTO();

        qrCodeToReturn.entityToDTO(qrCodeAdded);

        return qrCodeToReturn;
    }

}
