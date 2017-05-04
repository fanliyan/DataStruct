package dataStruct.Stacck;

import dataStruct.IXianxingbiao.IStack;
import dataStruct.danlianbiao.Node;

/**
 * 链栈
 * @author 范立炎
 *
 */
public class LinkStack implements IStack {

	private Node top;			//栈顶元素的引用
	
	//将栈置空
	@Override
	public void clear() {
		top = null;
	}

	//判链栈是否为空
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	//求链栈长度
	@Override
	public int length() {
		Node p = top; //初始化时，p指向栈顶元素，lenght为计数器
		int length = 0;
		while(p != null){
			p = p.next;
			++length;
		}
		return length;
	}

	//取栈顶元素并返回其值
	@Override
	public Object peek() {
		if(!isEmpty()){			//栈非空
			return top.data;   //返回栈顶元素的值
		}else{
			return null;
		}
		
	}

	//入栈
	@Override
	public void push(Object x) throws Exception {
		Node  p = new Node(x);   //构造一个新结点
		p.next = top;			//新结点成为当前的栈顶结点
		top = p;
	}

	//出栈
	@Override
	public Object pop() {
		if(isEmpty()){
			return null;
		}else{
			Node p = top;       //p指向被删除结点（栈顶结点）
			top = top.next;
			return p.data;
		}
	}

	//输出栈中所有数据元素(从栈顶元素到栈底元素)
	public void display(){
		Node p = top;
		while(p != null){
			System.out.println(p.data.toString() + " ");
			p = p.next;						//p指针向后移
		}
	}
	
}
