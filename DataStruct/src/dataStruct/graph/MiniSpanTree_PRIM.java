package dataStruct.graph;

/**
 * ����ķ�㷨������С���������������
 * @author ������
 * @ʱ�� 2017-05-05
 *
 */
public class MiniSpanTree_PRIM {

	private class CloseEdge{    //�ڲ��ศ����¼�Ӷ��㼯U��V-U�Ĵ�����С�ı�
		Object adjVex;     //�洢�ñ�������U�еĶ���
		int lowCost;       //vi����V - U,  �洢�ñ��ϵ�Ȩ����vi��U�ľ���  lowCost = |vi, U|
		
		public CloseEdge(Object adjVex, int lowCost){
			this.adjVex = adjVex;
			this.lowCost = lowCost;
		}
	}
	
	//������ķ�㷨 �ӵ�u������ ����������G����С������T������������������ɵĶ�ά����
	public Object[][] PRIM(MGraph G, Object u) throws Exception{
		Object[][] tree = new Object[G.getVexNum() - 1][2];
		int count = 0;
		CloseEdge[] closeEdge = new CloseEdge[G.getVexNum()];
		int k = G.locateVex(u);
		for(int j = 0; j < G.getVexNum(); j++){   //���������ʼ��
			if(j != k){
				closeEdge[j] = new CloseEdge(u, G.getArcs()[k][j]);
			}
		}
		closeEdge[k] = new CloseEdge(u, 0);		//��ʼ��U={u}
		for(int i = 1; i < G.getVexNum(); i++){   //ѡ������G.vexnum - 1 ������
			k = getMinMum(closeEdge);          //���T����һ���㣺��k������
			tree[count][0] = closeEdge[k].adjVex;   //�������ı߷���������
			tree[count][1] = G.getVexs()[k];
			count++;
			closeEdge[k].lowCost = 0;    //��k�����㲢��U��
			for(int j = 0; j < G.getVexNum(); j++){     //�¶��㲢��U������ѡ����С��
				if(G.getArcs()[k][j] < closeEdge[j].lowCost){
					closeEdge[j] = new CloseEdge(G.getVex(k), G.getArcs()[k][j]);
				}
			}
		}
		return tree;
	}
	
	private int getMinMum(CloseEdge[] closeEdge){  //��closeEdge��ѡ��lowCose��С�Ҳ�Ϊ0�Ķ���
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
