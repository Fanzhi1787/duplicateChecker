import java.util.Scanner;
public class Mashuying_Sum
{
	/**
	 * Sum
	 * 
	 * 
	 */
 static int sum(int n){
	 
 int i;
 
 int Sum=0;
 
 for(i = 1;i <= n; i++){
	 
	Sum=Sum+i;
	}
 
return Sum;
  }
public static void main(String[] args)
	{
	System.out.println(" ����һ������: ");
	
	Scanner sc=new Scanner
		
	(System.in);
		
	int n=sc.nextInt();
		
	System.out.println(" �� ��"+sum(n));
			 
	 }//main

}//class


