package dataStruct.graph;

import dataStruct.Stacck.LinkStack;

/**
 * ����������AOE���Ĺؼ�·��
 * @author ������
 * @ʱ�� 2017-05-06
 */
public class CriticalPath {
  private LinkStack T = new LinkStack();   //���������ж���ջ
  private int[] ve, vl;     //����������緢��ʱ�����ٷ���ʱ��
  
  //������G�����ڽӱ�洢�ṹ�������������緢��ʱ��ve����G�޻�·������ջT����G��һ���������У��Һ�������true,����Ϊfalse
  public boolean topologicalOrder(ALGraph G) throws Exception{
	  int count = 0;    //����������
	  int[] indegree = TopologicalSort.findInDegree(G);    //�������������
	  LinkStack S = new LinkStack();              //��������ȶ���ջS
	  for(int i = 0; i < G.getVexNum(); i++){
		  if(indegree[i] == 0){    //���Ϊ0�߽�ջ
			  S.push(i);      
		  }
	  }
	  ve = new int[G.getVexNum()];      //��ʼ��
	  while(!S.isEmpty()){
		  int j = (Integer)S.pop();
		  T.push(j);		//j�Ŷ�����Tջ������
		  ++count;
		  for(ArcNode arc = G.getVexs()[j].firstArc; arc != null; arc = arc.nextArc){
			  int k = arc.adjVex;
			  if(--indegree[k] == 0){   //��j�Ŷ����ÿ���ڽӵ����ȼ�1
				  S.push(k);        //����ȼ�Ϊ0,����ջ
			  }
			  if(ve[j] + arc.value > ve[k]){
				  ve[k] = ve[j] + arc.value;
			  }
		  }
	  }
	  if(count < G.getVexNum()){
		  return false;
	  }else{				//������ͼ�л�·
		  return true;
	  }
  }
  
  //GΪ�����������G�ĸ���ؼ��
  public boolean criticalPath(ALGraph G) throws Exception{
	  if(!topologicalOrder(G)){
		  return false;
	  }
	  vl = new int[G.getVexNum()];
	  for(int i = 0; i < G.getVexNum(); i++){
		  //��ʼ�������¼�����ٷ���ʱ��
		  vl[i] = ve[G.getVexNum() - 1];
	  }
	  while(!T.isEmpty()){   //������������������vlֵ
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
		  //��ee, el�͹ؼ��
		  for(ArcNode arc = G.getVexs()[j].firstArc; arc != null; arc = arc.nextArc){
			  int k = arc.adjVex;
			  int value = arc.value;
			  int ee = ve[j];
			  int el = vl[k] - value;
			  char tag = (ee == el) ? '*' : ' ';
			  System.out.println(G.getVex(j) + "->" + G.getVex(k) + " " + value + " " + ee + " " + el + " " + tag); //����ؼ��·��
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
