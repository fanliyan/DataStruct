package dataStruct.IGraph;

/**
 * ͼ�ĳ���������������
 * @author ������
 * ʱ�� 2017-05-02
 *
 */
public interface IGraph {
     void createGraph();   		//����һ��ͼ
     int getVexNum();    		//����ͼ�еĶ�����
     int getArcNum();			//����ͼ�еı���
     Object getVex(int v) throws Exception;		//��������λ��v,�������Ӧ�Ķ���ֵ�����У�0<= v < vexNum(vexNumΪ������)
     int locateVex(Object vex);   //��������ֵvex,���� ����ͼ�е�λ�ã����ͼ�в������˶��㣬�򷵻�-1
     int firstAdjVex(int v) throws Exception;		//����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ㣬�򷵻�-1�����У�0 <= v, w <vexNum
     int nextAdjVex(int v, int w) throws Exception;
     
}
