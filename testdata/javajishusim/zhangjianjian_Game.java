import java.util.Scanner;
public class zhangjianjian_Game
{
    static void dpMM(){
    	System.out.println("1 ��ʼ��Ϸ*");
    	System.out.println("2 �˳���Ϸ*");}
    static int Input(){
    	Scanner sc=new Scanner(System.in);
    	int i=-1;
    	try{i=sc.nextInt();}
    	catch(Exception e){}
    	return i;}
      static void xw(){
    	  System.out.println("����������������������һ����");}    
public static void main(String[] args)
	{ boolean exit=false;
      while(!exit){dpMM();int sel=Input();}
     }

}
