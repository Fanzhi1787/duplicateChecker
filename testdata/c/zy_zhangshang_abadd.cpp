// zy_fanghong_abadd.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a = -1;
	int b = 20;

	printf("%s \n\r","����������a b:");
	scanf("%d %d",&a,&b);
    
  //add a b
	long res = a+b;

	printf("�����%d \n\r",res);


	return 0;
}

