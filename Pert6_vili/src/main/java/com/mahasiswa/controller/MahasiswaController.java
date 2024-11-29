/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.stereotype.Controller;
/**
 *
 * @author User
 */
@Controller
public class MahasiswaController {
@Autowired
    private MahasiswaService mahasiswaService;
    
    public String add(@RequestBody MahasiswaModel mhs) {
        if (mhs.getNpm() == null || mhs.getNpm().isEmpty()){
            throw new IllegalArgumentException("NPM tidak boleh kosong");
        }
        mahasiswaService.addMhs(mhs);
        return "Mahasiswa added succesfully";
    }
    
    public MahasiswaModel getMahasiswa(@PathVariable int id) {
        return mahasiswaService.getMhs(id);
    }
    
    public String updateMahasiswa(@RequestBody MahasiswaModel mhs) {
        mahasiswaService.updateMhs(mhs);
        return "Mahasiswa updated succesfully";
    }
    
    public String deleteMahasiswa(@PathVariable int id) {
        mahasiswaService.deleteMhs(id);
        return "Mahasiswa Deleted Successfully";
    }
    
    public List<MahasiswaModel> getAll() {
        return mahasiswaService.getAll();
    }
}
