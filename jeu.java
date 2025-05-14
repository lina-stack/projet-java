import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;
public class jeu {
    boolean passerCoup=false;
    int passesConsecutives ;
    int[][]tab;
    public static void main(String[] args) {
//         jeu j = new jeu(5,5);
       

//         JoueurHumain j1=new JoueurHumain();
//         joueur_IA j2 = new joueur_IA ();
        
//          while ((j.Partie(1)||j.Partie(2))&&j.passesConsecutives<2) { 
//            j1.trd=1;
//           j2.trd=2;
//              j1.coup_humain(j);
//               j2.coup_IA(j);
//                System.out.println(j2.X);
//            System.out.println(j2.Y);
//             j.affiche_tab(j.tab);
//             System.out.println(j1.trd);

//          }
//         System.out.println("fin de parti");
//          System.out.println("le joueur 1 a :"+j.decompte_points(1,j.tab.length,j.tab.length)+"points");
//          System.out.println("le joueur 2 a :"+j.decompte_points(2,j.tab.length,j.tab.length)+"points");
       
      
// }  


    }


public boolean Partie(int trd) {
    boolean non_fin1 = false ;
        for(int i=0 ; i<tab.length ; i++){
            for(int j=0 ; j<tab.length ; j++){
                if (tab[i][j]==0){
                    if (valid(i,j,trd)){
                        non_fin1=true ;
                    }
                }
            }
        }
       
        return non_fin1 ;
    }
    public jeu (int ligne , int col ) {
        tab = new int[ligne][col];}

public void marquerCasesVues (int[][]tab , boolean [][] tabv) {
    for(int i=0 ; i<tab.length ; i++){
        for(int j=0 ; j<tab[0].length ; j++){
       if (tab[i][j]==1) {  
        tabv[i][j]=true ;  }}} }

public int decompte_points (int trd , int col , int ligne) {
    int somme =0 ;
    boolean [][]tabv = new boolean[col][ligne];
    for(int i=0 ; i<tab.length ; i++){
        for(int j=0 ; j<tab[0].length ; j++){
            if((tab[i][j]==trd)){
                if(!tabv[i][j]){
           int[][]grp = new int[10][10];
           group(i, j, trd,grp,trd );
            marquerCasesVues(grp , tabv);
            if(count_grp(grp)>=10){
            somme=somme+count_grp(grp); }}}
      }}
    return somme ;}

public  boolean  valid (int X , int Y ,int trd) {
    boolean c1= true ; boolean c2=true ,c3 =true ;
    int [][] grp= new int[tab.length][tab[0].length];
    if (X<0||Y<0||X>=tab.length||Y>=tab[0].length) {
        c1=false;
        }else{
             group(X, Y, 0 , grp,trd);
            if(tab[X][Y]!=0){
                c2=false ;
            }
            if(count_grp(grp)<10){
                c3=false ;}}
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

public  void group (int x ,int y, int  a , int [][] tab,int trd) {
    int ctr=0;
   tab[x][y]=1;
    boolean group =true;
    while(group){
        group = false ;
    for(int i=0 ; i<tab.length ;i++){
        for(int j=0 ; j<tab[0].length ;j++){
            if(tab[i][j]==1){
            if(i+1<tab.length){
            if ((this.tab[i+1][j]==trd||this.tab[i+1][j]==a) &&(tab[i+1][j]==0)) {
                tab[i+1][j]=1;
                group = true ;
            }}
            if (i-1>=0) {
            if ((this.tab[i-1][j]==trd||this.tab[i-1][j]==a)&&(tab[i-1][j]==0)) {
                tab[i-1][j]=1;
                group=true ;
            }}
            if (j+1<tab.length) {
            if ((this.tab[i][j+1]==trd||this.tab[i][j+1]==a)&&(tab[i][j+1]==0)) {
                tab[i][j+1]=1;
                group=true ;
            }}
            if (j-1>=0) {
            if ((this.tab[i][j-1]==trd||this.tab[i][j-1]==a)&&(tab[i][j-1]==0)) {
                tab[i][j-1]=1;
                group=true ;
            }}
        }
           
        }
    }
}

}
public  void affiche_tab(int[][]tab) {
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


