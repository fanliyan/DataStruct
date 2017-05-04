package dataStruct.graph.test;


import dataStruct.IGraph.IGraph;
import dataStruct.Stacck.LinkStack;
import dataStruct.graph.ALGraph;
import dataStruct.graph.ArcNode;
import dataStruct.graph.GraphKind;
import dataStruct.graph.VNode;

/**
 * ���ʵ��Ӧ��������������ж�һ������ͼ�Ƿ���ڻ�
 * @author ������
 * @ʱ�� 2017-05-04
 */
public class Example3 {
    private boolean[] visited;    //���ʱ�־����
    
    private LinkStack S = new LinkStack();   //����������������ʵ��Ⱥ�˳���¼��һ����ͨ��֧���еĶ���Ԫ��
    
    private boolean find  = false;    //��ʾ�Ƿ��Ѿ��ҵ���
    
    public void findCicle(IGraph G) throws Exception{
    	visited = new boolean[G.getVexNum()];
    	for(int v = 0; v < G.getVexNum(); v++){
    		//���ʱ�־�����ʼ��
    		visited[v] = false;
    	}
    	for(int v = 0; v < G.getVexNum(); v++){
    		if(!visited[v]){         //����δ���ʵĶ������DFS
    			find_DFS(G, v);
    		}
    	}
    	if(find){
    		System.out.println("������ͼ���ڻ���");
    	}else{
    		System.out.println("������ͼ�����ڻ���");
    	}
    }
    
    public void find_DFS(IGraph G, int v) throws Exception{
    	if(!find){
    		visited[v] = true;
    		S.push(v);
    		for(int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w)){
    			if(visited[w] && isDuplicate(w)){
    				find = true;
    			}else{
    				//��v����δ�����ڽӶ���2�ݹ����DFS
    				find_DFS(G, w);
    			}
    		}
    		S.pop();
    	}
    }
    
    //�ж�ջS���Ƿ����ֵΪw������Ԫ��
    private boolean isDuplicate(Integer w) throws Exception{
    	LinkStack S1 = new LinkStack();   //����ջ
    	while(!S.isEmpty() && !((Integer)S.peek()).equals(w)){
    		//�ж�ջS���Ƿ����Ϊw������Ԫ�أ������ø���ջS1,��¼��ջ������Ԫ��
    		S1.push(S.pop());
    	}
    	if(S.isEmpty()){   //���°�����Ԫ�ط���ջS��
    		while(!S1.isEmpty()){
    			S.push(S1.pop());
    		}
    		return false;
    	}else{
    		return true;
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
		VNode D = new VNode("E", de);
		
		ArcNode ef = new ArcNode(5);
		VNode E = new VNode("E", ef);
		
		ArcNode fa = new ArcNode(0);
		ArcNode fb = new ArcNode(1, 0, fa);
		VNode F = new VNode("F", fb);
		
		VNode[] vexs = {A, B, C, D, E, F};
		ALGraph G = new ALGraph(GraphKind.DG, 6, 8, vexs);
		Example3 e = new Example3();
		e.findCicle(G);
	}
    
}

