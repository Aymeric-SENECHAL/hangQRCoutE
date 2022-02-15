package com.example.hangqrcoute.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "qrcode")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QrCodeEntity {

    @Id
    @Column(name = "id_qrCode")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_qrCode;

    @Column(name = "name_qrCode")
    private String name_qrCode;

    @Column(name = "url_qrCode")
    private String url_qrCode;

}
