import java.util.Scanner;


public class xiayu_Game
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		while(true)
		{
			showMenu();
			Scanner scn=new Scanner(System.in);
			int num=0;
			try
			{
				num=scn.nextInt();
			} catch (Exception e)
			{
				// TODO: handle exception
			}
			switch (num)
			{
			case 1:
			{
				System.out.println("��ʼ��Ϸ");
				break;
			}
			case 2:
			{
				System.exit(0);
				break;
			}
			default:System.out.println("�����������������");
			}
		}
	}
	static void showMenu()
	{
		System.out.println("1 ��ʼ��Ϸ   2 �˳�");
	}
}
