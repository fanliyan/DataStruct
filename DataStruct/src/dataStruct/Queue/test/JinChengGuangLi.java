package dataStruct.Queue.test;

import dataStruct.Queue.PriorityQueue;
import dataStruct.danlianbiao.PriorityQData;

/**
 * ģ�²���ϵͳ���̹���
 * @author ������
 * @ʱ�� 2017-04-24
 *
 */
public class JinChengGuangLi {

	public static void main(String[] args) throws Exception {
       PriorityQueue pm = new PriorityQueue();     //����һ������
       pm.offer(new PriorityQData(1, 20));     //�������ȼ�����
       pm.offer(new PriorityQData(2, 30));
       pm.offer(new PriorityQData(3, 20));
       pm.offer(new PriorityQData(4, 20));
       pm.offer(new PriorityQData(5, 40));
       pm.offer(new PriorityQData(6, 10));
       System.out.println("���̷����˳��");
       System.out.println("����ID �������ȼ�");
       while(!pm.isEmpty()){     		//�Ӷ��׵���β���������������ֵ�����ȼ�
    	   PriorityQData p = (PriorityQData)pm.poll();   //�Ƴ����׽�㣬��������������
    	   System.out.println(" " + p.elem + "\t" + p.priority);   //���
       }
	}

}
