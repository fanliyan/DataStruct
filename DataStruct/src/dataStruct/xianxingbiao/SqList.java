package dataStruct.xianxingbiao;

import dataStruct.IXianxingbiao.IList;

public class SqList implements IList {

	private Object[] listElem;
	private int curLen;
	
	public SqList(int maxSize){
		curLen = 0;
		listElem = new Object[maxSize];
	}
	
	@Override
	public void clear() {
       curLen = 0;
	}

	@Override
	public boolean isEmpty() {
		return curLen == 0;
	}

	@Override
	public int length() {
		return curLen;
	}

	@Override
	public Object get(int i) throws Exception{
      if(i < 0 || i > curLen -1){
    	  throw new Exception("��" + i + "��Ԫ�ز�����");
      }
      return listElem[i];
	}

	@Override
	public void insert(int i, Object x) throws Exception{
         if(curLen == listElem.length){
        	 throw new Exception("˳�������");
         }
         if(i < 0 || i > curLen){
        	 throw new Exception("����λ�ò��Ϸ�");
         }
         for(int j = curLen; j > i; j--){
        	 listElem[j] = listElem[j - 1];
         }
         listElem[i] = x;
         curLen++;
	}

	@Override
	public void remove(int i) throws Exception{
			if(i < 0 || i > curLen){
				throw new Exception("ɾ��λ�ò��Ϸ�");
			}
			for(int j = i; j > curLen - 1; j++){
				listElem[j] = listElem[j + 1];
			}
			curLen--;
	}

	@Override
	public int indexOf(Object x) {
		int j = 0;
		while(j < curLen && !listElem[j].equals(x)){
			j++;
		}
		if(j < curLen){
			return j;
		}else{
			return -1;
		}
	}

	@Override
	public void display() {
		for(int j = 0; j < curLen; j++){
			System.out.print(listElem[j] + " ");
		}
		System.out.println();
	}

}
