import java.io.*;

/**
 * Classe labyrinthe
 * @autor:  Gabriel Comte
 * @autor:  Thomas Fuchs
 * @version: 1.0
 */
class Labyrinthe{
    /**
     * Attributs de la classe Labyrinthe
     * tableau à deux dimensions de booleens representant les murs
     * Personnage de la classe Personnage
     * Sortie de la classe Sortie
     */
    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;
    /**
     * Constantes d'affichage du Labyrinthe 
     * 'X' represente un mur dans le labyrinthe sera représenter par la constante MUR
     * 'P' represente le personnage dans le labyrinthe sera représenter par la constante PJ
     * 'S' represente la sortie dans le labyrinthe sera représenter par la constante SORTIE
     * '.' represente un espace vide dans le labyrinthe sera représenter par la constante VIDE
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char SORTIE = 'S';
    public static final char VIDE = '.';
    /**
     * Constantes d'actions possibles pour le personnage
     * "haut" représenteé par la constante HAUT
     * "bas" représenteé par la constante BAS
     * "gauche" représenteé par la constante GAUCHE
     * "droite" représenteé par la constante DROITE
     */
    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String GAUCHE = "gauche";
    public static final String DROITE = "droite";


    /*
     * retournant un caractère décrivant le contenu de
     * la case (x,y)
     * @param x
     * @param y
     * @return 
     */
    char getChar(int x, int y) {
        return personnage.equals(x, y) ? PJ 
        : sortie.equals(x, y) ? SORTIE 
        : murs[x][y] ? MUR : VIDE;
    }
    /**
     * méthode getSuivant: retourne la case suivante 
     * @param x case de départ
     * @param y case de départ
     * @param action action à effectuer
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action)  throws ActionInconnueException{
        int res [] = {x,y};
        switch(action)
        {
            case HAUT:
                res[0]--;
                break;
            case BAS:
                res[0]++;
            case GAUCHE:
                res[1]--;
                break;
            case DROITE:
                res[1]++;
                break;
            default:
                throw new ActionInconnueException("Erreur: action inconnue : " + action);
        }
        return res;
    }
    /**
     * méthode deplacerPerso: déplace le personnage
     * @param action action à effectuer
     */
    void deplacerPerso(String action) throws ActionInconnueException, PositionException{
        int[] suivant = getSuivant(personnage.getX(), personnage.getY(), action);
        if(!murs[suivant[0]][suivant[1]])
        {
            personnage.setX(suivant[0]);
            personnage.setY(suivant[1]);
        }
    }
    /**
     * ToString: retourne une chaine de caractères représentant le labyrinthe
     */
    public String toString() 
    {
        String res ="";  
        for(int x = 0; x < murs.length; x++)
        {
            for(int y = 0; y < murs[x].length; y++)
            {
                res += getChar(x, y);
            }
            res += "\n";
        }    
        return res;
    }
    /**
     * estFini: retourne vrai si le personnage est à la sortie
     * @return vrai si le personnage est à la sortie
     */
    public boolean etreFini()
    {
        //return this.sortie.equals(this.personnage.getX(), this.personnage.getY());
        return this.personnage.equals(this.sortie);
    }
    /**
     * méthode chargerLabyrinthe: charge un labyrinthe à partir d'un fichier .txt
     */
    public static Labyrinthe chargerLabyrinthe(String nom)throws PositionException
    {

        //On a tenté d'écrire cette fichue méthode mais on a pas réussi.

    }

}
