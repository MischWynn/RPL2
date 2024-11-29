/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mahasiswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author User
 */
@Service
public class MahasiswaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    
    public void addMhs(MahasiswaModel mhs) {
        mahasiswaRepository.save(mhs);
    }
    
    public MahasiswaModel getMhs(int id) {
        return mahasiswaRepository.findById(id).orElse(null);
    }
    
    public void updateMhs(MahasiswaModel mhs) {
        mahasiswaRepository.save(mhs);
    }
    
    public void deleteMhs(int id) {
        mahasiswaRepository.deleteById(id);
    }
    
    public List<MahasiswaModel> getAll() {
        return mahasiswaRepository.findAll();
    }
}
