package dataStruct.xianxingbiao.test;

import java.util.Scanner;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

/**
 * 编程实现一元多项式加法
 * @author 范立炎
 *
 */
public class PolynList extends LinkList{

	
	public PolynList(int n) throws Exception{
		head.data = new PolynNode(0, -1);     //初始化头结点
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= n; i++){        //输入n个结点数据域值
			double coef = sc.nextDouble();     //系数值
			int expn = sc.nextInt();           //指数值
			insert(new PolynNode(coef, expn));   //插入到有序链表
		}
	}
	
	//按指数递增顺序插入到多项式有序链表
	public void insert(PolynNode e) throws Exception{
		int j = 0;
		while(j < length()){
			PolynNode t = (PolynNode)get(j);   //与有序中的已有项进行指数比较
			if(t.expn > e.expn){
				break;
			}
			j++;
		}
		insert(j, e);     //调用父类插入函数
	}
	
	//判定函数，比较多项式中两项的指数，按a的指数值小于、等于和大于b的指数值，分别返回-1 0 +1
	public int cmp(PolynNode a, PolynNode b){
		if(a.expn < b.expn){
			return -1;
		}else if(a.expn == b.expn){
			return 0;
		}else{
			return 1;
		}
	}
	
	//多项式加法：Pa = Pa + Pb,利用两个多项式的结点构成"和多项式",并返回LA
	public PolynList addPolyn(PolynList LA, PolynList LB){
		Node ha = LA.head; //ha指向新形成的结点构成"和多项式"，并返回LA
		Node qa = LA.head.next;   //qa指向LA中需要计算的当前项
		Node qb = LB.head.next;   //qb指向LB中需要计算的当前项
		while(qa != null && qb != null){
			PolynNode a = (PolynNode)qa.data;
			PolynNode b = (PolynNode)qb.data;
			switch(cmp(a, b)){
			case -1:				//多项式中LA的结点的指数值小
				ha.next = qa;
				ha = qa;
				qa = qa.next;
				break;
			case 0:
				double sum = a.coef + b.coef; //求系数的和
				if(sum != 0.0){
					a.coef = sum;
					ha.next = qa;
					ha = qa;
					qa = qa.next;
					qb = qb.next;
				}else{
					qa = qa.next;
					qb = qb.next;
				}
				break;
			case 1:
				ha.next = qb;
				ha = qb;
				qb = qb.next;
				break;
			}
		}
		ha.next = (qa != null ? qa : qb);
		return LA;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入A多项式的项数：");
		int m = sc.nextInt();
		System.out.println("请分别输入多项式A各项的系数和指数：");
		PolynList LA = new PolynList(m);
		System.out.println("请输入B多项式的项数：");
		int n = sc.nextInt();
		System.out.println("请分别输入多项式B各项的系数和指数：");
		PolynList LB = new PolynList(n);    //创建多项式LB
		LA = LA.addPolyn(LA, LB);			//对多项式LA、LB求和，并赋给LA
		System.out.println("求和后的多项式各项为：");
		LA.display();
	}
	
	//重载父类display()方法
	public void display(){
		for(int i = 0; i < length(); i++){
			try {
				PolynNode e = (PolynNode)get(i);
				System.out.println("系数为：" + e.coef + "指数为：" + e.expn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
