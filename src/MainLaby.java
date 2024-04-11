/**
 * Classe MainLaby
 * permet de jouer au labyrinthe
 * @autor:  Gabriel Comte
 * @autor:  Thomas Fuchs
 * @version: 1.0
 */
import java.util.Scanner;
public class MainLaby
{
    /**
     * Main
     * @param args
     */
    public static void main(String[] args) 
    {
        //vérification de la présence d'un argument
        if (args.length < 1) {
            System.out.println("Veuillez preciser le nom du fichier associe au labyrinthe.");
            return;
        }
        Labyrinthe laby;
        //chargement du labyrinthe et gestion des exceptions
        try {
            laby = Labyrinthe.chargerLabyrinthe(args[0]);
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du labyrinthe : " + e.getMessage());
            return;
        }
        Scanner scanner = new Scanner(System.in);
        //boucle de jeu
        while (!laby.etreFini()) {
            System.out.println(laby.toString());
            System.out.println("Entrer une action (haut, bas, gauche, droite, exit) ");
            String action = scanner.nextLine();
            if ("exit".equals(action)) {
                System.out.println("Arret du jeu");
                break;
            }
            try {
                laby.deplacerPerso(action);
            } catch (ActionInconnueException e) {
                System.out.println("action inconnue : " + action);
            } catch (PositionException e) {
                System.out.println("Mouvement invalide : " + e.getMessage());
            }
        }
        scanner.close();
        if (laby.etreFini()) {
            System.out.println("Bravo !");
        }
    }
}