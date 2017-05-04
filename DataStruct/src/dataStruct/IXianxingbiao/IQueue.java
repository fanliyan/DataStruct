package dataStruct.IXianxingbiao;

public interface IQueue {

	public void clear();
	public boolean isEmpty();
	public int length();
	public Object peek();  		//读取队首元素并返回其值
	public void offer(Object x) throws Exception;   //将数据元素x插入到队列中使其成为新的队尾元素
	public Object poll(); 		//出队操作
}
