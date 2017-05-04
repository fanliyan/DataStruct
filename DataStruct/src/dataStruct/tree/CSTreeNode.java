package dataStruct.tree;

/**
 * 树的双亲孩子链表存储结构
 * @author 范立炎
 * @时间 2017-05-01
 *
 */
public class CSTreeNode {
	public Object data; 		//结点的数据域
	public CSTreeNode firstchild, nextsibling;    //左孩子、右兄弟
	
	//构造一个空结点
	public CSTreeNode(){
		this(null);
	}
	
	//构造一个孩子及兄弟为空的结点
	public CSTreeNode(Object data){	
		this(data, null, null);
	}
	
	//构造一棵数据域和孩子及兄弟都不为空的结点
	public CSTreeNode(Object data, CSTreeNode firstchild, CSTreeNode nextsibling){
		this.data = data;
		this.firstchild = firstchild;
		this.nextsibling = nextsibling;
	}
}		//孩子兄弟链表中结点的类描述结束
