package dataStruct.erchashu;

import dataStruct.Queue.LinkQueue;
import dataStruct.Stacck.LinkStack;

public class BiTree {

	private BiTreeNode root;   //���ĸ����
	
	public BiTree(){ 			//����һ�ÿ���
		this.root = null;         
	}
	
	public BiTree(BiTreeNode root){       //����һ����
		this.root = root;
	}
	
	//���ȸ��������и��������д���һ�ö��������㷨
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count){
		if(count > 0){							//�ȸ����и��ǿ�
			char r = preOrder.charAt(preIndex);  //ȡ�ȸ����������еĵ�һ�������Ϊ�����
			int i = 0;
			for(; i < count; i++){  		//Ѱ�Ҹ�������и����������е�λ��
				if(r == inOrder.charAt(i + inIndex)){
					break;
				}
			}
			root = new BiTreeNode(r);     //�������ĸ����
			root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;   //��������������
			root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root;   //��������������
		}
	}
	
	//�ɱ������������ȸ����и��������д���һ�ö������㷨
	private static int index = 0;  //���ڼ�¼preStr������ֵ
	public BiTree(String preStr){
		char c = preStr.charAt(index++);   //ȡ���ַ�������Ϊindex���ַ�����index��1
		if(c != '#'){
			root = new BiTreeNode(c);         //�����������ĸ����
			root.lchild = new BiTree(preStr).root;      //��������������
			root.rchild = new BiTree(preStr).root;     //��������������
		}else{
			root = null;
		}
	}
	
	//�ȸ������������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode T){
		if(T != null){
			System.out.println(T.data);     //���ʸ����
			preRootTraverse(T.lchild);     //�ȸ�����������
			preRootTraverse(T.rchild);    //�ȸ�����������
		}
	}
	
	//�ȸ������������ķǵݹ��㷨
	public void preRootTraverse() throws Exception{
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();    //����ջ
			S.push(T);      //�������ջ
			while(!S.isEmpty()){
				T = (BiTreeNode)S.pop();     //�Ƴ�ջ����㣬��������ֵ
				System.out.print(T.data);       //���ʽ��
				while(T != null){
					if(T.lchild != null){       //��������
						System.out.println(T.lchild.data);     //���ʽ��
					}
					if(T.rchild != null){     //�Һ�����ǿ�ջ
							S.push(T.rchild);
						}
					T = T.lchild;
				}
			}
		}
	}
	
	//�и������������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode T){
		if(T != null){
			inRootTraverse(T.lchild);
			System.out.println(T.data);
			inRootTraverse(T.rchild);
		}
	}
	
	//�и������������ķǵݹ��㷨
	public void inRootTraverse() throws Exception{
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();      //������ջ
			S.push(T);			//������ջ
			while(!S.isEmpty()){
				while(S.peek() != null){			//��ջ���������ӽ�������ջ
					S.push(((BiTreeNode)S.peek()).lchild);
				}
				S.pop();                    //�ս����ջ
				if(!S.isEmpty()){
					T = (BiTreeNode)S.pop();         //�Ƴ�ջ����㣬��������ֵ
					System.out.println(T.data);    //���ʽ��
					S.push(T.rchild);
				}
			}
		}
	}
	
	//��������������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode T){
		if(T != null){
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.println(T.data);
		}
	}
	
	//��������������ķǵݹ��㷨
	public void postRootTraverse() throws Exception{
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();     //������ջ
			S.push(T);  		//�����ջ
			Boolean flag;			//���ʱ��
			BiTreeNode p = null;     //pָ��ձ����ʵĽ��
			while(!S.isEmpty()){
				while(S.peek() != null){
					S.push(((BiTreeNode)S.peek()).lchild);
				}
				S.pop();    //�ս����ջ
				while(!S.isEmpty()){
					T = (BiTreeNode)S.peek();        //�鿴ջ��Ԫ��
					if(T.rchild == null || T.rchild == p){
						System.out.println(T.data);       //���ʽ��
						S.pop();       //�Ƴ�ջ��Ԫ��
						p = T;				//pָ��ձ����ʵĽ��
						flag = true;        //���÷��ʱ��
					}else{
						S.push(T.rchild);		//�Һ��ӽ����ջ
						flag = false;			//����δ���ʱ��
					}
					if(!flag){
						break;
					}
				}
			}
		}
	}
	
	//��α����������ķǵݹ��㷨���������ң�
	public void levelTraverse() throws Exception{
		BiTreeNode  T = root;
		if(T != null){
			LinkQueue L = new LinkQueue();		//�������
			L.offer(T);				//����������
			while(!L.isEmpty()){
				T = (BiTreeNode)L.poll();   
				System.out.println(T.data);   //���ʽ��
				if(T.lchild != null){     //���ӷǿգ������
					L.offer(T.lchild);
				}
				if(T.rchild != null){     //�Һ��ӷǿգ������
					L.offer(T.rchild);
				}
			}
		}
	}
	
	public BiTreeNode getRoot(){
		return root;
	}
	public void setRoot(){
		this.root = root;
	}
}
