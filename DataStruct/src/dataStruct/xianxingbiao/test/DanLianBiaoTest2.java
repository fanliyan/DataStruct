package dataStruct.xianxingbiao.test;

import dataStruct.danlianbiao.LinkList;
import dataStruct.danlianbiao.Node;

/**
 * 删除单链表重复结点
 * @author 范立炎
 *
 */
public class DanLianBiaoTest2 {

	public static void main(String[] args) {
         System.out.println("请输入单链表中的10个结点值：");
         try {
			LinkList L = new LinkList(10, true);
			System.out.println("删除重复结点前单链表中的各个 结点值为：");
			L.display();
			removeRepeatElem(L);
			System.out.println("删除重复结点后单链表中的各个结点值为：");
			L.display();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void removeRepeatElem(LinkList L) throws Exception{
		Node p = L.head.next, q;   //初始化p指向首结点
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
