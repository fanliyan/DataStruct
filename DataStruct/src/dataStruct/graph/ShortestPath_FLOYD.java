package dataStruct.graph;

/**
 * Floyd�㷨�������·�����������
 * @author Fanliyan
 * @ʱ�� 2017-05-06
 */
public class ShortestPath_FLOYD {

	private boolean[][][] P;   //����v��w֮������·��P[v][w],��P[v][w][u]Ϊtrue,��u�Ǵ�v��w���·���ϵĶ���
	
	private int[][] D; 		//����v��w֮�����·���Ĵ�Ȩ����D[v][w]
	
	private static final int INFINITY = Integer.MAX_VALUE;
	
	//��Floyd�㷨���������и��Զ���v��w֮������·��P[v][w]����·������D[v][w]
	public void FLOYD(MGraph G){
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum][vexNum];
		D = new int[vexNum][vexNum];
		for(int v = 0; v < vexNum; v++){   //���Խ��֮���ʼ����֪·��������
			for(int w = 0; w < vexNum; w++){
				D[v][w] = G.getArcs()[v][w];
				for(int u = 0; u < vexNum; u++){
					P[v][w][u] = false;
				}
				if(D[v][w] < INFINITY){   //��v��w��ֱ��·��
					P[v][w][v] = true;
					P[v][w][w] = true;
				}
			}
		}
		for(int u = 0; u < vexNum; u++){
			for(int v = 0; v < vexNum; v++){
				for(int w = 0; w < vexNum; w++){
					if(D[v][u] < INFINITY && D[u][w] < INFINITY && D[v][u] + D[u][w] < D[v][w]){  //��v��u��w��һ��·�����
						D[v][w] = D[v][u] + D[u][w];
						for(int i = 0; i < vexNum; i++){
							P[v][w][i] = P[v][u][i] || P[u][w][i];
						}
					}
				}
			}
		}
	}

	public boolean[][][] getP() {
		return P;
	}

	public int[][] getD() {
		return D;
	}
}
