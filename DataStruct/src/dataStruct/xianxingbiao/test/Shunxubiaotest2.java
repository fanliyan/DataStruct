package dataStruct.xianxingbiao.test;

import java.util.Scanner;

import dataStruct.xianxingbiao.SqList;

public class Shunxubiaotest2 {

	public static void main(String[] args) {
        int n = 10;
        SqList L = new SqList(80);
        for(int i = 0; i < n; i++){
        	try {
				L.insert(i, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        }
        System.out.println("请输入i的值：");
    	int i = new Scanner(System.in).nextInt();
    	if(0 < i && i <= n){
    		try {
				System.out.println("第" + i + "个元素的直接前驱是：" + L.get(i - 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else{
    		System.out.println("第" + i + "个元素的直接前驱不存在！");
    	}
	}

}
