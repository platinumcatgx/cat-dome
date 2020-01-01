package Collection.List.Set;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class UserRegister {
	public static HashSet<User> USER_DATA=new HashSet<User>();//�û�����
	public static void main(String[] args) {
		initData();//��ʼ����Ա��Ϣ
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�������û�����");
		String userName=scan.nextLine();
		System.out.print("���������룺");
		String password=scan.nextLine();
		System.out.print("���ظ����룺");
		String repassword=scan.nextLine();
		System.out.print("������������ڣ�");
		String birthday=scan.nextLine();
		System.out.print("������绰���룺");
		String telNumber=scan.nextLine();
		System.out.print("������������䣺");
		String email=scan.nextLine();
		
		//У���û���Ϣ�����ص�½״̬��Ϣ
		CheckInfo checkInfo = new CheckInfo(USER_DATA);
		String result = checkInfo.checkAction(userName, password, repassword, birthday, telNumber, email);
		System.out.println("ע������"+result);
	}
	//��ʼ������,���������Ѵ��ڵ��û�
	private static void initData() {
		User user = new User("����","zz,123",new Date(),"18800000000","zhangzheng@test.com");
		User user2 = new User("����","zq,123",new Date(),"18800000001","zhouqi@test.com");
		USER_DATA.add(user);
		USER_DATA.add(user2);
	}
}