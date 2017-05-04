package dataStruct.tree;

import dataStruct.Queue.LinkQueue;

/**
 * 
 * @author ������
 * ʱ�� 2017-05-01
 *
 */
public class Tree {

	//�����ȸ������ݹ��㷨
	public void preRootTraverse(CSTreeNode T){
		if(T != null){
			System.out.println(T.data);    //�������ĸ����
			preRootTraverse(T.firstchild);		//�ȸ��������и����ĵ�һ������
			preRootTraverse(T.nextsibling);		//�ȸ��������и�������������
		}
	}
	
	//���ĺ�������ݹ��㷨
	public void postRootTraverse(CSTreeNode T){
		if(T != null){
			postRootTraverse(T.firstchild);    //����������и����ĵ�һ������
			System.out.println(T.data);  	//���ʸ����
			postRootTraverse(T.nextsibling);    //����������и�������������
		}
	}
	
	//���Ĳ�α����㷨
	public void levelTraverse(CSTreeNode T) throws Exception{
		if(T != null){
			LinkQueue L = new LinkQueue();         //�������
			L.offer(T);					//����������
			while(!L.isEmpty()){
				for(T = (CSTreeNode)L.poll(); T != null; T = T.nextsibling){   //���ʸ���㼰�������ֵܽ��
					System.out.print(T.data + " ");  //���ʽ��
					if(T.firstchild != null){   //��һ�����ǿ������
						L.offer(T.firstchild);
					}
				}
			}
		}
	}
}
