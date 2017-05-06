package dataStruct.graph;
/**
 * Dijkstra算法构造最短路径的类的描述
 * @author 范立炎
 * @时间 2017-05-06
 *
 */
public class ShortestPath_DIJ {

	//v0到其余顶点的最短路径，若P[v][w]为true,则w是从v0到v当前求得最短路径上的顶点
	private boolean[][] P;
	private int[] D;             //v0到其余顶点的带权长度
	public final static int INFINITY = Integer.MAX_VALUE;
	
	
	//用Dijkstra算法 求有向网G的v0顶点到其余顶点v的最短路径P[v]及其路径长度D[v]
	public void DIJ(MGraph G, int v0){
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum];
		D = new int[vexNum];
		
		//fisish[v]为true当且仅当v属于S，即已经求得从v0到v的最短路径
		boolean[] finish = new boolean[vexNum];
		for(int v = 0; v < vexNum; v++){
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			for(int w = 0; w < vexNum; w++){
				P[v][w] = false;
			}
			if(D[v] < INFINITY){  		//设空路径
				P[v][v0] = true;
				P[v][v] = true;
			}
		}
		D[v0] = 0;
		finish[v0] = true;  		//初始化，v0顶点属于S集
		int v = -1;
		//开始主循环，每次求得v0到某个顶点的最短路径，并加v到S集
		for(int i = 1; i < vexNum; i++){    //其余G.getVexNum - 1个顶点
			int min = INFINITY;  			//当前所知离v0顶点最近距离
			for(int w = 0; w < vexNum; w++){
				if(!finish[w]){
					if(D[w] < min){
						v = w;
						min = D[w];
					}
				}
			}
			finish[v] = true;			//离v0顶点最近的v加入S集
			for(int w = 0; w < vexNum; w++){   //更新当前最短路径及距离
				if(!finish[w] && G.getArcs()[v][w] < INFINITY && (min + G.getArcs()[v][w] < D[w])){		//修改D[w]和P[w]，w属于V-S
					D[w] = min + G.getArcs()[v][w];
					System.arraycopy(P[v], 0, P[w], 0, P[v].length);
					P[w][w] = true;
				}
			}
		}
	}


	public boolean[][] getP() {
		return P;
	}


	public int[] getD() {
		return D;
	}
}
