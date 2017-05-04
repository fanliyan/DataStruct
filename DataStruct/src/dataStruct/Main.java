package dataStruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	  public static void main(String[] args) {
		int xiaoTaoNum = 0;
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入队伍人数n,按回车确认");
		int n = reader.nextInt();
		System.out.println("请输入队伍中三类人的情况，按回车确认");
		String duiwu = reader.next();
		System.out.println(n);
		System.out.println(duiwu);
		List jinchaList = new ArrayList();
		List xiaotaoList = new ArrayList();
		List ptrList = new ArrayList();
		if(duiwu.length() > n || duiwu.length() <= 0){
			System.out.println("队伍输入有误！");
		}else{
			String[] duiwuArray = duiwu.split("");
			System.out.println(duiwuArray.length);
			System.out.println(duiwuArray[1]);
			for(int i = 0; i < duiwuArray.length; i++){
				if(!"X".equals(duiwuArray[i]) || !"#".equals(duiwuArray[i]) || !"1".equals(duiwuArray[i]) || !"2".equals(duiwuArray[i]) || !"3".equals(duiwuArray[i]) || !"4".equals(duiwuArray[i])
						 || !"5".equals(duiwuArray[i]) || !"6".equals(duiwuArray[i]) || !"7".equals(duiwuArray[i]) || !"8".equals(duiwuArray[i]) || !"9".equals(duiwuArray[i])){
					System.out.println("输入不合法");
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
