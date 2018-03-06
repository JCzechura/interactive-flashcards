/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpwp;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Asia
 */
public class MainMenu {
    private final MainFrame mainFrame;
    
    public MainMenu(final MainFrame mainFrame) throws IOException {
        mainFrame.setSize(1024,768);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.mainFrame = mainFrame;
        createMainMenuPanel();
        
    }
    public void readStat() throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        File file = new File("statystyki.txt");
        if ((!file.exists()) || (file.length() == 0)){
            file.createNewFile();
        }else{
            Reader reader =new InputStreamReader(new FileInputStream("statystyki.txt"),"windows-1250");
            BufferedReader statistisc = new BufferedReader(reader);
            String dataRow = statistisc.readLine(); 
            System.out.println(dataRow);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String timenow = sdf.format(date);
            if (timenow.equals(dataRow)){
                mainFrame.date=0;
            }else System.out.println("test   ");
            dataRow = statistisc.readLine(); 
            System.out.println(dataRow);
            if (!(dataRow.trim().equals("ukoñczona"))){
                System.out.println("nieukonczona");
                mainFrame.changebase = false;
                dataRow = statistisc.readLine();
                System.out.println(dataRow);
                String parts[] = dataRow.split(":_");
                mainFrame.FileInName=parts[1];
            }
            try{
                statistisc.close();
            } catch (IOException e) {
                System.out.println("B£¥D PRZY ZAMYKANIU PLIKU!");
            }
            if(mainFrame.date==0){
                mainFrame.info.setFont(new Font("Monospaced",1,26));
                mainFrame.info.setBounds(50, 530, 950, 200);
                mainFrame.info.setText("<html>CZAS MIÊDZY ÆWICZENIAMI JESZCZE NIE MIN¥£ - WRÓÆ JUTRO ;) </html>");
                mainFrame.jlabel.add( mainFrame.info);
                mainFrame.setContentPane( mainFrame.jlabel);
                mainFrame.setVisible(true);
            }
        }
    }
    private void createMainMenuPanel() throws IOException {
        mainFrame.jlabel2 = new JLabel("SuperZapamiêtywanka");
        mainFrame.jlabel2.setBounds(400-200, 100+50, 140+500, 50);
        mainFrame.jlabel2.setFont(new Font("Verdana",1,44));
        mainFrame.jlabel=new JLabel(new ImageIcon("tloo.jpg"));
        mainFrame.tutorialicon.setIcon(new ImageIcon("tutorial.png"));
        mainFrame.tutorialicon.setBounds(370, 280, 250, 100);
        mainFrame.jlabel.add( mainFrame.jlabel2);   
        mainFrame.jlabel.add(mainFrame.tutorialicon);
        mainFrame.baseicon.setIcon(new ImageIcon("baza.png"));
        mainFrame.baseicon.setBounds(359, 390, 250, 110);
        mainFrame.jlabel.add(mainFrame.baseicon);
        mainFrame.exit.setIcon(new ImageIcon("koniec.png"));
        mainFrame.exit.setBounds(386, 500, 210, 90);  
        mainFrame.jlabel.add(mainFrame.exit);
        mainFrame.setContentPane( mainFrame.jlabel);
        mainFrame.setVisible(true);
        readStat();
        if(mainFrame.date==1){ 
            mainFrame.tutorialicon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0){
                    mainFrame.mode=0;
                    mainFrame.jlabel2.setText("");
                    mainFrame.jlabel.remove(mainFrame.baseicon);
                    mainFrame.jlabel.remove(mainFrame.tutorialicon);
                    Tutorial t= new Tutorial (mainFrame);
                    System.out.println(mainFrame.mode);
                }
                public void mouseExited(MouseEvent arg0){
                            mainFrame.tutorialicon.setIcon(new ImageIcon("tutorial.png"));
                } 
                public void mouseEntered(MouseEvent arg0){
                            mainFrame.tutorialicon.setIcon(new ImageIcon("tutorial_n.png"));
                } 
            });
            mainFrame.baseicon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {

                        mainFrame.jlabel2.setText("");
                        mainFrame.jlabel.remove(mainFrame.baseicon);
                        mainFrame.jlabel.remove(mainFrame.tutorialicon);
                        Base b= new Base (mainFrame);

                }
                public void mouseExited(MouseEvent arg0){
                            mainFrame.baseicon.setIcon(new ImageIcon("baza.png"));

            }
                public void mouseEntered(MouseEvent arg0){
                            mainFrame.baseicon.setIcon(new ImageIcon("baza_n.png"));
                }
            });
        }    
            mainFrame.exit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {
                    System.exit(0);
                }
                public void mouseExited(MouseEvent arg0){
                            mainFrame.exit.setIcon(new ImageIcon("koniec.png"));
                } 
                public void mouseEntered(MouseEvent arg0){
                            mainFrame.exit.setIcon(new ImageIcon("koniec_n.png"));
                }
            });
        
    }
}
