import java.util.Scanner;


public class zhaodexiong_Game
{
	static void displayMainMenu(){
		System.out.println("1 ��Ϸ��ʼ");
		System.out.println("1 ��Ϸ����");
	}
	static int getInput(){
		Scanner sc=new Scanner(System.in);
		int j=-1;
		try{
			j=sc.nextInt();
		}catch(Exception e){}
	}
	
	
static void dispError(){
	System.out.println("���������������");
}
static boolean handle(int sel){
	switch(sel){
	case 1:System.out.println("��Ϸ��ʼ");
	break;
	case 2:return true;
	default:dispError();
	
	}return false;
	}

