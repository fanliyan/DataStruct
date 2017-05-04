package dataStruct.Queue;

import dataStruct.IXianxingbiao.IQueue;

/**
 * 循环顺序队列
 * @author 范立炎
 *
 */
public class CircleSqQueue implements IQueue {
	
	private Object[] queueElem;				//队列存储空间
	private int front;						//队首的引用，若队列不空，指向队首元素
	private int rear;						//队尾的引用，若队列不空，指向队尾元素的下一个存储位置

	 public CircleSqQueue(int maxSize) {
		 front = rear = 0;			//队首队尾初始化为0
		 queueElem = new Object[maxSize];   //为队列分配maxSize个存储位置
	}
	
	 //队列置空
	@Override
	public void clear() {
		front = rear = 0;
	}

	//判断队列是否为空
	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	//求队列长度
	@Override
	public int length() {
		return (rear - front + queueElem.length) % queueElem.length;
	}

	//读取队首元素
	@Override
	public Object peek() {
		if(front == rear){			//队列为空
			return null;
		}else{
			return queueElem[front];  //返回队首元素
		}
	}

	
	//入队
	@Override
	public void offer(Object x) throws Exception {
		if((rear + 1) % queueElem.length == front){    //队列满
			throw new Exception("队列已满");
		}else{
			queueElem[rear] = x;
			rear = (rear + 1) % queueElem.length;
		}
	}

	//出队
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

	//输出队列中的所有数据元素（从队首到队尾）
	public void display(){
		if(!isEmpty()){
			for(int i = front; i != rear; i = (i + 1) % queueElem.length){
				System.out.println(queueElem[i].toString() + " ");
			}
		}else{
			System.out.println("此队列为空");
		}
	}
}
