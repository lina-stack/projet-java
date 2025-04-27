import java.util.Arrays;

import javax.swing.JOptionPane;
public class jeu {
    int trd;
    int X ;
    int Y;
    int[][]tab;
    public static void main(String[] args) {
        jeu j = new jeu(10,10);
        for(int i=0 ; i<10; i++){
           j.coups();
           j.affiche_tab();
           j.trd=3-j.trd;
           }
    
        }
    public jeu (int ligne , int col ) {
        trd=1;
        tab = new int[ligne][col];
 
    }
    

public  boolean  valid () {
   
    boolean c1=true ;
    boolean c2=true ;
    boolean c3=true ;
    if (X<0||Y<0||X>=tab.length||Y>=tab[0].length) {
        c1=false;
        }else{
            int [][] grp= group(X, Y, 0);
            if(tab[X][Y]!=0){
                c2=false ;
        
            }
            if(count_grp(grp)<10){
                c3=false ;
            }
        }
    
     return c1&&c2&&c3 ;
    }
public int count_grp(int [][]tab) {
    int somme =0 ;
    for(int i=0 ; i<tab.length ; i++){
        for(int j=0 ; j<tab[0].length ; j++){
        if (tab[i][j]==1){
            somme++;
        }
        }
    }
    return somme ;
}             

public int [][] group (int x ,int y, int  a) {
    int ctr=0;
   int [][]tab= new int[this.tab.length][this.tab[0].length];
   tab[x][y]=1;
   int trd =1;
    boolean group =true;
    while(group){
        group = false ;
    for(int i=0 ; i<tab.length ;i++){
        for(int j=0 ; j<tab.length ;j++){
            if(tab[i][j]==1){
            if(i+1<tab.length){
            if ((this.tab[i+1][j]==trd||this.tab[i+1][j]==a) &&(tab[i+1][j]==0)) {
                tab[i+1][j]=trd;
                group = true ;
            } }
            if (i-1>=0) {
            if ((this.tab[i-1][j]==trd||this.tab[i-1][j]==a)&&(tab[i-1][j]==0)) {
                tab[i-1][j]=trd;
                group=true ;
            }}
            if (j+1<tab.length) {
            if ((this.tab[i][j+1]==trd||this.tab[i][j+1]==a)&&(tab[i][j+1]==0)) {
                tab[i][j+1]=trd;
                group=true ;
            }}
            if (j-1>=0) {
            if ((this.tab[i][j-1]==trd||this.tab[i][j-1]==a)&&(tab[i][j-1]==0)) {
                tab[i][j-1]=trd;
                group=true ;
            }}
        }
           
        }
    }
}
return tab ;
}
    public boolean coups() { 
        String X_Case = JOptionPane.showInputDialog("entrez la coordonne X de la case avec X<"+tab.length);
        X = Integer.valueOf(X_Case);
        String Y_Case = JOptionPane.showInputDialog("entrez la coordonne Y de la case Y<"+tab.length);
        Y = Integer.valueOf(Y_Case);
        if (valid()) {
            tab[X][Y]=trd;
            return true ;
           }
           else{
            System.out.println("ce coup nest pas valide");
            return false;
        }
    }

public  void affiche_tab() {
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


