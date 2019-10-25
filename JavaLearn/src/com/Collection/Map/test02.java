package com.Collection.Map;

import java.util.*;

public class test02 {
public static void main(String[] args) {
	Properties p = new Properties();//��������
	p.setProperty("bgcolor", "red");//��������
	p.setProperty("Font-size","14px");
	p.setProperty("Language", "chinese");
	Enumeration names = p.propertyNames();
	while(names.hasMoreElements()) {//ѭ���������еļ�
		String key=(String) names.nextElement();
		String value=p.getProperty(key);//��ȡ��Ӧ����ֵ
		System.out.println(key+"="+value);
	}
}
}
