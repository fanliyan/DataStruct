package dataStruct.graph;

/**
 * ͼ���ڽӱ�洢��ʾ�еıߣ��򻡣������
 * @author ������
 * @ʱ�� 2017-05-02
 *
 */
public class ArcNode {
	public int adjVex;			//�û���ָ��Ķ���λ��
	public int value;			//�߻򻡵�Ȩֵ
	public ArcNode nextArc; 	//ָ����һ����
	
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
