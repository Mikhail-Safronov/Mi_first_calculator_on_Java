package myfirstcalculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
import javax.swing.*;
import static myfirstcalculator.MyFirstCalculator.calc;
//import java.awt.*;
/**
 *
 * @author 1
 */
public class JFrameToCalc extends JFrame {


    String result = ""; 
    JTextField areaOfResult = new JTextField();
    
    @SuppressWarnings("empty-statement")
    public JFrameToCalc(){
    setTitle("Мой калькулятор");// название окна
    setSize(275, 425);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(null);
    setVisible(true);
    
    
    JPanel textElements = new JPanel();
    {
        //textElements.setBackground(Color.red);
        textElements.setBounds(10, 10, 240, 75);
        textElements.setLayout(null);
        JLabel notification = new JLabel("Тут будут оповещения пользователю"); 
        notification.setBounds(0, 0, 240, 50);
        textElements.add(notification);
        
        
        areaOfResult.setLocation(0, 50);
        areaOfResult.setSize(240, 25);
        areaOfResult.setVisible(true);
        textElements.add(areaOfResult);
    
        this.add(textElements);
        
    }
    
    JPanel textNumberButtons = new JPanel();
    {
        //textNumberButtons.setBackground(Color.green);
        textNumberButtons.setBounds(10, 85, 240, 200);
        textNumberButtons.setVisible(true);
       // textNumberButtons.setLayout(new BorderLayout());
        
        String[][] namesOfButtons ={
        {"1", "2", "3", "+"},// Графическое отображение клавиатуры. Массив будет создавать имена кнопок.
        {"4", "5", "6", "-"}, 
        {"7", "8", "9", "/"}, 
        {"(", "0", ")", "*"} 
        
        };// Конец Массива. 
        int counter = 0;//Счетчик количества кнопок вообще
        for (String[] outherArray : namesOfButtons){for (String innerArray : outherArray){counter++;}}//Количество кнопок считается
        JButton[] arrayOfNumbers  = new JButton[counter];

        int indexOfArrayElenent = 0;
        for (int arrays = 0; arrays < 4; arrays++) {//цикл создает кнопки, и присваивает им имена в соответствии с именами в массиве
            for (int thisName = 0; thisName < 4; thisName++) {//i проходится по массивам, j - по именам
           arrayOfNumbers[indexOfArrayElenent] = new JButton();
           arrayOfNumbers[indexOfArrayElenent].setLocation(thisName*(50+10), arrays*(50));
           arrayOfNumbers[indexOfArrayElenent].setSize(60, 50);
           arrayOfNumbers[indexOfArrayElenent].setText(namesOfButtons[arrays][thisName]);
           textNumberButtons.add(arrayOfNumbers[indexOfArrayElenent]);
                
                arrayOfNumbers[indexOfArrayElenent].addActionListener((ActionEvent arg0) -> {
                JButton hollowButton = (JButton)arg0.getSource();//преобразовали событие к кнопке
                result = result + hollowButton.getText();
                areaOfResult.setText(result);
            });
            
           
           
           indexOfArrayElenent++;
                 }
        }
        
        this.add(textNumberButtons);
    }
    JPanel numberSystemButtons = new JPanel();
        {
        numberSystemButtons.setBounds(10, 285, 240, 50);
        numberSystemButtons.setVisible(true);
        String[] namesOfNumberButtons ={"/2", "/8", "/10", "/16"};
        JButton[] arrayOfSystemNumber  = new JButton[namesOfNumberButtons.length];
        int indexOf_arrayOfSystemNumber = 0;
            for (int i = 0; i < namesOfNumberButtons.length; i++) {
            arrayOfSystemNumber[indexOf_arrayOfSystemNumber] =  new JButton();     
            arrayOfSystemNumber[indexOf_arrayOfSystemNumber].setLocation(i*60, 0);  
            arrayOfSystemNumber[indexOf_arrayOfSystemNumber].setSize(60, 50);
            arrayOfSystemNumber[indexOf_arrayOfSystemNumber].setText(namesOfNumberButtons[i]);
            numberSystemButtons.add(arrayOfSystemNumber[indexOf_arrayOfSystemNumber]);
            indexOf_arrayOfSystemNumber++;
            }
            
        this.add(numberSystemButtons);
        }
    
  JPanel controlNumbers = new JPanel(); 
        {
        controlNumbers.setBounds(10, (285+50), 240, 50);
        controlNumbers.setVisible(true);
                JButton firstCommandButton =  new JButton(".");
                firstCommandButton.setSize(80, 50);
                firstCommandButton.setLocation(0, 0);
                
                firstCommandButton.addActionListener((ActionEvent arg0) -> {
                JButton hollowButton = (JButton)arg0.getSource();//преобразовали событие к кнопке
                result = result + hollowButton.getText();
                areaOfResult.setText(result);
            });
                
                controlNumbers.add(firstCommandButton);
                
        
        JButton secondCommandButton =  new JButton("Del");
                secondCommandButton.setSize(80, 50);
                secondCommandButton.setLocation(80, 0);
                controlNumbers.add(secondCommandButton);
                
                secondCommandButton.addActionListener((ActionEvent arg0) -> {
                result = "";
                areaOfResult.setText(result);
                });
                
        JButton thirdCommandButton =  new JButton("=");
                thirdCommandButton.setSize(80, 50);
                thirdCommandButton.setLocation(160, 0);
                
                thirdCommandButton.addActionListener((ActionEvent arg0) -> {
    
                    try {
                String x = result + " +0.1 -0.1";      
                double a = calc(x);
                result = ""+a;
            }       catch (ScriptException ex) {
                Logger.getLogger(JFrameToCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
               areaOfResult.setText(result);
                });
                    
                controlNumbers.add(thirdCommandButton);   
                
        this.add(controlNumbers);
        }
          


    

}
//        public class numberButtonListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent arg0) {
//            JButton hollowButton = (JButton)arg0.getSource();//преобразовали событие к кнопке
//            result = result + hollowButton.getText();
//            areaOfResult.setText();
//            //setPlusText(hollowButton.getText());
//        }
       }
    