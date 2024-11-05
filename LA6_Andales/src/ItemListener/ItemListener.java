package ItemListener;

import FoodOrderingSystem.FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ItemListener extends JFrame{
    private JCheckBox cCheckBox;
    private JCheckBox cppCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox javaCheckBox;
    private JCheckBox pythonCheckBox;
    private JComboBox proficiencyComboBox;
    private JLabel Label;
    private JLabel Label2;
    private JLabel proficiencyLabel;
    private JPanel pMain;
    private JLabel languageLabel;
    private Set<String> selectedLanguage = new LinkedHashSet<>();
    private JCheckBox[] languages = {cCheckBox,cppCheckBox,cSharpCheckBox,javaCheckBox,pythonCheckBox};
    public static void main(String[] args) {
        ItemListener app = new ItemListener();
        app.setTitle("Item Listener");
        app.setContentPane(app.pMain);
        app.setSize(350,400);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    ItemListener(){
        for(JCheckBox cb : languages){
            addCheckBoxListener(cb,cb.getText());
        }
        proficiencyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String)proficiencyComboBox.getSelectedItem();
                proficiencyLabel.setText("Proficiency: "+selected);
            }
        });
    }

    private void addCheckBoxListener(JCheckBox cb, String text) {
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb.isSelected()){
                    selectedLanguage.add(text);
                }
                else {
                    selectedLanguage.remove(text);
                }
                updateLabel();
            }
        });
    }

    private void updateLabel() {
        String myLang = String.join(", ",selectedLanguage);
        languageLabel.setText("My Favorite Languages: "+myLang);
    }
}
