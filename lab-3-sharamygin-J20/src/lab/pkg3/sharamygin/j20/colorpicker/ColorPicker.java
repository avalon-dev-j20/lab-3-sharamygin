/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3.sharamygin.j20.colorpicker;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.Serializable;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author sera
 */
public class ColorPicker extends JFrame implements Serializable {     
    static JFrame frameCP;
    
    private static JPanel colorP = new JPanel();
    private static JPanel sliderP = new JPanel();
    
    private final JLabel redL = new JLabel();
    private final JSlider redS = new JSlider(0, 255, 127);
    
    private final JLabel greenL = new JLabel("Green", SwingConstants.LEFT);
    private final JSlider greenS = new JSlider(0, 255, 127);
    
    private final JLabel blueL = new JLabel("Blue", SwingConstants.LEFT);
    private final JSlider blueS = new JSlider(0, 255, 127);
    
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    
   
    public void createColorPicker(){
        
        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
        
        frameCP = new JFrame("C o l o r   P i c k e r");
        frameCP.setSize(500, 250);
        frameCP.setLayout(new GridLayout(1, 2));

        frameCP.setLocationRelativeTo(null);
        frameCP.setVisible(true);
        frameCP.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frameCP.add(colorP);
        frameCP.add(sliderP);
        frameCP.setMinimumSize(new Dimension(480, 272));
        
        redS.addChangeListener(this::onSliderChange);
        greenS.addChangeListener(this::onSliderChange);
        blueS.addChangeListener(this::onSliderChange);
        
        createSliderP();
        updateColor();

}
    
    public JPanel createSliderP(){
        sliderP.setLayout(new GridLayout(3, 1));
        //sliderP.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        sliderP.setBackground(Color.white);       
        
        JPanel redP = new JPanel();
        redP.setLayout(new BoxLayout(redP, BoxLayout.X_AXIS));
        redP.setBackground(Color.WHITE);
        redL.setText(Integer.toString(redS.getValue()));
        redP.add(redL);
        redP.add(redS);
        Border borderRed = new TitledBorder("Red");
        redP.setBorder(borderRed);
        redS.setBackground(Color.WHITE);
        sliderP.add(redP);

                
        JPanel greenP = new JPanel();
        greenP.setLayout(new BoxLayout(greenP, BoxLayout.X_AXIS));
        greenP.setBackground(Color.WHITE);
        greenL.setText(Integer.toString(greenS.getValue()));       
        greenP.add(greenL);
        greenP.add(greenS);
        Border borderGreen = new TitledBorder("Green");
        greenP.setBorder(borderGreen);
        greenS.setBackground(Color.WHITE);
        sliderP.add(greenP);

        JPanel blueP = new JPanel();
        blueP.setLayout(new BoxLayout(blueP, BoxLayout.X_AXIS));
        blueP.setBackground(Color.WHITE);
        blueL.setText(Integer.toString(blueS.getValue()));
        blueP.add(blueL);
        blueP.add(blueS);
        Border borderBlue = new TitledBorder("Blue");
        blueP.setBorder(borderBlue);
        blueS.setBackground(Color.WHITE);
        sliderP.add(blueP);

        return sliderP;
    }
    
    public JPanel createColorP(){
        colorP.setLayout(new BorderLayout());
        colorP.setBorder(BorderFactory.createLineBorder(Color.gray, 10));
        colorP.setBackground(new Color(redS.getX(), greenS.getX(), blueS.getX()));

        return colorP;
    }

    private void updateColor() {
        colorP.setBackground(new Color(redS.getValue(), greenS.getValue(), blueS.getValue()));
        String hex = "#" + Integer.toHexString(colorP.getBackground().getRGB()).substring(2).toUpperCase();
        colorP.setToolTipText(hex);
        copyToClipboard(hex);
    }

        private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }
    
    private void onSliderChange(ChangeEvent e) {
        updateColor();
        redL.setText(Integer.toString(redS.getValue()));
        greenL.setText(Integer.toString(greenS.getValue()));
        blueL.setText(Integer.toString(blueS.getValue()));
    }

    public String toString(){
        return "Color Picker"; 
    }
}