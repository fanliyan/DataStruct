package dataStruct.sort;

import dataStruct.graph.ShortestPath_DIJ;

/**
 * ������˳���������
 * @author ������
 * @ʱ�� 2017-05-07
 *
 */
public class SeqList {
    public RecordNode[] r; 			//˳����¼�������
    public int curlen;				//˳����ȣ�����¼����
    
    //˳���Ĺ��췽��������һ���洢�ռ�����ΪmaxSize��˳���
    public SeqList(int maxSize){
    	this.r = new RecordNode[maxSize];      //Ϊ˳������maxSize���洢��Ԫ
    	this.curlen = 0;           //��˳���ĵ�ǰ����Ϊ0
    }
     //�ڵ�ǰ˳���ĵ�i�����֮ǰ ����һ��RecordNode���͵Ľ��x
    public void insert(int i, RecordNode x) throws Exception{
    	if(curlen == r.length){    //�ж�˳����Ƿ�����
    		throw new Exception("˳�������");
    	}
    	if(i < 0 || i > curlen){   //iС��0���ߴ��ڱ�
    		throw new Exception("����λ�ò�����");
    	}
    	for(int j = curlen; j > i; j--){
    		r[j] = r[j -1];     //����λ�ü�֮�������Ԫ�غ���
    	}
    	r[i] = x;     //����x
    	this.curlen++;
    }
    
  //���������ڵ�ֱ�Ӳ�������
  	public void insertSort(){
  		RecordNode temp;
  		int i, j;
  		for(i = 1; i < this.curlen; i++){    //n - 1��ɨ��
  			temp = r[i];   //��������ĵ�i����¼�ݴ���temp��
  			for(j = i - 1; j >= 0 && temp.key.compareTo(r[j].key) < 0; j--){
  				r[j + 1] = r[j];        //��ǰ���r[i]��ļ�¼����ƶ�
  			}
  			r[j + 1] = temp;     //r[i]���뵽��j+1��λ��
  		}
  		
  	}
  	
  	//�������ڵ�ֱ�Ӳ�������
  	public void insertSortWithGuard(){
  		int i, j;
  		for(i = 1; i < this.curlen; i++){    //n-1��ɨ��
  			r[0] = r[i];     //��������ĵ�i����¼�ݴ���r[0]�У�ͬʱr[0]Ϊ������
  			for(j = i - 1; r[0].key.compareTo(r[j].key) < 0; j--){   //��ǰ��ϴ������Ԫ������ƶ�
  				r[j + 1] = r[j];
  			}
  			r[j + 1] = r[0];     //r[i]���뵽��j+1��λ��
  		}
  	}
  	
