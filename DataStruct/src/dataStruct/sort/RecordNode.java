package dataStruct.sort;
/**
 * ������˳����¼��
 * @author ������
 * @ʱ�� 2017-05-07
 *
 */
public class RecordNode {

	public Comparable key;     //�ؼ���
	public Object element;		//����Ԫ��
	
	public RecordNode(Comparable key){
		this.key = key;
	}
	
	public RecordNode(Comparable key, Object element){
		this.key = key;
		this.element = element;
	}
}
