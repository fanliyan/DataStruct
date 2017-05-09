package dataStruct.sort;

/**
 * ˳����¼��ؼ���
 * @author ������
 * @param <T>
 * @ʱ�� 2017-05-09
 *
 */
public class KeyType implements Comparable {
   public int key;     //�ؼ�ֵ
   
   public KeyType() {
  }
   
   public KeyType(int key){
	   this.key = key;
   }
   
   public String toString(){     //����toString()����
	   return key + " ";
   }

	public int compareTo(Object another) {
		 int thisVal = this.key;
		   int anotherVal = ((KeyType)another).key;
		   return (thisVal < anotherVal ? - 1 : (thisVal == anotherVal ? 0 : 1));
	}

  
   
   
}
