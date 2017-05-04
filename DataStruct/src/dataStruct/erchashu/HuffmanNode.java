package dataStruct.erchashu;

/**
 * 哈夫曼树结点类描述
 * @author 范立炎
 *
 */
public class HuffmanNode {
     public int weight;    //结点的权值
     public int flag;      //结点是否加入哈夫曼树的标志
     public HuffmanNode parent, lchild, rchild;       //父结点及左、右孩子结点
     
     public HuffmanNode(){       //构造一个空结点
    	 this(0);
     }
     
     public HuffmanNode(int weight){      //构造一个具有权值的结点
    	 this.weight = weight;
    	 flag = 0;
    	 parent = lchild = rchild = null;
     }
}
