package com.example.hangqrcoute.controllers;

import com.example.hangqrcoute.entities.QrCodeEntity;
import com.example.hangqrcoute.services.QrCodeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qrcode")
@NoArgsConstructor
public class QrCodeController {

    private QrCodeService qrCodeService;

    @Autowired
    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    /*************************/
    /***** METHODES GET ******/
    /*************************/
    @GetMapping("")
    public List<QrCodeEntity> getQrCode(){return qrCodeService.getQrCode();}


    /*************************/
    /***** METHODES POST *****/
    /*************************/
    @PostMapping("")
    public QrCodeEntity postQrCode(@RequestBody QrCodeEntity qrCode){
        return this.qrCodeService.postQrCode(qrCode);
    }

}