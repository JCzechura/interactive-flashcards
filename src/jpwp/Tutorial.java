
package jpwp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Asia
 */
public class Tutorial {
    private final MainFrame mainFrame;
    JLabel check = new JLabel("");
    JLabel next= new JLabel("");
    
    public Tutorial(final MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        next.setIcon(new ImageIcon("px.png"));
        next.setBounds(800,570, 210, 110);  
        mainFrame.jlabel.add(next);
        mainFrame.setContentPane(mainFrame.jlabel);
        createTutorialPanel_1();
    }
    private void createTutorialPanel_1() { 
        mainFrame.mainGphPanel("te0.jpg");
        mainFrame.setVisible(true);
        next.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.jlabel.remove(mainFrame.border);
                mainFrame.jlabel.remove(mainFrame.image);
                mainFrame.setContentPane(mainFrame.jlabel);
                createTutorialPanel_2();
            }
            public void mouseExited(MouseEvent arg0){
                next.setIcon(new ImageIcon("px.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                next.setIcon(new ImageIcon("px_n.png"));
            }
        });      
        mainFrame.exit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);
            }
            public void mouseExited(MouseEvent arg0){
                mainFrame.exit.setIcon(new ImageIcon("wyj.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                mainFrame.exit.setIcon(new ImageIcon("wyj_n.png"));
            } 
        });
    }
    private void createTutorialPanel_2(){
        check.setIcon(new ImageIcon("spr.png"));
        check.setBounds(700, 450, 250, 110);  
        mainFrame.jlabel.add(check);
        mainFrame.word.setFont(new Font("Verdana",1,46));
        mainFrame.word.setText("green");
        mainFrame.word.setBounds(200,280, 210, 110);  
        mainFrame.jlabel.add(mainFrame.word);
        mainFrame.info.setBounds(100, 400, 400, 200);
        mainFrame.info.setText("<html> Wpisz poprawne t≥umaczenie s≥owa 'green' w bia≥ym polu a nastÍpnie wciúnij SPRAWDè </html>");
        mainFrame.jlabel.add(mainFrame.info);
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        mainFrame.textField.setFont(font1);
        mainFrame.textField.setBounds(660, 300, 250, 100);  
        mainFrame.add (mainFrame.textField);
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true);
        next.addMouseListener(new MouseAdapter() {
        //@Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    createTutorialPanel_3();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tutorial.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } 
        });  
        check.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseClicked(MouseEvent arg0) {
                String a = mainFrame.textField.getText();
                String b = "zielony";
                if (a.equals(b)){
                    mainFrame.info.setText("<html> åWIETNIE !!! <br> odpowiedü zaliczona </html>");
                }else{
                    mainFrame.info.setBounds(100, 400, 600, 300);
                    mainFrame.info.setText("<html> èle !!! Odpowiedü - zielony <br> w grze zostanie wyúwietlona poprawna odpowiedü a s≥owo wpisane do listy s≥Ûw, ktÛre postarasz siÍ opanowaÊ w nastÍpnej rozgrywce</html>");    
                }
            }
            public void mouseExited(MouseEvent arg0){
                check.setIcon(new ImageIcon("spr.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                check.setIcon(new ImageIcon("spr_n.png"));
            } 
        }); 
    }
    private void createTutorialPanel_3() throws InterruptedException {
        mainFrame.mouseDown=true;
        mainFrame.textField.setText("");
        mainFrame.info.setBounds(100, 400, 600, 300);
        mainFrame.info.setText("<html>Moøesz takøe skorzystaÊ z trybu na czas - wÛwczas w prawym gÛrnym rogu zostanπ odliczane sekundy.<br> Masz 20 sekund na odpowiedü !</html>");
        mainFrame.infotime.setFont(new Font("Monospaced",1,32));
        Color myCustomColor = new Color(250,102,102);
        mainFrame.infotime.setForeground(myCustomColor);
        mainFrame.infotime.setBounds(100,100, 410, 110);  
        mainFrame.jlabel.add(mainFrame.infotime);
        mainFrame.initThread(check);
        next.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.mouseDown=false;
                mainFrame.mouseEv=false;
                mainFrame.infotime.setText("20 sekund");
                createTutorialPanel_4();
            }
        });      
        check.addMouseListener(new MouseAdapter() {
        //@Override
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.mouseDown=false;
                mainFrame.mouseEv=false;
                String a = mainFrame.textField.getText();
                String b = "zielony";
                if (a.equals(b)){
                    mainFrame.info.setText("<html> åWIETNIE !!! <br> odpowiedü zaliczona </html>");
                }else{
                    mainFrame.info.setBounds(100, 400, 600, 300);
                    mainFrame.info.setText("<html> èle !!! Odpowiedü - zielony <br> w grze zostanie wyúwietlona poprawna odpowiedü a s≥owo wpisane do listy s≥Ûw, ktÛre postarasz siÍ opanowaÊ w nastÍpnej rozgrywce</html>");    
                }
            }
        }); 
    }
    private void createTutorialPanel_4(){
        mainFrame.remove(mainFrame.textField);
        mainFrame.jlabel.remove(check);
        mainFrame.jlabel.add(next);
        mainFrame.jlabel.remove(mainFrame.info);
        mainFrame.jlabel.remove(mainFrame.infotime);
        mainFrame.jlabel.remove(mainFrame.word);
        mainFrame.mainGphPanel("te2.jpg");
        next.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.jlabel.remove(mainFrame.image);
                mainFrame.setContentPane(mainFrame.jlabel);
                createTutorialPanel_5();
            }
        });    
    }
    private void createTutorialPanel_5(){
        mainFrame.mainGphPanel("te.jpg");
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true);
        next.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.jlabel.remove(mainFrame.border);
                mainFrame.jlabel.remove(mainFrame.image);
                mainFrame.jlabel.remove(next);
                mainFrame.info.setText("");    
                Base o = new Base(mainFrame);
            }
        }); 
    }
}