package dataStruct.erchashu.test;

import dataStruct.erchashu.HuffmanNode;

/**
 * 构造哈夫曼树和哈夫曼编码
 * @author 范立炎
 * @时间 2017-05-01
 */
public class HuffmanTree {

	//求哈夫曼编码的算法，W存放n个字符的权值（均>0）
	public int[][] huffmanCodint(int[] W){
		int n = W.length;     //字符个数
		int m = 2 * n - 1;     //哈夫曼树的结点数
		HuffmanNode[] HN = new HuffmanNode[m];
		int i;
		for(i = 0; i < n; i++){
			HN[i] = new HuffmanNode(W[i]);     //构造n个权具有值的结点
		}
		for( i = n; i < m; i++){           //建哈夫曼树
			//在HN[0..i-1]选择不在哈夫曼树中且weight最小的两个结点min1和min2
			HuffmanNode min1 = selectMin(HN, i - 1);
			min1.flag = 1;
			HuffmanNode min2 = selectMin(HN, i - 1);
			min2.flag = 1;
			//构造min1和min2的父结点，并修改其父结点的权值
			HN[i] = new HuffmanNode();
			min1.parent = HN[i];
			min2.parent = HN[i];
			HN[i].lchild = min1;
			HN[i].rchild = min2;
			HN[i].weight = min1.weight + min2.weight;
		}
		//从叶子到根逆向求每个字符的哈夫曼编码
		int[][] HuffCode = new int[n][n];       //分配n个字符编码存储空间
		for(int j = 0; j < n; j++){
			int start = n - 1;      //编码的开始位置，初始化为数组的结尾
			for(HuffmanNode c = HN[j], p = c.parent; p != null; c = p, p = p.parent){   //从叶子到根逆向求编码
				if(p.lchild.equals(c)){     //左孩子编码为0
					HuffCode[j][start--] = 0;
				}else{  					//右孩子编码为1
					HuffCode[j][start--] = 1;
				}
			}
			HuffCode[j][start] = -1;     //编码的开始标志为-1，编码是-1之后的0、1序列
		}
		return HuffCode;
	}
	
	//在HN[0..i-1]选择不在哈夫曼树中且weight最小的结点
	private HuffmanNode selectMin(HuffmanNode[] HN, int end){
		HuffmanNode min = HN[end];
		for(int i = 0; i <= end; i++){
			HuffmanNode h = HN[i];
			if(h.flag == 0 && h.weight < min.weight){   //不在哈夫曼树中且weight最小的结点
				min = h;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] W = {23, 11, 5, 3, 29, 14, 7, 8};   //初始化权值
		HuffmanTree T = new HuffmanTree();		//构造哈夫曼树
		int[][] HN = T.huffmanCodint(W);       //求哈夫曼编码
		System.out.println("哈夫曼编码为：");
		for(int i = 0; i < HN.length; i++){   //输出哈夫曼编码
			System.out.println(W[i] + " ");
			for(int j = 0; j < HN[i].length; j++){
				if(HN[i][j] == -1){       //开始标志符读到数组结尾
					for(int k = j + 1; k < HN[i].length; k++){
						System.out.println(HN[i][k]);  //输出
					}
					break;
				}
			}
			System.out.println();     //输出换行
		}
	}
}
