/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhammet;

import java.text.ParseException;

/**
 *
 * @author Administrator
 */
public class Runner {
    
    public static void main(String[] args) throws ParseException {
        
        HazirVeriler hz = new HazirVeriler();
      //  hz.veriekle();
        
        HQLSorgulari hql = new HQLSorgulari();
        //hql.FromSorgusu();
          
        // hql.SelectAndWhereSorgusu();
       
        //hql.InsertSorgusu();
        
        NativeSQL ntv = new NativeSQL();
        ntv.ViewDBDen();
       
    }
}
