package dataStruct.graph;

import java.util.Scanner;

import dataStruct.IGraph.IGraph;

/**
 * 图的邻接矩阵描述
 * @author 范立炎
 * @时间 2017-05-02
 *
 */
public class MGraph implements IGraph {
	
	public final static int INFINITY = Integer.MAX_VALUE;
	private GraphKind kind;     //图的种类标志
	private int vexNum, arcNum;     //图的当前顶点数和边数
	private Object[] vexs;     //顶点
	private int[][] arcs;      //邻接矩阵
	
	public MGraph(){
		this(null, 0, 0, null, null);
	}
	
	public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][] arcs){
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
		this.arcs = arcs;
	}
	
	//创建图
	@Override
	public void createGraph() {
       Scanner sc = new Scanner(System.in);
       System.out.println("请输入图的类型：");
       GraphKind kind = GraphKind.valueOf(sc.next());
       switch(kind){
       case UDG:
    	   createUDG();				//构造无向图
    	   return;
       case DG:
    	   createDG();				//构造有向图
    	   return;
       case UDN:
    	   createUDN();				//构造无向网
    	   return;
       case DN:						//构造有向网
    	   createDN();
    	   return;
       }
	}

    //创建无向图
	private void createUDG(){
		
	}
	
	//创建有向图
	private void createDG(){
		
	}
	
	//创建有向网
	private void createDN(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数和图的边数：");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个 顶点：");
		for(int v = 0; v < vexNum; v++){   //构造顶点向量
			vexs[v] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for(int v = 0; v < vexNum; v++){    //初始化邻接矩阵
			for(int u = 0; u < vexNum; u++){
				arcs[v][u] = INFINITY;
			}
		}
		System.out.println("请输入各个 边的两个 顶点及其权值：");
		for(int k = 0; k < arcNum; k++){
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = sc.nextInt();
		}
	}
	
	//创建无向网
	private void createUDN(){
		Scanner sc = new Scanner(System.in);
		System.out.println("请分别输入图的顶点数和 图的边数：");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("请分别输入图的各个顶点：");
		for(int v = 0; v < vexNum; v++){         //构造顶点向量
			vexs[v] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for(int v = 0; v < vexNum; v++){   //初始化邻接矩阵
			for(int u = 0; u < vexNum; u++){
				arcs[u][v] = INFINITY;
			}
		}
		System.out.println("请输入各个边的两个顶点及其权值：");
		for(int k = 0; k < arcNum; k++){
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = arcs[u][v] = sc.nextInt();
		}
	}
	
	//返回顶点数
	@Override
	public int getVexNum() {
		// TODO Auto-generated method stub
		return vexNum;
	}

	//返回边数
	@Override
	public int getArcNum() {
		// TODO Auto-generated method stub
		return arcNum;
	}

	//返回v表示结点的值，0 <= v < vexNum
	@Override
	public Object getVex(int v) throws Exception{
		if(v < 0 && v >= vexNum){
			throw new Exception("第" + v + "个顶点不存在！");
		}
		return vexs[v];
	}

	//给定顶点值vex,返回其在图中的位置，如果图中不包含此顶点，则返回-1
	@Override
	public int locateVex(Object vex) {
		for(int v = 0; v < vexNum; v++){
			if(vexs[v].equals(vex)){
				return v;
			}
		}
		return -1;
	}

	//返回v的第一个邻接点，若v没有邻接点则返回-1，0 <= v < vexNum
	@Override
	public int firstAdjVex(int v) throws Exception{
		if(v < 0 && v >= vexNum){
			throw new Exception("第" + v + "个顶点不存在！");
		}
		for(int j = 0; j < vexNum; j++){
			if(arcs[v][j] != 0 && arcs[v][j] < INFINITY){
				return j;
			}
		}
		return -1;
	}

	//返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1， 其中0 <= v, w < vexNum
	@Override
	public int nextAdjVex(int v, int w) throws Exception {
		if(v < 0 && v >= vexNum){
			throw new Exception("第" + v + "个顶点不存在！");
		}
		for(int j = w + 1; j < vexNum; j++){
			if(arcs[v][j] != 0 && arcs[v][j] < INFINITY){
				return j;
			}
		}
		return -1;
	}
	
	public GraphKind getKind(){
		return kind;
	}

	public int[][] getArcs(){
		return arcs;
	}
	
	public Object[] getVexs(){
		return vexs;
	}
}
