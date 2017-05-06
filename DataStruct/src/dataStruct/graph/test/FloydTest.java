package dataStruct.graph.test;

import dataStruct.graph.GraphKind;
import dataStruct.graph.MGraph;
import dataStruct.graph.ShortestPath_FLOYD;

public class FloydTest {

	public  static final int INFINITY = Integer.MAX_VALUE;
	
	//�����������·������
	public static void display(int[][] D){
		System.out.println("����֮������·������Ϊ��");
		for(int v = 0; v < D.length; v++){
			for(int w = 0; w < D.length; w++){
				System.out.print(D[v][w] + "\t");
			}
			System.out.println();
		}
	}
	
	//������������������·������֮����С�Ķ��㣬��������·����Ϣ
	public static void findPlace(MGraph G, int[][] D) throws Exception{
		int min = INFINITY;
		int sum = 0;		//���ڼ�¼һ�����㵽������������·�����ȵĺ�
		int u = -1;
		for(int v = 0; v < D.length; v++){
			sum = 0;
			for(int w = 0; w < D.length; w++){
				sum += D[v][w];		//��һ�㵽������������·�����ȵĺ�
			}
			if(min > sum){
				min = sum;
				u = v;
			}
		}
		System.out.println("���ֲ�Ӧ����" + G.getVex(u) + "�壬�䵽�����·����������Ϊ��");
		for(int i = 0; i < D.length; i++){
			System.out.print(D[u][i] + "\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		Object vexs[] = {"A", "B", "C", "D"};
		int[][] arcs = {
				{0, 15, 3, INFINITY},
				{10, 0, 2, INFINITY},
				{INFINITY, INFINITY, 0, 2},
				{INFINITY, 8, 4, 0}
		};
		MGraph G = new MGraph(GraphKind.UDG, 4, 7, vexs, arcs);
		ShortestPath_FLOYD floyd = new ShortestPath_FLOYD();
		floyd.FLOYD(G);
		display(floyd.getD());
		findPlace(G, floyd.getD());
	}

}
