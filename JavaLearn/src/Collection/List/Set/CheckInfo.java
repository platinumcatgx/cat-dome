package Collection.List.Set;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class CheckInfo {
	public static HashSet<User> USER_DATA=new HashSet<User>();
	
	public CheckInfo(HashSet<User> USER_DATA) {this.USER_DATA = USER_DATA;}
	
	//�����û���Ϣ�����ص�½״̬��Ϣ
	public String checkAction(String userName ,String password , String repassword,String birthday,String phone,String email) {
		StringBuilder resder = new StringBuilder();
		//1->true,2->false
		int state = 1;
		if(!password.equals(repassword)) {
			resder.append("������������벻һ�£�\r\n");
			state=2;
		}
		//�����ж�
		if(birthday.length()!=10) {
			resder.append("���ո�ʽ����ȷ\r\n");
			state=2;
		}else {
			for(int i=0;i<birthday.length();i++) {
				Character thisChar = birthday.charAt(i);
				if(i==4||i==7) {
					if(!(thisChar=='-')) {
						resder.append("���ո�ʽ����ȷ\r\n");
						state=2;
					}
				}
			}
		}
		
		//�ֻ����ж�
		if(phone.length()!=11) {
			resder.append("�ֻ��Ÿ�ʽ����ȷ\r\n");
			state=2;
		}else if(!(phone.startsWith("13"))||(phone.startsWith("15"))||(phone.startsWith("17"))||(phone.startsWith("18"))) {
			resder.append("�ֻ��Ÿ�ʽ����ȷ\r\n");
			state=2;
		}
		//�����ж�
		if(!email.contains("@")) {//�ж������ַ��Ĭ�ϲ���@����λ��Ч����
			resder.append("�����ʽ����ȷ\r\n");
			state=2;
		}
		//���������ϢУ������,�����û����뼯��
		if(state==1) {
			//��ʽ�����ڷ���Date����
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			Date dateBirthday=null;
			
			try {
				dateBirthday = format.parse(birthday);
			} catch (ParseException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			User newUser = new User(userName,repassword,dateBirthday,phone,email);
			//���û���ӵ��б���,ͬʱ�ɸ���HashSet�ж��û�����û���ظ�
			if(!USER_DATA.add(newUser)) {
				resder.append("�û��ظ�!");
				state=2;
			}
			if(state==1) {
				resder.append("ע��ɹ�!");
			}
		}
		
		return resder.toString();
		
	}
	
}
