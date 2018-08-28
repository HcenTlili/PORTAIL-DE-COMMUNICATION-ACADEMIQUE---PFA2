#ifndef VILLE_H_INCLUDED
#define VILLE_H_INCLUDED
#include <string.h>
typedef struct ville {
int idville ;
char nomville[100];
}ville ;
char rechercherville(ville *V,int nbrvilles,char nom[100]);
char* Saisie_ville(char nom[100]);
 void ajouter_ville(ville *tab_ville,int *nbrvilles);
void afficher_villes(ville *tab_ville,int nbrvilles);
void modifierville (ville *V, int nbrvilles);
/**************/
void gestion_des_villes(int* nbrvilles,ville tab_ville[100]);
#endif // VILLE_H_INCLUDED
