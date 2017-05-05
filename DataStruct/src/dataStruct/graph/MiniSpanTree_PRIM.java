package dataStruct.graph;

/**
 * 普里姆算法构造最小生成树的类的描述
 * @author 范立炎
 * @时间 2017-05-05
 *
 */
public class MiniSpanTree_PRIM {

	private class CloseEdge{    //内部类辅助记录从顶点集U到V-U的代价最小的边
		Object adjVex;     //存储该边依附在U中的顶点
		int lowCost;       //vi属于V - U,  存储该边上的权，即vi到U的距离  lowCost = |vi, U|
		
		public CloseEdge(Object adjVex, int lowCost){
			this.adjVex = adjVex;
			this.lowCost = lowCost;
		}
	}
	
	//用普里姆算法 从第u个顶点 出发构造网G的最小生成树T，返回由生成树边组成的二维数组
	public Object[][] PRIM(MGraph G, Object u) throws Exception{
		Object[][] tree = new Object[G.getVexNum() - 1][2];
		int count = 0;
		CloseEdge[] closeEdge = new CloseEdge[G.getVexNum()];
		int k = G.locateVex(u);
		for(int j = 0; j < G.getVexNum(); j++){   //辅助数组初始化
			if(j != k){
				closeEdge[j] = new CloseEdge(u, G.getArcs()[k][j]);
			}
		}
		closeEdge[k] = new CloseEdge(u, 0);		//初始，U={u}
		for(int i = 1; i < G.getVexNum(); i++){   //选择其余G.vexnum - 1 个顶点
			k = getMinMum(closeEdge);          //求出T的下一个点：第k个顶点
			tree[count][0] = closeEdge[k].adjVex;   //生成树的边放入数组中
			tree[count][1] = G.getVexs()[k];
			count++;
			closeEdge[k].lowCost = 0;    //第k个顶点并入U集
			for(int j = 0; j < G.getVexNum(); j++){     //新顶点并入U后重新选择最小边
				if(G.getArcs()[k][j] < closeEdge[j].lowCost){
					closeEdge[j] = new CloseEdge(G.getVex(k), G.getArcs()[k][j]);
				}
			}
		}
		return tree;
	}
	
	private int getMinMum(CloseEdge[] closeEdge){  //在closeEdge中选出lowCose最小且不为0的顶点
		int min = Integer.MAX_VALUE;
		int v = -1;
		for(int i = 0; i < closeEdge.length; i++){
			if(closeEdge[i].lowCost != 0 && closeEdge[i].lowCost < min){
				min = closeEdge[i].lowCost;
				v = i;
			}
		}
		return v;
	}
}
