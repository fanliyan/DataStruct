package dataStruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	  public static void main(String[] args) {
		int xiaoTaoNum = 0;
		Scanner reader = new Scanner(System.in);
		System.out.println("�������������n,���س�ȷ��");
		int n = reader.nextInt();
		System.out.println("����������������˵���������س�ȷ��");
		String duiwu = reader.next();
		System.out.println(n);
		System.out.println(duiwu);
		List jinchaList = new ArrayList();
		List xiaotaoList = new ArrayList();
		List ptrList = new ArrayList();
		if(duiwu.length() > n || duiwu.length() <= 0){
			System.out.println("������������");
		}else{
			String[] duiwuArray = duiwu.split("");
			System.out.println(duiwuArray.length);
			System.out.println(duiwuArray[1]);
			for(int i = 0; i < duiwuArray.length; i++){
				if(!"X".equals(duiwuArray[i]) || !"#".equals(duiwuArray[i]) || !"1".equals(duiwuArray[i]) || !"2".equals(duiwuArray[i]) || !"3".equals(duiwuArray[i]) || !"4".equals(duiwuArray[i])
						 || !"5".equals(duiwuArray[i]) || !"6".equals(duiwuArray[i]) || !"7".equals(duiwuArray[i]) || !"8".equals(duiwuArray[i]) || !"9".equals(duiwuArray[i])){
					System.out.println("���벻�Ϸ�");
				}else if("1".equals(duiwuArray[i]) || "2".equals(duiwuArray[i]) || "3".equals(duiwuArray[i]) || "4".equals(duiwuArray[i]) || "5".equals(duiwuArray[i]) || "6".equals(duiwuArray[i]) || "7".equals(duiwuArray[i])
						 || "8".equals(duiwuArray[i]) || "9".equals(duiwuArray[i])){
					int jingchaNL = Integer.parseInt(duiwuArray[i]);
					jinchaList.add(i);
				}else if("X".equals(duiwuArray[i])){
					   xiaotaoList.add(i);
				}else if("#".equals(duiwuArray[i])){
					  ptrList.add(i);
				}
				for(Object jci: jinchaList){
					for(Object xti: xiaotaoList){
					
					}
				}
			}
			
		}
	}
}
