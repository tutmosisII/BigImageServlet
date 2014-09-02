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
    ByteArrayOutputStream bo;

    private ImageManager(File f) throws IOException {

        bo = new ByteArrayOutputStream();
        int x;
        FileInputStream fin = new FileInputStream(f);
        
        while ((x = fin.read()) != -1) {
            bo.write(x);
        }

    }

    /**
     * Imagen almacenada en memoria
     *
     * @return
     */
    protected byte[] getImage() throws IOException {

        return bo.toByteArray();

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
