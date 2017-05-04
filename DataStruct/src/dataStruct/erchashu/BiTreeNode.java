package dataStruct.erchashu;


/**
 * ������ʽ�洢�ṹ
 * @author ������
 *
 */
public class BiTreeNode {

	public Object data;  //����������
	public BiTreeNode lchild, rchild;  //���Һ���
	
	//����һ���ս��
	public BiTreeNode(){
		this(null);
	}
	
	//����һ�����Һ�����Ϊ�յĶ�����
	public BiTreeNode(Object data){
		this(data, null, null);
	}
	
	//����һ�����Һ�����Ϊ�յĶ�����
	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild){
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}    //����ඨ�����
