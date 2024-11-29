/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabelMahasiswa extends AbstractTableModel{
    private List<MahasiswaModel> listMhs;
    private String[] columnNames = {"ID", "NPM", "Nama", "Semester", "IPK"};
    
    public ModelTabelMahasiswa(List<MahasiswaModel> mahasiswaList) {
        this.listMhs = mahasiswaList;
    }
 
    @Override
    public int getRowCount() {
        return listMhs.size(); // Jumlah baris sesuai dengan jumlah data mahasiswa
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Jumlah kolom sesuai dengan jumlah elemen dalam columnNames
    }
       @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MahasiswaModel mahasiswa = listMhs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mahasiswa.getId();
            case 1:
                return mahasiswa.getNpm();
            case 2:
                return mahasiswa.getNama();
            case 3:
                return mahasiswa.getSemester();
            case 4:
                return mahasiswa.getIpk();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Mengatur nama kolom
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Semua sel tidak dapat diedit
    }

    // Method untuk menambahkan atau memodifikasi data, jika dibutuhkan
    public void setMahasiswaList(List<MahasiswaModel> mahasiswaList) {
        this.listMhs = mahasiswaList;
        fireTableDataChanged(); // Memberitahu JTable bahwa data telah berubah
    }
}
