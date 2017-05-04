package dataStruct.IGraph;

/**
 * 图的抽象数据类型描述
 * @author 范立炎
 * 时间 2017-05-02
 *
 */
public interface IGraph {
     void createGraph();   		//创建一个图
     int getVexNum();    		//返回图中的顶点数
     int getArcNum();			//返回图中的边数
     Object getVex(int v) throws Exception;		//给定顶点位置v,返回其对应的顶点值，其中，0<= v < vexNum(vexNum为顶点数)
     int locateVex(Object vex);   //给定顶点值vex,返回 其在图中的位置，如果图中不包含此顶点，则返回-1
     int firstAdjVex(int v) throws Exception;		//返回v的第一个邻接点，若v没有邻接点，则返回-1，其中，0 <= v, w <vexNum
     int nextAdjVex(int v, int w) throws Exception;
     
}
