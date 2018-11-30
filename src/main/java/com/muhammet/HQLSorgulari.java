/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhammet;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class HQLSorgulari {
    
    Session ss;
    Transaction tt;
    
    public HQLSorgulari(){
    ss = NewHibernateUtil.getSessionFactory().openSession();
    
    }
    
    public void FromSorgusu(){
    
        // Tip-1 tablo adı ile sorgu
        String hql = "FROM tblmusteri";
        Query query = ss.createQuery(hql);
        List<tblmusteri> results = query.getResultList();
        
        for (tblmusteri result : results) {
            System.out.println(result.getId()+" Gelen Müşteriler....: "+result.getAd());
        }
        // Tip-2 entity sınıfı ile sorgu
        String hql2 = "FROM com.muhammet.tblsatis";
        Query query2 = ss.createQuery(hql2);
        List<tblsatis> results2 = query2.getResultList();
        for (tblsatis object : results2) {
            System.out.println(object.getId()+" Gelen Satışlar...: "+object.getTutar());
        }
        ss.close();
    }
    
    public void SelectAndWhereSorgusu(){
    
        String hql = "select E.ad FROM tblmusteri E WHERE E.id = 10";
        Query query = ss.createQuery(hql);
        List results = query.getResultList();
        
        for (Object result : results) {
            System.out.println("Gelen İsimler.....: "+ result);
        }
        ss.close();
    }
    
    public void UpdateSorgusu(){
    Transaction tt = ss.beginTransaction();
    String hql = "UPDATE tblmusteri set ad = :m_ad "  + 
             "WHERE id = :m_id";
        Query query = ss.createQuery(hql);
        query.setParameter("m_ad", "Yeni Adımmm");
        query.setParameter("m_id", 10L);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
       tt.commit();
       ss.close();
    }
    
    public void DeleteSorgusu(){
    String hql = "DELETE FROM tblmusteri "  + 
             "WHERE id = :m_id";
            Query query = ss.createQuery(hql);
            query.setParameter("m_id", 10);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
    }
    
    public void InsertSorgusu(){
        Transaction tt = ss.beginTransaction();
    String hql = "INSERT INTO tblmusteri(ad, adres, telefon)"  + 
             " values( :m_ad, :m_adres, :m_telefon)";
               Query query = ss.createQuery(hql);
               query.setParameter("m_ad", "Ekleme_ad");
               query.setParameter("m_adres", "Ekleme_adres");
               query.setParameter("m_telefon", "Ekleme_telefon");
               
               int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            tt.commit();
            ss.close();
    }
    
    public void IlkOnKayit(){
    String hql = "FROM tblmusteri";
    Query query = ss.createQuery(hql);
    query.setFirstResult(1);
    query.setMaxResults(10);
    List results = query.getResultList();
    }
    
}
