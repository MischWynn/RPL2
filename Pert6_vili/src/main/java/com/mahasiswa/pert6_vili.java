/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com;

import com.mahasiswa.MahasiswaController;
import com.mahasiswa.MahasiswaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author User
 */
@SpringBootApplication
public class pert6_vili implements ApplicationRunner {

    /**
     * @param args the command line arguments
     */
    @Autowired
    private MahasiswaController mhsService;
    
    public static void main(String args[]) {
        System.setProperty("java.awt.headless", "false");
        
        ApplicationContext context = SpringApplication.run(pert6_vili.class, args);
        
        MahasiswaController controller = context.getBean(MahasiswaController.class);
        MahasiswaView mhsView = new MahasiswaView(controller);
        mhsView.setVisible(true);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
    }
}
