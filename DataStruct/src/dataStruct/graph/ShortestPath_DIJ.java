package dataStruct.graph;
/**
 * Dijkstra�㷨�������·�����������
 * @author ������
 * @ʱ�� 2017-05-06
 *
 */
public class ShortestPath_DIJ {

	//v0�����ඥ������·������P[v][w]Ϊtrue,��w�Ǵ�v0��v��ǰ������·���ϵĶ���
	private boolean[][] P;
	private int[] D;             //v0�����ඥ��Ĵ�Ȩ����
	public final static int INFINITY = Integer.MAX_VALUE;
	
	
	//��Dijkstra�㷨 ��������G��v0���㵽���ඥ��v�����·��P[v]����·������D[v]
	public void DIJ(MGraph G, int v0){
		int vexNum = G.getVexNum();
		P = new boolean[vexNum][vexNum];
		D = new int[vexNum];
		
		//fisish[v]Ϊtrue���ҽ���v����S�����Ѿ���ô�v0��v�����·��
		boolean[] finish = new boolean[vexNum];
		for(int v = 0; v < vexNum; v++){
			finish[v] = false;
			D[v] = G.getArcs()[v0][v];
			for(int w = 0; w < vexNum; w++){
				P[v][w] = false;
			}
			if(D[v] < INFINITY){  		//���·��
				P[v][v0] = true;
				P[v][v] = true;
			}
		}
		D[v0] = 0;
		finish[v0] = true;  		//��ʼ����v0��������S��
		int v = -1;
		//��ʼ��ѭ����ÿ�����v0��ĳ����������·��������v��S��
		for(int i = 1; i < vexNum; i++){    //����G.getVexNum - 1������
			int min = INFINITY;  			//��ǰ��֪��v0�����������
			for(int w = 0; w < vexNum; w++){
				if(!finish[w]){
					if(D[w] < min){
						v = w;
						min = D[w];
					}
				}
			}
			finish[v] = true;			//��v0���������v����S��
			for(int w = 0; w < vexNum; w++){   //���µ�ǰ���·��������
				if(!finish[w] && G.getArcs()[v][w] < INFINITY && (min + G.getArcs()[v][w] < D[w])){		//�޸�D[w]��P[w]��w����V-S
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
