package dataStruct.Queue;

import dataStruct.IXianxingbiao.IQueue;
import dataStruct.danlianbiao.Node;

/**
 * 链队列
 * @author 范立炎
 * @时间 2017-04-24
 *
 */
public class LinkQueue implements IQueue {

	private Node front;			//队首指针
	private Node rear;			//队尾指针
	
	//链队列类的构造函数
	public LinkQueue() {
		front = rear = null;
	}
	
	//队列置空
	@Override
	public void clear() {
		front = rear = null;
	}

	//队列判空
	@Override
	public boolean isEmpty() {
		return front == null;
	}

	//求队列长度
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

	//取队首元素
	@Override
	public Object peek() {
		if(front != null){			//队列非空
			return front.data; 		//返回队首结点的数据域值
		}else{
			return null;
		}
	}

	//入队
	@Override
	public void offer(Object x) throws Exception {
		Node p = new Node(x);  //初始化新结点
		if(front != null){		//队列非空
			rear.next = p;
			rear = p;			//改变队尾位置
		}else{
			front = rear = p;
		}
	}

	//出队
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
