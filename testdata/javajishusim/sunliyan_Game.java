import java.util.Scanner;
public class sunliyan_Game
{
	static void display(){
	System.out.println("1 ��ʼ��Ϸ   2 �˳�");
	}
	static int getInput(){
		Scanner ss = new Scanner(System.in);
		int s = -1;	
		s = ss.nextInt();	
		return s;	
	}	
	static boolean handle(int sel){
		switch(sel){
		case 1:System.out.print("��Ϸ��ʼ");break;
		case 2:return true;	
		
		}
		return false;
	}	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		boolean exit =false;
		while(!exit){
			display();
			int sel = getInput();
			exit = handle(sel);
		}
	}
}
