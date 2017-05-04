package dataStruct.erchashu;

/**
 * �����������������
 * @author ������
 *
 */
public class HuffmanNode {
     public int weight;    //����Ȩֵ
     public int flag;      //����Ƿ������������ı�־
     public HuffmanNode parent, lchild, rchild;       //����㼰���Һ��ӽ��
     
     public HuffmanNode(){       //����һ���ս��
    	 this(0);
     }
     
     public HuffmanNode(int weight){      //����һ������Ȩֵ�Ľ��
    	 this.weight = weight;
    	 flag = 0;
    	 parent = lchild = rchild = null;
     }
}
