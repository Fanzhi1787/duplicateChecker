import java.util.*;
public class bianlinliang_Game
{

	/**
	 * @param args
	 */
	static void menu(){
	System.out.println("1 ��ʼ��Ϸ");
	System.out.println("2 �˳�");
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String  select=null;
		while(true){
			menu();
			Scanner sc=new Scanner(System.in);
			select=sc.nextLine();
			if(select.equals("1")){
				System.out.println("��ʼ��Ϸ");
			}else if(select.equals("2")){
				System.exit(0);
			}else{
				System.out.println("�����������������");
			}
		}
	}
	 

}
