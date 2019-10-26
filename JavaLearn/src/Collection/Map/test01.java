package Collection.Map;

import java.util.*;

public class test01 {
public static void main(String[] args) {
	Map m = new LinkedHashMap();//����LinkerhashMap���󣬶�ȡ˳�������˳����ͬ
	m.put("1", "java");
	m.put("2","c++");
	m.put("3","python");
	//Collection c = m.values();//��ȡ��
	Set c=m.keySet();//��ȡ��
	Iterator it =c.iterator();//���ڱ���Map����
	while(it.hasNext()) {//ѭ������
		Object key = it.next();//��ȡ��һ��ֵ��
		Object value = m.get(key);//��ȡ����Ӧ��ֵ
		System.out.println(key+":"+value);
	}
}
}
