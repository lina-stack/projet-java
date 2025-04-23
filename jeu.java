import javax.swing.JOptionPane;
public class jeu {
    int trd;
    int X ;
    int Y;
    int[][]tab;
    public static void main(String[] args) {
       
        }
    

    
    public jeu (int ligne , int col ) {
        trd=1;
        tab = new int[ligne][col];
    }
    public  void depasse() {
       // if (X<0||Y<0||X>=tab.length||Y>=tab[0].length) {
             String X_Case = JOptionPane.showInputDialog("ce coup nest pas valide :entrez la coordonne X de la case x<"+X);
            X = Integer.valueOf(X_Case);
            String Y_Case = JOptionPane.showInputDialog("le coup precedent  nest pas valide: entrez al coordonne Y de la case y<"+Y);
            Y = Integer.valueOf(Y_Case);
            if (X>=0&&Y>=0&&X<tab.length&&Y<tab[0].length) {
                tab[Y][X]=trd;
        
    }
}
public  void  rempli () {
   String X_Case = JOptionPane.showInputDialog("entrez une autre case 'X' que"+X);
                X = Integer.valueOf(X_Case);
               String Y_Case = JOptionPane.showInputDialog("entrez une autre case 'Y' que"+Y);
                Y = Integer.valueOf(Y_Case);
            if (tab[X][Y]==0) {
                tab[Y][X]=trd;}
                
}
    public  void coups() { 
        String X_Case = JOptionPane.showInputDialog("entrez al coordonne X de la case");
        X = Integer.valueOf(X_Case);
        String Y_Case = JOptionPane.showInputDialog("entrez al coordonne Y de la case");
        Y = Integer.valueOf(Y_Case);
        if (X>=0&&Y>=0&&X<tab.length&&Y<tab[0].length) {
            if(tab[X][Y]==0){
            tab[Y][X]=trd;}}
    for(int i=0 ;i<tab.length; i++){
        for(int j=0 ;j<tab[i].length;j++){
            System.out.print(tab[i][j]);
            System.out.print(" ");
        }
        System.out.println("");
    }
    System.out.println("-------------------");
}
}


