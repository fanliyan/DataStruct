package dataStruct.graph.test;

import dataStruct.IGraph.IGraph;
import dataStruct.graph.ALGraph;
import dataStruct.graph.ArcNode;
import dataStruct.graph.GraphKind;
import dataStruct.graph.VNode;

/**
 * ���ʵ���ж�һ������ͼ�������������������֮���Ƿ����һ��Ϊk�ļ�·��
 * @author ������
 * @ʱ�� 2017-05-04
 */
public class Example2 {
   
	private boolean[] visited;   //���ʱ�־����
	
	private int i = 0;    //�����������ڱ������������ڼ�¼����������·������
	
	private boolean find  = false;   //��ʾ�Ƿ����ҵ���ָ�����ȵ�·��
	
	public void findPath(IGraph G, int u, int v, int k) throws Exception{
		visited = new boolean[G.getVexNum()];
		for(int w = 0; w < G.getVexNum(); w++){
			//���������ʼ��
			visited[w] = false;
		}
		find_DFS(G, u, v, k);
		if(find){
			System.out.println(G.getVex(u) + "��" + G.getVex(v) + "֮�����һ������Ϊ" + k + "�ļ�·��");
		}else{
			System.out.println(G.getVex(u) + "��" + G.getVex(v) + "֮�䲻����һ������Ϊ" + k + "�ļ�·��");
		}
	}
	
	public void find_DFS(IGraph G, int u, int v, int k) throws Exception{
		if(i == k && u == v){
			find = true;
		}else if(!find){
			visited[u] = true;
			for(int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)){
				if(!visited[w]){
					if(i < k){
						++i;
						find_DFS(G, w, v, k);
						//��v����δ���ʵ��ڽӶ���w�ݹ����find_DFS
					}else{
						break;   //��·�������Ѵﵽkֵ����δ�ҵ���·�������ټ����Ե�ǰ������������������
					}
				}
			}
			--i;      //����һ������
		}
	}
	
	public static void main(String[] args) throws Exception{
		ArcNode ab = new ArcNode(1);
		VNode A = new VNode("A", ab);
		
		ArcNode bc = new ArcNode(2);
		ArcNode be = new ArcNode(4, 0, bc);
		VNode B = new VNode("B", be);
		
		ArcNode cd = new ArcNode(3);
		VNode C = new VNode("C", cd);
		
		ArcNode de = new ArcNode(4);
		VNode D = new VNode("D", de);
		
		ArcNode ef = new ArcNode(5);
		VNode  E = new VNode("E", ef);
		
		ArcNode fa = new ArcNode(0);
		ArcNode fb = new ArcNode(1, 0, fa);
		VNode F = new VNode("F", fb);
		
		VNode[] vexs = {A, B, C, D, E, F};
		ALGraph G =new ALGraph(GraphKind.DG, 6, 8, vexs);
		Example2 p = new Example2();
		p.findPath(G, 0, 5, 3);
	}
}
