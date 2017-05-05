package dataStruct.graph.test;

import dataStruct.graph.GraphKind;
import dataStruct.graph.MGraph;
import dataStruct.graph.MiniSpanTree_PRIM;

public class MiniSpanTree_PRIM_test {

	public static final int INFINITY = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
			Object vexs[] = {"v0", "v1", "v2", "v3", "v4", "v5"};
			int[][] arcs = {
					{INFINITY, 7, 1, 5, INFINITY, INFINITY},
					{7, INFINITY, 6, INFINITY, 3, INFINITY},
					{1, 6, INFINITY, 7, 6, 4},
					{5, INFINITY, 7, INFINITY, INFINITY,2},
					{INFINITY, 3, 6, INFINITY, INFINITY, 7},
					{INFINITY, INFINITY, 4, 2, 7, INFINITY}
			};
			MGraph G = new MGraph(GraphKind.UDG, 6, 10, vexs, arcs);
			Object[][] tree = new MiniSpanTree_PRIM().PRIM(G, "v1");
			for(int i = 0; i < tree.length; i++){
				System.out.println(tree[i][0] + " - " + tree[i][1]);
			}
			
	}

}
