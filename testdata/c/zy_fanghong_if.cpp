#include  <stdio.h>

int main(){
  //�ж�һ�������桢ż��
  int value = 8;
  if((value % 2) == 0){
     printf("value is oushu \n");
  }else{
     printf("value is jishu \n");
  }
  // �ж�һ����������0����
  value = 10 ;
  if(value == 0){  
     printf("value is 0\n"); 
  }else if(value < 0){
     printf("value is fushu\n");
  }else {
     printf("value is zhengshu \n");
  }
  //����һ�����ľ���ֵ
  float abs = -2.8;
  if(abs<0){
     abs = -abs;    
  }
  printf("abs is %f \n",abs);
 
  value = 0;
  if(value = 2){  //��ʧ=����
    printf("value is %d\n",value);
  }
  //������������ķ���
  if(2==value){

  }



  printf("hello world\n");

  return 0;
}