import java.util.*;
public class zhumaolei_Game
{
	static void playgame(){
	 System.out.println("1 ��ʼ��Ϸ");
	 System.out.println("2 �˳�");
	}
		 static int getInput(){ 
	    Scanner cs = new Scanner(System.in);
	    int n=-1;
	    try{
	      n = cs.nextInt();
	    }catch(Exception e){
	    }
	    return n;  
	 }
	 static void Error(){
	  System.out.println("�����������������");
	 }
	 static boolean handle(int sel){
	   switch (sel){
	     case 1: System.out.println("��Ϸ��ʼ");
	             break;
	     case 2: return true;
	     default:Error();
	   }
	   return false;
	 }
	public static void main(String[] args)
	{
		  boolean exit = false;
		  while(!exit){
		    playgame();
		    int sel =  getInput();
		    exit = handle(sel);
		 }
	}
}
