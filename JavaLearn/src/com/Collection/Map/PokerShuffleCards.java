package com.Collection.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PokerShuffleCards {
	public static void main(String[] args) {
		//准备花色
		ArrayList<String> color = new ArrayList<String>();
		color.add("♠");
		color.add("♥");
		color.add("♦");
		color.add("♣");
		//准备数字
		ArrayList<String> number=new ArrayList<String>();
		for(int i=3;i<10;i++) {
			number.add(i+"");
		}
		number.add("J");
		number.add("Q");
		number.add("K");
		number.add("A");
		number.add("2");
		
		//定义一个map集合，用数字与每一张牌进行对应
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		int index=0;//纸牌编号
		for(String thisNumber:number) {//循环牌号
			for(String thisColor:color) {//循环花色
				map.put(index++, thisNumber+thisColor);//组成52张牌
			}
		}
		map.put(index++,"JOERK大");
		map.put(index++, "joker小");
		
		//创建内容为0-53的数字集合，代表54张牌
		ArrayList<Integer> cards=new ArrayList<Integer>();
		for(int i=0;i<=53;i++) {
			cards.add(i);
		}
		
		//洗牌,使用COllections工具类中的shuffle()方法
		Collections.shuffle(cards);
		
		//创建三个玩家和底牌
		ArrayList<Integer> iPlay=new ArrayList<Integer>();
		ArrayList<Integer> iPlay2=new ArrayList<Integer>();
		ArrayList<Integer> iPlay3=new ArrayList<Integer>();
		ArrayList<Integer> iSecretCards=new ArrayList<Integer>();
		
		//遍历这副洗好的牌,遍历过程中发牌
		for(int i=0;i<cards.size();i++) {
			if(i>=51) {
				iSecretCards.add(cards.get(i));//保留三张底牌
			}else {
				if(i%3==0) {// 与三取余为0, 给1；为1,给2；其余,给3
					iPlay.add(cards.get(i));
				}else if(i%3==1) {
					iPlay2.add(cards.get(i));
				}else {
					iPlay3.add(cards.get(i));
				}
			}
		}
		//对每个人种手中的牌排序
		Collections.sort(iPlay);
		Collections.sort(iPlay2);
		Collections.sort(iPlay3);
		
		//对应数字形式的每个人手中的牌，定义字符串形式的牌
		ArrayList<String> sPlayer=new ArrayList<String>();
		ArrayList<String> sPlayer2=new ArrayList<String>();
		ArrayList<String> sPlayer3=new ArrayList<String>();
		ArrayList<String> sSecretCards=new ArrayList<String>();
		//循环主键，从map中获取纸牌
		for(Integer key:iPlay) {
			sPlayer.add(map.get(key));
		}
		for(Integer key:iPlay2) {
			sPlayer2.add(map.get(key));
		}
		for(Integer key:iPlay3) {
			sPlayer3.add(map.get(key));
		}
		for(Integer key:iSecretCards) {
			sSecretCards.add(map.get(key));
		}
		
		System.out.println("玩家1："+sPlayer);
		System.out.println("玩家2："+sPlayer2);
		System.out.println("玩家3："+sPlayer3);
		System.out.println("底牌："+sSecretCards);
	}
}






















