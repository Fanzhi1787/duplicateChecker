import java.util.Scanner;


public class caimin_Sum
{
	int  sum(int n){
	
	int sum = 0;
	
	for(int i=0;i<=n;i++){
		
		sum = sum+i;
	}

return sum;
}

	
	public static void main(String[] args)
	{
	System.out.println("����һ��������");
        
		Scanner sc = new Scanner(System.in);
        
       int n = sc.nextInt();
      caimin_Sum cai=new caimin_Sum();
        int sum=cai.sum(n);
        
        System.out.println("�ۼӺ�Ϊ��"+sum);
	}

}
