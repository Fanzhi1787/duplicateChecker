import java.util.Scanner;
public class dingxiaomin_Sum
{
	int v(int n){
	int sum=0;
	for(int i=0;i<=n;i++){
		sum=sum+i;
	}
	
	return sum;
	
	
		
	}	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("������һ������n��");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dingxiaomin_Sum dxm=new dingxiaomin_Sum();
        int Sum=dxm.v(n);
        System.out.println("�ۼӺͣ�"+Sum);

	}

}
