package dataStruct.xianxingbiao.test;

import dataStruct.xianxingbiao.SqList;

public class Shunxubiaotest1 {
		public static void main(String[] args) throws Exception {
				SqList L = new SqList(10);
				L.insert(0, 'a');
				L.insert(1, 'z');
				L.insert(2, 'd');
				L.insert(3, 'm');
				L.insert(4, 'z');
				int order = L.indexOf('z');
				if(order != -1){
					System.out.println("˳����е�һ�γ��ֵ�ֵΪ'z'������Ԫ�ص�λ��Ϊ��" + order);
				}else{
					System.out.println("˳����в�����ֵΪ'z'������Ԫ��");
				}
		}
}
