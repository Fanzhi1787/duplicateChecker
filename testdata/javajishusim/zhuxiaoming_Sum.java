/**
	 * @param args
	 */
import java.util.*;
public class zhuxiaoming_Sum
{
	int sum(int n)
	{
	int sum=0;
	int i=0;
	for(i=1;i<=n;i++)
	
		sum+=i;
	
	return sum;
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("����һ������");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		zhuxiaoming_Sum zxm=new zhuxiaoming_Sum();
		int sum=zxm.sum(n);
		System.out.println("��͵Ľ����:"+sum);
		

	}

}
