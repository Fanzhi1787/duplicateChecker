import java.util.*;
public class sunchaofan_Game {

	/**
	 * @param args
	 */
	static void CaiDan(){
		 System.out.println("1 ��ʼ��Ϸ");
		 System.out.println("2 �˳�");
		}
	static int ShuRu(){
	    
	    Scanner scanner = new Scanner(System.in);
	    int j = 0;
	    try{
	      j = scanner.nextInt();
	    }catch(Exception e){
	      
	    }
	    return j;  
	 }
	static void CongXinShuRu(){
	  System.out.println("�����������������");
	 }
	 static boolean ChongXinXianShiCaiDan(int s){
	   switch (s){
	     case 1: System.out.println("��Ϸ��ʼ");
	             break;
	     case 2: return false;  
	     default:CongXinShuRu();
	  
	   }
	   return true;
	 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean XunHuanBiaoZhi = true;
		  while(XunHuanBiaoZhi){
		    CaiDan();  
		    int sz =ShuRu(); 
		    XunHuanBiaoZhi = ChongXinXianShiCaiDan(sz); 

	}

	}
}
