
import java.util.*;
public class zhuxiaoming_Game
{
   static void xianshi(){
	System.out.println("1 ��ʼ��Ϸ");
	System.out.println("2 �˳�");
   }
	static int hq()
	{
		Scanner sc=new  Scanner(System.in);
		int i=-1;
		try
		{
			i=sc.nextInt();
		} catch (RuntimeException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return i;
	}
	static void xianerror()
	{
		System.out.println("�����������������");
	}
	static boolean bd(int s)
	{
		switch (s){
		case 1:System.out.println("��ʼ��Ϸ");break;
		case 2: return true;
		default:xianerror();
		}
  return false;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
    boolean e=false;
    while(!e)
    {
    	xianshi();
    	int s=hq();
    	e=bd(s);
    	
    }
	}

}
