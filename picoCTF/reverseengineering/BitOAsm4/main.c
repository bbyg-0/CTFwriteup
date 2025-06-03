#include <stdio.h>

int main(){
	int x = 0x9fe1a;

	if(x <= 0x2710)
		x += 0x65;
	else
		x -= 0x65;

	printf("%d\n", x);

	return 0;
}
