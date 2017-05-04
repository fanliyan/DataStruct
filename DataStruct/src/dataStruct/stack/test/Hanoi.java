package dataStruct.stack.test;

/**
 * ��ŵ��
 * @author ������
 *
 */
public class Hanoi {
     private int c = 0;		//�������԰ᶯ����
     //������x�ϰ�ֱ����С���������϶��µı��Ϊ1��n��n��Բ�̰������Ƶ�����z�ϣ�y����������
     public void hanoi(int n, char x, char y, char z){
    	 if(n == 1){
    		 move(x, 1,z);
    	 }else{
    		 hanoi(n - 1, x, z, y);
    		 move(x, n, z);
    		 hanoi(n - 1, y, x, z);
    	 }
     }
     
     //�ƶ������������Ϊn��Բ�̴�x�Ƶ�z
     public void move(char x, int n, char z){
    	 System.out.println("��" + ++c + "���ƶ���" + n + "��Բ�̣�" + x + "->" + z);
     }
     
     public static void main(String[] args) {
		Hanoi h = new Hanoi();
		h.hanoi(3, 'x', 'y', 'z');
	}
}
