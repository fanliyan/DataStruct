package dataStruct.stack.test;

import dataStruct.Stacck.LinkStack;

public class DaShuJiaFa {

	public String add(String a, String b) throws Exception{
		LinkStack sum = new LinkStack();  //�����ĺ�
		LinkStack sA = numSplit(a);     //�����ַ����Ե����ַ�����ʽ����ջ��
		LinkStack sB = numSplit(b);     //�������ַ����Ե����ַ�����ʽ����ջ��
		int partialSum;         		//������λ�������
		boolean isCarry = false;       //��λ��ʾ
		while(!sA.isEmpty() && !sB.isEmpty()){
			partialSum = (int)sA.pop() + (int)sB.pop();   //��������λ��ͣ�����ջ��ȥ�������ͱ������еĸ�λ
			if(isCarry){			//��λ��λ
				partialSum++;		//��λ�ӵ���λ��
				isCarry = false;	//���ý�λ��ʾ
			}
			if(partialSum >= 10){   //��Ҫ��λ
				partialSum -= 10;
				sum.push(partialSum);
				isCarry = true;    //��ʾ��λ
			}else{              //λ�Ͳ���Ҫ��λ
				sum.push(partialSum);   //�ͷ���ջ��
			}
		}
		LinkStack temp = !sA.isEmpty()?sA:sB;  //����ָ������ͱ������зǿ�ջ
		while(!temp.isEmpty()){			
			if(isCarry){         //���һ��ִ�мӷ���������Ҫ��λ
				int t = (int)temp.pop();   //ȡ�������򱻼���û�вμӵ�λ
				++t;
				if(t >= 10){          //��Ҫ��λ
					t -= 10; 
					sum.push(t);
				}else{
					sum.push(t);
					isCarry = false;   //����λ��ʾ
				}
			}else{
				//��� һ��ִ�мӷ����㲻��Ҫ��λ
				sum.push(temp.pop());    //�Ѽ����򱻼����зǿյ�ֵ�������
			}
		}
			if(isCarry){       //�������  Ҫ��λ
				sum.push(1);    //��λ����ջ��
			}
			String str = new String();
			while(!sum.isEmpty()){
				//��ջ��Ԫ��ת�����ַ���
				str = str.concat(sum.pop().toString());
			}
			return str;
	}
	
	//�ַ����Ե����ַ���ʽ����ջ�У���ȥ���ַ����пո񣬷����Ե����ַ�ΪԪ�ص�ջ
	public LinkStack numSplit(String str) throws Exception{
		LinkStack s = new LinkStack();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);   //ָ����������charֵ
			if(' ' == c){			//ȥ���ո�
				continue;
			}else if('0' <= c && '9' >= c){   //���ַ���ջ��
				s.push(Integer.valueOf(String.valueOf(c)));
			}else{                 //�Ƿ������ַ�
				throw new Exception("���������˷��������ַ���");
			}          
		}
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		DaShuJiaFa d = new DaShuJiaFa();
		System.out.println("����������Ϊ��" + d.add("18 452 543 389 943 209 752 345 473", "8 123 542 678 432 986 899 334"));
	}
	
}
