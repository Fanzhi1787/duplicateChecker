import java.util.Scanner;
public class nixinlei_Sum
{int a(int n){
	
	int sum = 0;
	for(int i=0;i<=n;i++){
		sum = sum+i;
	}
	return sum;
}

public static void main(String[] args)
{
	
     System.out.println("������һ������n��");
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     nixinlei_Sum s= new nixinlei_Sum();
     int sum = s.a(n);
     System.out.println("������Ϊ��"+sum);
     
}

}
