import java.util.Scanner;


public class xiayu_Sum
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("����һ������");
		Scanner sc=new Scanner(System.in);
		int num=0,sum=0;
		try
		{
			if(sc.hasNext())
			{
				num=sc.nextInt();
			}
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println("�������");
			return;
		}
		sum=Sum(num);
		System.out.println(sum);
	}
	static int Sum(int n)
	{
		if(n==1)
			return 1;
		else
			return n+Sum(n-1);
	}

}
