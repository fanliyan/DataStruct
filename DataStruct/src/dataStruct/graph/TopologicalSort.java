package dataStruct.graph;

import dataStruct.Stacck.LinkStack;
/**
 * ��������
 * @author Fanliyan
 *
 */
public class TopologicalSort {

	//����������
	public static int[] findInDegree(ALGraph G) throws Exception{
		int[] indegree = new int[G.getVexNum()];
		for(int i = 0; i < G.getVexNum(); i++){
			for(ArcNode arc = G.getVexs()[i].firstArc; arc != null; arc = arc.nextArc){
				++indegree[arc.adjVex];   //�����1
			}
		}
		return indegree;
	}
	
	//��G�޻�·�������G�Ķ����һ���������в�����true,���򷵻�false
	public static boolean topologicalSort(ALGraph G) throws Exception{
		int count = 0;    //����������
		int[] indegree = findInDegree(G);   //����������
		LinkStack S = new LinkStack();      //������ȶ���ջ
		for(int i = 0; i < G.getVexNum(); i++){
			if(indegree[i] == 0){    //���Ϊ0�߽�ջ
				S.push(i);
			}
		}
		while(!S.isEmpty()){
			int i = (Integer)S.pop();
			System.out.println(G.getVexs()[i] + " "); //���v�Ŷ��㲢����
			++count;
			for(ArcNode arc = G.getVexs()[i].firstArc; arc != null; arc = arc.nextArc){
				int k = arc.adjVex;
				if(--indegree[k] == 0){    //��j�Ŷ����ÿ���ڽӵ����ȼ�1
					S.push(k);			//����ȼ�Ϊ0,����ջ
				}
			}
		}
		if(count < G.getVexNum()){    
			return false;    //������ͼ�л�·
		}else{
			return true;
		}
	}
}
