package co.edu.uelbosque.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aleon
 */
class ImageManager {

    private static ImageManager singleton;
    private static Boolean control=true;
    
    ByteBuffer bb;
    
    private ImageManager(){
       
        
        
        
      
    }
    
    /**
     * Imagen almacenada en memoria
     * @return 
     */
    protected byte[] getImage(File f) throws IOException{
        
          ByteArrayOutputStream bo=new ByteArrayOutputStream();
            FileInputStream fin=new FileInputStream(f);
            int x;
            
            while((x=fin.read())!=-1){
              bo.write(x);
            }  
            return bo.toByteArray();

    }
    
    public static ImageManager getInstance() throws InterruptedException  {
        if(singleton==null){            
            synchronized(control){
             if(singleton!=null){ 
                 return singleton;
             }
             singleton=new ImageManager();
            }
        }
        return singleton;
    }
    
}
