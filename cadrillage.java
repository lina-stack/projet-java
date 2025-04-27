import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
public class cadrillage {
    public static void main(String[] args) {
        MyComponent component = new MyComponent();
        JFrame frame = new JFrame();
        frame.setSize(component.cell*component.col +57, component.cell*component.ligne+140); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(component);
        frame.setVisible(true);
        Graphics g = component.getGraphics();
        jeu j = new jeu(component.col,component.ligne);
       for(int i=0 ; i<5; i++){
        boolean valid  = j.coups();
        System.out.println(valid);
        if (valid) {
           component.pieces(g, j.X, j.Y , j.trd );
        }else{
          component.non_valid(g ,"coup invalide!");
        }
       j.affiche_tab();
       j.trd=3-j.trd;
       }

    }
}

class MyComponent extends JComponent {
    int cell = 30, col = 10, ligne = 10;
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      Color boisFonce = new Color(190, 150, 110); // Cases foncées
Color boisClair = new Color(235, 215, 190); // Cases claires
Color fond = new Color(170, 130, 90 ,120);       // Fond
Color bande = new Color(140, 100, 60 ,120);

        try {
          Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Bestime.ttf")).deriveFont(20f);
          g2.setFont(font); // Appliquer la police une seule fois
      } catch (Exception e) {
          e.printStackTrace();
          g2.setFont(new Font("Serif", Font.PLAIN, 30)); // Police par défaut si erreur
      }
       

      g.setColor(fond);
      g.fillRect(0, 0, cell * col + 43, cell * ligne + 110);
      g.setColor(bande);
      g.fillRect(0, 0, cell * col + 43, 60);
      g.setColor(Color.BLACK);

      ImageIcon icon = new ImageIcon("Image3.png");
        Image image = icon.getImage();
        g2.drawImage(image, 2, 2, 60, 60, this);


      ImageIcon icon2 = new ImageIcon("Image6.png");
        Image image2 = icon2.getImage();
        g2.drawImage(image2, col*cell-50, 2, 60, 60, this);
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
    points(g2, 1, 2);
} 
  
  public  void pieces(Graphics g , int x , int y , int trd ) {
    Graphics2D g2 = (Graphics2D) g;
      if (trd == 1) g.setColor(Color.BLACK);
      else g.setColor(Color.WHITE);
      g.fillOval(x *cell+20+5, y *cell+80 +5, cell-10, cell-10);
  
}
public void non_valid(Graphics g, String text) {
  Graphics2D g2 = (Graphics2D) g;
  try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Bestime.ttf")).deriveFont(20f);
      g2.setFont(font); // Appliquer la police une seule fois
  } catch (Exception e) {
      e.printStackTrace();
      g2.setFont(new Font("Serif", Font.PLAIN, 30)); // Police par défaut si erreur
  }

  int steps = 20; 
  for (int i = 0; i <= steps; i++) {
      float ratio = (float) i / steps;

      int red   = (int) (174 * ratio);
      int green = (int) (144 * ratio);
      int blue  = (int) (117  * ratio);

      g2.setColor(new Color(red, green, blue));
      g2.drawString(text, cell*col/2-55, 35);
      try {
          Thread.sleep(70);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
  g2.setColor(new Color(174, 144, 117));
  g2.drawString(text, cell*col/2-55, 35);
}
 public void points (Graphics g2, int x , int y ) {
    g2.setColor(Color.black);
        g2.drawString(String.valueOf(x), 50, 50);
        g2.setColor(Color.white);
        g2.drawString(String.valueOf(y), col*cell, 50);
 } 
}
       


