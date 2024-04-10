/**
 * Exception a utiliser pour gerer la classe Labyrinthe
 * @author Gabriel Comte
 * @author Thomas Fuchs
 * @version 1.0
 */
class ActionInconnueException extends Exception{
/** 
 * constructeur vide basé sur le constructeur d’Exception
*/
	public ActionInconnueException () {
		super();
	}
/** constructeur basé sur le constructeur d’Exception
* @param message texte associé a l’exception
*/
	public ActionInconnueException (String message) {
		super(message);
	}
}