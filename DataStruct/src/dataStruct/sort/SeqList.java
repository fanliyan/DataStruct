package dataStruct.sort;

import dataStruct.graph.ShortestPath_DIJ;

/**
 * 待排序顺序表类描述
 * @author 范立炎
 * @时间 2017-05-07
 *
 */
public class SeqList {
    public RecordNode[] r; 			//顺序表记录结点数组
    public int curlen;				//顺序表长度，即记录个数
    
    //顺序表的构造方法，构造一个存储空间容量为maxSize的顺序表
    public SeqList(int maxSize){
    	this.r = new RecordNode[maxSize];      //为顺序表分配maxSize个存储单元
    	this.curlen = 0;           //置顺序表的当前长度为0
    }
     //在当前顺序表的第i个结点之前 插入一个RecordNode类型的结点x
    public void insert(int i, RecordNode x) throws Exception{
    	if(curlen == r.length){    //判断顺序表是否已满
    		throw new Exception("顺序表已满");
    	}
    	if(i < 0 || i > curlen){   //i小于0或者大于表长
    		throw new Exception("插入位置不合理");
    	}
    	for(int j = curlen; j > i; j--){
    		r[j] = r[j -1];     //插入位置及之后的数据元素后移
    	}
    	r[i] = x;     //插入x
    	this.curlen++;
    }
    
  //不带监视哨的直接插入排序
  	public void insertSort(){
  		RecordNode temp;
  		int i, j;
  		for(i = 1; i < this.curlen; i++){    //n - 1趟扫描
  			temp = r[i];   //将待插入的第i条记录暂存在temp中
  			for(j = i - 1; j >= 0 && temp.key.compareTo(r[j].key) < 0; j--){
  				r[j + 1] = r[j];        //将前面比r[i]大的记录向后移动
  			}
  			r[j + 1] = temp;     //r[i]插入到第j+1个位置
  		}
  		
  	}
  	
  	//带监视哨的直接插入排序
  	public void insertSortWithGuard(){
  		int i, j;
  		for(i = 1; i < this.curlen; i++){    //n-1趟扫描
  			r[0] = r[i];     //将待插入的第i条记录暂存在r[0]中，同时r[0]为监视哨
  			for(j = i - 1; r[0].key.compareTo(r[j].key) < 0; j--){   //将前面较大的数据元素向后移动
  				r[j + 1] = r[j];
  			}
  			r[j + 1] = r[0];     //r[i]插入到第j+1个位置
  		}
  	}
  	
  	//希尔排序算法
  	public void shellSort(int[] d){     //d[]为增量数组
  		RecordNode temp;
  		int i, j;
  		//控制增量，增量减半，若干趟扫描
  		for(int k = 0; k < d.length; k++){
  			//一趟中若干子表，每个记录在自己所属子表内进行直接插入排序
  			int dk = d[k];
  			for(i = dk; i < this.curlen; i++){
  				temp = r[i];
  				for(j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j-= dk){
  					r[j + dk] = r[j];
  				}
  				r[j + dk] = temp;
  			}
  		}
  	}
  	
  	//冒泡排序算法
  	public void bubbleSort(){
  		RecordNode temp;      //辅助结点
  		boolean flag = true;    //是否交换记
  		for(int i = 1; i < this.curlen && flag; i++){  //有交换时再进行下一趟，最多n-1趟
  			flag = false;       //记录未交换
  			for(int j = 0; j < this.curlen - i; j++){   //一次比较、交换
  				if(r[j].key.compareTo(r[j + 1].key) > 0){  //逆序时交换
  					temp = r[j];
  					r[j] = r[j + 1];
  					r[j + 1] = temp;
  					flag = true;
  				}
  			}
  		}
  	}
  	
  	//一趟快速排序算法
  	//交换排序表r[i..j]的记录，使支点记录到位，并返回所在位置
  	//此时，在支点之前（后）的记录关键字值均不大于（小于）它
  	public int Partition(int i, int j){
  		RecordNode pivot = r[i];   //第一个记录作为支点记录
  		while(i < j){     //从表的两端交替地向中间扫描
  			while(i < j && pivot.key.compareTo(r[j].key) <= 0){
  				j--;
  			}
  			if(i < j){
  				r[i] = r[j];   //将比支点记录关键字值小的记录向前移动
  				i++;
  			}
  			while(i < j && pivot.key.compareTo(r[i].key) > 0){
  				i++;
  			}
  			if(i < j){
  				r[j] = r[i];      //将比支点记录关键字值大的记录向后移动
  				j--;
  			}
  		}
  		r[i] = pivot;     //支点记录到位
  		return i;          //返回支点位置
  	}
  	
  	//递归形式的快速排序算法
  	//对子表r[low..high]快速排序
  	public void qSort(int low, int high){
  		if(low < high){
  			int pivotloc = Partition(low, high);       //一趟排序，将排序表分为两部分
  			qSort(low, pivotloc - 1);       //低子表递归排序
  			qSort(pivotloc + 1, high);     //高子表递归排序
  		}
  	}
  	
  	//顺序表快速排序算法
  	//对顺序表r[0..curlen - 1]快速排序
  	public void quickSort(){
  		qSort(0, this.curlen - 1);
  	}
  	
