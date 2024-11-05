package FoodOrderingSystem;

import SimpleCalculator.SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox ctea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    private JPanel pMain;
    private  JCheckBox[] cbOrder = {cPizza,cBurger,cFries,cSoftDrinks, ctea,cSundae};
    private JRadioButton[] rb = {rbNone,rb5,rb10,rb15};
    double[] discs = {0, 0.05, 0.10, 0.15};
    int[] prices = {100, 80, 65, 55, 50, 40};

    public static void main(String[] args) {
        FoodOrderingSystem app = new FoodOrderingSystem();
        app.setContentPane(app.pMain);
        app.setSize(550,400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    FoodOrderingSystem(){
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                int count =  0;
                double disc = 0;
                for(JCheckBox c : cbOrder){
                    if(c.isSelected()){
                        total += prices[count];
                    }
                    count++;
                }
                for(int i = 0; i < 4; i++) {
                    if(rb[i].isSelected()) {
                        disc = discs[i];
                        break;
                    }
                }
                total -= (total * disc);
                JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", total));
            }
        });
    }
}
