package dataStruct.xianxingbiao.test;

import java.util.Scanner;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

public class DanLianBiaoTest3 {

	public static void main(String[] args) throws Exception{
			Scanner sc = new Scanner(System.in);
			int m = 0, n = 0;        //初始化LA中的结点个数m,LB中的结点个数n
			System.out.println("请输入LA中的结点个数：");
			m = sc.nextInt();
			System.out.println("请按非递减方式输入" + m + "个数字：");
			LinkList LA = new LinkList(m, true);   //用尾插法创建单链表LA
			System.out.println("请输入LB中的结点个数：");
			n = sc.nextInt();
			System.out.println("请按非递减方式输入" + n + "个数字：");
			LinkList LB = new LinkList(n, true);
			System.out.println("将单链表LA和LB归并后，新的单链表LA中的各个数据元素：");
			mergeList_L(LA, LB).display();
	}

	public static LinkList mergeList_L(LinkList LA, LinkList LB){
		  Node pa = LA.head.next;		//初始化，pa为LA的首结点
		  Node pb = LB.head.next;		//初始化，pb为LB的首结点
		  Node pc = LA.head;            //用LA的头结点，初始化pc
		  int da, db;   				//结点值所对应的整数
		  while(pa != null && pb != null){
			  da = Integer.valueOf(pa.data.toString());     //把字符串转化为整数
			  db = Integer.valueOf(pa.data.toString());
			  if(da <= db){
				  pc.next = pa;          //将LA中的结点加入新的LA中
				  pc = pa;
				  pa = pa.next;
			  }else{
				  pc.next = pb;         //将LB中的结点加入新的LA中
				  pc = pb;
				  pb = pb.next;
			  }
		  }
		  pc.next = (pa != null ? pa : pb);
		  return LA;
	}
}
