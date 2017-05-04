package dataStruct.graph;

import java.util.Scanner;

import dataStruct.IGraph.IGraph;

/**
 * ͼ���ڽӾ�������
 * @author ������
 * @ʱ�� 2017-05-02
 *
 */
public class MGraph implements IGraph {
	
	public final static int INFINITY = Integer.MAX_VALUE;
	private GraphKind kind;     //ͼ�������־
	private int vexNum, arcNum;     //ͼ�ĵ�ǰ�������ͱ���
	private Object[] vexs;     //����
	private int[][] arcs;      //�ڽӾ���
	
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
	
	//����ͼ
	@Override
	public void createGraph() {
       Scanner sc = new Scanner(System.in);
       System.out.println("������ͼ�����ͣ�");
       GraphKind kind = GraphKind.valueOf(sc.next());
       switch(kind){
       case UDG:
    	   createUDG();				//��������ͼ
    	   return;
       case DG:
    	   createDG();				//��������ͼ
    	   return;
       case UDN:
    	   createUDN();				//����������
    	   return;
       case DN:						//����������
    	   createDN();
    	   return;
       }
	}

    //��������ͼ
	private void createUDG(){
		
	}
	
	//��������ͼ
	private void createDG(){
		
	}
	
	//����������
	private void createDN(){
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı�����");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ��� ���㣺");
		for(int v = 0; v < vexNum; v++){   //���춥������
			vexs[v] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for(int v = 0; v < vexNum; v++){    //��ʼ���ڽӾ���
			for(int u = 0; u < vexNum; u++){
				arcs[v][u] = INFINITY;
			}
		}
		System.out.println("��������� �ߵ����� ���㼰��Ȩֵ��");
		for(int k = 0; k < arcNum; k++){
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = sc.nextInt();
		}
	}
	
	//����������
	private void createUDN(){
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ�����ͼ�Ķ������� ͼ�ı�����");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new Object[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ������㣺");
		for(int v = 0; v < vexNum; v++){         //���춥������
			vexs[v] = sc.next();
		}
		arcs = new int[vexNum][vexNum];
		for(int v = 0; v < vexNum; v++){   //��ʼ���ڽӾ���
			for(int u = 0; u < vexNum; u++){
				arcs[u][v] = INFINITY;
			}
		}
		System.out.println("����������ߵ��������㼰��Ȩֵ��");
		for(int k = 0; k < arcNum; k++){
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			arcs[v][u] = arcs[u][v] = sc.nextInt();
		}
	}
	
	//���ض�����
	@Override
	public int getVexNum() {
		// TODO Auto-generated method stub
		return vexNum;
	}

	//���ر���
	@Override
	public int getArcNum() {
		// TODO Auto-generated method stub
		return arcNum;
	}

	//����v��ʾ����ֵ��0 <= v < vexNum
	@Override
	public Object getVex(int v) throws Exception{
		if(v < 0 && v >= vexNum){
			throw new Exception("��" + v + "�����㲻���ڣ�");
		}
		return vexs[v];
	}

	//��������ֵvex,��������ͼ�е�λ�ã����ͼ�в������˶��㣬�򷵻�-1
	@Override
	public int locateVex(Object vex) {
		for(int v = 0; v < vexNum; v++){
			if(vexs[v].equals(vex)){
				return v;
			}
		}
		return -1;
	}

	//����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ��򷵻�-1��0 <= v < vexNum
	@Override
	public int firstAdjVex(int v) throws Exception{
		if(v < 0 && v >= vexNum){
			throw new Exception("��" + v + "�����㲻���ڣ�");
		}
		for(int j = 0; j < vexNum; j++){
			if(arcs[v][j] != 0 && arcs[v][j] < INFINITY){
				return j;
			}
		}
		return -1;
	}

	//����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1�� ����0 <= v, w < vexNum
	@Override
	public int nextAdjVex(int v, int w) throws Exception {
		if(v < 0 && v >= vexNum){
			throw new Exception("��" + v + "�����㲻���ڣ�");
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
