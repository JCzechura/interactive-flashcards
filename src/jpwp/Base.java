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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 *
 * @author Asia
 */
public class Base {
    private final MainFrame mainFrame;
    
    public Base(final MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        mainFrame.baselabel.setIcon(new ImageIcon("px.png"));
        if(mainFrame.changebase==true)
            createBasePanel();
        else createBasePanel_nchange();
        mainFrame.baselabel.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                mainFrame.baselabel.setIcon(new ImageIcon("px.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                mainFrame.baselabel.setIcon(new ImageIcon("px_n.png"));
            }
        });
        mainFrame.exit.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent arg0){
                mainFrame.exit.setIcon(new ImageIcon("wyj.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                mainFrame.exit.setIcon(new ImageIcon("wyj_n.png"));
            } 
        });
    }
    public void readBase(){
        mainFrame.jlabel.remove(mainFrame.baselabel);
        File fileIn=null;
        int i=0;
        int otwieranie=0;
        System.out.println(mainFrame.FileInName);
        fileIn= new File(mainFrame.FileInName);
        if(fileIn.exists()){
            //mainFrame.jlabel.remove(mainFrame.info);
            mainFrame.setContentPane(mainFrame.jlabel);
            mainFrame.setVisible(true);
            if(otwieranie==0){
                try {
                    Reader reader =new InputStreamReader(new FileInputStream(mainFrame.FileInName),"windows-1250");
                    BufferedReader fin = new BufferedReader(reader);
                    String s;
                    while ((s=fin.readLine())!=null) 
                    {
                        String[] parts = s.split("#");
                        mainFrame.tab1[i] = parts[0].trim();
                        mainFrame.tab2[i] = parts[1].trim();
                        i=i+1;
                    }
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mainFrame.jlabel.remove(mainFrame.baselabel);
                    Mode mode = new Mode(mainFrame);
                } catch (IOException ex) {
                    Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println(mainFrame.FileInName);
            otwieranie=1;
            mainFrame.image.add(mainFrame.textField);
            mainFrame.setContentPane(mainFrame.jlabel);
            mainFrame.info.setBounds(180, 530, 800, 200);
            if (mainFrame.changebase==true)
                mainFrame.info.setText("<html>NIEPOPRAWNA NAZWA PLIKU - spróbuj ponownie</html>");
            else
            {
                mainFrame.info.setText("<html>NIE ZNALEZIONO PLIKU - uruchom grê ponownie</html>");
                File file = new File("statystyki.txt");
                file.delete();
            }
            mainFrame.jlabel.add(mainFrame.baselabel);
            mainFrame.jlabel.add(mainFrame.info);
            mainFrame.setContentPane(mainFrame.jlabel);
            mainFrame.setVisible(true);
        } 
    }
    private void createBasePanel() {
        System.out.println("base");
        mainFrame.mainGphPanel("te1.jpg");
        mainFrame.baselabel.setIcon(new ImageIcon("px.png"));
        mainFrame.baselabel.setBounds(800,570, 210, 110);  
        mainFrame.jlabel.add(mainFrame.baselabel);
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        Border border = BorderFactory.createLineBorder(Color.red);
        mainFrame.textField.setFont(font1);
        mainFrame.textField.setBorder(border);
        mainFrame.textField.setBounds(150, 340, 250, 100);  
        mainFrame.image.add(mainFrame.textField);
        mainFrame.setVisible(true);
        mainFrame.setContentPane(mainFrame.jlabel);          
        mainFrame.baselabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                String a = mainFrame.textField.getText();
                a=a+".txt";
                mainFrame.textField.setText("");
                mainFrame.image.remove(mainFrame.textField);
                mainFrame.FileInName=a;
                mainFrame.jlabel.remove(mainFrame.baselabel);
                readBase();
            }
        });
    }
    private void createBasePanel_nchange() {
        System.out.println("baseee");
        mainFrame.mainGphPanel("te3.jpg");
        mainFrame.baselabel.setIcon(new ImageIcon("px.png"));
        mainFrame.baselabel.setBounds(800,570, 210, 110);  
        mainFrame.jlabel.add(mainFrame.baselabel);
        mainFrame.word.setBounds(180,280, 210, 110); 
        mainFrame.word.setFont(new Font("Verdana",1,30));
        mainFrame.word.setText(mainFrame.FileInName.trim());
        mainFrame.word.setFont(mainFrame.changeFont(mainFrame.word,mainFrame.FileInName.trim(),new Font("Verdana",1,30)));
        mainFrame.image.add(mainFrame.word);
        mainFrame.jlabel.add(mainFrame.image);
        mainFrame.setVisible(true);
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.baselabel.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseClicked(MouseEvent arg0) {
                        mainFrame.image.remove(mainFrame.word);
                readBase();
          }    
        });
    }
}