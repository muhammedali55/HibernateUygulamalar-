/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhammet;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class HazirVeriler {
    
    public void veriekle() throws ParseException{
    
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tt = ss.beginTransaction();
        DateFormat format = new SimpleDateFormat("dd-MM-YYYY", Locale.ROOT);

        tblmusteri mst;
        
        tblsatis sts;
        
        // Müşteri Kayıt
        mst = new tblmusteri();
        mst.setAd("Muhammet KAYA");
        mst.setAdres("Ankara");
        mst.setTelefon("0 555 333 6655");
        ss.save(mst);
        
        mst = new tblmusteri();
        mst.setAd("Bahar KAYA");
        mst.setAdres("Samsun");
        mst.setTelefon("0 533 333 6655");
        ss.save(mst);
        
        // Satış Kayıt
        
        sts = new tblsatis();
        sts.setMid(1L);
        sts.setTarih(format.parse("01-01-2018"));
        sts.setTutar(6520d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(1L);
        sts.setTarih(format.parse("05-01-2018"));
        sts.setTutar(1520d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(1L);
        sts.setTarih(format.parse("12-01-2018"));
        sts.setTutar(3520d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(1L);
        sts.setTarih(format.parse("30-01-2018"));
        sts.setTutar(9520d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(1L);
        sts.setTarih(format.parse("11-02-2018"));
        sts.setTutar(120d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(2L);
        sts.setTarih(format.parse("19-01-2018"));
        sts.setTutar(150d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(2L);
        sts.setTarih(format.parse("23-01-2018"));
        sts.setTutar(3500d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(2L);
        sts.setTarih(format.parse("29-01-2018"));
        sts.setTutar(260d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(2L);
        sts.setTarih(format.parse("09-02-2018"));
        sts.setTutar(290d);
        ss.save(sts);
        
        sts = new tblsatis();
        sts.setMid(2L);
        sts.setTarih(format.parse("21-02-2018"));
        sts.setTutar(2510d);
        ss.save(sts);
        
        tt.commit();
        ss.close();
        
        
        
    }
    
    
}
