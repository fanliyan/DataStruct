package dataStruct.search;

import dataStruct.erchashu.BiTreeNode;
import dataStruct.sort.RecordNode;
import dataStruct.sort.SeqList;

/**
 * ����
 * @author ������
 * @ʱ�� 2017-05-09
 *
 */
public class Search extends SeqList{
	
	public Search(int maxSize) {
		super(maxSize);
	}

	
/**
 * ˳�������㷨 	
 * @param key
 * @return
 * @author ������
 * @ʱ�� 2015-05-09
 */
public int seqSearch(Comparable key){
	int i = 0, n = length();
	while(i < n && r[i].key.compareTo(key) != 0){
		i++;
	}
	if(i < n){    //������ �ɹ����򷵻ظ�����Ԫ���±�i;���򣬷���-1
		return i;
	}else{
		return -1;
	}
}

/**
 * ˳�������㷨�Ż����������ڣ�����ÿ��ѭ���ж��Ƿ�Խ�磩
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

//���ֲ����㷨
public int binarySearch(Comparable key){
	if(length() > 0){
		int low = 0, high = length() - 1;      //���ҷ�Χ���½���Ͻ�
		while(low <= high){     
			int mid = (low + high) / 2;        //�м�λ�ã���ǰ�Ƚϵ�����Ԫ��λ��
			if(r[mid].key.compareTo(key) == 0){
				return mid;         //���ҳɹ�
			}else if(r[mid].key.compareTo(key) > 0){    //����ֵ��С
				high = mid - 1;							//���ҷ�Χ��С��ǰ���
			}else{
				low = mid + 1;							//���ҷ�Χ��С������
			}
		}
	}
	return -1;
}

	
  
}
