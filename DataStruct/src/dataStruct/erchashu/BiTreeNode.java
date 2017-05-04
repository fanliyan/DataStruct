package dataStruct.erchashu;


/**
 * 二叉链式存储结构
 * @author 范立炎
 *
 */
public class BiTreeNode {

	public Object data;  //结点的数据域
	public BiTreeNode lchild, rchild;  //左右孩子
	
	//构造一个空结点
	public BiTreeNode(){
		this(null);
	}
	
	//构造一棵左、右孩子域为空的二叉树
	public BiTreeNode(Object data){
		this(data, null, null);
	}
	
	//构造一棵左、右孩子域不为空的二叉树
	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild){
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}    //结点类定义结束
