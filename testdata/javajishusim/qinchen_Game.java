import java.util.Scanner;
public class qinchen_Game
{
       static int n=0;
       static void ini(){
    	   System.out.println("1.��ʼ��Ϸ");
           System.out.println("2.�˳�");
       Scanner  sc=new  Scanner( System.in);
       try{
    	   
    	   
    	   n=sc.nextInt();
       }catch  (Exception e){   
    	   
               }
       suiji(n);}
       static void suiji(int f){
    	   switch(f)
    { case 1:System.out.println("��ʼ��Ϸ");   	   
          ini();
          break;
    case 2 :Runtime.getRuntime().exit(0);
    break;
    default:System.out.println("�����������������");
      ini();	   
    }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
       ini();
	}

}
