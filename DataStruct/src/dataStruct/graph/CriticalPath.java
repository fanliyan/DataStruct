package dataStruct.graph;

import dataStruct.Stacck.LinkStack;

/**
 * 拓扑排序求AOE网的关键路径
 * @author 范立炎
 * @时间 2017-05-06
 */
public class CriticalPath {
  private LinkStack T = new LinkStack();   //拓扑逆序列顶点栈
  private int[] ve, vl;     //各顶点的最早发生时间和最迟发生时间
  
  //有向网G采用邻接表存储结构，求各顶点的最早发生时间ve，若G无回路，则用栈T返回G的一个拓扑序列，且函数返回true,否则为false
  public boolean topologicalOrder(ALGraph G) throws Exception{
	  int count = 0;    //输出顶点计数
	  int[] indegree = TopologicalSort.findInDegree(G);    //求各个顶点的入度
	  LinkStack S = new LinkStack();              //建立零入度顶点栈S
	  for(int i = 0; i < G.getVexNum(); i++){
		  if(indegree[i] == 0){    //入度为0者进栈
			  S.push(i);      
		  }
	  }
	  ve = new int[G.getVexNum()];      //初始化
	  while(!S.isEmpty()){
		  int j = (Integer)S.pop();
		  T.push(j);		//j号顶点入T栈并计数
		  ++count;
		  for(ArcNode arc = G.getVexs()[j].firstArc; arc != null; arc = arc.nextArc){
			  int k = arc.adjVex;
			  if(--indegree[k] == 0){   //对j号顶点的每个邻接点的入度减1
				  S.push(k);        //若入度减为0,则入栈
			  }
			  if(ve[j] + arc.value > ve[k]){
				  ve[k] = ve[j] + arc.value;
			  }
		  }
	  }
	  if(count < G.getVexNum()){
		  return false;
	  }else{				//该有向图有回路
		  return true;
	  }
  }
  
  //G为有向网，输出G的各项关键活动
  public boolean criticalPath(ALGraph G) throws Exception{
	  if(!topologicalOrder(G)){
		  return false;
	  }
	  vl = new int[G.getVexNum()];
	  for(int i = 0; i < G.getVexNum(); i++){
		  //初始化顶点事件的最迟发生时间
		  vl[i] = ve[G.getVexNum() - 1];
	  }
	  while(!T.isEmpty()){   //按拓扑逆序求各顶点的vl值
		  int j = (Integer)T.pop();
		  for(ArcNode arc = G.getVexs()[j].firstArc; arc != null; arc = arc.nextArc){
			  int k = arc.adjVex;
			  int value = arc.value;
			  if(vl[k] - value < vl[j]){
				  vl[j] = vl[k] - value;
			  }
		  }
	  }
	  for(int j = 0; j < G.getVexNum(); j++){
		  //求ee, el和关键活动
		  for(ArcNode arc = G.getVexs()[j].firstArc; arc != null; arc = arc.nextArc){
			  int k = arc.adjVex;
			  int value = arc.value;
			  int ee = ve[j];
			  int el = vl[k] - value;
			  char tag = (ee == el) ? '*' : ' ';
			  System.out.println(G.getVex(j) + "->" + G.getVex(k) + " " + value + " " + ee + " " + el + " " + tag); //输出关键活动路径
		  }
	  }
	  return true;
  }
  
  public static void main(String[] args) throws Exception{
	  ArcNode v12 = new ArcNode(1, 6);
	  ArcNode v13 = new ArcNode(2, 4, v12);
	  ArcNode v14 = new ArcNode(3, 5, v13);
	  VNode v1 = new VNode("v1", v14);
	  
	  ArcNode v25 = new ArcNode(4, 1);
	  VNode v2 = new VNode("v2", v25);
	  
	  ArcNode v35 = new ArcNode(4, 1);
	  VNode v3 = new VNode("v3", v35);
	  
	  ArcNode v46 = new ArcNode(5, 2);
	  VNode v4 = new VNode("v4", v46);
	  
	  ArcNode v57 = new ArcNode(6, 9);
	  ArcNode v58 = new ArcNode(7, 7, v57);
	  VNode v5 = new VNode("v5", v58);
	  
	  ArcNode v68 = new ArcNode(7, 4);
	  VNode v6 = new VNode("v6", v68);
	  
	  ArcNode v79 = new ArcNode(8, 2);
	  VNode v7 = new VNode("v7", v79);
	  
	  ArcNode v89 = new ArcNode(8, 4);
	  VNode v8 = new VNode("v8", v89);
	  
	  VNode v9 = new VNode("v9");
	  
	  VNode[] vexs = {v1, v2, v3, v4, v5, v6, v7, v8, v9};
	  ALGraph G = new ALGraph(GraphKind.DG, 9, 11, vexs);
	  CriticalPath p = new CriticalPath();
	  p.criticalPath(G);
  }
  
}
