import java.util.*; 
public class gujunliang_Game
{
	void  caishu(){
	    System.out.println("1 ��ʼ��Ϸ");
	    System.out.println("2 �˳���Ϸ");

	   }
	static int getlnput(){
		Scanner sc = new Scanner(System.in);
		int i = -1;
		try{
			i = sc.nextInt();
		}catch(Exception e){
		
		}
		return i;
		}
		static void dispError(){
			System.out.println("�����������������");
		}
	static boolean handle(int sel){
		switch (sel){
		case 1:System.out.println("��Ϸ��ʼ");
		       break;
		case 2:return true;
		default:dispError();
		
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		boolean exit = true;
		int sel = getlnput();
		exit=handle(sel);
	}
}

