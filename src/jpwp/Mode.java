/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpwp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author Asia
 */
public class Mode {
        private final MainFrame mainFrame;
        JLabel info = new JLabel("");
        JLabel jlabel2 = new JLabel ("");
        JLabel jlabel3 = new JLabel("");
        JLabel jlabelv1 = new JLabel ("");
        JLabel jlabelv2 = new JLabel ("");
        JLabel jlabelv3 = new JLabel ("");
        JLabel lb3 = new JLabel("MULTIPLAYER");
        JLabel lb2 = new JLabel("TRYB NA CZAS");
        JLabel lb1 = new JLabel("TRYB NORMALNY");
        
    public Mode(final MainFrame mainFrame) throws IOException {
        this.mainFrame = mainFrame;
        createModeMenuPanel();
        jlabelv1.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                jlabelv1.setIcon(new ImageIcon("tryb.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                jlabelv1.setIcon(new ImageIcon("tryb_n.png"));
            }
        });
        jlabelv2.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                jlabelv2.setIcon(new ImageIcon("tryb.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                jlabelv2.setIcon(new ImageIcon("tryb_n.png"));
            }
        });
        jlabelv3.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                jlabelv3.setIcon(new ImageIcon("tryb.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                jlabelv3.setIcon(new ImageIcon("tryb_n.png"));
            }
        });
    }

    private void createModeMenuPanel() throws IOException {
        jlabel2 = new JLabel("SuperZapamiêtywanka");
        jlabel2.setBounds(200, 150, 640, 50);
        jlabel2.setFont(new Font("Verdana",1,44));
        mainFrame.jlabel=new JLabel(new ImageIcon("tloo.jpg"));

        lb1.setFont(new Font("Monospaced",1,36));
        lb1.setBounds(200, 280, 400, 100);
        jlabelv1.setIcon(new ImageIcon("tryb.png"));
        jlabelv1.setBounds(550, 282, 400, 100);
        mainFrame.jlabel.add(jlabel2); 
         mainFrame.jlabel.add(jlabelv1); 
        Color myCustomColor = new Color(204,102,102);
        lb1.setForeground(myCustomColor); 
        mainFrame.jlabel.add(lb1);

        lb2.setFont(new Font("Monospaced",1,36));
        lb2.setBounds(200, 380, 400, 100); 
        lb2.setForeground(myCustomColor);
        jlabelv2.setIcon(new ImageIcon("tryb.png"));
        jlabelv2.setBounds(550, 382, 400, 100);
        mainFrame.jlabel.add(jlabelv2); 
        mainFrame.jlabel.add(lb2);
        if(mainFrame.changebase==true){
            lb3.setFont(new Font("Monospaced",1,36));
            lb3.setBounds(201, 480, 250, 100); 
            lb3.setForeground(myCustomColor); 
            jlabelv3.setIcon(new ImageIcon("tryb.png"));
            jlabelv3.setBounds(550, 482, 400, 100);
            mainFrame.jlabel.add(jlabelv3); 
            mainFrame.jlabel.add(lb3);
            jlabelv3.addMouseListener(new MouseAdapter() {
                //@Override
                public void mouseClicked(MouseEvent arg0) {
                    mainFrame.mode = 3;
                    deleteComponents();
                    System.out.println(mainFrame.mode);
                    Game game = new Game(mainFrame);
                }
            });
        }
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true);
        jlabelv1.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.mode = 1;
                deleteComponents();
                System.out.println(mainFrame.mode);
                Game game = new Game(mainFrame);
            }
        });
        jlabelv2.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.mode = 2;
                deleteComponents();
                System.out.println(mainFrame.mode);
                Game game = new Game(mainFrame);
            }
        });
    }
    public void deleteComponents()
    {
        mainFrame.jlabel.remove(jlabel2); 
        mainFrame.jlabel.remove(jlabelv1);
        mainFrame.jlabel.remove(jlabelv2);
        mainFrame.jlabel.remove(jlabelv3);
        mainFrame.jlabel.remove(lb1); 
        mainFrame.jlabel.remove(lb2);
        mainFrame.jlabel.remove(lb3); 

    }
}