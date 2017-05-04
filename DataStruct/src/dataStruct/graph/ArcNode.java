package dataStruct.graph;

/**
 * 图的邻接表存储表示中的边（或弧）结点类
 * @author 范立炎
 * @时间 2017-05-02
 *
 */
public class ArcNode {
	public int adjVex;			//该弧所指向的顶点位置
	public int value;			//边或弧的权值
	public ArcNode nextArc; 	//指向下一条弧
	
	public ArcNode(){
		this(-1, 0, null);
	}
	
	public ArcNode(int adjVex){
		this(adjVex, 0, null);
	}
	
	public ArcNode(int adjVex, int value){
		this(adjVex, value, null);
	}
	
	public ArcNode(int adjVex, int value, ArcNode nextArc){
		this.value = value;
		this.adjVex = adjVex;
		this.nextArc = nextArc;
	}
}
