package dataStruct.graph;

/**
 * ͼ���ڽӱ�洢��ʾ�еĶ�������
 * @author ������
 * @ʱ�� 2017-05-02
 *
 */
public class VNode {

	public Object data;    //������Ϣ
	public ArcNode firstArc;   //ָ���һ�������ڸö���Ļ�
	
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
