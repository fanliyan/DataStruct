package dataStruct.tree;

/**
 * ����˫�׺�������洢�ṹ
 * @author ������
 * @ʱ�� 2017-05-01
 *
 */
public class CSTreeNode {
	public Object data; 		//����������
	public CSTreeNode firstchild, nextsibling;    //���ӡ����ֵ�
	
	//����һ���ս��
	public CSTreeNode(){
		this(null);
	}
	
	//����һ�����Ӽ��ֵ�Ϊ�յĽ��
	public CSTreeNode(Object data){	
		this(data, null, null);
	}
	
	//����һ��������ͺ��Ӽ��ֵܶ���Ϊ�յĽ��
	public CSTreeNode(Object data, CSTreeNode firstchild, CSTreeNode nextsibling){
		this.data = data;
		this.firstchild = firstchild;
		this.nextsibling = nextsibling;
	}
}		//�����ֵ������н�������������
