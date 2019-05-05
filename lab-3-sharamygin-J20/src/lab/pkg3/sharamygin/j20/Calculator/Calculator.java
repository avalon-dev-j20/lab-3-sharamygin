/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3.sharamygin.j20.Calculator;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXUIFactory;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.*;

/**
 *
 * @author sera
 */
public class Calculator extends JFrame implements ActionListener  {
    
    static JFrame frameC; 
    static JLabel l; 
    String s0, s1, s2; 
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
 
    public Calculator(){ 
        s0 = s1 = s2 = ""; 
    } 
  
    // main function 
    public static Calculator createCalc(){ 
        
        frameC = new JFrame("C a l c u l a t o r");

        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
  
        Calculator calculator = new Calculator(); 
  
        l = new JLabel("Type any number", SwingConstants.RIGHT); 
        l.setFont(new Font("DIN Alternate", Font.BOLD, 16));      

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, bdot, beq, beq1; 
   
        b0 = new JButton("0"); 
        b1 = new JButton("1"); 
        b2 = new JButton("2"); 
        b3 = new JButton("3"); 
        b4 = new JButton("4"); 
        b5 = new JButton("5"); 
        b6 = new JButton("6"); 
        b7 = new JButton("7"); 
        b8 = new JButton("8"); 
        b9 = new JButton("9"); 
        
        beq1 = new JButton("=");
        beq1.setPreferredSize(new Dimension(320, 10));
  
        ba = new JButton("+"); 
        bs = new JButton("-"); 
        bd = new JButton("/"); 
        bm = new JButton("*"); 
        beq = new JButton("C"); 
        

        bdot = new JButton("."); 
  
        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(Color.white); 
        JPanel allTheButtonsPanel = new JPanel();
        JPanel equationButtonPanel = new JPanel();
        
        
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        frameC.setContentPane(contentPane);
  
        bm.addActionListener(calculator); 
        bm.setMnemonic(KeyEvent.VK_ASTERISK);
        
        bd.addActionListener(calculator); 
        bd.setMnemonic(KeyEvent.VK_SLASH);
        
        bs.addActionListener(calculator);
        bs.setMnemonic(KeyEvent.VK_MINUS);
        
        ba.addActionListener(calculator); 
        ba.setMnemonic(KeyEvent.VK_EQUALS);
        
        b9.addActionListener(calculator); 
        b9.setMnemonic(KeyEvent.VK_9);
        
        b8.addActionListener(calculator); 
        b8.setMnemonic(KeyEvent.VK_8);
        
        b7.addActionListener(calculator); 
        b7.setMnemonic(KeyEvent.VK_7);
        
        b6.addActionListener(calculator);
        b6.setMnemonic(KeyEvent.VK_6);
        
        b5.addActionListener(calculator); 
        b5.setMnemonic(KeyEvent.VK_5);
        
        b4.addActionListener(calculator);
        b4.setMnemonic(KeyEvent.VK_4);
        
        b3.addActionListener(calculator); 
        b3.setMnemonic(KeyEvent.VK_3);
        
        b2.addActionListener(calculator);
        b2.setMnemonic(KeyEvent.VK_2);
        
        b1.addActionListener(calculator);
        b1.setMnemonic(KeyEvent.VK_1);
        
        b0.addActionListener(calculator);
        b0.setMnemonic(KeyEvent.VK_0);
        
        bdot.addActionListener(calculator);
        bdot.setMnemonic(KeyEvent.VK_MULTIPLY);
        
        beq.addActionListener(calculator);
        beq.setMnemonic(KeyEvent.VK_BACK_SPACE); 
        
        beq1.addActionListener(calculator);
        beq1.setMnemonic(KeyEvent.VK_ENTER);
  
        labelPanel.add(l); 
        allTheButtonsPanel.add(b7); 
        allTheButtonsPanel.add(b8); 
        allTheButtonsPanel.add(b9); 
        allTheButtonsPanel.add(ba); 
        allTheButtonsPanel.add(b4); 
        allTheButtonsPanel.add(b5); 
        allTheButtonsPanel.add(b6);
        allTheButtonsPanel.add(bs); 
        allTheButtonsPanel.add(b1); 
        allTheButtonsPanel.add(b2); 
        allTheButtonsPanel.add(b3);
        allTheButtonsPanel.add(bm);
        allTheButtonsPanel.add(beq);
        allTheButtonsPanel.add(b0);
        allTheButtonsPanel.add(bdot);
        allTheButtonsPanel.add(bd);
        equationButtonPanel.add(beq1);   

        allTheButtonsPanel.setLayout(new GridLayout(4, 4));
        allTheButtonsPanel.setBackground(Color.white);
        equationButtonPanel.setLayout(new GridLayout(1, 1));
        equationButtonPanel.setBackground(Color.white);
        equationButtonPanel.setPreferredSize(new Dimension(WIDTH, 10)); 
        frameC.add(labelPanel);
        frameC.add(allTheButtonsPanel); 
        frameC.add(equationButtonPanel);
        
        frameC.setLocationRelativeTo(null);
        frameC.setMaximumSize(new Dimension(600, 600));
        frameC.setMinimumSize(new Dimension(360,320));
        frameC.setVisible(true);
        frameC.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        return calculator;
        
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
  
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
            if (!s1.equals("")) 
                s2 = s2 + s; 
            else
                s0 = s0 + s; 
  
            l.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == 'C') { 
            s0 = s1 = s2 = ""; 
  
            l.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == '=') { 
  
            double te; 

            if (s1.equals("+")) 
                te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
                te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
                te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
 
            l.setText(s0 + s1 + s2 + "=" + te); 

            s0 = Double.toString(te); 
              copyToClipboard(s0);
            s1 = s2 = ""; 
        } 
        else { 
            if (s1.equals("") || s2.equals("")) 
                s1 = s; 
            else { 
                double te; 

                if (s1.equals("+")) 
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
                else if (s1.equals("-")) 
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
                else if (s1.equals("/")) 
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
                s0 = Double.toString(te); 
                s1 = s; 
                s2 = ""; 
                
                copyToClipboard(s0);
            } 
            l.setText(s0 + s1 + s2); 
        } 
    } 

        private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }
    
    @Override
    public String toString(){
        return "Calculator";
    }

}
