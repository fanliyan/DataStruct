package dataStruct.Queue;

import dataStruct.IXianxingbiao.IQueue;

/**
 * ѭ��˳�����
 * @author ������
 *
 */
public class CircleSqQueue implements IQueue {
	
	private Object[] queueElem;				//���д洢�ռ�
	private int front;						//���׵����ã������в��գ�ָ�����Ԫ��
	private int rear;						//��β�����ã������в��գ�ָ���βԪ�ص���һ���洢λ��

	 public CircleSqQueue(int maxSize) {
		 front = rear = 0;			//���׶�β��ʼ��Ϊ0
		 queueElem = new Object[maxSize];   //Ϊ���з���maxSize���洢λ��
	}
	
	 //�����ÿ�
	@Override
	public void clear() {
		front = rear = 0;
	}

	//�ж϶����Ƿ�Ϊ��
	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	//����г���
	@Override
	public int length() {
		return (rear - front + queueElem.length) % queueElem.length;
	}

	//��ȡ����Ԫ��
	@Override
	public Object peek() {
		if(front == rear){			//����Ϊ��
			return null;
		}else{
			return queueElem[front];  //���ض���Ԫ��
		}
	}

	
	//���
	@Override
	public void offer(Object x) throws Exception {
		if((rear + 1) % queueElem.length == front){    //������
			throw new Exception("��������");
		}else{
			queueElem[rear] = x;
			rear = (rear + 1) % queueElem.length;
		}
	}

	//����
	@Override
	public Object poll() {
		if(front == rear){
			return null;
		}else{
			Object t = queueElem[front];
			front = (front + 1) % queueElem.length;
			return t;
		}
		
	}

	//��������е���������Ԫ�أ��Ӷ��׵���β��
	public void display(){
		if(!isEmpty()){
			for(int i = front; i != rear; i = (i + 1) % queueElem.length){
				System.out.println(queueElem[i].toString() + " ");
			}
		}else{
			System.out.println("�˶���Ϊ��");
		}
	}
}
