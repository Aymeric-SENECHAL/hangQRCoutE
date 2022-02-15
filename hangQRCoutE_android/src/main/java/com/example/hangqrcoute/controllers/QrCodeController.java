package com.example.hangqrcoute.controllers;

import com.example.hangqrcoute.dto.QrCodeDTO;
import com.example.hangqrcoute.entities.QrCodeEntity;
import com.example.hangqrcoute.services.qrCode.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private QrCodeService qrCodeService;

    @Autowired
    public QrCodeController(QrCodeService qrCodeService){
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("")
    public List<QrCodeDTO> getQrCode(){
        return qrCodeService.getQrCode();
    }

    @PostMapping("")
    public QrCodeDTO createQrCode(@RequestBody QrCodeEntity qrCodeToAdd){
        return this.qrCodeService.addQrCode(qrCodeToAdd);
    }

}
