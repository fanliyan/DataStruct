package dataStruct.graph;

/**
 * 图的邻接表存储表示中的顶点结点类
 * @author 范立炎
 * @时间 2017-05-02
 *
 */
public class VNode {

	public Object data;    //顶点信息
	public ArcNode firstArc;   //指向第一条依附于该顶点的弧
	
	public VNode(){
		this(null, null);
	}
	
	public VNode(Object data){
		this(data, null);
	}
	
	public VNode(Object data, ArcNode firstArc){
		this.data = data;
		this.firstArc = firstArc;
	}
}
