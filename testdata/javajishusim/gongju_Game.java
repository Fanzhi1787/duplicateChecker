import java.util.Scanner;
public class gongju_Game
{
    static void diaplayMainMenu(){
    	System.out.println("1 ��ʼ��Ϸ");
    	System.out.println("2 �˳�");
    }
    static int getInput(){
    	Scanner sc=new Scanner(System.in);
    	int a=-1;
    	try{
    		a=sc.nextInt();
    	}catch(Exception e){
    	}
    	return 1;
    }
       static void dispError(){
    	   System.out.println("�����������������");
       }
       static boolean handle(int sel){
    	   switch(sel){
    	   case 1:System.out.println("��Ϸ��ʼ");
    	          break;
    	   case 2:return true;
    	   default:dispError();
    	}
    	   return false;
       }
       
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
       boolean exit=false;
         while(!exit){
        	 diaplayMainMenu();
        	 int sel= getInput();
        	 exit=handle(sel);
        	 
         } 	 
        	 
	}

}
