   import java.util.Scanner;
   public class zhangxiaofa_Sum
    {
 float sum(int i){
		
	int sum = 0;
		for(int j=0;j<=i;j++)
          {
			sum = sum+j;
     }
		return sum;
        }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
      System.out.println("������һ��������");
         Scanner sc = new Scanner(System.in);
           int i = sc.nextInt();
       zhangxiaofa_Sum su = new zhangxiaofa_Sum();
        float sum= su.sum(i);
       System.out.println("��������ۼӵĺ�Ϊ��"+sum);   
	}
}

