package dataStruct.Stacck;

import dataStruct.IXianxingbiao.IStack;
import dataStruct.danlianbiao.Node;

/**
 * ��ջ
 * @author ������
 *
 */
public class LinkStack implements IStack {

	private Node top;			//ջ��Ԫ�ص�����
	
	//��ջ�ÿ�
	@Override
	public void clear() {
		top = null;
	}

	//����ջ�Ƿ�Ϊ��
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	//����ջ����
	@Override
	public int length() {
		Node p = top; //��ʼ��ʱ��pָ��ջ��Ԫ�أ�lenghtΪ������
		int length = 0;
		while(p != null){
			p = p.next;
			++length;
		}
		return length;
	}

	//ȡջ��Ԫ�ز�������ֵ
	@Override
	public Object peek() {
		if(!isEmpty()){			//ջ�ǿ�
			return top.data;   //����ջ��Ԫ�ص�ֵ
		}else{
			return null;
		}
		
	}

	//��ջ
	@Override
	public void push(Object x) throws Exception {
		Node  p = new Node(x);   //����һ���½��
		p.next = top;			//�½���Ϊ��ǰ��ջ�����
		top = p;
	}

	//��ջ
	@Override
	public Object pop() {
		if(isEmpty()){
			return null;
		}else{
			Node p = top;       //pָ��ɾ����㣨ջ����㣩
			top = top.next;
			return p.data;
		}
	}

	//���ջ����������Ԫ��(��ջ��Ԫ�ص�ջ��Ԫ��)
	public void display(){
		Node p = top;
		while(p != null){
			System.out.println(p.data.toString() + " ");
			p = p.next;						//pָ�������
		}
	}
	
}
