package dataStruct.xianxingbiao.test;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

/**
 * ɾ���������ظ����
 * @author ������
 *
 */
public class DanLianBiaoTest2 {

	public static void main(String[] args) {
         System.out.println("�����뵥�����е�10�����ֵ��");
         try {
			LinkList L = new LinkList(10, true);
			System.out.println("ɾ���ظ����ǰ�������еĸ��� ���ֵΪ��");
			L.display();
			removeRepeatElem(L);
			System.out.println("ɾ���ظ����������еĸ������ֵΪ��");
			L.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void removeRepeatElem(LinkList L) throws Exception{
		Node p = L.head.next, q;   //��ʼ��pָ���׽��
		while(p != null){
			int order = L.indexOf(p.data);
			q = p.next;
			while(q != null){
				if((p.data).equals(q.data)){
					L.remove(order + 1);
				}else{
					++order;
				}
				q = q.next;
			}
			p = p.next;
		}
	}
}
