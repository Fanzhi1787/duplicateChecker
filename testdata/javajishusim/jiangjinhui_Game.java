import java.util.Scanner;
public class jiangjinhui_Game
{
	static void displayMainMenu() {
    System.out.println("1 ��ʼ��Ϸ");
    System.out.println("2 �˳�");
	}
	static int getInput(){
	Scanner sc = new Scanner(System.in);
	int i = -1;
	try{
		 i = sc.nextInt();
	 }catch(Exception e){
		
	 }
	return i;  
    }
	static void disError(){
	 System.out.println("�����������������");
	 }
	 static boolean handle(int sel) {
    	 switch(sel) {
    	 case 1 :System.out.println("��Ϸ��ʼ"); break;
    	 case 2: System.out.println("��Ϸ�˳�");
    	         System.exit(-1);
    	         return true;  
    	 default:disError();
    	 }
    	 return false;
     }
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
        boolean exit = false;
        while(!exit) {
        	displayMainMenu();
        	int sel = getInput();
        	exit = handle(sel);
        }
	}

}
