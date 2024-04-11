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
        while(!murs[suivant[0]][suivant[1]] && !sortie.equals(suivant[0], suivant[1]))
        {
            personnage.setX(suivant[0]);
            personnage.setY(suivant[1]);
            suivant = getSuivant(personnage.getX(), personnage.getY(), action);
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
        return this.sortie.equals(this.personnage.getX(), this.personnage.getY());
    }
    /**
     * méthode chargerLabyrinthe: charge un labyrinthe à partir d'un fichier .txt
     */
    public static Labyrinthe chargerLabyrinthe(String nom)throws IOException, FichierIncorrectException, PositionException
    {


        BufferedReader br = new BufferedReader(new FileReader(nom));
        int lignes, colonnes;
        try {
            lignes = Integer.parseInt(br.readLine());
            colonnes = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            throw new FichierIncorrectException("le nombre de lignes ou de colonnes n'est pas de type entier");
        }

        Labyrinthe labyrinthe = new Labyrinthe();
        labyrinthe.murs = new boolean[lignes][colonnes];

        //Compteurs de personnage et sortie
        int personnage = 0;
        int sortie = 0;

        for (int i = 0; i < lignes; i++) {
            String line = br.readLine();
            if (line.length() != colonnes) {
                throw new FichierIncorrectException("le nombre de colonnes ne correspond pas");
            }
            for (int j = 0; j < colonnes; j++) {
                char c = line.charAt(j);
                switch (c) {
                    case MUR:
                        labyrinthe.murs[i][j] = true;
                        break;
                    case VIDE:
                        labyrinthe.murs[i][j] = false;
                        break;
                    case PJ:
                        labyrinthe.murs[i][j] = false;
                        labyrinthe.personnage = new Personnage(i, j);
                        personnage++;
                        break;
                    case SORTIE:
                        labyrinthe.murs[i][j] = false;
                        labyrinthe.sortie = new Sortie(i, j);
                        sortie++;
                        break;
                    default:
                        throw new FichierIncorrectException("caractere inconnu : " + c);
                }
            }
        }

        if (personnage!= 1) {
            throw new FichierIncorrectException("il devrait y a avoir au plus un personnage");
        }
        if (sortie!= 1) {
            throw new FichierIncorrectException("il devrait y a avoir au plus une sortie");
        }

        return labyrinthe;

    }

}
