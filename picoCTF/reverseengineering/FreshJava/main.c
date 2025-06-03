#include <stdio.h>
#include <string.h>

int main(){
	char buffer[100] = "!} d0a1efb2_d3r1uq3r_gn1l007{FTCocip";
	for(int i = strlen(buffer)-1; i >= 0; i--){
		printf("%c", buffer[i]);
	}
	printf("\n");
}
