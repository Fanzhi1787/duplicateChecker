import java.util.*;

public class tanglei_Game{

static void displayMainMenu(){
 System.out.println("1 ��ʼ��Ϸ");
 System.out.println("2 �˳�");
}
static int getInput(){
    Scanner c = new Scanner(System.in);
    int i = -1;
    try{
      i = c.nextInt();
    }catch(Exception e){
      
    }
    return i;  
 }
 static void SubGuessNumber(){
 
 }

 static void dispError(){
  System.out.println("�����������������");
 }
 

 static boolean handle(int sel){
   switch (sel){
     case 1: SubGuessNumber();
     System.out.println("��ʼ����");
     case 2: return true;  
     default:dispError();
  
   }
   return false;
 
 }
 

public static void main(String[] args){
  boolean exit = false;
  while(!exit){
    displayMainMenu();  
    int sel =  getInput(); 
    exit = handle(sel); 
  }

}
  

}