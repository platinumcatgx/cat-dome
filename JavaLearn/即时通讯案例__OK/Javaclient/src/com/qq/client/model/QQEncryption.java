package com.qq.client.model;

import com.qq.client.*;
import com.qq.client.encryption.DES;
import com.qq.client.encryption.RSACrypto;
/*
 * 加密，解密操作
 * 两种实现方式：1.DES   2.RSA  我用的是RSA
 */
public class QQEncryption {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QQEncryption qq = new QQEncryption();
		String result = qq.RSAEncryption("123");
		System.out.println(result);
		result = qq.RSADecryption(result);
		System.out.println(result);
	}
	
	
	//DSE加密
	public String DESEncryption(String str){
		String text;
		byte[] result;
		       
        String password = "88888888";//密码，长度要是8的倍数

        result = DES.encrypt(str.getBytes(),password);
		text = byteToString(result);
		
		return text;
	}	
	
	//DSE解密
	public String DESDecryption(String resouce){
		
		//把字符串按照空格进行拆分成数组，然后转化成byte[],返回
		byte[] result = stringToByte(resouce);		
		String str = null;
        
        String password = "88888888";//密码，长度要是8的倍数
       
        //直接将如上内容解密
        try {
                byte[] decryResult = DES.decrypt(result, password);
                str=new String(decryResult);

        } catch (Exception e1) {
                e1.printStackTrace();
        }
        
        return str;
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
	
	
	
	
	
	//RSA加密
	public String RSAEncryption(String str){
		String result = null;
		try{
            RSACrypto.generateKey();
            result = RSACrypto.encrypt(str);

            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return result;
	}	
	
	//RSA解密
	public String RSADecryption(String result){
		String str = null;
        
		try{
            str = RSACrypto.decrypt(result);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return str;
	}

}






