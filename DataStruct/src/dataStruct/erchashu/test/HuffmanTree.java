package dataStruct.erchashu.test;

import dataStruct.erchashu.HuffmanNode;

/**
 * ������������͹���������
 * @author ������
 * @ʱ�� 2017-05-01
 */
public class HuffmanTree {

	//�������������㷨��W���n���ַ���Ȩֵ����>0��
	public int[][] huffmanCodint(int[] W){
		int n = W.length;     //�ַ�����
		int m = 2 * n - 1;     //���������Ľ����
		HuffmanNode[] HN = new HuffmanNode[m];
		int i;
		for(i = 0; i < n; i++){
			HN[i] = new HuffmanNode(W[i]);     //����n��Ȩ����ֵ�Ľ��
		}
		for( i = n; i < m; i++){           //����������
			//��HN[0..i-1]ѡ���ڹ�����������weight��С���������min1��min2
			HuffmanNode min1 = selectMin(HN, i - 1);
			min1.flag = 1;
			HuffmanNode min2 = selectMin(HN, i - 1);
			min2.flag = 1;
			//����min1��min2�ĸ���㣬���޸��丸����Ȩֵ
			HN[i] = new HuffmanNode();
			min1.parent = HN[i];
			min2.parent = HN[i];
			HN[i].lchild = min1;
			HN[i].rchild = min2;
			HN[i].weight = min1.weight + min2.weight;
		}
		//��Ҷ�ӵ���������ÿ���ַ��Ĺ���������
		int[][] HuffCode = new int[n][n];       //����n���ַ�����洢�ռ�
		for(int j = 0; j < n; j++){
			int start = n - 1;      //����Ŀ�ʼλ�ã���ʼ��Ϊ����Ľ�β
			for(HuffmanNode c = HN[j], p = c.parent; p != null; c = p, p = p.parent){   //��Ҷ�ӵ������������
				if(p.lchild.equals(c)){     //���ӱ���Ϊ0
					HuffCode[j][start--] = 0;
				}else{  					//�Һ��ӱ���Ϊ1
					HuffCode[j][start--] = 1;
				}
			}
			HuffCode[j][start] = -1;     //����Ŀ�ʼ��־Ϊ-1��������-1֮���0��1����
		}
		return HuffCode;
	}
	
	//��HN[0..i-1]ѡ���ڹ�����������weight��С�Ľ��
	private HuffmanNode selectMin(HuffmanNode[] HN, int end){
		HuffmanNode min = HN[end];
		for(int i = 0; i <= end; i++){
			HuffmanNode h = HN[i];
			if(h.flag == 0 && h.weight < min.weight){   //���ڹ�����������weight��С�Ľ��
				min = h;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] W = {23, 11, 5, 3, 29, 14, 7, 8};   //��ʼ��Ȩֵ
		HuffmanTree T = new HuffmanTree();		//�����������
		int[][] HN = T.huffmanCodint(W);       //�����������
		System.out.println("����������Ϊ��");
		for(int i = 0; i < HN.length; i++){   //�������������
			System.out.println(W[i] + " ");
			for(int j = 0; j < HN[i].length; j++){
				if(HN[i][j] == -1){       //��ʼ��־�����������β
					for(int k = j + 1; k < HN[i].length; k++){
						System.out.println(HN[i][k]);  //���
					}
					break;
				}
			}
			System.out.println();     //�������
		}
	}
}
