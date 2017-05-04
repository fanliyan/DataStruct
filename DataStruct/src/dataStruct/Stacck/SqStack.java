package dataStruct.Stacck;

import dataStruct.IXianxingbiao.IStack;

/**
 * 顺序栈
 * @author 范立炎
 *
 */
public class SqStack implements IStack {

	private Object[] stackElem;    //对象数组
	private int top;				//在非空栈中， top始终指向栈顶元素的下一个存储位置；当栈为空时，top值为0
	
	public SqStack(int maxSize){
		top = 0;						//初始化top为0
		stackElem = new Object[maxSize];  //为栈分配maxSize个存储单元
	}
	
	//栈置空
	@Override
	public void clear() {
		top = 0;
	}

	//判栈是否为空
	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	//求栈中元素个数
	@Override
	public int length() {
		return top;
	}

	//取栈顶元素
	@Override
	public Object peek() {
		if(!isEmpty()){				//栈非空
			return stackElem[top - 1];   //返回栈顶元素
		}else{
			return null;
		}
	}

	//入栈
	@Override
	public void push(Object x) throws Exception {
		if(top == stackElem.length){		//栈满
			throw new Exception("栈已满");  //抛出异常
		}else{
			stackElem[top++] = x; //先将新的数据元素x压入栈顶，再top增1
		}
	}

	//出栈
	@Override
	public Object pop() {
		if(isEmpty()){
			return null;  //栈空
		}else{					//栈非空
			return stackElem[--top];
		}
	}

	//输出栈中所有数据元素（从栈顶到栈底元素）
	public void display(){
		for(int i = top - 1; i >= 0; i--){
			System.out.println(stackElem[i].toString() + " ");
		}
	}
}
