import java.util.Scanner;

public class DongYouWei_Sum{
	public static void main(String[] args)
	{
		System.out.println("������һ��������");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
		for(int i=0;i<=n;i++){
			sum = sum+i;}
        System.out.println("�ۼӺ�Ϊ��"+sum);
	}

}
