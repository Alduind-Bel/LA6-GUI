package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class SimpleCalculator extends JFrame{
    private JPanel pMain;
    private JTextField tfIn1;
    private JComboBox cbOps;
    private JTextField tfIn2;
    private JButton btnCompute;
    private JTextField tfRes;

    public static void main(String[] args) {
        SimpleCalculator app = new SimpleCalculator();
        app.setContentPane(app.pMain);
        app.setSize(650,200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    SimpleCalculator(){
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int a = Integer.parseInt(tfIn1.getText());
                    int b = Integer.parseInt(tfIn2.getText());
                    if(cbOps.getSelectedIndex() == 0){
                        tfRes.setText(String.valueOf(a+b));
                    }
                    if(cbOps.getSelectedIndex() == 1){
                        tfRes.setText(String.valueOf(a-b));
                    }
                    if(cbOps.getSelectedIndex() == 2){
                        tfRes.setText(String.valueOf(a*b));
                    }
                    if(cbOps.getSelectedIndex() == 3){
                        tfRes.setText(String.valueOf(a/b));
                    }
                }catch (InputMismatchException err){
                    tfIn1.setText("");
                    tfIn2.setText("");
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }
}
