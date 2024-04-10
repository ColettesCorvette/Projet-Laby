/**
 * Exception a utiliser pour gerer la classe Position
 * @author Gabriel Comte
 * @author Thomas Fuchs
 * @version 1.0
 */
class PositionException extends Exception{
/** 
 * constructeur vide basé sur le constructeur d’Exception
*/
	public PositionException () {
		super();
	}
/** constructeur basé sur le constructeur d’Exception
* @param message texte associé a l’exception
*/
	public PositionException (String message) {
		super(message);
	}
}