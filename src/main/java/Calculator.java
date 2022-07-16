/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vidya
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberedButtons=new JButton[10];
    JButton[] functionButtons=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton eqlButton,clrButton,decButton,delButton,negButton;
    JPanel panel;
    Font myFont=new Font("Ink Free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    Calculator(){
        frame =new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(440,550);
        
        textfield =new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setEditable(false);
        textfield.setFont(myFont);
        textfield.setBackground(Color.WHITE);
        
        addButton =new JButton("+");
        subButton =new JButton("-");
        mulButton =new JButton("*");
        divButton =new JButton("/");
        decButton =new JButton(".");
        eqlButton =new JButton("=");
        clrButton =new JButton("Clr");
        delButton =new JButton("Del");
        negButton =new JButton(("-"));
        
        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=eqlButton;
        functionButtons[6]=clrButton;
        functionButtons[7]=delButton;
        functionButtons[8]=negButton;
        
        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        
        for(int i=0;i<10;i++){
            numberedButtons[i]=new JButton(String.valueOf(i));
            numberedButtons[i].addActionListener(this);
            numberedButtons[i].setFont(myFont);
            numberedButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);  
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10, 10));
        
        panel.add(numberedButtons[1]);
        panel.add(numberedButtons[2]);
        panel.add(numberedButtons[3]);
        panel.add(addButton);
        panel.add(numberedButtons[4]);
        panel.add(numberedButtons[5]);
        panel.add(numberedButtons[6]);
        panel.add(subButton);
        panel.add(numberedButtons[7]);
        panel.add(numberedButtons[8]);
        panel.add(numberedButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberedButtons[0]);
        panel.add(divButton);
        panel.add(eqlButton);
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Calculator calc=new Calculator();
    }
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource()==numberedButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }}
        if(e.getSource()==decButton){
            textfield.setText(textfield.getText().concat("."));
        }if(e.getSource()==addButton){
           num1=Double.parseDouble(textfield.getText());
           operator='+';
           textfield.setText("");
        }if(e.getSource()==subButton){
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }if(e.getSource()==mulButton){
            num1=Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }if(e.getSource()==divButton){
            num1=Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }if(e.getSource()==clrButton){
            textfield.setText("");
        }if(e.getSource()==eqlButton){
            num2=Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=(num1/num2);
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }if(e.getSource()==delButton){
            String string=textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }if(e.getSource()==negButton){
            double temp=Double.parseDouble(textfield.getText());
            
            
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }


        
    }

    
    
}
