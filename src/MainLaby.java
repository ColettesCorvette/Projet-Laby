import java.util.Scanner;


public class MainLaby
{
    /**
     * Main
     * @param args
     */
    public static void main(String[] args)
    {

        if (args.length < 1) {
            System.out.println("Veuillez preciser le nom du fichier associe au labyrinthe.");
            return;
        }

        Labyrinthe laby;
        try {
            laby = Labyrinthe.chargerLabyrinthe(args[0]);
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement du labyrinthe : " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
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

        if (laby.etreFini()) {
            System.out.println("Bravo !");
        }

    }

}