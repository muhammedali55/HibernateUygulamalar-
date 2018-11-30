/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhammet;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class NativeSQL {
     
    Session ss;
    Transaction tt;
    
    public NativeSQL(){
    ss = NewHibernateUtil.getSessionFactory().openSession();
    
    }
    
    
    public void ScalarSorgular(){
    
        String sql = "SELECT * FROM tblmusteri";
        SQLQuery query = ss.createSQLQuery(sql);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List results = query.getResultList();
        
    }
    
    public void VarlikSorgulari(){
    
        String sql = "SELECT * FROM tblmusteri";
        SQLQuery query = ss.createSQLQuery(sql);
        query.addEntity(tblmusteri.class);
        List results = query.list();
        
    }
    
    public void AdlandirilmisSQLSorgulari(){
    
        String sql = "SELECT * FROM tblmusteri WHERE id = :m_id";
        SQLQuery query = ss.createSQLQuery(sql);
        query.addEntity(tblmusteri.class);
        query.setParameter("m_id", 15);
        List results = query.list();
    }
    
    public void ViewSQLIle(){
    
         String sql = "SELECT mst.id,mst.ad,sts.tutar FROM tblmusteri as mst"
                 + " left join tblsatis as sts on sts.mid=mst.id where sts.id is not null";
        SQLQuery query = ss.createSQLQuery(sql);
        List results = query.list();
        
        for (Object result : results) {
           Object[] list = (Object[]) result;
            for (Object item : list) {
                System.out.println("gelen....: "+ item);
            }
        }
        
    }
    
    public void ViewDBDen(){
         String sql = "SELECT * FROM vwmusterisatis";
        SQLQuery query = ss.createSQLQuery(sql);
        List results = query.list();
        
        for (Object result : results) {
           Object[] list = (Object[]) result;
            for (Object item : list) {
                System.out.println("gelen....: "+ item);
            }
        }
    
    }
}