  	//ϣ�������㷨
  	public void shellSort(int[] d){     //d[]Ϊ��������
  		RecordNode temp;
  		int i, j;
  		//�����������������룬������ɨ��
  		for(int k = 0; k < d.length; k++){
  			//һ���������ӱ�ÿ����¼���Լ������ӱ��ڽ���ֱ�Ӳ�������
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
  	
  	//ð�������㷨
  	public void bubbleSort(){
  		RecordNode temp;      //�������
  		boolean flag = true;    //�Ƿ񽻻���
  		for(int i = 1; i < this.curlen && flag; i++){  //�н���ʱ�ٽ�����һ�ˣ����n-1��
  			flag = false;       //��¼δ����
  			for(int j = 0; j < this.curlen - i; j++){   //һ�αȽϡ�����
  				if(r[j].key.compareTo(r[j + 1].key) > 0){  //����ʱ����
  					temp = r[j];
  					r[j] = r[j + 1];
  					r[j + 1] = temp;
  					flag = true;
  				}
  			}
  		}
  	}
  	
  	//һ�˿��������㷨
  	//���������r[i..j]�ļ�¼��ʹ֧���¼��λ������������λ��
  	//��ʱ����֧��֮ǰ���󣩵ļ�¼�ؼ���ֵ�������ڣ�С�ڣ���
  	public int Partition(int i, int j){
  		RecordNode pivot = r[i];   //��һ����¼��Ϊ֧���¼
  		while(i < j){     //�ӱ�����˽�������м�ɨ��
  			while(i < j && pivot.key.compareTo(r[j].key) <= 0){
  				j--;
  			}
  			if(i < j){
  				r[i] = r[j];   //����֧���¼�ؼ���ֵС�ļ�¼��ǰ�ƶ�
  				i++;
  			}
  			while(i < j && pivot.key.compareTo(r[i].key) > 0){
  				i++;
  			}
  			if(i < j){
  				r[j] = r[i];      //����֧���¼�ؼ���ֵ��ļ�¼����ƶ�
  				j--;
  			}
  		}
  		r[i] = pivot;     //֧���¼��λ
  		return i;          //����֧��λ��
  	}
  	
  	//�ݹ���ʽ�Ŀ��������㷨
  	//���ӱ�r[low..high]��������
  	public void qSort(int low, int high){
  		if(low < high){
  			int pivotloc = Partition(low, high);       //һ�����򣬽�������Ϊ������
  			qSort(low, pivotloc - 1);       //���ӱ�ݹ�����
  			qSort(pivotloc + 1, high);     //���ӱ�ݹ�����
  		}
  	}
  	
  	//˳�����������㷨
  	//��˳���r[0..curlen - 1]��������
  	public void quickSort(){
  		qSort(0, this.curlen - 1);
  	}
  	
  	//ֱ��ѡ������
  	public void selectSort(){
  		RecordNode temp;     //�������
  		for(int i = 0; i < this.curlen - 1; i++){    //n-1������
  			//ÿ���ڴ�r[i]��ʼ����������Ѱ����С�ؼ���ֵ�ļ�¼
  			int min = i;     //���i����¼�Ĺؼ���ֵ��С
  			for(int j = i + 1; j < this.curlen; j++){    //����������ѡ��ؼ���ֵ��С�ļ�¼
  				if(r[j].key.compareTo(r[min].key) < 0){
  					min = j;					//��ס�ؼ���ָ��С��¼���±�
  				}
  			}
  			if(min != i){    //�����˹ؼ���ֵ��С�ļ�¼���i����¼����
  				temp = r[i];
  				r[i] = r[min];
  				r[min] = temp;
  			}
  		}
  	}
  	
  	/**
  	 * ����ѡ�������㷨
  	 */
  	//��������˳��洢����tree,���������򣬽�������ص�r��
  	public void tournamentSort(){
  		TreeNode[] tree;  			//ʤ�����������
  		int leafSize = 1;   		//ʤ������Ҷ�ӽ����
  		
  		//�õ�ʤ����Ҷ�ӽ�㣨���㣩�ĸ������ø���������2����
  		while(leafSize < this.curlen){
  			leafSize *= 2;
  		}
  		
  		int TreeSize = 2 * leafSize - 1;      //ʤ���������н����
  		int loadindex = leafSize - 1;     //Ҷ�ӽ�㣨���㣩��ŵ���ʼλ��
  		tree = new TreeNode[TreeSize];
  		int j = 0;
  		
  		//�Ѵ������㸴�Ƶ�ʤ������Ҷ�ӽ��
  		for(int i = loadindex; i < TreeSize; i++){
  			tree[i] = new TreeNode();
  			tree[i].index = i;
  			if(j < this.curlen){    //���ƽ��
  				tree[i].active = 1;
  				tree[i].data = r[j++];
  			}else{
  				tree[i].active = 0;   //�յ�����
  			}
  		}
  		int i = loadindex;    //���г�ʼ���Ƚϲ��ҹؼ���ֵ��С�Ľ��
  		while(i > 0){ 			//����ʤ����
  			j = i;
  			while(j < 2 * i){  //������Ա�����
  				if(tree[j + 1].active == 0 || ((tree[j].data).key.compareTo((tree[j + 1].data).key)) <= 0){
  					tree[(j - 1) / 2] = tree[j];    //���ӣ�ʤ�ߣ���ֵ�������
  				}else{
  					tree[(j - 1) / 2] = tree[j + 1];   //�Һ��ӣ�ʤ�ߣ���ֵ�������
  				}
  				j += 2;   //��һ�Ա�����
  			}
  			i = (i - 1) / 2;     //�����ϲ���
  		}
  		for(i = 0; i < this.curlen - 1; i++){    //����ʣ���n-1����¼
  			r[i] = tree[0].data;      //��ʤ�����ĸ�����С�ߣ���������r
  			tree[tree[0].index].active = 0;   //�ü�¼��Ӧ���� ���ٱ���
  			updateTree(tree, tree[0].index);    //����ʤ����
  		}
  		r[this.curlen - 1] = tree[0].data;
  	}
  	
  	public void updateTree(TreeNode[] tree, int i){
  		int j;
  		if(i % 2 == 0){     //iΪż��������Ϊ����
  			tree[(i - 1) / 2] = tree[i - 1];
  		}else{    //iΪ����������Ϊ�ҽ��
  			tree[(i - 1) / 2] = tree[i + 1];
  		}
  		i = (i - 1) / 2;    //��С��¼���������������������
  		while(i > 0){       //ֱ��i==0
  			if(i % 2 == 0){   //iΪż��������Ϊ����
  				j = i - 1;
  			}else{    //iΪ����������Ϊ�ҽ��
  				j = i + 1;
  			}
  		//������������һ��Ϊ��
  	  		if(tree[i].active == 0 || tree[j].active == 0){
  	  			if(tree[i].active == 1){
  	  				tree[(i - 1) / 2] = tree[i];  //i��ѡ�Σ�i�����������
  	  			}else{
  	  				tree[(i - 1) / 2] = tree[j];   //����j�����������
  	  			}
  	  		}else{    //˫�����ɲ�ѡ
  	  			//�ؼ���ֵ��С�������������
  	  			if((tree[i].data).key.compareTo((tree[j].data).key) <= 0){
  	  				tree[(i - 1) / 2] = tree[i];
  	  			}else{
  	  				tree[(i - 1) / 2] = tree[j];
  	  			}
  	  			i = (i - 1) / 2;   //i�����������
  	  		}
  		}
  	}
  	/**
  	 * ɸѡ���������㷨
  	 * @param low
  	 * @param high
  	 * @author ������
  	 */
  	public void sift(int low, int high){
  		int i = low;   //�����ĸ����
  		int j = 2 * i + 1;    //jΪi��������
  		RecordNode temp = r[i];     
  		while(j < high){
  			if(j < high - 1 && r[j].key.compareTo(r[j + 1].key) > 0){
  				j++; 			//��¼�Ƚϣ� jΪ���Һ��ӵĽ�С��
  			}
  			if(temp.key.compareTo(r[j].key) > 0){    //����ĸ���ֵ�ϴ�
  			   r[i] = r[j];     //���ӽ���еĽ�Сֵ����
  			   i = j;
  			   j = 2 * i + 1;
  			}else{
  				j = high + 1;			//�˳�ѭ��
  			}
  		}
  		r[i] = temp;      //��ǰ������ԭ��ֵ�������λ��
  	}
  	
  	/**
  	 * �������㷨
  	 */
  	public void heapSort(){
  		System.out.println("������");
  		int n = this.curlen;
  		RecordNode temp;
  		for(int i = n / 2 - 1; i > 0; i--){   //������
  			sift(i, n);
  		}
  		for(int i = n - 1; i > 0; i--){   //ÿ�˽���С�ؼ���ֵ���������棬�ٵ����ɶ�
  			temp = r[0];
  			r[0] = r[i];
  			r[i] = temp;
  			sift(0, i);
  		}
  	}
}
