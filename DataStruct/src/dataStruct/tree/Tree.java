package dataStruct.tree;

import dataStruct.Queue.LinkQueue;

/**
 * 
 * @author 范立炎
 * 时间 2017-05-01
 *
 */
public class Tree {

	//树的先根遍历递归算法
	public void preRootTraverse(CSTreeNode T){
		if(T != null){
			System.out.println(T.data);    //访问树的根结点
			preRootTraverse(T.firstchild);		//先根遍历树中根结点的第一棵子树
			preRootTraverse(T.nextsibling);		//先根遍历树中根结点的其他子树
		}
	}
	
	//树的后根遍历递归算法
	public void postRootTraverse(CSTreeNode T){
		if(T != null){
			postRootTraverse(T.firstchild);    //后根遍历树中根结点的第一棵子树
			System.out.println(T.data);  	//访问根结点
			postRootTraverse(T.nextsibling);    //后根遍历树中根结点的其他子树
		}
	}
	
	//树的层次遍历算法
	public void levelTraverse(CSTreeNode T) throws Exception{
		if(T != null){
			LinkQueue L = new LinkQueue();         //构造队列
			L.offer(T);					//根结点入队列
			while(!L.isEmpty()){
				for(T = (CSTreeNode)L.poll(); T != null; T = T.nextsibling){   //访问根结点及其所有兄弟结点
					System.out.print(T.data + " ");  //访问结点
					if(T.firstchild != null){   //第一个结点非空入队列
						L.offer(T.firstchild);
					}
				}
			}
		}
	}
}
