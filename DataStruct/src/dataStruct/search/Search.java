package dataStruct.search;

import dataStruct.erchashu.BiTreeNode;
import dataStruct.sort.RecordNode;
import dataStruct.sort.SeqList;

/**
 * 查找
 * @author 范立炎
 * @时间 2017-05-09
 *
 */
public class Search extends SeqList{
	
	public Search(int maxSize) {
		super(maxSize);
	}

	
/**
 * 顺序表查找算法 	
 * @param key
 * @return
 * @author 范立炎
 * @时间 2015-05-09
 */
public int seqSearch(Comparable key){
	int i = 0, n = length();
	while(i < n && r[i].key.compareTo(key) != 0){
		i++;
	}
	if(i < n){    //若查找 成功，则返回该数据元素下标i;否则，返回-1
		return i;
	}else{
		return -1;
	}
}

/**
 * 顺序表查找算法优化（带监视哨，不用每次循环判断是否越界）
 * @param key
 * @return
 */
public int seqSearchWithGuard(Comparable key){
	int i = length() - 1;
	r[0].key = key;
	while((r[i].key).compareTo(key) != 0){
		i--;
	}
	if(i > 0){
		return i;
	}else{
		return -1;
	}
}

//二分查找算法
public int binarySearch(Comparable key){
	if(length() > 0){
		int low = 0, high = length() - 1;      //查找范围的下界和上界
		while(low <= high){     
			int mid = (low + high) / 2;        //中间位置，当前比较的数据元素位置
			if(r[mid].key.compareTo(key) == 0){
				return mid;         //查找成功
			}else if(r[mid].key.compareTo(key) > 0){    //给定值更小
				high = mid - 1;							//查找范围缩小到前半段
			}else{
				low = mid + 1;							//查找范围缩小到后半段
			}
		}
	}
	return -1;
}

	
  
}
