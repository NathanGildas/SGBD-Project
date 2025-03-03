package com.example.repository;

import com.example.model.HistoriqueUpload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueUploadRepository extends JpaRepository<HistoriqueUpload, Integer> {
    List<HistoriqueUpload> findByAdminId(Long adminId);
}