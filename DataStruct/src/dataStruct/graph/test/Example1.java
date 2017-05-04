package dataStruct.graph.test;

import dataStruct.IGraph.IGraph;
import dataStruct.Queue.LinkQueue;
import dataStruct.graph.GraphKind;
import dataStruct.graph.MGraph;

/**
 * ��������㷨����ȷ������ͼ��ͨ����
 * @author ������
 * @ʱ�� 2017-05-04
 */
public class Example1 {
    public final static int INFINITY = Integer.MAX_VALUE;
    
    public static void CC_BFS(IGraph G) throws Exception{
    	boolean visited[] = new boolean[G.getVexNum()];   //���ʱ�־����
    	for(int v = 0; v < G.getVexNum(); v++){
    		//���ʱ�־�����ʼ��
    		visited[v] = false;
    	}
    	LinkQueue Q = new LinkQueue();    //��������Q
    	LinkQueue P = new LinkQueue();     //��������P,���ڼ�¼��ͨ�����Ķ���
    	int i = 0;					//���ڼ�¼��ͨ�����ĸ���
    	for(int v = 0; v < G.getVexNum(); v++){
    		P.clear();    //�������
    		if(!visited[v]){     //v��δ����
    			visited[v] = true;
    			P.offer(G.getVex(v));
    			Q.offer(v);    //v�����
    			while(!Q.isEmpty()){
    				int u = (Integer)Q.poll();       //��ͷԪ�س����в���ֵ
    				for(int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)){
    					if(!visited[w]){   //wΪu����δ���ʵ��ڽӶ���
    						visited[w] = true;
    						P.offer(G.getVex(w));
    						Q.offer(w);
    					}
    				}
    			}
    			System.out.println("ͼ�ĵ�" + ++i + "����ͨͼΪ��");
    			while(!P.isEmpty()){
    				System.out.print(P.poll().toString() + " ");
    			}
    			System.out.println();
    		}
    	}
    }
    
    public static void main(String[] args) throws Exception{
		Object vexs[] = {"A", "B", "C", "D", "E", "F", "G"};
		int[][] arcs = {
				{0, 1, INFINITY, 1, INFINITY, INFINITY, INFINITY},
				{1, 0, 1, INFINITY, INFINITY, INFINITY, INFINITY},
				{INFINITY, 1, 0, 1, INFINITY, INFINITY, INFINITY},
				{1, INFINITY, 1, 0, INFINITY, INFINITY, INFINITY},
				{INFINITY, INFINITY, INFINITY, INFINITY, 0, 1, INFINITY},
				{INFINITY, INFINITY, INFINITY, INFINITY, 1, 0, 1},
				{INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 1, 0},
		};
		MGraph G = new MGraph(GraphKind.UDG, 7, 6, vexs, arcs);
		CC_BFS(G);
	}
}
