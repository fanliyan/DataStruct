package dataStruct.stack.test;

import java.util.Scanner;

import dataStruct.Stacck.SqStack;

/**
 * �ָ���ƥ��
 * @author Fanliyan
 *
 */
public class FenGeFuPiPei{

	private final int LEFT = 0;  //��¼�ָ���Ϊ"��"�ָ���
	private final int RIGHT = 0; //��¼�ָ���Ϊ"��"�ָ���
	private final int OTHER = 0;
	
	//�жϷָ��������ͣ���3�֣�"��"��"��"��"�Ƿ�"
	public int verifyFlag(String str){
		if("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str)){
			return LEFT;     		//��ָ���
		}else if(")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str)){
			return RIGHT;			//�ҷָ���
		}else{
			return OTHER;			//�����ָ���
		}
	}
	
	//������ָ���str1���ҷָ���str2�Ƿ�ƥ��
	public boolean matches(String str1, String str2){
		if(("(".equals(str1) && ")".equals(str2)) || ("[".equals(str1) && "]".equals(str2)) || ("{".equals(str1) && "}".equals(str2)) || ("/*".equals(str1) && "*/".equals(str2))){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isLegal(String str) throws Exception{
		if(!"".equals(str) && str != null){
			SqStack s = new SqStack(100);   //�½��洢�ռ�Ϊ100��˳��ջ
			int length = str.length();
			for(int i = 0; i < length; i++){
				char c = str.charAt(i);     //ָ����������charֵ
				String t = String.valueOf(c);
				if(i != length){
					if(('/' == c && '*' == str.charAt(i + 1)) || ('*' == c && '/' == str.charAt(i + 1))){  //�Ƿָ���"/*"��"*/"
						t = t.concat(String.valueOf(str.charAt(i + 1)));   //���һ���ָ�������
						++ i;											   //����һ���ַ�
					}
				}
				if(LEFT == verifyFlag(t)){   //Ϊ��ָ���
					s.push(t);				 //ѹ��ջ
				}else if(RIGHT == verifyFlag(t)){
					if(s.isEmpty() || !matches(s.pop().toString(), t)){    //�ҷָ�����ջ��Ԫ�ز�ƥ��
						throw new Exception("����Java��䲻�Ϸ���");      //�׳��쳣
					}
				}
			}
			if(!s.isEmpty()){
				throw new Exception("����Java��䲻�Ϸ���");
			}else{
				return true;
			}
			
		}else{
			throw new Exception("����Java���Ϊ�գ�");
		}
	}
	public static void main(String[] args) throws Exception{
		FenGeFuPiPei f = new FenGeFuPiPei();
		System.out.println("�������Java��䣺");
		Scanner sc = new Scanner(System.in);
		if(f.isLegal(sc.nextLine())){
			System.out.println("Java���Ϸ���");
		}else{
			System.out.println("����Java��䲻�Ϸ���");
		}
	}
}