  	//直接选择排序
  	public void selectSort(){
  		RecordNode temp;     //辅助结点
  		for(int i = 0; i < this.curlen - 1; i++){    //n-1趟排序
  			//每趟在从r[i]开始的子序列中寻找最小关键字值的记录
  			int min = i;     //设第i条记录的关键字值最小
  			for(int j = i + 1; j < this.curlen; j++){    //在子序列中选择关键字值最小的记录
  				if(r[j].key.compareTo(r[min].key) < 0){
  					min = j;					//记住关键字指最小记录的下标
  				}
  			}
  			if(min != i){    //将本趟关键字值最小的记录与第i条记录交换
  				temp = r[i];
  				r[i] = r[min];
  				r[min] = temp;
  			}
  		}
  	}
  	
  	/**
  	 * 树形选择排序算法
  	 */
  	//建立树的顺序存储数组tree,并对其排序，将结果返回到r中
  	public void tournamentSort(){
  		TreeNode[] tree;  			//胜者树结点数组
  		int leafSize = 1;   		//胜者树的叶子结点数
  		
  		//得到胜者树叶子结点（外结点）的个数，该个数必须是2的幂
  		while(leafSize < this.curlen){
  			leafSize *= 2;
  		}
  		
  		int TreeSize = 2 * leafSize - 1;      //胜者树中所有结点数
  		int loadindex = leafSize - 1;     //叶子结点（外结点）存放的起始位置
  		tree = new TreeNode[TreeSize];
  		int j = 0;
  		
  		//把待排序结点复制到胜者树的叶子结点
  		for(int i = loadindex; i < TreeSize; i++){
  			tree[i] = new TreeNode();
  			tree[i].index = i;
  			if(j < this.curlen){    //复制结点
  				tree[i].active = 1;
  				tree[i].data = r[j++];
  			}else{
  				tree[i].active = 0;   //空的外结点
  			}
  		}
  		int i = loadindex;    //进行初始化比较查找关键子值最小的结点
  		while(i > 0){ 			//产生胜者树
  			j = i;
  			while(j < 2 * i){  //处理各对比赛者
  				if(tree[j + 1].active == 0 || ((tree[j].data).key.compareTo((tree[j + 1].data).key)) <= 0){
  					tree[(j - 1) / 2] = tree[j];    //左孩子（胜者）赋值给父结点
  				}else{
  					tree[(j - 1) / 2] = tree[j + 1];   //右孩子（胜者）赋值给父结点
  				}
  				j += 2;   //下一对比赛者
  			}
  			i = (i - 1) / 2;     //处理上层结点
  		}
  		for(i = 0; i < this.curlen - 1; i++){    //处理剩余的n-1个记录
  			r[i] = tree[0].data;      //将胜者树的根（最小者）存入数组r
  			tree[tree[0].index].active = 0;   //该记录相应外结点 不再比赛
  			updateTree(tree, tree[0].index);    //调整胜者树
  		}
  		r[this.curlen - 1] = tree[0].data;
  	}
  	
  	public void updateTree(TreeNode[] tree, int i){
  		int j;
  		if(i % 2 == 0){     //i为偶数，对手为左结点
  			tree[(i - 1) / 2] = tree[i - 1];
  		}else{    //i为奇数，对手为右结点
  			tree[(i - 1) / 2] = tree[i + 1];
  		}
  		i = (i - 1) / 2;    //最小记录输出后，其对手上升到父结点
  		while(i > 0){       //直到i==0
  			if(i % 2 == 0){   //i为偶数，对手为左结点
  				j = i - 1;
  			}else{    //i为奇数，对手为右结点
  				j = i + 1;
  			}
  		//比赛对手中有一个为空
  	  		if(tree[i].active == 0 || tree[j].active == 0){
  	  			if(tree[i].active == 1){
  	  				tree[(i - 1) / 2] = tree[i];  //i可选参，i上升到父结点
  	  			}else{
  	  				tree[(i - 1) / 2] = tree[j];   //否则，j上升到父结点
  	  			}
  	  		}else{    //双方都可参选
  	  			//关键字值较小者上升到父结点
  	  			if((tree[i].data).key.compareTo((tree[j].data).key) <= 0){
  	  				tree[(i - 1) / 2] = tree[i];
  	  			}else{
  	  				tree[(i - 1) / 2] = tree[j];
  	  			}
  	  			i = (i - 1) / 2;   //i上升到父结点
  	  		}
  		}
  	}
  	/**
  	 * 筛选法调整堆算法
  	 * @param low
  	 * @param high
  	 * @author 范立炎
  	 */
  	public void sift(int low, int high){
  		int i = low;   //子树的根结点
  		int j = 2 * i + 1;    //j为i结点的左孩子
  		RecordNode temp = r[i];     
  		while(j < high){
  			if(j < high - 1 && r[j].key.compareTo(r[j + 1].key) > 0){
  				j++; 			//记录比较， j为左右孩子的较小者
  			}
  			if(temp.key.compareTo(r[j].key) > 0){    //若父母结点值较大
  			   r[i] = r[j];     //孩子结点中的较小值上移
  			   i = j;
  			   j = 2 * i + 1;
  			}else{
  				j = high + 1;			//退出循环
  			}
  		}
  		r[i] = temp;      //当前子树的原根值调整后的位置
  	}
  	
  	/**
  	 * 堆排序算法
  	 */
  	public void heapSort(){
  		System.out.println("堆排序");
  		int n = this.curlen;
  		RecordNode temp;
  		for(int i = n / 2 - 1; i > 0; i--){   //创建堆
  			sift(i, n);
  		}
  		for(int i = n - 1; i > 0; i--){   //每趟将最小关键字值交换到后面，再调整成堆
  			temp = r[0];
  			r[0] = r[i];
  			r[i] = temp;
  			sift(0, i);
  		}
  	}
}
