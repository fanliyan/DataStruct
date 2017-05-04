package dataStruct.graph;

import dataStruct.IGraph.IGraph;

/**
 * 图的深度优先遍历
 * @author 范立炎
 * 时间 2017-05-03
 */
public class DTraverser {
  private static boolean[] visited;     //访问标志数组
  
  public static void DFSTraverse(IGraph G) throws Exception{    //对图G做深度优先遍历
	  visited = new boolean[G.getVexNum()];
	  for(int v = 0; v < G.getVexNum(); v++){        //访问标志数组初始化
		  visited[v] = false;  				
	  }
	  for(int v = 0; v < G.getVexNum(); v++){
		  if(!visited[v]){              //对未访问顶点调用DFS
			  DFS(G, v);
		  }
	  }
  }
  
  public static void DFS(IGraph G, int v) throws Exception{
	  //从第v个顶点出发递归地深度优先遍历图G
	  visited[v] = true;
	  System.out.println(G.getVex(v).toString() + " ");     //访问第v个顶点
	  for(int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w)){
		  if(!visited[w]){			//对v的尚未访问的邻接顶点w递归调用DFS
			  DFS(G, w);
		  }
	  }
  }
  
}
