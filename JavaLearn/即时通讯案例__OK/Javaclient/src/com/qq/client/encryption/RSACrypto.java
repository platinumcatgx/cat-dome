package com.qq.client.encryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

public class RSACrypto { 
    private final static String RSA = "RSA";
    public static PublicKey uk;
    public static PrivateKey rk;
    
  //just for test
    public static void main(String args[]){

    	
        try{
            RSACrypto.generateKey();
            String cipherText = RSACrypto.encrypt("1 123456");
            System.out.println("密文是:"+cipherText);
            String plainText = RSACrypto.decrypt(cipherText);
            System.out.println("明文是:"+plainText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void generateKey() throws Exception{

        KeyPairGenerator gen = KeyPairGenerator.getInstance(RSA); 
        gen.initialize(512, new SecureRandom()); 
        KeyPair keyPair = gen.generateKeyPair(); 
        uk = keyPair.getPublic();
        rk = keyPair.getPrivate();
    }
    private static byte[] encrypt(String text, PublicKey pubRSA) throws Exception{

        Cipher cipher = Cipher.getInstance(RSA); 
        cipher.init(Cipher.ENCRYPT_MODE, pubRSA);
        return cipher.doFinal(text.getBytes());
    }
    public final static String encrypt(String text){

        try {
            return byte2hex(encrypt(text, uk));//
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public final static String decrypt(String data){

        try{
            return new String(decrypt(hex2byte(data.getBytes())));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] decrypt(byte[] src) throws Exception{

        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, rk);
        return cipher.doFinal(src);
    } 

    public static String byte2hex(byte[] b){

        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n ++)
        {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs += ("0" + stmp);
            else
                hs += stmp;
        }
        return hs.toUpperCase();
    }

    public static byte[] hex2byte(byte[] b){

        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("长度不是偶数");

        byte[] b2 = new byte[b.length / 2];

        for (int n = 0; n < b.length; n += 2)
        {
            String item = new String(b, n, 2);
            b2[n/2] = (byte)Integer.parseInt(item, 16);
        }
        return b2;
    }
    
	 //  把byte[]元素之间添加空格，并转化成字符串返回，
	  public static String byteToString(byte[] resouce){
	  	StringBuffer sb = new StringBuffer();
	  	for (int i = 0; i < resouce.length; i++) {
	  		if (i == resouce.length-1) {
	  			sb.append(Byte.toString(resouce[i]));
				}else{
					sb.append(Byte.toString(resouce[i]));	
					sb.append(" ");
				}			
			}
	  	return sb.toString();
	  	
	  }
	  
	//  把字符串按照空格进行拆分成数组，然后转化成byte[],返回
	  public byte[] stringToByte(String resouce){
	  	String[] strArr = resouce.split(" ");
	  	int len = strArr.length;
	  	byte[] clone = new byte[len];
	  	for (int i = 0; i < len; i++) {
				clone[i] = Byte.parseByte(strArr[i]);
	  	}
	  	
	  	return clone;
	  	
	  }
}



    



