package dataStruct.xianxingbiao.test;

import java.util.Scanner;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

/**
 * ���ʵ��һԪ����ʽ�ӷ�
 * @author ������
 *
 */
public class PolynList extends LinkList{

	
	public PolynList(int n) throws Exception{
		head.data = new PolynNode(0, -1);     //��ʼ��ͷ���
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= n; i++){        //����n�����������ֵ
			double coef = sc.nextDouble();     //ϵ��ֵ
			int expn = sc.nextInt();           //ָ��ֵ
			insert(new PolynNode(coef, expn));   //���뵽��������
		}
	}
	
	//��ָ������˳����뵽����ʽ��������
	public void insert(PolynNode e) throws Exception{
		int j = 0;
		while(j < length()){
			PolynNode t = (PolynNode)get(j);   //�������е����������ָ���Ƚ�
			if(t.expn > e.expn){
				break;
			}
			j++;
		}
		insert(j, e);     //���ø�����뺯��
	}
	
	//�ж��������Ƚ϶���ʽ�������ָ������a��ָ��ֵС�ڡ����ںʹ���b��ָ��ֵ���ֱ𷵻�-1 0 +1
	public int cmp(PolynNode a, PolynNode b){
		if(a.expn < b.expn){
			return -1;
		}else if(a.expn == b.expn){
			return 0;
		}else{
			return 1;
		}
	}
	
	//����ʽ�ӷ���Pa = Pa + Pb,������������ʽ�Ľ�㹹��"�Ͷ���ʽ",������LA
	public PolynList addPolyn(PolynList LA, PolynList LB){
		Node ha = LA.head; //haָ�����γɵĽ�㹹��"�Ͷ���ʽ"��������LA
		Node qa = LA.head.next;   //qaָ��LA����Ҫ����ĵ�ǰ��
		Node qb = LB.head.next;   //qbָ��LB����Ҫ����ĵ�ǰ��
		while(qa != null && qb != null){
			PolynNode a = (PolynNode)qa.data;
			PolynNode b = (PolynNode)qb.data;
			switch(cmp(a, b)){
			case -1:				//����ʽ��LA�Ľ���ָ��ֵС
				ha.next = qa;
				ha = qa;
				qa = qa.next;
				break;
			case 0:
				double sum = a.coef + b.coef; //��ϵ���ĺ�
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
		System.out.println("������A����ʽ��������");
		int m = sc.nextInt();
		System.out.println("��ֱ��������ʽA�����ϵ����ָ����");
		PolynList LA = new PolynList(m);
		System.out.println("������B����ʽ��������");
		int n = sc.nextInt();
		System.out.println("��ֱ��������ʽB�����ϵ����ָ����");
		PolynList LB = new PolynList(n);    //��������ʽLB
		LA = LA.addPolyn(LA, LB);			//�Զ���ʽLA��LB��ͣ�������LA
		System.out.println("��ͺ�Ķ���ʽ����Ϊ��");
		LA.display();
	}
	
	//���ظ���display()����
	public void display(){
		for(int i = 0; i < length(); i++){
			try {
				PolynNode e = (PolynNode)get(i);
				System.out.println("ϵ��Ϊ��" + e.coef + "ָ��Ϊ��" + e.expn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
