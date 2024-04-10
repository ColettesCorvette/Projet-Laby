/**
 * Classe Personnage, hérite de Position, représente un personnage dans le jeu.
 * @autor:  Gabriel Comte
 * @autor:  Thomas Fuchs
 * @version: 1.0
 */
public class Personnage extends Position{
    /**
     * Constructeur de la classe Personnage
     * @param x: ordonnée de la position du personnage
     * @param y: abscisse de la position du personnage
     */
    public Personnage(int x, int y) throws PositionException
    {
        super(x, y);
    }
    /**
     * méthode qui permet de déplacer le personnage
     * @param x: ordonnée de la position du personnage
     * @param y: abscisse de la position du personnage
     */
    public void deplacer(int x, int y) throws PositionException
    {
        super.setX(x);
        super.setY(y);
    }
}