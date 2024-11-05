package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class LeapYearChecker extends JFrame{
    private JTextField tfYear;
    private JButton btnCheckYear;
    private JPanel pMain;

    public static void main(String[] args) {
        LeapYearChecker app = new LeapYearChecker();
        app.setContentPane(app.pMain);
        app.setSize(250,200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
        LeapYearChecker(){
            btnCheckYear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int year = Integer.parseInt(tfYear.getText());
                        if(year % 4 == 0){
                            if(year % 100 != 0){
                                tfYear.setText("");
                                JOptionPane.showMessageDialog(null, "Leap year");
                            } else if (year % 100 == 0 && year % 400 == 0) {
                                tfYear.setText("");
                                JOptionPane.showMessageDialog(null, "Leap year");
                            }
                            else{
                                tfYear.setText("");
                                JOptionPane.showMessageDialog(null, "Not a leap year");
                            }
                        }
                        else{
                            tfYear.setText("");
                            JOptionPane.showMessageDialog(null, "Not a leap year");
                        }
                    }catch(InputMismatchException er){
                        tfYear.setText("");
                        JOptionPane.showMessageDialog(null, "Invalid Input");
                    }
                }
            });
        }
}
