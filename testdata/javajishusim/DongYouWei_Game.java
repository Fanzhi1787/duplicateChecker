import java.util.*;
public class DongYouWei_Game
{
     static void displayMainMenu(){
	 System.out.println("1.��ʼ��Ϸ");
	 System.out.println("2.�˳�");

	}  
	 static int inpout(){
	   Scanner sc = new Scanner(System.in);
	   int i = -1;
	   try{
	     i = sc.nextInt();
	   }catch(Exception e){
	   System.out.println("��������ȷ�����ַ��ַ�!");   
	   }
	    return i;  
	 } 
	 static boolean handle(int chouse){
	   switch (chouse){
	     case 1: System.out.println("��Ϸ��ʼ");break;
	     case 2: return true;
	     }
	   return false;
	 
	 }
	public static void main(String[] args)
	{
		  boolean out = false;
		  while(!out){
		  displayMainMenu();  
		  int chouse =inpout(); 
		  out= handle(chouse); 
		  }
	}

}