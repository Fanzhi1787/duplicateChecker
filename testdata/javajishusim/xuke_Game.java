

import java.util.Scanner;


public class xuke_Game
{

	static void display()
	{
		 
		System.out.println("1 ��ʼ��Ϸ");
		 System.out.println("2 �˳�");

		}
		
		 
		 static int Input(){
		    
		    Scanner sc = new Scanner(System.in);
		    
		    int j = -1;
		    try{
		      j = sc.nextInt();
		    }
		    catch(Exception e){
		      
		    }
		    return j;  
		 }
	
		 static void Error(){
		    
			 System.out.println("�����������������");
		 
		 }
		 
		 static boolean handle(int n){
		   
		switch (n)
		{
		   case 1: System.out.println("��Ϸ��ʼ");
		             break;
		   case 2: System.out.println("��Ϸ�˳�");
		    	     return true;  //
		   default:Error();
		  
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
			  
			while(!exit)
		{
			  display();  //
			    
			  int n =  Input(); //
			    
			  exit = handle(n);  //
			  //
		 }
	}//

 }//
