package dataStruct.stack.test;

import java.util.Scanner;

import dataStruct.Stacck.SqStack;

/**
 * 分隔符匹配
 * @author Fanliyan
 *
 */
public class FenGeFuPiPei{

	private final int LEFT = 0;  //记录分隔符为"左"分隔符
	private final int RIGHT = 0; //记录分隔符为"右"分隔符
	private final int OTHER = 0;
	
	//判断分隔符的类型，有3种："左"、"右"、"非法"
	public int verifyFlag(String str){
		if("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str)){
			return LEFT;     		//左分隔符
		}else if(")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str)){
			return RIGHT;			//右分隔符
		}else{
			return OTHER;			//其他分隔符
		}
	}
	
	//检验左分隔符str1和右分隔符str2是否匹配
	public boolean matches(String str1, String str2){
		if(("(".equals(str1) && ")".equals(str2)) || ("[".equals(str1) && "]".equals(str2)) || ("{".equals(str1) && "}".equals(str2)) || ("/*".equals(str1) && "*/".equals(str2))){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isLegal(String str) throws Exception{
		if(!"".equals(str) && str != null){
			SqStack s = new SqStack(100);   //新建存储空间为100的顺序栈
			int length = str.length();
			for(int i = 0; i < length; i++){
				char c = str.charAt(i);     //指定索引处的char值
				String t = String.valueOf(c);
				if(i != length){
					if(('/' == c && '*' == str.charAt(i + 1)) || ('*' == c && '/' == str.charAt(i + 1))){  //是分隔符"/*"或"*/"
						t = t.concat(String.valueOf(str.charAt(i + 1)));   //与后一个分隔符相连
						++ i;											   //跳过一个字符
					}
				}
				if(LEFT == verifyFlag(t)){   //为左分隔符
					s.push(t);				 //压入栈
				}else if(RIGHT == verifyFlag(t)){
					if(s.isEmpty() || !matches(s.pop().toString(), t)){    //右分隔符与栈顶元素不匹配
						throw new Exception("错误：Java语句不合法！");      //抛出异常
					}
				}
			}
			if(!s.isEmpty()){
				throw new Exception("错误：Java语句不合法！");
			}else{
				return true;
			}
			
		}else{
			throw new Exception("错误：Java语句为空！");
		}
	}
	public static void main(String[] args) throws Exception{
		FenGeFuPiPei f = new FenGeFuPiPei();
		System.out.println("请输入分Java语句：");
		Scanner sc = new Scanner(System.in);
		if(f.isLegal(sc.nextLine())){
			System.out.println("Java语句合法！");
		}else{
			System.out.println("错误：Java语句不合法！");
		}
	}
}
