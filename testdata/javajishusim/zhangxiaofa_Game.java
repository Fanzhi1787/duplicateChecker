   import java.util.Scanner;
   public class zhangxiaofa_Game
{
	
	static void game()
	
	{
	        System.out.println("1 ��ʼ��Ϸ");
	 
	        System.out.println("2 �˳�");

	} 
static int shurupanduan()
         {
	    
	    Scanner sc = new Scanner(System.in);
	      int i = -1;
	    try
	       {
	        i = sc.nextInt();
	       }
	    catch(Exception e)
	    { 
	    	System.out.println("����");
	    }
	    return i;  
	 }

static void Error()
{
	    System.out.println("�����������������");
}
static boolean youxiqiehuan(int _se){
	   switch (_se)
	  {
	    case 1: System.out.println("��Ϸ��ʼ");break;case 2: return true;  
	    
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
		   boolean _ex = false;
		        while(!_ex){
		      game();  
		       int sel =  shurupanduan(); 
		     _ex = youxiqiehuan(sel);  
		         }
	}

}


