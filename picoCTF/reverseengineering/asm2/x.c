#include <stdio.h>

int asm2 (int parameter1, int parameter2);

int main(void){
	printf("%x\n", asm2(0x4, 0x2d));

	return 0;
}

int asm2 (int parameter1, int parameter2){
	int locvar1, locvar2;

	locvar1 = parameter2;
	locvar2 = parameter1;

	while(locvar2 <= 0x5fa1){
		locvar1 += 0x1;
		locvar2 += 0xd1;
	}

	return locvar1;
}
