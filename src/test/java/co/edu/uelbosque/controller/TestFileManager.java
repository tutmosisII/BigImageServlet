package co.edu.uelbosque.controller;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aleon
 */
public class TestFileManager {
    
 
    
    static ImageManager unique;
    @Test(threadPoolSize = 100, invocationCount = 100)
    public void verificaQuelasInstanciasSenIguales() throws InterruptedException, IOException, URISyntaxException{
        System.out.println("Thread Number: "+Thread.currentThread().getId());
        Random r=new Random(System.currentTimeMillis());
            Thread.sleep(r.nextInt(5000));
        File f=new File(this.getClass().getResource("/108.jpg").toURI());
        ImageManager img=ImageManager.getInstance(f); 
        if(unique==null) unique=img;
        Assert.assertTrue(unique==img);        
    }
    
    @Test
    public void debeCrearUnBufferDeLaImagen() throws InterruptedException, URISyntaxException, IOException{
        File f=new File(this.getClass().getResource("/108.jpg").toURI());        
        ImageManager im=ImageManager.getInstance(f);       
        byte x[]=im.getImage();
        Assert.assertEquals(x.length,105898);
    }
}
