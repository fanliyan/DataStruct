package dataStruct.IXianxingbiao;

public interface IQueue {

	public void clear();
	public boolean isEmpty();
	public int length();
	public Object peek();  		//��ȡ����Ԫ�ز�������ֵ
	public void offer(Object x) throws Exception;   //������Ԫ��x���뵽������ʹ���Ϊ�µĶ�βԪ��
	public Object poll(); 		//���Ӳ���
}
