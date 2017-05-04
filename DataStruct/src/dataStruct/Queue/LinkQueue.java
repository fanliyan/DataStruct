package dataStruct.Queue;

import dataStruct.IXianxingbiao.IQueue;
import dataStruct.danlianbiao.Node;

/**
 * ������
 * @author ������
 * @ʱ�� 2017-04-24
 *
 */
public class LinkQueue implements IQueue {

	private Node front;			//����ָ��
	private Node rear;			//��βָ��
	
	//��������Ĺ��캯��
	public LinkQueue() {
		front = rear = null;
	}
	
	//�����ÿ�
	@Override
	public void clear() {
		front = rear = null;
	}

	//�����п�
	@Override
	public boolean isEmpty() {
		return front == null;
	}

	//����г���
	@Override
	public int length() {
		Node  p = front;
		int length = 0;
		while(p != null){
			p = p.next;
			++length;
		}
		return length;
	}

	//ȡ����Ԫ��
	@Override
	public Object peek() {
		if(front != null){			//���зǿ�
			return front.data; 		//���ض��׽���������ֵ
		}else{
			return null;
		}
	}

	//���
	@Override
	public void offer(Object x) throws Exception {
		Node p = new Node(x);  //��ʼ���½��
		if(front != null){		//���зǿ�
			rear.next = p;
			rear = p;			//�ı��βλ��
		}else{
			front = rear = p;
		}
	}

	//����
	@Override
	public Object poll() {
		if(front != null){
			Node p = front;
			front = front.next;
			if(p == rear){
				rear = null;
			}
			return p.data;
		}else{
			return null;
		}
		
	}

}
