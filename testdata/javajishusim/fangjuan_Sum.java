import java.util.Scanner;
public class fangjuan_Sum
{
   int sum(int n){
		int res = 0;
		int sum = 0;
		for(int i=0;i<=n;i++){
			sum = sum+i;
		}
		res = sum;
		return res;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
         System.out.println("����һ��������");
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         
       fangjuan_Sum fj = new fangjuan_Sum();
         int sum = fj.sum(n);
         System.out.println("���Ϊ��"+sum);
          	
	}
}

