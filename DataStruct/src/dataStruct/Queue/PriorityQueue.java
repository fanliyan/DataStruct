package dataStruct.Queue;

import dataStruct.IXianxingbiao.IQueue;
import dataStruct.danlianbiao.Node;
import dataStruct.danlianbiao.PriorityQData;


public class PriorityQueue implements IQueue {

	private Node front;      //队首的引用
	private Node rear;
	
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
		Node p = front;
		int length = 0;
		while(p != null){     //一直查找到队尾
			p = p.next;
			++length;
		}
		return length;
	}

	//读取队首元素
	@Override
	public Object peek() {
		if(front == null){    //队列为空
			return null;
		}else{				//返回队首结点的数据域值
			return front.data;
		}
		
	}

	//入队
	@Override
	public void offer(Object x) throws Exception {
		PriorityQData pn = (PriorityQData)x;
		Node s = new Node(pn);   //构造一个新结点
		if(front == null){			//队列为空
			front = rear = s;			//修改队列的首尾结点
		}else{
			Node p = front, q = front;
			while(p != null && pn.priority >= ((PriorityQData)p.data).priority){   //新结点的数据域值与队列结点的数据域值相比较
				q = p;
				p = p.next;
			}
			if(p == null){     //p为空，表示遍历到了队列尾部
				rear.next = s;		//将新结点加入到队尾
				rear = s;			//修改队尾指针
			}else if(p == front){      //p的优先级大于队首结点优先级
				s.next = front;			//将新结点加入到队首
				front = s;				//修改队首结点
			}else{					//新结点加入队列中部
				q.next = s;
				s.next = p;
			}
		}
	}

	//出队
	@Override
	public Object poll() {
		if(front == null){     //队列为空
			return null;  
		}else{      //返回队首结点的数据域值，并修改队首指针
			Node p = front;
			front = p.next;
			return p.data;
		}
	}

	//输出所有队列中的所有数据元素（从队首到队尾）
	public void display(){
		if(!isEmpty()){
			Node p = front;
			while(p != rear.next){     //从队首到队尾
				PriorityQData q = (PriorityQData)p.data;
				System.out.println(q.elem + " " + q.priority);
				p = p.next;
			}
		}else{
			System.out.println("此队列为空");
		}
	}
	
}
