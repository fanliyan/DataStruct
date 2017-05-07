package dataStruct.sort;

/**
 * 胜者树结点类
 * @author 范立炎
 * @时间 2017-05-07
 *
 */
public class TreeNode {
    
	public RecordNode data;     //结点的数据域
	public int index;      //结点在满二叉树中的序号
	public int active;       //参加选择标志，1表示参选，0表示不参选
}
