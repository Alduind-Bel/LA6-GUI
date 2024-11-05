package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class SimpleCalculator extends JFrame{
    private JPanel pMain;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JTextField lblResult;

    public static void main(String[] args) {
        SimpleCalculator app = new SimpleCalculator();
        app.setContentPane(app.pMain);
        app.setSize(650,200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    SimpleCalculator(){
        tfNumber1.setHorizontalAlignment(JTextField.CENTER);
        tfNumber2.setHorizontalAlignment(JTextField.CENTER);
        lblResult.setHorizontalAlignment(JTextField.CENTER);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int a = Integer.parseInt(tfNumber1.getText());
                    int b = Integer.parseInt(tfNumber2.getText());
                    if(cbOperations.getSelectedIndex() == 0){
                        lblResult.setText(String.valueOf(a+b));
                    }
                    if(cbOperations.getSelectedIndex() == 1){
                        lblResult.setText(String.valueOf(a-b));
                    }
                    if(cbOperations.getSelectedIndex() == 2){
                        lblResult.setText(String.valueOf(a*b));
                    }
                    if(cbOperations.getSelectedIndex() == 3){
                        lblResult.setText(String.valueOf(a/b));
                    }
                }catch (InputMismatchException err){
                    tfNumber1.setText("");
                    tfNumber2.setText("");
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }
}
