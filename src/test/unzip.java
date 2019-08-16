package test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class unzip {
    @Test
    public  void  unzip() throws Exception {
        FileInputStream fis = new FileInputStream("d:/xxx.zip");
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry entry = null;
        byte[] buf = new byte[1024];
        int len = 0;

        while ((entry = zis.getNextEntry())!= null){
            String name = entry.getName();
            FileOutputStream fos = new FileOutputStream("d:/"+name);
            while ((len = zis.read(buf))!= -1){
                fos.write(buf,0,len);

            }
            fos.close();
        }
        zis.close();
        fis.close();


    }
}
