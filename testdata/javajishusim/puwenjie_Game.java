import java.util.Scanner;
public class puwenjie_Game
{
	//����һ�����˵��ĳ���
	static void zhucaidan(){
		 System.out.println("1 ��ʼ��Ϸ");
		 System.out.println("2 �˳�");
	}
	
	
	//�Ӽ������벢�Ҷ�ȡ��Ӧ���ݲ��ҷ���m
	
	 static int read(){
	    Scanner sc = new Scanner(System.in);
	    int m = -1;
	    try{
	      m = sc.nextInt();
	      
	    }catch(Exception e){
	      
	    	
	    }
	    return m;  
	 }
	 
	 
	 
	 //������ʾ
	 static void chucuotishi(){
	  System.out.println("�����������������");
	 }
	 static boolean panduan(int sel){
		   switch (sel){
		     case 1: System.out.println("��Ϸ��ʼ");
		             break;
		     case 2: return true; 
		     default:chucuotishi();
		  
		   }
		   return false;
		                }
	 
	 
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		 boolean exit = false;
		  while(!exit){
		    zhucaidan(); 
		    int n =  read(); 
		    exit = panduan(n);  
		  }
	}//main

}//class
