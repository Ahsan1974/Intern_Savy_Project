package com.company1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task1 extends JFrame implements ActionListener {
    private Container container;
    private JLabel TemperatureConverter;
    private JLabel Input;
    private JTextField Temperature;
    private JButton CtoF;
    private JButton FtoC;
    private JTextField Output;
    private JLabel YourResult;
    public Task1(){
        setTitle("Temperature Convertor");
        setBounds(500,200,400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        container=getContentPane();
        container.setLayout(null);

        TemperatureConverter = new JLabel("Temperature Convertor");
        TemperatureConverter.setFont(new Font("Arial", Font.PLAIN, 20));
        TemperatureConverter.setSize(300, 22);
        TemperatureConverter.setLocation(110, 30);
        container.add(TemperatureConverter);

        Input=new JLabel("Input Temperature");
        Input.setFont(new Font("Arial", Font.PLAIN, 15));
        Input.setSize(300, 20);
        Input.setLocation(140, 90);
        container.add(Input);

        Temperature=new JTextField();
        Temperature.setFont(new Font("Arial", Font.PLAIN, 15));
        Temperature.setSize(150, 20);
        Temperature.setLocation(135, 130);
        container.add(Temperature);

        CtoF=new JButton(" C to F");
        CtoF.setFont(new Font("Arial", Font.PLAIN, 15));
        CtoF.setSize(90, 20);
        CtoF.setLocation(110, 280);
        CtoF.setFocusable(true);
        CtoF.addActionListener(this);
        container.add(CtoF);

        FtoC=new JButton(" F to C");
        FtoC.setFont(new Font("Arial", Font.PLAIN, 15));
        FtoC.setSize(90, 20);
        FtoC.setLocation(220, 280);
        FtoC.setFocusable(true);
        FtoC.addActionListener(this);
        container.add(FtoC);

        YourResult=new JLabel("Your Result");
        YourResult.setFont(new Font("Arial", Font.PLAIN, 15));
        YourResult.setSize(300, 20);
        YourResult.setLocation(140, 180);
        container.add(YourResult);

        Output=new JTextField();
        Output.setFont(new Font("Arial", Font.PLAIN, 15));
        Output.setSize(150, 20);
        Output.setLocation(135, 220);
        container.add(Output);

        setVisible(true);

    }

    public static void main(String[] args) {
        Task1 convertor=new Task1();




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==CtoF){
            try {
                double celsius = Double.parseDouble(Temperature.getText());
                double fahrenheit = (celsius * 9 / 5) + 32;
                String format=String.format("%.2f",fahrenheit);
                Output.setText(format + "°F");
            }catch (NumberFormatException number){
                Output.setText("Invalid Input");
            }
        } else if (e.getSource()==FtoC) {
            try {
                double fahrenheit = Double.parseDouble(Temperature.getText());
                double celsius = (fahrenheit - 32) * 5 / 9;
                String format=String.format("%.2f",celsius);
                Output.setText(format + "°C");
            } catch (NumberFormatException number) {
                Output.setText("Invalid input");
            }
        }

    }
}
