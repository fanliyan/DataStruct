package dataStruct.sort;
/**
 * 待排序顺序表记录类
 * @author 范立炎
 * @时间 2017-05-07
 *
 */
public class RecordNode {

	public Comparable key;     //关键字
	public Object element;		//数据元素
	
	public RecordNode(Comparable key){
		this.key = key;
	}
	
	public RecordNode(Comparable key, Object element){
		this.key = key;
		this.element = element;
	}
}
