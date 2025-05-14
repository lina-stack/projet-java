import javax.swing.JOptionPane;

public class JoueurHumain {
    int trd ;
    int X;
    int Y ;
        public boolean coup_humain(jeu j) { 
           
        String[] options = { "Jouer", "Passer son tour" };
        int choice = JOptionPane.showOptionDialog(
            null,
            "Entrez les coordonnées sous la forme X,Y",
            "Tour du joueur " + trd,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]  // Définir "Jouer" comme option par défaut
            );
       if (choice==1) {
        j.passerCoup=true;
        j.passesConsecutives++;
        return false;
       }else{
        j.passerCoup=false;
        String X_Case = JOptionPane.showInputDialog("entrez la coordonne X de la case avec X<"+j.tab.length);
        X = Integer.valueOf(X_Case);
        String Y_Case = JOptionPane.showInputDialog("entrez la coordonne Y de la case Y<"+j.tab.length);
        Y = Integer.valueOf(Y_Case);     
             
            if (j.valid(X ,Y,trd)) {
                j.tab[X][Y]=trd;
                j.passesConsecutives = 0;
                return true ;
               }
               else{
                System.out.println("ce coup nest pas valide");
                return false;
            }
       }
      
    }
}
