


import java.util.Scanner;


public class xuke_Sum

{
	static int sum(int n){
		
		int j;
		int Sum=0;
			
		 for(j=1;j<=n;j++)
		{
				Sum=Sum+j;
			}
			
			return Sum;
	}

	
	/**
	 * @param args
	 */
	
	
    public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		System.out.println("����һ������");
		
		    
		     Scanner sc=new Scanner
				(System.in);
		
		       int s=sc.nextInt();
		
		System.out.println("�ۼӺ�Ϊ��"+sum(s));

		//
		
		//
	}


}	

