package dataStruct.Queue;

import dataStruct.IXianxingbiao.IQueue;
import dataStruct.danlianbiao.Node;
import dataStruct.danlianbiao.PriorityQData;


public class PriorityQueue implements IQueue {

	private Node front;      //���׵�����
	private Node rear;
	
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
		Node p = front;
		int length = 0;
		while(p != null){     //һֱ���ҵ���β
			p = p.next;
			++length;
		}
		return length;
	}

	//��ȡ����Ԫ��
	@Override
	public Object peek() {
		if(front == null){    //����Ϊ��
			return null;
		}else{				//���ض��׽���������ֵ
			return front.data;
		}
		
	}

	//���
	@Override
	public void offer(Object x) throws Exception {
		PriorityQData pn = (PriorityQData)x;
		Node s = new Node(pn);   //����һ���½��
		if(front == null){			//����Ϊ��
			front = rear = s;			//�޸Ķ��е���β���
		}else{
			Node p = front, q = front;
			while(p != null && pn.priority >= ((PriorityQData)p.data).priority){   //�½���������ֵ����н���������ֵ��Ƚ�
				q = p;
				p = p.next;
			}
			if(p == null){     //pΪ�գ���ʾ�������˶���β��
				rear.next = s;		//���½����뵽��β
				rear = s;			//�޸Ķ�βָ��
			}else if(p == front){      //p�����ȼ����ڶ��׽�����ȼ�
				s.next = front;			//���½����뵽����
				front = s;				//�޸Ķ��׽��
			}else{					//�½���������в�
				q.next = s;
				s.next = p;
			}
		}
	}

	//����
	@Override
	public Object poll() {
		if(front == null){     //����Ϊ��
			return null;  
		}else{      //���ض��׽���������ֵ�����޸Ķ���ָ��
			Node p = front;
			front = p.next;
			return p.data;
		}
	}

	//������ж����е���������Ԫ�أ��Ӷ��׵���β��
	public void display(){
		if(!isEmpty()){
			Node p = front;
			while(p != rear.next){     //�Ӷ��׵���β
				PriorityQData q = (PriorityQData)p.data;
				System.out.println(q.elem + " " + q.priority);
				p = p.next;
			}
		}else{
			System.out.println("�˶���Ϊ��");
		}
	}
	
}
