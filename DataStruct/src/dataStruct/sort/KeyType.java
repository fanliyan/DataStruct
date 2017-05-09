package dataStruct.sort;

/**
 * 顺序表记录类关键字
 * @author 范立炎
 * @param <T>
 * @时间 2017-05-09
 *
 */
public class KeyType implements Comparable {
   public int key;     //关键值
   
   public KeyType() {
  }
   
   public KeyType(int key){
	   this.key = key;
   }
   
   public String toString(){     //覆盖toString()方法
	   return key + " ";
   }

	public int compareTo(Object another) {
		 int thisVal = this.key;
		   int anotherVal = ((KeyType)another).key;
		   return (thisVal < anotherVal ? - 1 : (thisVal == anotherVal ? 0 : 1));
	}

  
   
   
}
