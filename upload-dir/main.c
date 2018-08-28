#include <stdio.h>
#include <stdlib.h>
#include "ville.h"
#include "route.h"
int main(){
    int choixMP;
    int nbrvilles=0;
    int nbrroutes=0;
    ville tab_ville[100];
    route tab_route[100];

ville *tvoy;
int nvoy;

printf("\t\t\t\t\t****** GESTION DITINIRAIRE******\n");
do{
    printf("\t\t\t\t**** 1 : gerer les villes**** \n");
    printf("\t\t\t\t**** 2 : gerer les routes **** \n");
    printf("\t\t\t\t**** 3 : calculer itineraire**** \n");
    printf("\t\t\t\t**** 4 : sortir de l'application**** \n");
    scanf ("%d",&choixMP);
    switch (choixMP)
    {
        case 1:system("cls");
        gestion_des_villes(&nbrvilles,tab_ville);break;
        case 2:system("cls");


        gestion_des_routes(&nbrroutes,tab_route,tab_ville,nbrvilles);break;
        case 3:system("cls");calculs_itineraires(tab_ville,nbrvilles,tab_route,nbrroutes);break;
        case 4:break;

        default : system("cls");
                printf("faux numero");

    }
}while(choixMP!=4);


return 0;
}








