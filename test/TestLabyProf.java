import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe de test fournie destinee a verifier les methodes de la classe Labyrinthe
 */
public class TestLabyProf {
    /**
     * test de chargement + getChar + Constantes
     * (NE PAS MODIFIER)
      */
    @Test
    public void test_charger() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // verifie labyrinthe
        assertEquals(l.getChar(0,0),Labyrinthe.MUR);
        assertEquals(l.getChar(1,1),Labyrinthe.SORTIE);
        assertEquals(l.getChar(2,3),Labyrinthe.PJ);
        assertEquals(l.getChar(2,1),Labyrinthe.VIDE);
    }
    /**
     * test des methodes publiques
     * (NE PAS MODIFIER)
      */
    @Test
    public void test_methodes() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // getsuivant et constantes action
        int[] res;
        res = Labyrinthe.getSuivant(1,1,Labyrinthe.HAUT);
        res = Labyrinthe.getSuivant(1,1,Labyrinthe.BAS);
        res = Labyrinthe.getSuivant(1,1,Labyrinthe.DROITE);
        res = Labyrinthe.getSuivant(1,1,Labyrinthe.GAUCHE);
        // deplacerPerso
        l.deplacerPerso(Labyrinthe.HAUT);
        // etrefini
        boolean b = l.etreFini();
        // toString
        String s = l.toString();
    }
    /**
     * Test Numero 1 : test de la methode déplacerPerso haut
     */
    @Test
    public void test_deplacerPerso() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // deplacerPerso
        l.deplacerPerso(Labyrinthe.HAUT);
        assertEquals(l.getChar(2,3),Labyrinthe.VIDE);
        assertEquals(l.getChar(1,3),Labyrinthe.PJ);
    }
    /**
     * Test Numero 2 : test de la methode déplacerPerso bas
     */
    @Test
    public void test_deplacerPerso2() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // deplacerPerso
        l.deplacerPerso(Labyrinthe.BAS);
        assertEquals(l.getChar(2,3),Labyrinthe.VIDE);
        assertEquals(l.getChar(3,3),Labyrinthe.PJ);
    }
    /**
     * Test Numero 3 : test de la methode déplacerPerso droite
     */
    @Test
    public void test_deplacerPerso3() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // deplacerPerso
        l.deplacerPerso(Labyrinthe.DROITE);
        assertEquals(l.getChar(2,3),Labyrinthe.VIDE);
        assertEquals(l.getChar(2,5),Labyrinthe.PJ);
    }
    /**
     * Test Numero 4 : test de la methode déplacerPerso gauche
     */
    @Test
    public void test_deplacerPerso4() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // deplacerPerso
        l.deplacerPerso(Labyrinthe.GAUCHE);
        assertEquals(l.getChar(2,3),Labyrinthe.VIDE);
        assertEquals(l.getChar(2,1),Labyrinthe.PJ);
    }
    /**
     * Test Numero 5 : test de la methode déplacerPerso avec une action inconnue
     */
    @Test
    public void test_deplacerPerso5() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // deplacerPerso
        try{
            l.deplacerPerso("action inconnue");
        }catch(ActionInconnueException e){
            assertEquals(e.getMessage(),"Erreur: action inconnue : action inconnue");
        }
    }
    /**
     * test méthode etreFini
     */
    @Test
    public void test_etreFini() throws Exception{
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        // deplacerPerso
        l.deplacerPerso(Labyrinthe.HAUT);
        l.deplacerPerso(Labyrinthe.GAUCHE);
        assertEquals(l.etreFini(),true);
    }
    /**
     * test méthode chargerLabyrinthe avec un fichier inexistant
     */
    @Test
    public void test_chargerLabyrinthe() throws Exception{
        try{
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby1.txt");
        }catch(Exception e){
            assertEquals(e.getMessage(),"Erreur: fichier laby/laby1.txt introuvable");
        }
    }
    /**
     * test méthode chargerLabyrinthe laby_deuxSortie.txt
     */
    @Test
    public void test_chargerLabyrinthe2() throws Exception{
        // utilise laby_deuxSortie.txt fourni
        try{
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_deuxSortie.txt");
        }catch(Exception e){
            assertEquals(e.getMessage(),"il devrait y avoir seulement une sortie");
        }
    }   
    /**
     * test méthode chargerLabyrinthe laby_pasDeSortie.txt
     */
    @Test
    public void test_chargerLabyrinthe3() throws Exception{
        // utilise laby_pasSortie.txt fourni
        try{
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt");
        }catch(Exception e){
            assertEquals(e.getMessage(),"il devrait y avoir seulement une sortie");
        }
    }
}
