package dataStruct.Queue.test;

import dataStruct.Queue.PriorityQueue;
import dataStruct.danlianbiao.PriorityQData;

/**
 * 模仿操作系统进程管理
 * @author 范立炎
 * @时间 2017-04-24
 *
 */
public class JinChengGuangLi {

	public static void main(String[] args) throws Exception {
       PriorityQueue pm = new PriorityQueue();     //构造一个对象
       pm.offer(new PriorityQData(1, 20));     //插入优先级队列
       pm.offer(new PriorityQData(2, 30));
       pm.offer(new PriorityQData(3, 20));
       pm.offer(new PriorityQData(4, 20));
       pm.offer(new PriorityQData(5, 40));
       pm.offer(new PriorityQData(6, 10));
       System.out.println("进程服务的顺序：");
       System.out.println("进程ID 进程优先级");
       while(!pm.isEmpty()){     		//从队首到队尾，输出结点的数据域值和优先级
    	   PriorityQData p = (PriorityQData)pm.poll();   //移除队首结点，并返回其数据域
    	   System.out.println(" " + p.elem + "\t" + p.priority);   //输出
       }
	}

}
