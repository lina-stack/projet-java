import java.util.ArrayList;
import java.util.Random;

public class joueur_IA {
    int X;
    int Y;
    int trd;
        public void coup_IA(jeu j) {

        if (j.Partie(2)) {
            ArrayList<int[]> coupsPossibles = new ArrayList<>();

            // Étape 1 : trouver toutes les cases valides pour le joueur 2
            for (int x = 0; x < j.tab.length; x++) {
                for (int y = 0; y < j.tab.length; y++) {
                    if (j.valid(x, y, 2)) {
                        coupsPossibles.add(new int[]{x, y});
                    }
                }
            }
        System.out.println("Coups possibles pour l'IA :");
for (int x = 0; x < j.tab.length; x++) {
    for (int y = 0; y < j.tab.length; y++) {
        if (j.valid(x, y, 2)) {
            coupsPossibles.add(new int[]{x, y});
            System.out.println("x = " + y + ", y = " + x);
        }
    }
}
            // Étape 2 : vérifier s'il y a des coups possibles
            if (j.Partie(2)) {
                Random rand = new Random();
                int[] coup = coupsPossibles.get(rand.nextInt(coupsPossibles.size()));
                int x = coup[0];
                int y = coup[1];
                System.out.println(x);
                System.out.println(y);
                X = coup[0];
                Y = coup[1];
                // Étape 3 : jouer le coup
                j.tab[x][y] = 2;
                
           
    }

}}}

      
    
