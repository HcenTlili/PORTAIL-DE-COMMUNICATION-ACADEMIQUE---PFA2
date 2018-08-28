#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ville.h"
char rechercherville(ville *tab_ville,int nbrvilles,char nom[100])
{
printf("donner le nom de la ville a rechercher");
scanf("%s",nom);
    int i,j=-1 ;
    for (i=0;i<nbrvilles;i++)
    {
        if(strcmp(tab_ville[i].nomville,nom)==0){j=i;};
    }
    if(j!=-1){printf("la ville %s existe et son id est %d",nom,j);}


}


 void ajouter_ville(ville *tab_ville,int* nbrvilles)
{
    ville v;

printf("donner le nom de la ville\t");
scanf("%s",v.nomville);
fflush(stdin);

    strcpy(tab_ville[(*nbrvilles)].nomville,v.nomville);
    tab_ville[*nbrvilles].idville=(*nbrvilles);
    printf("%d",*nbrvilles);
    *nbrvilles=*nbrvilles+1;


}
void afficher_villes(ville tab_ville[100],int nbrvilles)
{
    int i ;
for (i=0 ;i<nbrvilles;i++)
    {
        printf("la ville  %s et son id est %d \n",tab_ville[i].nomville,tab_ville[i].idville);
}}
void modifierville (ville *V, int nbrvilles)
{    ville v ;
    char nom[100];
    int i=0 ;
    int j=0 ;
   int preexistance=0;
    printf("donner le nom de ville a modifier: ");
scanf("%s",nom);
while ( preexistance== 0  && i < nbrvilles )
    {
        if (strcmp (V[i].nomville,nom)== 0)
        {
            printf("\n donner le nouveau nom de cette ville :");
            scanf("%s",v.nomville);
            while ( (preexistance== 0)  && j< nbrvilles )
    {
        if (strcmp (V[j].nomville,v.nomville)== 0)

            {
            printf("Cette ville existe  !\n");
            preexistance = 1;}
        else j++;}
        if (preexistance==0)

            {
                strcpy(V[i].nomville, v.nomville);
            preexistance= 1;}

        }

        else i++;
        }


}

/*** gestion ville ***/
void gestion_des_villes(int* nbrvilles,ville tab_ville[100]){
char nom[100];
int b ;


system("cls");
printf("\t\t\t\t*****GESTION DES VILLES*****\n\n\n");
printf("\t\t\t\t 1:ajouter une ville\n");
printf("\t\t\t\t 2:modifier une ville\n");
printf("\t\t\t\t 3:rechercher une ville\n");
printf("\t\t\t\t 4:afficher les villes\n");
printf("\t\t\t\t 5:Retour au menu principal\n");

scanf("%d",&b);
switch(b)
{
 case 1:system("cls");ajouter_ville(tab_ville,nbrvilles);break;
    case 2:system("cls");modifierville(tab_ville,*nbrvilles);break;
    case 3:system("cls");rechercherville(tab_ville,*nbrvilles,nom);break;
    case 4:system("cls");afficher_villes(tab_ville,*nbrvilles);break;
    case 5:system("cls"); break;
    default: printf("faux numero");system("cls");gestion_des_villes(nbrvilles,tab_ville);
}
}

