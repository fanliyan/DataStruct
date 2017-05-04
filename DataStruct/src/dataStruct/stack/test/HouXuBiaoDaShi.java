package dataStruct.stack.test;
import dataStruct.Stacck.LinkStack;

/**
 * 计算后缀表达式的值
 * @author 范立炎
 *
 */
public class HouXuBiaoDaShi {
	
	public String convertToPostfix(String expression) throws Exception{
		LinkStack  st = new LinkStack();    //初始化一个运算符栈
		String posfix = new String();     //用于存储输出后缀表达式
		for(int i = 0; expression != null && i < expression.length(); i++){
			char c = expression.charAt(i);  //从算术表达式中读取 一个字符
			if(' ' != c){
				if(isOpenParenthesis(c)){
					st.push(c);      //为开括号，压栈
				}else if(isCloseParenthesis(c)){     //为闭括号
					char ac = (Character)st.pop();   //弹出栈顶元素
					while(!isOpenParenthesis(ac)){     //一直到开括号为止
						posfix = posfix.concat(String.valueOf(ac));   //串联到后缀表达式结尾
						ac = (Character)st.pop();
					}
				}else if(isOperator(c)){    //为运算符
					if(!st.isEmpty()){       //栈非空，取出栈顶优先级高的运算符送往后缀表达式
						Character ac = (Character)st.pop();
						while(ac != null && priority(ac.charValue()) >= priority(c)){
							posfix = posfix.concat(String.valueOf(ac));
							ac = (Character)st.pop();
						}
						if(ac != null){    //若最后一次取出的优先级低的操作符，重新压栈
							st.push(ac);
						}
					}
					st.push(c);  		//压栈
				}else{					//为操作数，串联到后缀表达式的结尾
					posfix = posfix.concat(String.valueOf(c));
				}
			}
		}
		while(!st.isEmpty()){        //栈中剩余的所有操作符串联到后缀表达式的结尾
			posfix = posfix.concat(String.valueOf(st.pop()));  
		}
		return posfix;
	}
	
	//对后缀表达式进行求值计算的函数
	public double numberCalculate(String postfix) throws Exception{
		LinkStack st = new LinkStack();
		for(int i = 0; postfix != null && i < postfix.length(); i++){
			char c = postfix.charAt(i);  	//从后缀表达式中读取一个字符
			if(isOperator(c)){       //当为操作符时
				//取出两个操作娄
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				if('+' == c){
					d3 = d1 + d2;
				}else if('-' == c){
					d3 = d1 - d2;
				}else if('*' == c){
					d3 = d1 * d2;
				}else if('/' == c){
					d3 = d1 / d2;
				}else if('^' == c){      //幂运算
					d3 = Math.pow(d1, d2);
				}else if('%' == c){
					d3 = d1 % d2;
				}
				st.push(d3);
			}else{
				st.push(c);
			}
		}
		return (Double)st.pop();
	}
	
	//判断字符串是否为运算符
	public boolean isOperator(char c){
		if('+' == c || '-' == c || '*' == c || '/' == c || '^' == c || '%' == c){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串是否为开括号
	public boolean isOpenParenthesis(char c){
		return '(' == c;
	}
	
	//判断字符串是否为闭括号
	public boolean isCloseParenthesis(char c){
		return ')' == c;
	}
	
	//判断运算符优先级
	public int priority(char c){
		if(c == '^'){
			return 3;
		}
		if(c == '*' || c == '/' || c == '%'){
			return 2;
		}else if(c == '+' || c == '-'){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args) throws Exception{
			HouXuBiaoDaShi h = new HouXuBiaoDaShi();
			String postfix = h.convertToPostfix("(1+2)*(5-2)/2^2+5%3");
			System.out.println("表达式的结果为：" + h.numberCalculate(postfix));  //对后缀表达式求值后，并输出
	}

}
