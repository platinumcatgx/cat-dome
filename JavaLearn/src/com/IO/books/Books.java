package com.IO.books;

public class Books {
	int id;
	String name;
	double price;//单价
	int number;//数量
	double money;//总价
	String Publish;//出版社
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
		String m = "图书编号："+id+"  图书名称："+name+"  出版社："+Publish+"  单价："+price+"  库存数量："+number;
		return m;
	}
	
	public void setNumber(int number) {
		this.number=number;
	}
	
	
	
}
