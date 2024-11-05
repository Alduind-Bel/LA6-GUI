package KeyEventActivity;

import javax.swing.*;

public class KeyEventActivity extends JFrame{
    private JTextArea editableTextArea;
    private JTextArea nonEditableTextArea;
    private JPanel pMain;

    public static void main(String[] args) {
        KeyEventActivity app = new KeyEventActivity();
        app.setContentPane(app.pMain);
        app.setSize(500,200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Key Event Class");
        app.setVisible(true);
    }
    KeyEventActivity(){
        editableTextArea.addCaretListener( e -> updateTextArea());
    }
    void updateTextArea(){
        String str = editableTextArea.getText();
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(ch == 'A' || ch == 'a' ||ch == 'E' ||ch == 'e' ||ch == 'I' ||ch == 'i' ||ch == 'O' ||ch == 'o' ||ch == 'U' ||ch == 'u'){
                ch = Character.toUpperCase(ch);
                sb.append(ch);
            }
            else{
                ch  = Character.toLowerCase(ch);
                sb.append(ch);
            }
        }
        nonEditableTextArea.setText(sb.toString());
    }
}
