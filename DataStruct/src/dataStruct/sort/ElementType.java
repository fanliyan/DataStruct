package dataStruct.sort;

/**
 * 顺序表记录结点类
 * @author 范立炎
 * @时间 2017-05-10
 *
 */
public class ElementType {

	public String data;     //用户可自定义其他数据项
	
	public ElementType(String data) {
		this.data = data;
	}

	public ElementType() {
	
	}
	
	public String toString(){     //覆盖toString()方法
		return data;
	}
}
