import java.util.Scanner;
public class hujin_Sum
{
     float sum(int n){
		float res = 0;
		int sum = 0;
		for(int i=0;i<=n;i++){
			sum=sum+i;
		}
		res = sum;
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub5
		 System.out.println("����һ��������");
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         
     hujin_Sum fa = new hujin_Sum();
         float sum = fa.sum(n);
         System.out.println("�����ͣ�"+sum);
         
	}

}
