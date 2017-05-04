package dataStruct.graph;

import dataStruct.IGraph.IGraph;

/**
 * ͼ��������ȱ���
 * @author ������
 * ʱ�� 2017-05-03
 */
public class DTraverser {
  private static boolean[] visited;     //���ʱ�־����
  
  public static void DFSTraverse(IGraph G) throws Exception{    //��ͼG��������ȱ���
	  visited = new boolean[G.getVexNum()];
	  for(int v = 0; v < G.getVexNum(); v++){        //���ʱ�־�����ʼ��
		  visited[v] = false;  				
	  }
	  for(int v = 0; v < G.getVexNum(); v++){
		  if(!visited[v]){              //��δ���ʶ������DFS
			  DFS(G, v);
		  }
	  }
  }
  
  public static void DFS(IGraph G, int v) throws Exception{
	  //�ӵ�v����������ݹ��������ȱ���ͼG
	  visited[v] = true;
	  System.out.println(G.getVex(v).toString() + " ");     //���ʵ�v������
	  for(int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w)){
		  if(!visited[w]){			//��v����δ���ʵ��ڽӶ���w�ݹ����DFS
			  DFS(G, w);
		  }
	  }
  }
  
}
