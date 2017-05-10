package dataStruct.search;

import dataStruct.erchashu.BiTreeNode;
import dataStruct.sort.RecordNode;

/**
 * ��������������ṹ����
 * @author ������
 * @ʱ�� 2017-05-10
 *
 */
public class BSTree {       //������������

	public BiTreeNode root;    //�����
	
	public BSTree(){    //����յĶ���������
		root = null;     
	}
	
	public void inOrderTraverse(BiTreeNode p){    //�и����������p���Ϊ���Ķ�����
		if(p != null){
			inOrderTraverse(p.lchild);
			System.out.println(((RecordNode)p.data).toString() + " ");
			inOrderTraverse(p.rchild);
		}
	}
	
	/**
	 * ���������������㷨
	 * @param key
	 * @return
	 */
 //���ҹؼ���ֵΪkey�Ľ�㣬�����ҳɹ����򷵻ؽ��ֵ�����򷵻�null
   public Object searchBST(Comparable key){
	   if(key == null || !(key instanceof Comparable)){
		   return null;
	   }
	   return searchBST(root, key);
   }
   
   //�������������ҵĵݹ��㷨
   //�ڶ����������в��ҹؼ���ֵΪkey�Ľ�㣬�����ҳɹ����򷵻ؽ��ֵ�����򷵻�null
   private Object searchBST(BiTreeNode p, Comparable key){
	   if(p != null){
		   if(key.compareTo(((RecordNode)p.data).key) == 0){   //���ҳɹ�
			   return p.data;
		   }
		   if(key.compareTo(((RecordNode)p.data).key) < 0){
			   return searchBST(p.lchild, key);   //���������в���
		   }else{
			   return searchBST(p.rchild, key);      //���������в���
		   }
	   }
	   return null;
   }
   
   //�ڶ����������в���ؼ���ֵΪKey������Ԫ��ΪtheElement���½��
   public boolean insertBST(Comparable key, Object theElement){
	   if(key == null || !(key instanceof Comparable)){    //���ܲ���ն���򲻿ɱȽϴ�С�Ķ���
		   return false;
	   }
	   if(root == null){
		   root = new BiTreeNode(new RecordNode(key, theElement));    //���������
	   }
	   return insertBST(root, key, theElement);
   }
   
   //���ؼ���ֵΪkey������Ԫ��ΪtheElement�Ľ����뵽��pΪ���Ķ����������еĵݹ��㷨
   private boolean insertBST(BiTreeNode p, Comparable key, Object theElement){
	   if(key.compareTo(((RecordNode)p.data).key) == 0){
		   return false;            //������ؼ���ֵ�ظ��Ľ��
	   }
	   if(key.compareTo(((RecordNode)p.data).key) < 0){
		   if(p.lchild == null){   //��p��������Ϊ��
			   p.lchild = new BiTreeNode(new RecordNode(key, theElement));   //����Ҷ�ӽ����Ϊp������
			   return true;
		   }else{         //��p���������ǿ�
			   return insertBST(p.lchild, key, theElement);         //���뵽p����������
		   }
	   }else if(p.rchild == null){    //��p��������Ϊ��
		   p.rchild = new BiTreeNode(new RecordNode(key, theElement));   //����Ҷ�ӽ����Ϊp���Һ���
		   return true;
	   }else{ 										//��p���������ǿ�
		   return insertBST(p, key, theElement);    //���뵽p����������
	   }
   }
   
   /**
    * �ڶ�����������ɾ��һ�������㷨
    * @param key
    * @return
    */
   //������������ɾ��һ����� �㷨 ����ɾ���ɹ����򷵻ر�ɾ�����ֵ�����򷵻�null
   public Object removeBST(Comparable key){
	   if(root == null || key == null || !(key instanceof Comparable)){
		   return null;
	   }
	   //����rootΪ���Ķ�����������ɾ���ؼ���ֵΪelemKey�Ľ��
	   return removeBST(root, key, null);
   }
   
   //����rootΪ���Ķ�����������ɾ���ؼ���ֵΪelemKey,parent��p�ĸ���㣬���õݹ��㷨
   private Object removeBST(BiTreeNode p, Comparable elemKey, BiTreeNode parent){
	   if(p != null){
		   if(elemKey.compareTo(((RecordNode)p.data).key) < 0){     //����������ɾ��
			   return removeBST(p.lchild, elemKey, p);       //���������еݹ�����
		   }else if(elemKey.compareTo(((RecordNode)p.data).key) > 0){  //����������ɾ��
			   return removeBST(p.rchild, elemKey, p);      //���������еݹ�����
		   }else if(p.lchild != null && p.rchild != null){
			   //����Ҹý������������
			   BiTreeNode innext = p.rchild;    //Ѱ��p���и������µĺ�̽��innet
			   while(innext.lchild != null){    //��Ѱ���������е�������
				   innext = innext.lchild;
			   }
			   p.data = innext.data;
			   return removeBST(p.rchild, ((RecordNode)p.data).key, p);    //�ݹ�ɾ�����p
		   }else{   //p��1�Ⱥ�Ҷ�ӽ��
			   if(parent == null){      //ɾ������㣬��p==root
				   if(p.lchild != null){
					   root = p.lchild;
				   }else{
					   root = p.rchild;
				   }
				   return p.data;     //���ر�ɾ�����p
			   }
			   if(p == parent.lchild){    //p��parent������
				   if(p.lchild != null){
					   parent.lchild = p.lchild;
				   }else{
					   parent.lchild = p.rchild;
				   }
			   }else if(p.lchild != null){    //p��parent���Һ�����p�����ӷǿ�
				   parent.rchild = p.lchild;
			   }else{
				   parent.rchild = p.rchild;
			   }
			   return p.data;
		   }
	   }
	   return null;
   }
}
