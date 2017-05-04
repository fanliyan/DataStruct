package dataStruct.graph;

import dataStruct.IGraph.IGraph;
import dataStruct.Queue.LinkQueue;

/**
 * ͼ�Ĺ�����ȱ���
 * @author ������
 * @ʱ�� 2017-05-03
 *
 */
public class BTraverser {
   
	private static boolean[] visited;    //���ʱ�־����
	
	//��ͼG���й�����ȱ���
	public static void BFSTraverse(IGraph G) throws Exception{
		visited = new boolean[G.getVexNum()];   //���ʱ�־����
		for(int v = 0; v < G.getVexNum(); v++){
			//���ʱ�־�����ʼ��
			visited[v] = false;
		}
		for(int v = 0; v < G.getVexNum(); v++){
			if(!visited[v]){    //v��δ����
				BFS(G, v);
			}
		}
	}
	
	private static void BFS(IGraph G, int v) throws Exception{
		visited[v] = true;
		System.out.println(G.getVex(v).toString() + " ");
		LinkQueue Q = new LinkQueue();     //��������Q
		Q.offer(v);  		//v�����
		while(!Q.isEmpty()){
			int u = (Integer)Q.poll();   //��ͷԪ�س����в���ֵ��u
			for(int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)){
				if(!visited[w]){		//wΪu����δ���ʵ��ڽӶ���
					visited[w] = true;
					System.out.println(G.getVex(w).toString() + " ");
					Q.offer(w);
				}
			}
		}
	}
	
}
