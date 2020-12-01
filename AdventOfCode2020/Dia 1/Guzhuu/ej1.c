#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char const *argv[])
{
	FILE * file_input = fopen("input.txt", "r");
	int count = 1;
	char c;
	int buscado = 2020;
	int encontrado = -1;
	clock_t start, end;

	if(file_input == NULL){
		printf("Error abriendo archivo D:");
		return 0;
	}

	for(c = getc(file_input); c != EOF; c = getc(file_input)){
		if(c == '\n'){
			count++;
		}
	}

	rewind(file_input);

	int arr[count];
	int i = 0;
	while(fscanf(file_input, "%d", &arr[i]) != EOF){
		i++;
	}

	//Metodo restar a 2020
	encontrado = -1;
	start = clock();
	for(int i = 0; i < count; i++){
		int posible_existencia = buscado - arr[i];
		for(int j = i; j < count; j++){
			if(arr[j] == posible_existencia){
				encontrado = arr[j] * arr[i];
			}
		}
	}
	end = clock();
	printf("Se ha encontrado el valor en restar %d en %.*e\n", encontrado, ((double) (end - start)) / CLOCKS_PER_SEC);

	//Metodo subnormal
	encontrado = -1;
	start = clock();
	for(int i = 0; i < count; i++){
		for(int j = i; j < count; j++){
			if(arr[i] + arr[j] == buscado){
				encontrado = arr[i] * arr[j];
			}
		}
	}
	end = clock();
	printf("Se ha encontrado el valor en subnormal %d en %.*e\n", encontrado, ((double) (end - start)) / CLOCKS_PER_SEC);

	return 0;
}