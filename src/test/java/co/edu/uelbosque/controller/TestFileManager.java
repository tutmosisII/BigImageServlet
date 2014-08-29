package co.edu.uelbosque.controller;


import co.edu.uelbosque.controller.ImageManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.logging.Logger;
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
    public void verificaQuelasInstanciasSenIguales() throws InterruptedException{
        System.out.println(" "+Thread.currentThread().getId());
        Random r=new Random(System.currentTimeMillis());
            Thread.sleep(r.nextInt(5000));
        ImageManager img=ImageManager.getInstance(); 
        if(unique==null) unique=img;
        Assert.assertTrue(unique==img);        
    }
    
    @Test
    public void debeCrearUnBufferDeLaImagen() throws InterruptedException, URISyntaxException, IOException{
        ImageManager im=ImageManager.getInstance();
        File f=new File(this.getClass().getResource("/BigImageMix.png").toURI());
        
        byte x[]=im.getImage(f);
        System.out.println("X: "+x.length );
        //Assert.assertNotNull(in);
    }
}
