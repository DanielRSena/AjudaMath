#include <stdio.h>
#include <string.h>
#include <malloc.h>

char repeteProcesso(){
	char vezes;
	do {
		printf("\n\n\tQuer fazer novamente? (s/n): "); 
		scanf(" %c", &vezes); 
	} while (vezes != 's' && vezes != 'n');

	return vezes;
}

float arredonda(float num){
	float numAux;
	numAux = num * 100;
	numAux = (int)numAux;
	numAux = numAux / 100;
	return numAux;
}

int pedeInt(char msg[], int min){
	int num;
	do {
		printf("%s", msg);
		scanf("%d", &num);
	} while (num < min);
	return num;
}

int pedeInt(char msg[]){
	int num;
	printf("%s", msg);
	scanf("%d", &num);
	return num;
}

float pedeFloat(char msg[]){
	float num;
	printf("%s", msg);
	scanf("%f", &num);
	return num;
}

float pedeFloat(char msg[], float min){
	float num;
	do {
		printf("%s", msg);
		scanf("%f", &num);
	} while (num < min);
	return num;
}
