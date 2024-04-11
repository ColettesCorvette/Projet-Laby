/**
 * Classe Position qui représente un couple (x,y) de coordonnées.
 * @autor:  Gabriel Comte
 * @autor:  Thomas Fuchs
 * @version: 1.0
 */
public class Position {
    /*
     * Attributs qui représentent un couple (x,y) de coordonnées.
     * x : ordonnée
     * y : abscisse
     */
    private int x;
    private int y;
    /**
     * Constructeur de la classe Position.
     * @param x : ordonnée
     * @param y : abscisse
     */
     public Position(int x,int y) throws PositionException{  
        try{
            valide(x,y);
            this.x = x;
            this.y = y;
        }catch(PositionException e){
            throw e;
        }
     }
     /**
      * méthode valide qui vérifie si la position est valide.
      * @param x : ordonnée
      * @param y : abscisse
      */
    public static void valide(int x, int y) throws PositionException{
        if(y < 0){
            throw new PositionException("Position y invalide : " + y);
        }
        if(x < 0){
            throw new PositionException("Position x invalide : " + x);
        }
        if(x < 0 || y < 0){
            throw new PositionException("Position x et y invalide : " + x + " " + y);
        }
    }
    /**
     * méthode equals qui vérifie si deux positions sont égales.
     * @param x
     * @param y
     * @return true si les positions sont égales, false sinon
     */
    public boolean equals(int x, int y){
        return this.x == x && this.y == y;
    }
    /**
     * setter de l'attribut x.
     * setX : ordonnée
     */
    public void setX(int x) throws PositionException{
        try{
            valide(x,this.y);
            this.x = x;
        }catch(PositionException e){
            throw e;
        }
    }
    /**
     * setter de l'attribut y.
     * setY : abscisse
     */
    public void setY(int y) throws PositionException{
        try{
            valide(this.x,y);
            this.y = y;
        }catch(PositionException e){
            throw e;
        }
    }
    /**
     * getter de l'attribut x.
     * getX : ordonnée
     */
    public int getX(){
        return this.x;
    }
    /**
     * getter de l'attribut y.
     * getY : abscisse
     */
    public int getY(){
        return this.y;
    }
}