import java.util.Scanner;
public class puwenjie_Sum
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int i,sum=0;
		Scanner sc=new Scanner(System.in);//�Ӽ��̻�ȡһ������
		System.out.println("����һ������:");
		int n=sc.nextInt();
		for(i=1;i<=n;i++)
		{
			sum=sum+i;
			}
		System.out.println("1��n��������Ϊ:");
		System.out.println(sum);
	}//main

}//class
