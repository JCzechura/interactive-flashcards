/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpwp;


import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Asia
 */
public class MainFrame extends JFrame {
    int newBaseCounter = 0, number=0, counter=20, date=1;
    int mode=0; //  0 - tutorial, 1 - tryb normalny , 2 - tryb na czas, 3 - 2 users 
    JTextField textField = new JTextField("");
    JLabel info = new JLabel("");
    JLabel jlabel = new JLabel(new ImageIcon("tloo.jpg"));
    JLabel tutorialicon = new JLabel(" ");
    JLabel baseicon = new JLabel("");
    JLabel exit = new JLabel("");
    JLabel baselabel = new JLabel("");
    JLabel jlabel2;
    JLabel word = new JLabel("green");
    JLabel infotime = new JLabel("20 sekund");
    JLabel image = new JLabel("");
    JLabel border = new JLabel("");
    String[] tab1 = new String[64];
    String[] tab2 = new String[64];
    String[] tab1out = new String[64];
    String[] tab2out = new String[64];
    String FileInName;
    boolean changebase = true;
    boolean iftab1 = true;
    volatile public boolean mouseDown = false;
    volatile public boolean mouseEv = true;
    volatile public boolean isRunning = false;
    
    public MainFrame() {
        super("SuperZapamiÍtywanka!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    public Font changeFont(JLabel label, String text, Font font){
        String labelText = text;
        int stringWidth = label.getFontMetrics(font).stringWidth(labelText);
        int componentWidth = label.getWidth();
        double widthRatio = (double)componentWidth / (double)stringWidth;
        int newFontSize = (int)(font.getSize() * widthRatio);
        int componentHeight = label.getHeight();
        int fontSizeToUse = Math.min(newFontSize, componentHeight);
        Font x =new Font(font.getName(), Font.PLAIN, fontSizeToUse);
        return x;
    }
    public synchronized boolean checkAndMark() {
        if (isRunning) return false;
        isRunning = true;
        return true;
        }
    public void initThread(JLabel label) {
        if (checkAndMark()) {
            new Thread() {
                public void run() {
                    if(mode==0){
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Tutorial.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    do{   
                        long a=System.currentTimeMillis();
                        counter=20;
                        for(int i = 0; i<=20; i++){ 
                            while(a+(i*1000)>System.currentTimeMillis());
                                if (mouseDown==false)
                                {
                                    i=20;
                                    counter=20;
                                    break;
                        }
                            String y;
                            y = counter + " sekund";
                            infotime.setText(y);
                            counter--;
                        }
                        if(mouseEv==true){
                            jlabel.remove(label);
                            setContentPane(jlabel);
                            setVisible(true);
                            mouseDown=false;
                            tab1out[newBaseCounter]=tab1[number];
                            tab2out[newBaseCounter]=tab2[number];
                            newBaseCounter++;
                            if (mode==0)
                                info.setText("<html> Czas minπ≥ !!! Odpowiedü - ZIELONY </html>"); 
                                else info.setText("<html> Czas minπ≥ !!! Odpowiedü "+tab2[number]+" </html>");    
                        } 
                        mouseDown=false;
                    } while (mouseDown);
                    mouseDown=false;
                    isRunning = false;
                }
            }.start();
        }
    }
    public void mainGphPanel(String name){
        exit.setIcon(new ImageIcon("wyj.png"));
        exit.setBounds(900, 30, 210, 110);  
        jlabel.add(exit);
        info.setFont(new Font("Monospaced",1,24));
        Color myCustomColor = new Color(204,102,102);
        info.setForeground(myCustomColor);
        info.setBounds(100,150, 700, 300);  
        border.setIcon(new ImageIcon("bord.png"));
        border.setBounds(150,50, 700, 600);  
        jlabel.add(border);
        image.setIcon(new ImageIcon(name));
        image.setBounds(195,51, 700, 600);  
        jlabel.add(image);
        setContentPane(jlabel);
        setVisible(true);
    }
}