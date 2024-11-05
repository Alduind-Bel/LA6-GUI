package MostFrequentChar;


import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentChar extends JFrame{
    private JPanel pMain;
    private JTextArea textArea;
    private JLabel frequentCharLabel;

    public static void main(String[] args) {
        MostFrequentChar app = new MostFrequentChar();
        app.setContentPane(app.pMain);
        app.setSize(300,200);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Most Frequent Character");
        app.setVisible(true);
    }
    MostFrequentChar(){
        textArea.addCaretListener(e -> updateRecentFrequentChar());
    }

    private void updateRecentFrequentChar() {
        String text = textArea.getText();
        if (text.isEmpty()) {
            frequentCharLabel.setText("Most Frequent Character: ");
            return;
        }

        // Find the most frequent character
        char mostFrequent = findMostFrequentChar(text);
        frequentCharLabel.setText("Most Frequent Character: " + mostFrequent);
    }

    private char findMostFrequentChar(String text) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count occurrences of each character
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                continue; // Ignore spaces
            }
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Find the character with the maximum frequency
        char mostFrequentChar = text.charAt(0);
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentChar;
    }

}
