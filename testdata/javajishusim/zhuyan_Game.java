import java.util.Scanner;
public class zhuyan_Game
{
	public static void main(String[] args)
	{
			System.out.println("1 ��ʼ��Ϸ   2 �˳�");
			Scanner sc=new Scanner(System.in);
			int n=0;
			try
			{
				n=sc.nextInt();
			} catch (Exception e)
			{
				
			}
			switch (n)
			{
			case 1:System.out.println("��ʼ��Ϸ");
			       break;
			case 2:System.exit(0);
			       break;
			default:System.out.println("�������,����������");
			}
			String[] args1 =null;
			main(args1);
	}
}
