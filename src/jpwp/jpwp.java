/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpwp;

import java.io.IOException;

/**
 *
 * @author Asia
 */
public class jpwp {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        MainFrame f = new MainFrame();
        MainMenu o = new MainMenu(f);
    }
}
