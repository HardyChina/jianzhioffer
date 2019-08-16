package test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class zipTest {
    public static void main(String[] args) throws Exception {
        //文件输出流
        FileOutputStream fos = new FileOutputStream("d:/xxx.zip");
        //压缩流
        ZipOutputStream zos = new ZipOutputStream(fos);
        String[] fileNames = {
            "d:/test.jpg"
        };
        for(String path:fileNames){
            addZipFile(zos,path);

        }
        zos.close();
        fos.close();
        System.out.println("over");
    }
    public static void addZipFile(ZipOutputStream zos,String path) throws IOException {
        File file = new File(path);
        zos.putNextEntry(new ZipEntry(file.getName()));
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();

        zos.write(bytes);
        zos.closeEntry();

    }

    /**
     * 解压缩
     */
    @Test
    public static void  unzip() throws Exception {
        FileInputStream fis = new FileInputStream("d:/xxx.zip");
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry entry = null;
        byte[] buf = new byte[1024];
        int len = 0;

        while ((entry = zis.getNextEntry())!= null){
            String name = entry.getName();
            FileOutputStream fos = new FileOutputStream("d:/");
            while ((len = zis.read(buf))!= -1){
                fos.write(buf,0,len);

            }
            fos.close();
        }
        zis.close();
        fis.close();


    }
}
