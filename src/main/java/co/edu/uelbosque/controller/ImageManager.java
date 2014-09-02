package co.edu.uelbosque.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
    private static Boolean control = true;
    
    byte img[];
    
    private ImageManager(File f) throws IOException {

        ByteArrayOutputStream bo = new ByteArrayOutputStream(650000000);
        int x;
        FileInputStream fin = new FileInputStream(f);

        while ((x = fin.read()) != -1) {
           
            bo.write(x);
        }
        img=bo.toByteArray();
    }

    /**
     * Imagen almacenada en memoria
     *
     * @return
     */
    protected byte[] getImage() throws IOException {

        return img;

    }

    public static ImageManager getInstance(File f) throws InterruptedException, IOException {
        if (singleton == null) {
            synchronized (control) {
                if (singleton != null) {
                    return singleton;
                }
                singleton = new ImageManager(f);
            }
        }
        return singleton;
    }

}
