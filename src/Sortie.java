/**
 * Classe Sortie, hérite de Position, représente la sortie du labyrinthe.
 * @autor:  Gabriel Comte
 * @autor:  Thomas Fuchs
 * @version: 1.0
 */
public class Sortie extends Position{
    /**
     * Constructeur de la classe Sortie
     * @param x: ordonnée de la sortie
     * @param y: abscisse de la sortie
     */
    public Sortie(int x, int y) throws PositionException
    {
        super(x, y);
    }
}