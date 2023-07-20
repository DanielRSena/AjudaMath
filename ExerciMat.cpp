#include<stdio.h>
#include<math.h>
#include<time.h>
int main()

{
    int menu = 0;
    while (menu == 0)
    {
          int opcao, vezes, v1, v2, r1, r2, pontos, vezes = 0;
          printf("\n---------------\n\n\t\tExerciMat -\n");
          printf("\n\tQual serah o tema do exercicio solicitado?\n\n\t\t1. Funcao de 1 grau;\n\t\t2. Funcao de 2 grau;\n\t\tTabuada."); 
          scanf("%d", &opcao);
          if (opcao == 1)
          {
                    if (vezes ==0)
                    {
                              printf("\n---------------\n\n\t\tFuncao de 1 grau -\n");
                  		      srand(time(NULL));
 		                      v1 = rand() % 11;
                              v2 = rand() % 11;
 		                      r1 = n1 * n2;
 		                      printf("\n\n\t\t%d\tx\t%d\t=\t ", n1, n2); scanf("%d", &r2);
 		                      if (r1 == r2) 
                              {
                                 pontos = pontos + 1;
 			                     printf("\n	Parabens! Vc colocou a resposta certa, e agora tem %d pontos!", pontos);
                                 }
		else {
			printf("\n\tNa realidade, a resposta certa eh %d:\n ", r1);
			for (cont = 0; cont < 11; cont = cont + 1) printf("\n\t\t%d x %d = %d", n1, cont, n1 * cont);	
	   	     }
                              printf
                              
          
          
          
    }
}
