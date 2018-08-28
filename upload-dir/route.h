#ifndef ROUTE_H_INCLUDED
#define ROUTE_H_INCLUDED
#include "ville.h"
#include "route.h"
typedef struct route{
int distance ;
int idvilledepart;
int idvillearrivee ;
int id;
}route ;
int id_ville(ville *v,int nbrvilles, char *nom_ville);
int chercherroute(route *r,int nbrroutes,route rout);
route saisirroute(ville *v,int nbrroutes,int nb_villes);
void ajouterroute(route* tab_rout,int *nbrroutes,route r);
void modifierroute(route *tab_route,int *nbrroutes);
void supprimerroute(route tab_route[10],int *nbrroutes,route r);
void afficheroutes(int nbrroutes,ville *tab_villes,int nbrvilles,route *tab_route);
int minimum(int tab[100], int a);
int existance(int a,int tab[100],int b);
void leplusprochevoisin(ville tp[100],int nvp,int nbrvilles,ville *tab_ville,int nbrroutes,route *tab_route);
void inversion(ville *tab_villes,int nbr_villes,route *tab_route,int nbrroutes);
int fact(int a);
void saisir_tab_parcours(ville *tab_ville,int nbrvilles);
void permutations(ville *tab_ville,int nbrvilles,route *tab_route,int nbrroutes);
void permutaionspossibles(route tab_route[100],ville *tab_ville,int *nbrroutes,int nbrvilles);
void gestion_des_routes(int *nbrroutes,route *tab_routeroute,ville *tab_villes,int nbrvilles);
void parcours(ville *tab_parcours,int n,ville *tab_villes,route *tab_routes,int nbrvilles,int nbrroutes);
void saisieduparcours(ville *tvoy,int nvoy,ville *tab_ville,int nbrvilles);
void voyageurs_de_commerce(ville *tvoy,int nvoy,ville *tv,int nv,route *tr,int nr);
void calculs_itineraires (ville *tab_ville,int nbrvilles,route *tab_route,int nbrroutes);
#endif // ROUTE_H_INCLUDED
