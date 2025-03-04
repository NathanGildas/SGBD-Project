package com.example.service;

import com.example.model.HistoriqueUpload;
import com.example.repository.HistoriqueUploadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueUploadService {

    private final HistoriqueUploadRepository historiqueUploadRepository;

    public HistoriqueUploadService(HistoriqueUploadRepository historiqueUploadRepository) {
        this.historiqueUploadRepository = historiqueUploadRepository;
    }

    public List<HistoriqueUpload> getHistoriqueByAdmin(Long adminId) {
        return historiqueUploadRepository.findByAdminId(adminId);
    }
}