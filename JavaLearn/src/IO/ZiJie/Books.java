package IO.ZiJie;

public class Books {
	int id;
	String name;
	double price;//??�b??
	int number;//???????
	double money;//???
	String Publish;//??????
	public Books(int id, String name, double price, int number, double money, String publish) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.money = money;
		this.Publish = publish;
	}
	@Override
	public String toString() {
		String m = "?????:"+"id"+"????????"+name+"?????��"+Publish+"?????"+price+"???????"+number;
		return m;
	}
	
	public void setNumber(int number) {
		this.number=number;
	}
	
	
	
}
