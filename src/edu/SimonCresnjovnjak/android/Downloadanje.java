package edu.SimonCresnjovnjak.android;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.graphics.BitmapFactory;


public class Downloadanje{
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
// 
//        ImageView imgView =(ImageView)findViewById(R.id.pic);
//        Drawable drawable = LoadImageFromWeb("http://www.krka.si/media/bin?bin.id=5641");
//        imgView.setImageDrawable(drawable);
// 
//    }
// 
   private Drawable LoadImageFromWeb(String url)
   {
  try
  {
   InputStream is = (InputStream) new URL(url).getContent();
   Drawable d = Drawable.createFromStream(is, "src name");
   return d;
  }catch (Exception e) {
   System.out.println("Exc="+e);
   return null;
  }
 }
//}

   
    private final String PATH = "/data";  //put the downloaded file here
    
    
    public void DownloadFromUrl(String imageURL, String fileName) {  //this is the downloader method
            try {
                    URL url = new URL(imageURL); //you can write here any link
                    File file = new File(PATH +"/"+ fileName);

                    long startTime = System.currentTimeMillis();
                    Log.d("ImageManager", "download begining");
                    Log.d("ImageManager", "download url:" + url);
                    Log.d("ImageManager", "downloaded file name:" + fileName);
                    /* Open a connection to that URL. */
                    URLConnection ucon = url.openConnection();

                    /*
                     * Define InputStreams to read from the URLConnection.
                     */
                    InputStream is = ucon.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(is);

                    /*
                     * Read bytes to the Buffer until there is nothing more to read(-1).
                     */
                    ByteArrayBuffer baf = new ByteArrayBuffer(50);
                    int current = 0;
                    while ((current = bis.read()) != -1) {
                            baf.append((byte) current);
                    }

                    /* Convert the Bytes read to a String. */
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(baf.toByteArray());
                    fos.close();
                    Log.d("ImageManager", "download ready in"
                                    + ((System.currentTimeMillis() - startTime) / 1000)
                                    + " sec");

            } catch (IOException e) {
                    Log.d("ImageManager", "Error: " + e);
            }

    }
}
