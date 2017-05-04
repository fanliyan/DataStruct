package dataStruct.stack.test;
import dataStruct.Stacck.LinkStack;

/**
 * �����׺���ʽ��ֵ
 * @author ������
 *
 */
public class HouXuBiaoDaShi {
	
	public String convertToPostfix(String expression) throws Exception{
		LinkStack  st = new LinkStack();    //��ʼ��һ�������ջ
		String posfix = new String();     //���ڴ洢�����׺���ʽ
		for(int i = 0; expression != null && i < expression.length(); i++){
			char c = expression.charAt(i);  //���������ʽ�ж�ȡ һ���ַ�
			if(' ' != c){
				if(isOpenParenthesis(c)){
					st.push(c);      //Ϊ�����ţ�ѹջ
				}else if(isCloseParenthesis(c)){     //Ϊ������
					char ac = (Character)st.pop();   //����ջ��Ԫ��
					while(!isOpenParenthesis(ac)){     //һֱ��������Ϊֹ
						posfix = posfix.concat(String.valueOf(ac));   //��������׺���ʽ��β
						ac = (Character)st.pop();
					}
				}else if(isOperator(c)){    //Ϊ�����
					if(!st.isEmpty()){       //ջ�ǿգ�ȡ��ջ�����ȼ��ߵ������������׺���ʽ
						Character ac = (Character)st.pop();
						while(ac != null && priority(ac.charValue()) >= priority(c)){
							posfix = posfix.concat(String.valueOf(ac));
							ac = (Character)st.pop();
						}
						if(ac != null){    //�����һ��ȡ�������ȼ��͵Ĳ�����������ѹջ
							st.push(ac);
						}
					}
					st.push(c);  		//ѹջ
				}else{					//Ϊ����������������׺���ʽ�Ľ�β
					posfix = posfix.concat(String.valueOf(c));
				}
			}
		}
		while(!st.isEmpty()){        //ջ��ʣ������в�������������׺���ʽ�Ľ�β
			posfix = posfix.concat(String.valueOf(st.pop()));  
		}
		return posfix;
	}
	
	//�Ժ�׺���ʽ������ֵ����ĺ���
	public double numberCalculate(String postfix) throws Exception{
		LinkStack st = new LinkStack();
		for(int i = 0; postfix != null && i < postfix.length(); i++){
			char c = postfix.charAt(i);  	//�Ӻ�׺���ʽ�ж�ȡһ���ַ�
			if(isOperator(c)){       //��Ϊ������ʱ
				//ȡ����������¦
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
				}else if('^' == c){      //������
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
	
	//�ж��ַ����Ƿ�Ϊ�����
	public boolean isOperator(char c){
		if('+' == c || '-' == c || '*' == c || '/' == c || '^' == c || '%' == c){
			return true;
		}else{
			return false;
		}
	}
	
	//�ж��ַ����Ƿ�Ϊ������
	public boolean isOpenParenthesis(char c){
		return '(' == c;
	}
	
	//�ж��ַ����Ƿ�Ϊ������
	public boolean isCloseParenthesis(char c){
		return ')' == c;
	}
	
	//�ж���������ȼ�
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
			System.out.println("���ʽ�Ľ��Ϊ��" + h.numberCalculate(postfix));  //�Ժ�׺���ʽ��ֵ�󣬲����
	}

}
