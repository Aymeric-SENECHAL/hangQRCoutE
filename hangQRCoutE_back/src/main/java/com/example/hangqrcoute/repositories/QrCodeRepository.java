package com.example.hangqrcoute.repositories;

import com.example.hangqrcoute.entities.QrCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrCodeRepository extends JpaRepository<QrCodeEntity, Integer> {
}
