package com.test.glidelib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String MD5Encryption(String password){
        StringBuilder sb = new StringBuilder();
        try {
            //MD5是加密方式
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //将二进制的byte数组进行加密
            byte[] digest = messageDigest.digest(password.getBytes());
            //遍历
            for (int i = 0; i <digest.length ; i++) {
                //进行加密 & int值的 255   000...00010000001
                int result = digest[i] & 0xff;
                //将int值转换为16进制
                String hexString = Integer.toHexString(result);
                //String hexString = Integer.toHexString(result) + 1 ;//这里加1可以进行2次加密---加盐
                //这里会输出一个长度小于2的一段字符，所以前面加个0
                if (hexString.length() < 2){
                    sb.append("0");
                }
                sb.append(hexString);
            }
            //这里返回一个加密过的结果
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
