import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
public class cadrillage {

    public static void main(String[] args) {
        MyComponent component = new MyComponent();
        cadrillage c = new cadrillage();
        JFrame frame = new JFrame();
        frame.setSize(component.cell*component.col +57, component.cell*component.ligne+140); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(component);
        frame.setVisible(true);
        Graphics g = component.getGraphics();

        jeu j = new jeu(component.col,component.ligne);
       JoueurHumain j1= new JoueurHumain();
       joueur_IA j2 = new joueur_IA(); 
        while((j.Partie(1)||j.Partie(2))&&j.passesConsecutives<2){ 
          j1.trd=1;
          boolean valid =j1.coup_humain(j);
            if (valid) {
              component.pieces(g,j1.X,j1.Y,1 );
           }else{
            if(!j.passerCoup){
             component.draw_string(g ,"coup invalide!");}
           }
           j2.coup_IA(j);
           System.out.println(j2.X);
           System.out.println(j2.Y);
           component.pieces(g,j2.Y,j2.X,2 );}
        
          component.draw_string(g ,"Fin de parti!");
          g.setColor(new Color(174, 144, 116 )); // même couleur que ta bande
          g.fillRect(50, 30, 30, 30); // même taille que la bande
         
          g.fillRect(component.col*component.cell, 30, 30, 30); // même taille que la bande
        
         int Score_1=j.decompte_points(1,component.col,component.ligne);
         
         int Score_2=j.decompte_points(2,component.col,component.ligne);
         component.points(g,Score_1, Score_2);
        
        
      
       
      

    

      }}
      class MyComponent extends JComponent {
    int cell = 30, col = 6, ligne = 6;
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      Color boisFonce = new Color(190, 150, 110); // Cases foncées
Color boisClair = new Color(235, 215, 190); // Cases claires
Color fond = new Color(170, 130, 90 ,120);       // Fond
Color bande = new Color(140, 100, 60 ,120);
      g.setColor(fond);
      g.fillRect(0, 0, cell * col + 43, cell * ligne + 110);
      g.setColor(bande);
      g.fillRect(0, 0, cell * col + 43, 60);
      
      ImageIcon icon = new ImageIcon("Image3.png");
        Image image = icon.getImage();
        g2.drawImage(image, 2, 0, (int)(cell * col /4), (int)(cell * col /4), this);
      ImageIcon icon2 = new ImageIcon("Image6.png");
        Image image2 = icon2.getImage();
        g2.drawImage(image2, col*cell, 2, (int)(cell * col /4), (int)(cell * col /4), this);
        jeu j = new jeu (col ,ligne);
       for(int i=0 ; i<j.tab.length ; i++){
        for(int k=0 ; k<j.tab.length;k++){
            if(j.tab[i][k]!=0){ 
              pieces(g,i,k,j.tab[i][k]);
            }
        }
      }
      boolean noir =true ;  
      for (int y = 0; y < col; y++) {
        for (int x = 0; x < ligne; x++) {
            if (noir) {
                g.setColor(boisFonce);
            } else {
                g.setColor(boisClair);
            }
            g.fillRect(x * cell+20, y * cell+80, cell, cell);
            noir = !noir; // alterner la couleur
        }
        noir = !noir; // alterner au début de chaque ligne
        
    }
    

} 

   

  
  public  void pieces(Graphics g , int x , int y , int trd ) {
    Graphics2D g2 = (Graphics2D) g;
      if (trd == 1) g.setColor(Color.BLACK);
      else g.setColor(Color.WHITE);
      g.fillOval(x *cell+20+5, y *cell+80 +5, cell-10, cell-10);
  
}
public void draw_string(Graphics g, String text) {
  Graphics2D g2 = (Graphics2D) g;
  try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Bestime.ttf")).deriveFont( Math.max(12f, cell * 0.5f));
      g2.setFont(font); // Appliquer la police une seule fois
  } catch (Exception e) {
      e.printStackTrace();
      g2.setFont(new Font("Serif", Font.PLAIN, 20)); // Police par défaut si erreur
  }

  int steps = 20; 
  for (int i = 0; i <= steps; i++) {
      float ratio = (float) i / steps;

      int red   = (int) (174 * ratio);
      int green = (int) (144 * ratio);
      int blue  = (int) (117  * ratio);

      g2.setColor(new Color(red, green, blue));
      g2.drawString(text, (cell*col)-(Math.max(12f, cell * 0.5f)*(text.length())/2)-20, 35);
      try {
          Thread.sleep(70);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
  g2.setColor(new Color(174, 144, 117));
g2.drawString(text, (cell*col)-(Math.max(12f, cell * 0.5f)*(text.length())/2), 35);
}
public void points(Graphics g2, int x, int y) {
  Graphics2D g = (Graphics2D) g2;

  // Chargement de la police personnalisée une seule fois
  try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Bestime.ttf")).deriveFont(Math.max(12f, cell * 0.3f));
      g.setFont(font);
  } catch (Exception e) {
      e.printStackTrace();
      g.setFont(new Font("Serif", Font.PLAIN, 20));
  }

  // Fond des points
  g.setColor(new Color(174, 144, 116));
  g.fillRect(50, 30, 30, 30);          // rectangle pour joueur 1
  g.fillRect(col * cell, 30, 30, 30);  // rectangle pour joueur 2

  // Affichage du score
  g.setColor(Color.BLACK);
  g.drawString(String.valueOf(x), 55, 52);  // Score joueur 1
  g.setColor(Color.WHITE);
  g.drawString(String.valueOf(y+0.5), col * cell - (int)(cell * col /4), 52); // Score joueur 2
}

}