package dataStruct.Stacck;

import dataStruct.IXianxingbiao.IStack;

/**
 * ˳��ջ
 * @author ������
 *
 */
public class SqStack implements IStack {

	private Object[] stackElem;    //��������
	private int top;				//�ڷǿ�ջ�У� topʼ��ָ��ջ��Ԫ�ص���һ���洢λ�ã���ջΪ��ʱ��topֵΪ0
	
	public SqStack(int maxSize){
		top = 0;						//��ʼ��topΪ0
		stackElem = new Object[maxSize];  //Ϊջ����maxSize���洢��Ԫ
	}
	
	//ջ�ÿ�
	@Override
	public void clear() {
		top = 0;
	}

	//��ջ�Ƿ�Ϊ��
	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	//��ջ��Ԫ�ظ���
	@Override
	public int length() {
		return top;
	}

	//ȡջ��Ԫ��
	@Override
	public Object peek() {
		if(!isEmpty()){				//ջ�ǿ�
			return stackElem[top - 1];   //����ջ��Ԫ��
		}else{
			return null;
		}
	}

	//��ջ
	@Override
	public void push(Object x) throws Exception {
		if(top == stackElem.length){		//ջ��
			throw new Exception("ջ����");  //�׳��쳣
		}else{
			stackElem[top++] = x; //�Ƚ��µ�����Ԫ��xѹ��ջ������top��1
		}
	}

	//��ջ
	@Override
	public Object pop() {
		if(isEmpty()){
			return null;  //ջ��
		}else{					//ջ�ǿ�
			return stackElem[--top];
		}
	}

	//���ջ����������Ԫ�أ���ջ����ջ��Ԫ�أ�
	public void display(){
		for(int i = top - 1; i >= 0; i--){
			System.out.println(stackElem[i].toString() + " ");
		}
	}
}
