
package jpwp;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Asia
 */
public class Game {
    private final MainFrame mainFrame;
    int user1counter, user2counter,user1wynik, user2wynik,user = 1, wynik=0, wyznacznik=0;
    String fileOutName,nick1,nick2;
    JTextField textField1= new JTextField ("wpisz nick"), textField2= new JTextField ("wpisz nick");
    JLabel nextWord = new JLabel(""), checkWord = new JLabel(""), hand1 = new JLabel(""),hand2 = new JLabel("");

    public Game(final MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        if (!(mainFrame.mode == 3))
            createGamePanel();
        else createMpPanel();
        nextWord.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                nextWord.setIcon(new ImageIcon("px.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                nextWord.setIcon(new ImageIcon("px_n.png"));
            }
        });
        checkWord.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                checkWord.setIcon(new ImageIcon("spr.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                checkWord.setIcon(new ImageIcon("spr_n.png"));
            }
        });
        hand1.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                hand1.setIcon(new ImageIcon("reka.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                hand1.setIcon(new ImageIcon("reka_n.png"));
            }
        });
        hand2.addMouseListener(new MouseAdapter() {        
            public void mouseExited(MouseEvent arg0){
                hand2.setIcon(new ImageIcon("reka.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                hand2.setIcon(new ImageIcon("reka_n.png"));
            }
        });
    }
    private void createMpPanel(){
        Color myCustomColor = new Color(204,102,102);
        mainFrame.jlabel.remove(mainFrame.image);
        mainFrame.jlabel.remove(mainFrame.border);  
        JLabel gracz1 = new JLabel("Gracz nr 1: ");
        gracz1.setFont(new Font("Monospaced",1,40));
        gracz1.setBounds(200, 280, 400, 100);
        textField1.setBounds(470,295,200,70);
        textField2.setBounds(470,395,200,70);
        JLabel gracz2 = new JLabel("Gracz nr 2: ");
        gracz2.setFont(new Font("Monospaced",1,40));
        gracz2.setBounds(200, 380, 400, 100);
        gracz2.setForeground(myCustomColor);
        gracz1.setForeground(myCustomColor);
        mainFrame.jlabel.add(gracz2);
        mainFrame.jlabel.add(gracz1);
        mainFrame.jlabel.add(textField1);
        mainFrame.jlabel.add(textField2);
        JLabel test=new JLabel("");
        test.setIcon(new ImageIcon("px.png"));
        test.setBounds(800,570, 210, 110);  
        mainFrame.jlabel.add(test);
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true); 
        test.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
            mainFrame.jlabel.remove(mainFrame.image);
            //mainFrame.setContentPane(mainFrame.jlabel);
            if (textField1.getText().equals("wpisz nick"))
                nick1="gracz nr 1";
            else nick1=textField1.getText();
            if (textField2.getText().equals("wpisz nick"))
                nick2="gracz nr 2";
            else nick2=textField2.getText();
            mainFrame.jlabel.remove(textField1);
            mainFrame.jlabel.remove(textField2);
            mainFrame.jlabel.remove(gracz2);
            mainFrame.jlabel.remove(gracz1);
            mainFrame.jlabel.remove(test);
            choosemode(); 
            }
            public void mouseExited(MouseEvent arg0){
                test.setIcon(new ImageIcon("px.png"));
            } 
            public void mouseEntered(MouseEvent arg0){
                test.setIcon(new ImageIcon("px_n.png"));
            }
    }); 
    }
    private void choosemode(){ 
        if(mainFrame.mode==1)
        createGame_normal();
        else if(mainFrame.mode==2) 
            createGame_time();
            else if(mainFrame.mode==3) 
                createGame_2users();
    }
    public void putText()      {        
        if (mainFrame.iftab1==true){
            mainFrame.word.setFont(mainFrame.changeFont(mainFrame.word,mainFrame.tab1[mainFrame.number].trim(),new Font("Verdana",1,46)));
            mainFrame.word.setText(mainFrame.tab1[mainFrame.number].trim());
        }else{
            mainFrame.word.setFont(mainFrame.changeFont(mainFrame.word,mainFrame.tab2[mainFrame.number].trim(),new Font("Verdana",1,46)));
            mainFrame.word.setText(mainFrame.tab2[mainFrame.number].trim());
        }
    }
    public void mainGamePanel(){
        checkWord.setIcon(new ImageIcon("spr.png"));
        checkWord.setBounds(400+300, 450, 250, 110);  
        mainFrame.jlabel.add(checkWord);
        mainFrame.mouseEv = true;
        mainFrame.mouseDown=true;
        mainFrame.word.setBounds(200,280, 210, 110);
        putText();
        mainFrame.jlabel.add(mainFrame.word);
        mainFrame.info.setBounds(100, 400, 400, 200);
        mainFrame.jlabel.add(mainFrame.info);
        nextWord.setIcon(new ImageIcon("px.png"));
        nextWord.setBounds(800,570, 210, 110);  
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        mainFrame.textField.setFont(font1);
        mainFrame.textField.setBounds(660, 300, 250, 100);  
        mainFrame.add (mainFrame.textField);
    }
    private void createGamePanel(){  
        mainFrame.mainGphPanel("te4.jpg");
        hand1.setIcon(new ImageIcon("reka.png")); //przed
        hand1.setBounds(300, 252, 100, 100);
        mainFrame.image.add(hand1); 
        hand2.setIcon(new ImageIcon("reka.png")); //za
        hand2.setBounds(300, 352, 100, 100);
        mainFrame.image.add(hand2); 
        mainFrame.jlabel.add(mainFrame.image);
        hand1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.iftab1 = true;
                mainFrame.jlabel.remove(mainFrame.image);
                mainFrame.jlabel.remove(mainFrame.border);
                choosemode(); 
            }
        });
        hand2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.iftab1 = false;
                mainFrame.jlabel.remove(mainFrame.border);
                mainFrame.jlabel.remove(mainFrame.image);
                choosemode(); 
            }
        });
    }
    private void generateNewBase() throws UnsupportedEncodingException, FileNotFoundException, IOException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String timenow = sdf.format(date);
        String partsa [] = mainFrame.FileInName.split(".txt");
        String parts[] = partsa[0].split("basedate");
        fileOutName = parts[0]+"basedate"+timenow;
        Writer writer =new OutputStreamWriter(new FileOutputStream(fileOutName+".txt"), "windows-1250");
        BufferedWriter fout = new BufferedWriter(writer); 
        for (int i=0;i<mainFrame.newBaseCounter;i++)  {
            fout.write(mainFrame.tab1out[i]+"#"+mainFrame.tab2out[i]);
            fout.newLine();
        }
        fout.close();
    }
    private void generateStatistics() throws FileNotFoundException, UnsupportedEncodingException, IOException       {
        BufferedReader statistisc= new BufferedReader(new FileReader("statystyki.txt"));
        ArrayList list = new ArrayList();
        String dataRow = statistisc.readLine(); 
        while (dataRow != null){
            list.add(dataRow);
            dataRow = statistisc.readLine(); 
        }
        try{
            statistisc.close();
        } catch (IOException e) {
            System.out.println("B≥•D PRZY ZAMYKANIU PLIKU!");
        }
        FileWriter writer = new FileWriter("statystyki.txt"); //same as your file name above so that it will replace it
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date();
        String time = sdf1.format(date1);
        writer.append(time);
        writer.append(System.getProperty("line.separator"));
        System.out.println("UWAGA DWIE LICZBY!!");
        System.out.println(wynik);
        System.out.println(mainFrame.number);
        if (wynik==mainFrame.number){
            System.out.println("UKO—CZY£EEEEEEEEEEEEEEEEEEEEEM");
            writer.append("ukoÒczona");
            writer.append(System.getProperty("line.separator"));
            writer.append("-");
        }else{
            writer.append("nieukoÒczona");
              System.out.println("NIE UKO—CZY£EEEEEEEEEEEEEEEEEEEEEM");
            writer.append(System.getProperty("line.separator"));
            writer.append("next base:_"+fileOutName+".txt");
        }
        writer.append(System.getProperty("line.separator"));
        writer.append("wynik: "+wynik+"/"+mainFrame.number);
        writer.append(System.getProperty("line.separator"));
        writer.append("______________________________");
        for (int i = 0; i < list.size(); i++){
           writer.append(System.getProperty("line.separator"));
           writer.append((CharSequence) list.get(i));
        }
        writer.flush();
        writer.close();
    }
    private String  number2procent(double num){
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(0);
        return defaultFormat.format(num); 
    }
    private void createExitPanel() throws UnsupportedEncodingException, FileNotFoundException, IOException{
        mainFrame.jlabel.remove(mainFrame.jlabel2);
        //if((wynik!=mainFrame.number)&&(mainFrame.mode!=3)){
        if((mainFrame.mode!=3)){
            generateNewBase();
            generateStatistics();
        }
        mainFrame.jlabel.remove(mainFrame.word);
        mainFrame.jlabel.remove(mainFrame.info);
        mainFrame.jlabel.remove(checkWord);
        mainFrame.jlabel.remove(nextWord);
        mainFrame.jlabel.remove(mainFrame.infotime);
        mainFrame.remove(mainFrame.textField);
        if(mainFrame.mode!=3){
            mainFrame.image.setIcon(new ImageIcon("te5.jpg"));
            double num = (double)wynik/(double)mainFrame.number;
            mainFrame.info.setBounds(255,238, 300, 100);
            mainFrame.info.setFont(new Font("Verdana",1,25));
            mainFrame.info.setText(wynik+"/"+mainFrame.number+"="+number2procent(num));
            mainFrame.image.add(mainFrame.info);
        }else{
            mainFrame.image.setIcon(new ImageIcon("te6.jpg"));
            JLabel userjeden = new JLabel("", SwingConstants.CENTER);
            JLabel userdwa = new JLabel("", SwingConstants.CENTER);
            userjeden.setBounds(310,328, 350, 100);
            userdwa.setBounds(310,368, 350, 100);
            double nr1 = (double)user1wynik/(double)user1counter;
            double nr2 = (double)user2wynik/(double)user2counter;
            System.out.println(user1wynik+"/"+user1counter);
            System.out.println(user2wynik+"/"+user2counter);
            if (nick1.length()>20)
                userjeden.setFont(mainFrame.changeFont(userjeden,(nick1+" : "+number2procent(nr1)),new Font("Times New Roman",0,46)));
            else userjeden.setFont(new Font("Times New Roman",0,32));
            userjeden.setText((nick1+" : "+number2procent(nr1)));
            if (nick2.length()>20)
                userdwa.setFont(mainFrame.changeFont(userdwa,(nick2+" : "+number2procent(nr2)),new Font("Times New Roman",0,46)));
            else userdwa.setFont(new Font("Times New Roman",0,32)); 
            userdwa.setText((nick2+" : "+number2procent(nr2)));
            mainFrame.jlabel.add(userjeden);
            mainFrame.jlabel.add(userdwa);
            mainFrame.border.setBounds(150,50, 700, 600);  
        }
        mainFrame.border.setIcon(new ImageIcon("bord.png"));
        mainFrame.image.remove(hand1);
        mainFrame.image.remove(hand2);
        mainFrame.image.setBounds(195,51, 700, 600); 
        mainFrame.jlabel.add(mainFrame.image);
        mainFrame.jlabel.add(mainFrame.border);
    }
   private void createGame_2users(){
        mainFrame.jlabel2.setBounds(200,100,400,200);
        mainFrame.jlabel2.setFont(mainFrame.changeFont(mainFrame.jlabel2,nick1+" odpowiada:",new Font("Verdana",1,46)));
        mainFrame.jlabel2.setText(nick1+" odpowiada:");
        Color nickuser1 = new Color(133,71,194);
        Color nickuser2 = new Color(82,163,0);
        Color slowouser2 = new Color(0,102,51);
        mainFrame.jlabel2.setForeground(nickuser1);
        Color slowouser1 = new Color(102,0,102);
        mainFrame.word.setForeground(slowouser1);
        mainFrame.jlabel.add(mainFrame.jlabel2);
        mainGamePanel();
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true);
        checkWord.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.jlabel.remove(checkWord);
                mainFrame.jlabel.add(nextWord);
                mainFrame.setContentPane(mainFrame.jlabel);
                mainFrame.setVisible(true);
                String a = mainFrame.textField.getText();
                mainFrame.textField.setText("");
                String b = mainFrame.tab2[mainFrame.number];
                if (a.equals(b)){   
                    if (user==1)
                    user1wynik++;
                    else user2wynik++;
                    mainFrame.info.setText("<html> åWIETNIE !!! <br> odpowiedü zaliczona </html>");
                }else{
                    mainFrame.info.setBounds(100, 400, 600, 300);
                    mainFrame.info.setText("<html>èle !!! Odpowiedü - "+b+"<br>S≥owo zostaje wpisane do nowej bazy.</html>");    
                }
            }
        }); 
        nextWord.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.jlabel.remove(nextWord);
                mainFrame.info.setText(" ");
                mainFrame.number++;
                System.out.println(mainFrame.number);
                if ((mainFrame.number==65)||(mainFrame.tab1[mainFrame.number]==null)){
                    if(user==1){
                        user1counter++;
                        System.out.println("counter1: "+user1counter);
                    }else{
                        user2counter++;
                        System.out.println("counter1: "+user1counter);
                    } 
                    mainFrame.jlabel.remove(checkWord);
                    mainFrame.setContentPane(mainFrame.jlabel);
                    mainFrame.setVisible(true);
                    try {
                        createExitPanel();
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    if(user==1){
                        user1counter++;
                        System.out.println("counter1: "+user1counter);
                        user=2;
                        mainFrame.jlabel2.setForeground(nickuser2);
                        mainFrame.word.setForeground(slowouser2);
                        mainFrame.jlabel2.setFont(mainFrame.changeFont(mainFrame.jlabel2,nick2+" odpowiada :",new Font("Verdana",1,46)));
                        mainFrame.jlabel2.setText(nick2+" odpowiada :");
                    }else{
                        user2counter++;
                        System.out.println("counter1: "+user1counter);
                        mainFrame.jlabel2.setForeground(nickuser1);
                        mainFrame.word.setForeground(slowouser1);
                        mainFrame.jlabel2.setFont(mainFrame.changeFont(mainFrame.jlabel2,nick1+" odpowiada :",new Font("Verdana",1,46)));
                        mainFrame.jlabel2.setText(nick1+" odpowiada :");
                        user=1;
                    }
                    mainFrame.word.setFont(mainFrame.changeFont(mainFrame.word,mainFrame.tab1[mainFrame.number].trim(),new Font("Verdana",1,46)));
                    mainFrame.word.setText(mainFrame.tab1[mainFrame.number].trim());
                    mainFrame.jlabel.add(checkWord);
                    mainFrame.jlabel.add(mainFrame.jlabel2);
                    mainFrame.setContentPane(mainFrame.jlabel);
                    mainFrame.setVisible(true);
                }
            }
        });
    }
    private void createGame_time(){
        mainGamePanel();
        mainFrame.infotime.setFont(new Font("Monospaced",1,32));
        Color myCustomColor = new Color(250,102,102);
        mainFrame.infotime.setForeground(myCustomColor);
        mainFrame.infotime.setBounds(100,100, 410, 110);  
        mainFrame.jlabel.add(mainFrame.infotime);
        mainFrame.initThread(checkWord);
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true);
        checkWord.addMouseListener(new MouseAdapter() {
        //@Override
            public void mouseClicked(MouseEvent arg0) {
                mainFrame.mouseDown=false;
                mainFrame.mouseEv=false;
                check();
            }
        }); 
        nextWord.addMouseListener(new MouseAdapter() {
            //@Override
            public void mouseClicked(MouseEvent arg0) {
                nextword();
            }
        });
    }
    public void check(){                
        mainFrame.jlabel.remove(checkWord);
        mainFrame.jlabel.add(nextWord);
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true);
        mainFrame.mouseDown=false;
        mainFrame.mouseEv=false;
        String a = mainFrame.textField.getText();
        String b;
        if (mainFrame.iftab1==true)
        b = mainFrame.tab2[mainFrame.number];
        else b = mainFrame.tab1[mainFrame.number];
        if (a.equals(b)){
            wynik++;
            mainFrame.info.setText("<html> åWIETNIE !!! <br> odpowiedü zaliczona </html>");
        }else{
            mainFrame.tab1out[mainFrame.newBaseCounter]=mainFrame.tab1[mainFrame.number];
            mainFrame.tab2out[mainFrame.newBaseCounter]=mainFrame.tab2[mainFrame.number];
            mainFrame.info.setBounds(100, 400, 600, 300);
            mainFrame.info.setText("<html>èle !!! Odpowiedü - "+b+"<br>S≥owo zostaje wpisane do nowej bazy.</html>");    
            mainFrame.newBaseCounter++;
        }
    }
    private void createGame_normal(){
        mainGamePanel();
        mainFrame.setContentPane(mainFrame.jlabel);
        mainFrame.setVisible(true);
        checkWord.addMouseListener(new MouseAdapter() {
        //@Override
            public void mouseClicked(MouseEvent arg0) {
                check();
            }
        }); 
       nextWord.addMouseListener(new MouseAdapter() {
        //@Override
            public void mouseClicked(MouseEvent arg0) {
                nextword();
            }
        });
    }
    public void nextword()
    {
        mainFrame.jlabel.remove(nextWord);
               mainFrame.number++;
               System.out.println(mainFrame.number);
               mainFrame.mouseEv = true;
               if ((mainFrame.number==65)||(mainFrame.tab1[mainFrame.number]==null)){
                    mainFrame.textField.setText("");
                    mainFrame.mouseEv = true;
                    checkWord.setIcon(new ImageIcon("spr.png"));
                    checkWord.setBounds(400+300, 450, 250, 110);  
                    mainFrame.jlabel.remove(checkWord);
                    mainFrame.image.remove(checkWord);
                    mainFrame.info.setText("");
                    mainFrame.setContentPane(mainFrame.jlabel);
                    mainFrame.setVisible(true);
                    try{
                        createExitPanel();
                    } catch (UnsupportedEncodingException ex) {
                       Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                       Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                       Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    putText();
                    mainFrame.mouseDown=true;
                    mainFrame.jlabel.add(checkWord);
                    mainFrame.info.setText("");
                    mainFrame.setContentPane(mainFrame.jlabel);
                    mainFrame.setVisible(true);
                    mainFrame.initThread(checkWord);
                } 
    }
}