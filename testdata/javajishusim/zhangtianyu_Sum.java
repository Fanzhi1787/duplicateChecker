	import java.util.Scanner;
		public class zhangtianyu_Sum
{
			int sum(int y){
			
		int sum = 0;
			for(int u=0;u<=y;u++){
		sum = sum+u;
}
					return sum;
}
		public static void main(String[] args)
{
			System.out.println("�������ۼӵ�m��");
			Scanner sc = new Scanner(System.in);
			int m = sc.nextInt();
			zhangtianyu_Sum ss=  new zhangtianyu_Sum();
			int sum= ss.sum(m);
			System.out.println("�ۼӽ���ǣ�"+sum);
}
}

