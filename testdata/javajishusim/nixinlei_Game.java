import java.util.Scanner;

public class nixinlei_Game
{
	
	static void displayMainMenu(){
	 System.out.println("1 ��ʼ��Ϸ");
	 System.out.println("2 �˳�");

	}
	 static int put(){
	    Scanner sc = new Scanner(System.in);
	    int p = -1;
	    try{
	      p = sc.nextInt();
	    }catch(Exception e){
	      
	    }
	    return p;  
	 }
	
	 static void cou(){
	  System.out.println("�����������������");
	 }
	 
	 static boolean fan(int pool){
	   switch (pool){
	     case 1: System.out.println("��Ϸ��ʼ");
	             break;
	     case 2: return true;  
	     default:cou();
	  
	   }
	   return false;
	 
	 }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		  boolean poo = false;
		  while(!poo){
		    displayMainMenu();  
		    int sel = put(); 
		    poo = fan(sel);  }
	}

}
