package dataStruct.graph;

import dataStruct.Stacck.LinkStack;
/**
 * 拓扑排序
 * @author Fanliyan
 *
 */
public class TopologicalSort {

	//求各顶点入度
	public static int[] findInDegree(ALGraph G) throws Exception{
		int[] indegree = new int[G.getVexNum()];
		for(int i = 0; i < G.getVexNum(); i++){
			for(ArcNode arc = G.getVexs()[i].firstArc; arc != null; arc = arc.nextArc){
				++indegree[arc.adjVex];   //入度增1
			}
		}
		return indegree;
	}
	
	//若G无回路，则输出G的顶点的一个拓扑序列并返回true,否则返回false
	public static boolean topologicalSort(ALGraph G) throws Exception{
		int count = 0;    //输出顶点计数
		int[] indegree = findInDegree(G);   //求各顶点入度
		LinkStack S = new LinkStack();      //建零入度顶点栈
		for(int i = 0; i < G.getVexNum(); i++){
			if(indegree[i] == 0){    //入度为0者进栈
				S.push(i);
			}
		}
		while(!S.isEmpty()){
			int i = (Integer)S.pop();
			System.out.println(G.getVexs()[i] + " "); //输出v号顶点并计数
			++count;
			for(ArcNode arc = G.getVexs()[i].firstArc; arc != null; arc = arc.nextArc){
				int k = arc.adjVex;
				if(--indegree[k] == 0){    //对j号顶点的每个邻接点的入度减1
					S.push(k);			//若入度减为0,则入栈
				}
			}
		}
		if(count < G.getVexNum()){    
			return false;    //该有向图有回路
		}else{
			return true;
		}
	}
}
