#include <stdio.h>

int main (void) {
	char pass[] = "jU5t_a_sna_3lpm12g94c_u_4_m7ra41";
	
	char password[50];

	for(int i = 0; i < 8; i++){
		password[i] = pass[i];
	}
	for(int i = 9; i < 16; i++){
		password[23-i] = pass[i];
	}
	for(int i = 17; i < 32; i+= 2){
		password[16-i] = pass[i];
	}/*
	for (int i = 31; i>= 17; i -= 2){
		password[i] = pass[i];
	}*/

	printf("%s\n", password);

	return 0;
}
