package dataStruct.graph;

import java.util.Scanner;

import dataStruct.IGraph.IGraph;

/**
 * ͼ���ڽӱ�������
 * @author ������
 * @ʱ�� 2017-05-02
 *
 */
public class ALGraph implements IGraph {

	private GraphKind kind;    //ͼ�������־
	private int vexNum, arcNum;    //ͼ�ĵ�ǰ�������ͱ���
	private VNode[] vexs;		//����
	
	public ALGraph(){
		this(null, 0, 0, null);
	}
	
	public ALGraph(GraphKind kind, int vexNum, int arcNum, VNode[] vexs){
		this.kind = kind;
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}
	
	//����ͼ
	@Override
	public void createGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ͼ�����ͣ�");
		GraphKind kind = GraphKind.valueOf(sc.next());
		switch(kind){
		case DG:
			createDG();        //��������ͼ
			return;
		case UDG:
			createUDG();		//��������ͼ
			return;
		case DN:
			createDN(); 		//����������
			return;
		case UDN:
			createUDN();	   //��������ͼ
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
	private void createUDN(){
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı�����");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ����㣺");
		for(int v = 0; v < vexNum; v++){
			vexs[v] = new VNode(sc.next());
		}
		System.out.println("����������㼰��Ȩֵ��");
		for(int k = 0; k < arcNum; k++){
			int v = locateVex(sc.next());
			int u = locateVex(sc.next());
			int value = sc.nextInt();
			addArc(v, u, value);
			addArc(u, v, value);
		}
	}
	
	//����������
	private void createDN(){
		Scanner sc = new Scanner(System.in);
		System.out.println("��ֱ�����ͼ�Ķ�������ͼ�ı�����");
		vexNum = sc.nextInt();
		arcNum = sc.nextInt();
		vexs = new VNode[vexNum];
		System.out.println("��ֱ�����ͼ�ĸ����㣺");
		for(int v = 0; v < vexNum; v++){    //���춥������
			vexs[v] = new VNode(sc.next());
		}
		System.out.println("��������ߵĶ��㼰Ȩֵ��");
		for(int k = 0; k < arcNum; k++){
			int v = locateVex(sc.next());  //��β
			int u = locateVex(sc.next());  //��ͷ
			int value = sc.nextInt();
			addArc(v, u, value);
		}
	}
	
	//��λ��Ϊv��u�Ķ���֮�䣬���һ��������ȨֵΪvalue
	public void addArc(int v, int u, int value){
		ArcNode arc = new ArcNode(u, value);
		arc.nextArc = vexs[v].firstArc;
		vexs[v].firstArc = arc;
	}
	
	//���ض�����
	@Override
	public int getVexNum() {
		return vexNum;
	}

	//���ر���
	@Override
	public int getArcNum() {
		return arcNum;
	}

	//����v��ʾ����ֵ��0 <= v < vexnum
	@Override
	public Object getVex(int v) throws Exception {

		if(v < 0 && v >= vexNum){
			throw new Exception("��" + v + "�����㲻���ڣ�");
		}
		return vexs[v].data;
	}

	//���������ֵvex,��������ͼ�е�λ�ã���ͼ�в������˶��㣬�򷵻�-1
	@Override
	public int locateVex(Object vex) {
		for(int v = 0; v < vexNum; v++){
			if(vexs[v].data.equals(vex)){
				return v;
			}
		}
		return -1;
	}
	
	public VNode[] getVexs(){
		return vexs;
	}
	
	public GraphKind getKind(){
		return kind;
	}

	//����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ㣬�򷵻�-1��0 <= v < vexnum
	@Override
	public int firstAdjVex(int v) throws Exception {
		if(v < 0 && v >= vexNum){
			throw new Exception("��" + v + "�����㲻���ڣ�");
		}
		VNode vex = vexs[v];
		if(vex.firstArc != null){
			return vex.firstArc.adjVex;
		}else{
			return -1;
		}
		
	}

	//����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1�����У� 0<=v, w<vexNum
	@Override
	public int nextAdjVex(int v, int w) throws Exception {
		if(v < 0 && v >= vexNum){
			throw new Exception("��" + v + "�����㲻���ڣ�");
		}
		VNode vex = vexs[v];
		ArcNode arcvw = null;
		for(ArcNode arc = vex.firstArc; arc != null; arc = arc.nextArc){
			if(arc.adjVex == w){
				arcvw = arc;
				break;
			}
		}
		if(arcvw != null && arcvw.nextArc != null){
			return arcvw.nextArc.adjVex;
		}else{
			return -1;
		}
	}

}
