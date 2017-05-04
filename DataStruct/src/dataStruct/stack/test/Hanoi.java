package dataStruct.stack.test;

/**
 * 汉诺塔
 * @author 范立炎
 *
 */
public class Hanoi {
     private int c = 0;		//变量，对搬动计数
     //将塔座x上按直径由小到大且自上而下的编号为1至n的n个圆盘按规则移到塔座z上，y用作辅助塔
     public void hanoi(int n, char x, char y, char z){
    	 if(n == 1){
    		 move(x, 1,z);
    	 }else{
    		 hanoi(n - 1, x, z, y);
    		 move(x, n, z);
    		 hanoi(n - 1, y, x, z);
    	 }
     }
     
     //移动操作，将编号为n的圆盘从x移到z
     public void move(char x, int n, char z){
    	 System.out.println("第" + ++c + "次移动：" + n + "号圆盘，" + x + "->" + z);
     }
     
     public static void main(String[] args) {
		Hanoi h = new Hanoi();
		h.hanoi(3, 'x', 'y', 'z');
	}
}
