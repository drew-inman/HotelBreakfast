package hotelbreakfast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class HotelBreakfast extends JFrame implements ActionListener, ItemListener, MouseListener{
    
    JTextArea itemDesc, orderDesc, mouseInfo;
    JTextField grandTotal;
    JCheckBox cb1, cb2, cb3;
    JButton submit;
    
    String total = "Total: ";
    String pancake = "Pancakes";
    String tremTwelve = "Trmds 12";
    String burger = "Burger";
    
    double pancakePrice = 7.99;
    double tremTwelvePrice = 12.00;
    double burgerPrice = 10.99;
    
    double totalCost;
    
    DecimalFormat df = new DecimalFormat("#.00");
    
    //Constuctor
    
    public HotelBreakfast(){
        super("Welcome to Hotel California! It's such a lovely place... with a lovely breakfast selection!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,896,504);
        breakfastItems();
        breakfastItemDescriptions();
        currentOrder();
        hitSubmit();
        mouseInfo();
        setVisible(true);
        addMouseListener(this);
    }
    
    //The different parts of the JFrame (In BorderLayout)
    //There should be five methods for each of the five different parts of BorderLayout
    
    public void breakfastItems(){
        JPanel breakfastPanel = new JPanel();
        
        cb1 = new JCheckBox("An Infinite Amount of Endlessly Unlimited Pancakes");
        cb2 = new JCheckBox("The Tremendous Twelve Hundred");
        cb3 = new JCheckBox("The Ultra Definitive Ultimate Brunch Burger");
        breakfastPanel.add(cb1);
        breakfastPanel.add(cb2);
        breakfastPanel.add(cb3);
        
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        getContentPane().add(breakfastPanel,BorderLayout.NORTH);
    }
    public void breakfastItemDescriptions(){
        itemDesc = new JTextArea("Item Price and Description",10,20);
        JScrollPane scrollPane = new JScrollPane(itemDesc);
        JPanel itemDescArea = new JPanel();
        
        itemDesc.setLineWrap(true);
        itemDesc.setWrapStyleWord(true);
                
        add(scrollPane);
        itemDescArea.add(scrollPane);
        getContentPane().add(itemDesc,BorderLayout.WEST);
    }
    public void currentOrder(){
        orderDesc = new JTextArea("===========ORDER===========\n",23,20);
        grandTotal = new JTextField(total+" $"+totalCost,20);
        JScrollPane scrollPane = new JScrollPane(orderDesc);
        JPanel orderDescArea = new JPanel();
        
        orderDescArea.setLayout(new BoxLayout(orderDescArea,BoxLayout.Y_AXIS));
        orderDescArea.add(scrollPane);
        orderDescArea.add(grandTotal);
        getContentPane().add(orderDescArea,BorderLayout.EAST);
    }
    public void hitSubmit(){
        submit = new JButton("Submit");
        submit.addActionListener(this);
        add(submit);
        getContentPane().add(submit,BorderLayout.SOUTH);
    }
    public void mouseInfo(){
        mouseInfo = new JTextArea("Mouse Detection!\n",23,30);
        JScrollPane mouseInfoScrollPane = new JScrollPane(mouseInfo);
        JPanel mouseInfoPanel = new JPanel();
        
        mouseInfoPanel.add(mouseInfoScrollPane);
        getContentPane().add(mouseInfoPanel,BorderLayout.CENTER);
    }
    
    //The ordering methods
    
    public void orderPancakes(){
        orderDesc.append(pancake+" @$7.99\n");
        totalCost = (totalCost+pancakePrice);
        grandTotal.setText(total+" $"+df.format(totalCost));
    }
    public void orderTwelve(){
        orderDesc.append(tremTwelve+" @$12.00\n");
        totalCost = (totalCost+tremTwelvePrice);
        grandTotal.setText(total+" $"+df.format(totalCost));
    }
    public void orderBurger(){
        orderDesc.append(burger+" @$10.99\n");
        totalCost = (totalCost+burgerPrice);
        grandTotal.setText(total+" $"+df.format(totalCost));
    }
    
    //actionPerformed, itemStateChanged and mouseEvents are below here
    
    public void actionPerformed(ActionEvent ae){
        Object obj = ae.getSource();
        
        if(obj==submit){
            if(cb1.isSelected()){
                orderPancakes();
            }
            if(cb2.isSelected()){
                orderTwelve();
            }
            if(cb3.isSelected()){
                orderBurger();
            }
        }
    }
    public void itemStateChanged(ItemEvent ie){
        Object obj = ie.getSource();
        
        if(obj==cb1 && cb1.isSelected()){
            itemDesc.setText("Price: $7.99\n\n"
                + "A Hotel California classic!\n"
                + "Enjoy the light, fluffy, deliciousness that has been a winner with all of our guests for years! "
                + "Experience as many pancakes as you've ever seen in your life, multiplied by infinity. "
                + "In layman's terms, it's unlimited pancakes, brought directly to you as long as you can eat them.");
        }
        if(obj==cb2 && cb2.isSelected()){
            itemDesc.setText("Price: $12.00\n\n"
                + "Definitely not stolen from Perkin's!\n"
                + "They have only twelve things. We have TWELVE HUNDRED! "
                + "It's perfect for a very large party or for one EXTREMELY hungry person! "
                + "Choose 1,200 items from any combination of the protein, fruit, vegetable, dairy or grain categories. "
                + "You're guaranteed to be full and to have many leftovers for a long time. "
                + "That's a freakin' steal!\n\n\n\n\n\n"
                + "..but really though, it's got like 1,200,000 calories. Yikes!");
        }
        if(obj==cb3 && cb3.isSelected()){
            itemDesc.setText("Price: $10.99\n\n"
                    + "Have you ever had breakfast and lunch COMBINED?\n"
                    + "Have you ever had it combined into a BURGER??? "
                    + "You will now!"
                    + "It's got any combination of (up to eight) choices including "
                    + "bacon, eggs, cereal, oatmeal, hashbrowns, a burger, lunch meat, leftovers from last night, cheese, fast food, "
                    + "or, anything else you can name that you'd eat for lunch!"
                    + "It's so insanely popular that the pancakes aren't selling that well anymore."
                    + "I guess you could say that they're selling like hotcakes ;)");
        }
    }
    public void mousePressed(MouseEvent me){
        mouseInfo.append("The mouse has been pressed. (mousePressed)"+"\n");
    }
    public void mouseReleased(MouseEvent me){
        mouseInfo.append("The mouse has been released. (mouseReleased)"+"\n");
    }
    public void mouseEntered(MouseEvent me){
        mouseInfo.append("The mouse has entered. (mouseEntered)"+"\n");
    }
    public void mouseExited(MouseEvent me){
        mouseInfo.append("The mouse has exited. (mouseExited)"+"\n");
    }
    public void mouseClicked(MouseEvent me){
        mouseInfo.append("The mouse has been clicked. (mouseClicked)"+"\n");
    }
}