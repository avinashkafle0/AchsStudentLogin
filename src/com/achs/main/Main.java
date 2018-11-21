/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achs.main;

import com.achs.ui.Login;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;


/**
 *
 * @author avinash
 */
public class Main {
    
    public static void main(String[] args) {
        
    SwingUtilities.invokeLater(new Runnable(){//create event dspatch thread by using runnable
            @Override
            public void run(){
                Login login = new Login();
                login.setVisible(true);
                login.pack();
                login.setLocationRelativeTo(null);
                login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            
            }
        });
    }
}
