import java.util.Scanner;
public class sunliyan_Sum
{

	int sum(int n){
		int i=0;
		int s=0;
		for (i=0;i<=n;i++){
			s+=i;
		}
		return s;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		System.out.println("����һ������:");
		Scanner sss = new Scanner(System.in);
		int n =sss.nextInt();
		sunliyan_Sum ss = new sunliyan_Sum();
		int sum = ss.sum(n);
		System.out.println("�ۼӽ���ǣ�"+sum);
	}

}
