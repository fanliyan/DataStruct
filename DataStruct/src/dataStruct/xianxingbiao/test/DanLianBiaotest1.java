package dataStruct.xianxingbiao.test;

import java.util.Scanner;

import dataStruct.danlianbiao.LinkList;

public class DanLianBiaotest1 {

	public static void main(String[] args) {
		int n = 10;
		LinkList L = new LinkList();
		for(int i = 0; i < n; i++){
			try {
				L.insert(i, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("������i��ֵ��");
		int i = new Scanner(System.in).nextInt();
		if(0 < i && i <= n){
			try {
				System.out.println("��" + i + "��Ԫ�ص�ֱ��ǰ���ǣ�" + L.get(i - 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("��" + i + "��Ԫ�ص�ֱ��ǰ��������");
		}
	}
}
