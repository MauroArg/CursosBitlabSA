/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.util;

import com.bitlab.managed.util.JsfUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;
import javax.ws.rs.client.Entity;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author Andrea
 */
public class UploadFile {
    public static final String URL = "resources/docs";
    public static final String SEPARATOR = "/";
    private String destination = "";
    
   
    public Boolean upload(UploadedFile archivo, int idEntity){        
        try{
            destination = URL + idEntity;
            System.out.println("++++++++++++++++++++++++ Destination = " + destination);
             File folder = new File(JsfUtil.getPath() + destination);
            if(!folder.exists()){
                folder.mkdirs();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("+++++++++++++++++++++++catch+++++++++++++++++++++++++");
            return false;
        }
        
    }
    
    public void copyFile(String fileName, InputStream in){
        try {
            destination = destination + SEPARATOR + fileName;
            System.out.println("++++++++++++++++++++++++ Destination = " + destination);
            OutputStream out = new FileOutputStream(new File(JsfUtil.getPath() + destination));
            
            int r = 0;
            byte[] bytes = new byte[1024];
             while ((r = in.read(bytes))!= -1) {                
                out.write(bytes, 0, r);
            }
            
            in.close();
            out.flush();
            out.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("error_cargar_doc"));
           
        }
    }
}
