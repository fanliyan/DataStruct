package dataStruct.erchashu;

import dataStruct.Queue.LinkQueue;
import dataStruct.Stacck.LinkStack;

public class BiTree {

	private BiTreeNode root;   //树的根结点
	
	public BiTree(){ 			//构造一棵空树
		this.root = null;         
	}
	
	public BiTree(BiTreeNode root){       //构造一棵树
		this.root = root;
	}
	
	//由先根遍历和中根遍历序列创建一棵二叉树的算法
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count){
		if(count > 0){							//先根和中根非空
			char r = preOrder.charAt(preIndex);  //取先根遍历序列中的第一个结点作为根结点
			int i = 0;
			for(; i < count; i++){  		//寻找根结点在中根遍历序列中的位置
				if(r == inOrder.charAt(i + inIndex)){
					break;
				}
			}
			root = new BiTreeNode(r);     //建立树的根结点
			root.lchild = new BiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;   //建立树的左子树
			root.rchild = new BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root;   //建立树的右子树
		}
	}
	
	//由标明空子树的先根和中根遍历序列创建一棵二叉树算法
	private static int index = 0;  //用于记录preStr的索引值
	public BiTree(String preStr){
		char c = preStr.charAt(index++);   //取出字符串索引为index的字符，且index增1
		if(c != '#'){
			root = new BiTreeNode(c);         //建立二叉树的根结点
			root.lchild = new BiTree(preStr).root;      //建立树的左子树
			root.rchild = new BiTree(preStr).root;     //建立树的右子树
		}else{
			root = null;
		}
	}
	
	//先根遍历二叉树的递归算法
	public void preRootTraverse(BiTreeNode T){
		if(T != null){
			System.out.println(T.data);     //访问根结点
			preRootTraverse(T.lchild);     //先根遍历左子树
			preRootTraverse(T.rchild);    //先根遍历右子树
		}
	}
	
	//先根遍历二叉树的非递归算法
	public void preRootTraverse() throws Exception{
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();    //构造栈
			S.push(T);      //根结点入栈
			while(!S.isEmpty()){
				T = (BiTreeNode)S.pop();     //移除栈顶结点，并返回其值
				System.out.print(T.data);       //访问结点
				while(T != null){
					if(T.lchild != null){       //访问左孩子
						System.out.println(T.lchild.data);     //访问结点
					}
					if(T.rchild != null){     //右孩子入非空栈
							S.push(T.rchild);
						}
					T = T.lchild;
				}
			}
		}
	}
	
	//中根遍历二叉树的递归算法
	public void inRootTraverse(BiTreeNode T){
		if(T != null){
			inRootTraverse(T.lchild);
			System.out.println(T.data);
			inRootTraverse(T.rchild);
		}
	}
	
	//中根遍历二叉树的非递归算法
	public void inRootTraverse() throws Exception{
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();      //构造链栈
			S.push(T);			//构造链栈
			while(!S.isEmpty()){
				while(S.peek() != null){			//将栈顶结点的左孩子结点相继入栈
					S.push(((BiTreeNode)S.peek()).lchild);
				}
				S.pop();                    //空结点退栈
				if(!S.isEmpty()){
					T = (BiTreeNode)S.pop();         //移除栈顶结点，并返回其值
					System.out.println(T.data);    //访问结点
					S.push(T.rchild);
				}
			}
		}
	}
	
	//后根遍历二叉树的递归算法
	public void postRootTraverse(BiTreeNode T){
		if(T != null){
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.println(T.data);
		}
	}
	
	//后根遍历二叉树的非递归算法
	public void postRootTraverse() throws Exception{
		BiTreeNode T = root;
		if(T != null){
			LinkStack S = new LinkStack();     //构造链栈
			S.push(T);  		//根结点栈
			Boolean flag;			//访问标记
			BiTreeNode p = null;     //p指向刚被访问的结点
			while(!S.isEmpty()){
				while(S.peek() != null){
					S.push(((BiTreeNode)S.peek()).lchild);
				}
				S.pop();    //空结点退栈
				while(!S.isEmpty()){
					T = (BiTreeNode)S.peek();        //查看栈顶元素
					if(T.rchild == null || T.rchild == p){
						System.out.println(T.data);       //访问结点
						S.pop();       //移除栈顶元素
						p = T;				//p指向刚被访问的结点
						flag = true;        //设置访问标记
					}else{
						S.push(T.rchild);		//右孩子结点入栈
						flag = false;			//设置未访问标记
					}
					if(!flag){
						break;
					}
				}
			}
		}
	}
	
	//层次遍历二叉树的非递归算法（自左向右）
	public void levelTraverse() throws Exception{
		BiTreeNode  T = root;
		if(T != null){
			LinkQueue L = new LinkQueue();		//构造队列
			L.offer(T);				//根结点入队列
			while(!L.isEmpty()){
				T = (BiTreeNode)L.poll();   
				System.out.println(T.data);   //访问结点
				if(T.lchild != null){     //左孩子非空，入队列
					L.offer(T.lchild);
				}
				if(T.rchild != null){     //右孩子非空，入队列
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
