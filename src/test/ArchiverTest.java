package test;

import org.testng.annotations.Test;

public class ArchiverTest {
    @Test
    public void test1(){
        System.out.println(5&10);
        System.out.println(~1);
        System.out.println(byte2Int(int2Byte(128)));
        System.out.println(bytes2Int(int2ByteArray(128)));
//        System.out.println( int2Byte(129)[1]);
    }
    /**
     * 整型转换成字节数组
     */
    public static byte[] int2Byte(int i){
        byte[] arr = new byte[4] ;
        arr[0] = (byte)i ;
        arr[1] = (byte)(i >> 8) ;
        arr[2] = (byte)(i >> 16) ;
        arr[3] = (byte)(i >> 24) ;
        return arr ;
    }

    /**
     * 字节数组转成int
     */
    public static int byte2Int(byte[] bytes){
        int i0= bytes[0] &0xFF;
        int i1 = (bytes[1] & 0xFF) << 8 ;
        int i2 = (bytes[2] & 0xFF) << 16 ;
        int i3 = (bytes[3] & 0xFF) << 24 ;
        return i0 | i1 | i2 | i3 ;
    }
    public static byte[] int2ByteArray(int i){
            byte[] result=new byte[4];
            result[0]=(byte)((i >> 24)& 0xFF);
            result[1]=(byte)((i >> 16)& 0xFF);
            result[2]=(byte)((i >> 8)& 0xFF);
            result[3]=(byte)(i & 0xFF);
            return result;
        }
    public static int bytes2Int(byte[] bytes){
               int num=bytes[3] & 0xFF;
               num |=((bytes[2] <<8)& 0xFF00);
               num |=((bytes[1] <<16)& 0xFF0000);
               num |=((bytes[0] <<24)& 0xFF0000);
               return num;
           }
}
