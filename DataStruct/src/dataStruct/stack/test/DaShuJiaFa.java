package dataStruct.stack.test;

import dataStruct.Stacck.LinkStack;

public class DaShuJiaFa {

	public String add(String a, String b) throws Exception{
		LinkStack sum = new LinkStack();  //大数的和
		LinkStack sA = numSplit(a);     //加数字符串以单个字符的形式放入栈中
		LinkStack sB = numSplit(b);     //被加数字符串以单个字符的形式放入栈中
		int partialSum;         		//对于两位数的求和
		boolean isCarry = false;       //进位标示
		while(!sA.isEmpty() && !sB.isEmpty()){
			partialSum = (int)sA.pop() + (int)sB.pop();   //对于两个位求和，并在栈中去除加数和被加数中的该位
			if(isCarry){			//低位进位
				partialSum++;		//进位加到此位上
				isCarry = false;	//重置进位标示
			}
			if(partialSum >= 10){   //需要进位
				partialSum -= 10;
				sum.push(partialSum);
				isCarry = true;    //标示进位
			}else{              //位和不需要进位
				sum.push(partialSum);   //和放入栈中
			}
		}
		LinkStack temp = !sA.isEmpty()?sA:sB;  //引用指向加数和被加数中非空栈
		while(!temp.isEmpty()){			
			if(isCarry){         //最后一次执行加法运算中需要进位
				int t = (int)temp.pop();   //取出加数或被加数没有参加的位
				++t;
				if(t >= 10){          //需要进位
					t -= 10; 
					sum.push(t);
				}else{
					sum.push(t);
					isCarry = false;   //重置位标示
				}
			}else{
				//最后 一次执行加法运算不需要进位
				sum.push(temp.pop());    //把加数或被加数中非空的值放入和中
			}
		}
			if(isCarry){       //最高们需  要进位
				sum.push(1);    //进位放入栈中
			}
			String str = new String();
			while(!sum.isEmpty()){
				//把栈中元素转化成字符串
				str = str.concat(sum.pop().toString());
			}
			return str;
	}
	
	//字符串以单个字符形式放入栈中，并去除字符串中空格，返回以单个字符为元素的栈
	public LinkStack numSplit(String str) throws Exception{
		LinkStack s = new LinkStack();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);   //指定索引处的char值
			if(' ' == c){			//去除空格
				continue;
			}else if('0' <= c && '9' >= c){   //数字放入栈中
				s.push(Integer.valueOf(String.valueOf(c)));
			}else{                 //非法数字字符
				throw new Exception("错误：输入了非数字型字符！");
			}          
		}
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		DaShuJiaFa d = new DaShuJiaFa();
		System.out.println("两个大数和为：" + d.add("18 452 543 389 943 209 752 345 473", "8 123 542 678 432 986 899 334"));
	}
	
}
