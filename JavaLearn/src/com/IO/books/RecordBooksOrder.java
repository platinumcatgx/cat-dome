package com.IO.books;

import java.util.ArrayList;
import java.util.Scanner;

public class RecordBooksOrder {
	static  ArrayList<Books> booksList = new ArrayList<Books>();//创建书架
	public static void main(String[] args) {
		init();
		for(int i=0;i<booksList.size();i++) {//打印书架上所有图书信息打印出ac来
			System.out.println(booksList.get(i));
		}
		while (true) {
			//获取控制台输入的信息
			Scanner s =new Scanner(System.in);
			System.out.println("请输入图书编号：");
			int bookId=s.nextInt();
			if(bookId==-1){return ;}//如果输入-1，推出程序
			Books stockBooks = getBooksBuId(bookId);
			if(stockBooks!=null) {//判断是否存在此图书
				System.out.println("当前图书信息"+stockBooks);
				System.out.println("请输入购买数量");
				int bookNumber=s.nextInt();
				if(bookNumber<=stockBooks.number) {//判断库存是否足够
					Books books = new Books(stockBooks.id,stockBooks.name,stockBooks.price,bookNumber,stockBooks.price * bookNumber,stockBooks.Publish);
					FileUtil.saveBooks(books);//将本条数据保存至本地文件
					stockBooks.setNumber(stockBooks.number-bookNumber);//修改库存
				}else{
					System.out.println("库存不足");
				}
			}else{
				System.out.println("图书编号输入错误!");
			}
		}
	}

	/**
	 * 初始化图书信息，将图书放到书架
	 * @return
	 */
	private static void init() {
		Books goods1 = new Books(101,"java基础入门",44.50,100,4450,"清华大学出版社");
		Books goods2 = new Books(102,"java编程思想",108.00,50,5400,"机械工业出版社");
		Books goods3 = new Books(103,"疯狂Java讲义",99.00,100,9900,"电子工业出版社");
		booksList.add(goods1);
		booksList.add(goods2);
		booksList.add(goods3);
	}

	/**
	 * 根据输入的图书编号查找图书信息，循环遍历书架中的图书信息，找到图书编号相等的取出
	 */
	private static Books getBooksBuId(int bookId) {
		for(int i=0;i<booksList.size();i++){
			Books thisBooks = booksList.get(i);
			if(bookId==thisBooks.id)
				return thisBooks;
		}
		return null;
	}
}
