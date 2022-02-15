package com.example.hangqrcoute.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QrCodeDTO {

    private int idProject;
    private String name;
    private List<QrCodeDTO> tasks;

}
