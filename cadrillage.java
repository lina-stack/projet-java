import java.awt.Color;
import java.awt.*;
import javax.swing.*;

public class cadrillage {
    public static void main(String[] args) {
        MyComponent component = new MyComponent();
        JFrame frame = new JFrame();
        frame.setSize(component.cell*component.col +110, component.cell*component.ligne+146); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        frame.add(component);
        frame.setVisible(true);
        Graphics g = component.getGraphics();
        jeu j = new jeu(component.col,component.ligne);
       for(int i=0 ; i<5; i++){
         j.coups();
         if (j.X>=0&&j.Y>=0&&j.X<j.tab.length&&j.Y<j.tab[0].length&&j.tab[j.X][j.Y]==0) {
            component.pieces(g, j.X, j.Y , j.trd );
           }
            if (j.X<0||j.Y<0||j.X>=j.tab.length||j.Y>=j.tab[0].length) {
                component.rempli(g,"coup illegal! ");
                j.depasse();
                if (!(j.X<0||j.Y<0||j.X>=j.tab.length||j.Y>=j.tab[0].length)) {
                    if (j.tab[j.X][j.Y]!=0) {
                        component.rempli(g,"Deja rempli! ");
                        j.rempli();
                        if (j.tab[j.X][j.Y]!=0) {
                            component.rempli(g,"mauvais coup tour perdu!");
                        }else{
                            component.pieces(g, j.X, j.Y , j.trd );
                        }
                    }else{component.pieces(g, j.X, j.Y , j.trd );}
                   
                }else{component.rempli(g,"mauvais coup tour perdu!");}
            } 
            component.pieces(g, j.X, j.Y , j.trd ); 
       j.trd=3-j.trd;
       }

    }
}

class MyComponent extends JComponent {
    int cell = 30, col = 10, ligne = 10;
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      

      Color brown = new Color(226, 178, 4 ,180);
      g.setColor(brown);
      g.fillRect(0, 0, cell * col + 110, cell * ligne + 110);

      g.setColor(Color.BLACK);
      
       
      for (int i = 0; i <= ligne; i++) {
          g2.drawLine(50, i * cell + 50, col * cell + 50, i * cell + 50);
      }
      for (int i = 0; i <= col; i++) {
          g2.drawLine(i * cell + 50, 50, i * cell + 50, ligne * cell + 50);
      }  
  }
  public  void pieces(Graphics g , int x , int y , int trd) {
    Graphics2D g2 = (Graphics2D) g;
    if (trd == 1) g.setColor(Color.BLACK);
    else g.setColor(Color.WHITE);
    g.fillOval(x *cell+50+5, y *cell+50 +5, cell-10, cell-10);
  }
  public  void rempli(Graphics g  ,String text) {
    Graphics2D g2 = (Graphics2D) g;
    g.drawString(text, 250/2,250/2);
    for (int i = 0; i < 20; i++) { // Réduire progressivement l'opacité
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i/10));
        g2.setColor(Color.BLACK);
        g2.drawString(text, 125, 125);

        try {
            Thread.sleep(100); // Pause pour voir l'effet progressivement
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
}
}