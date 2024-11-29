/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.controller;
 
import com.mahasiswa.model.HibernateUtil;
import com.mahasiswa.model.MahasiswaModel;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;




/**
 *
 * @author User
 */
public class MahasiswaController {
    public MahasiswaController(){
    }
        public void add(MahasiswaModel mhs){
        Transaction trx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.save(mhs);
            trx.commit();
        }catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }
    }
       public void update(MahasiswaModel mhs) {
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.update(mhs);
            trx.commit();
        } catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }
    }
         public void deleteMhs(int id) {
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            MahasiswaModel mhs = session.get(MahasiswaModel.class, id);
            if(mhs != null){
                session.delete(mhs);
                System.out.println("Berhasil hapus");
            }
            trx.commit();
        } catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }
    }
        public List<MahasiswaModel> getAll() {
        Transaction trx = null;
        List<MahasiswaModel> listMhs = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            // Using HQL (Hibernate Query Language) to fetch all records
            Query<MahasiswaModel> query = session.createQuery("from MahasiswaModel", MahasiswaModel.class);
            listMhs = query.list(); // Fetch all results

        
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback(); // Rollback transaction in case of error
            }
            e.printStackTrace();
        }

        return listMhs;
    }
    
    public MahasiswaModel getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}



