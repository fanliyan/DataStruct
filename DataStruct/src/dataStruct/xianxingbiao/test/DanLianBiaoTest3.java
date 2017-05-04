package dataStruct.xianxingbiao.test;

import java.util.Scanner;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

public class DanLianBiaoTest3 {

	public static void main(String[] args) throws Exception{
			Scanner sc = new Scanner(System.in);
			int m = 0, n = 0;        //��ʼ��LA�еĽ�����m,LB�еĽ�����n
			System.out.println("������LA�еĽ�������");
			m = sc.nextInt();
			System.out.println("�밴�ǵݼ���ʽ����" + m + "�����֣�");
			LinkList LA = new LinkList(m, true);   //��β�巨����������LA
			System.out.println("������LB�еĽ�������");
			n = sc.nextInt();
			System.out.println("�밴�ǵݼ���ʽ����" + n + "�����֣�");
			LinkList LB = new LinkList(n, true);
			System.out.println("��������LA��LB�鲢���µĵ�����LA�еĸ�������Ԫ�أ�");
			mergeList_L(LA, LB).display();
	}

	public static LinkList mergeList_L(LinkList LA, LinkList LB){
		  Node pa = LA.head.next;		//��ʼ����paΪLA���׽��
		  Node pb = LB.head.next;		//��ʼ����pbΪLB���׽��
		  Node pc = LA.head;            //��LA��ͷ��㣬��ʼ��pc
		  int da, db;   				//���ֵ����Ӧ������
		  while(pa != null && pb != null){
			  da = Integer.valueOf(pa.data.toString());     //���ַ���ת��Ϊ����
			  db = Integer.valueOf(pa.data.toString());
			  if(da <= db){
				  pc.next = pa;          //��LA�еĽ������µ�LA��
				  pc = pa;
				  pa = pa.next;
			  }else{
				  pc.next = pb;         //��LB�еĽ������µ�LA��
				  pc = pb;
				  pb = pb.next;
			  }
		  }
		  pc.next = (pa != null ? pa : pb);
		  return LA;
	}
}
