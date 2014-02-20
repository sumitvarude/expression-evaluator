
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class temp extends JFrame {
    public temp() {
        createUI();
    }

    private void createUI() {
        final TextArea textBox = new TextArea(1, 60);
        JButton answerJButton = new JButton("Show Answer");

        answerJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String exp = textBox.getText();
            }
        });
        add(textBox);
        JPanel pa = new JPanel();
        pa.setVisible(true);
        pa.setSize(100, 100);
        pa.setBackground(Color.RED);
        add(pa);
        java.util.List<JButton> numberJButtons = new ArrayList();

//        for (int i = 0; i < 10; i++) {
//            final JButton num = new JButton("" + i);
//            numberJButtons.add(num);
//            add(numberJButtons.get(i));
//        }

        final JButton power = new JButton("^");
        final JButton divide = new JButton("/");
        final JButton multiply = new JButton("*");
        final JButton subtract = new JButton("-");
        final JButton add = new JButton("+");
        numberJButtons.add(add);
        numberJButtons.add(subtract);
        numberJButtons.add(multiply);
        numberJButtons.add(divide);
        numberJButtons.add(power);
        add(add);
        add(subtract);
        add(multiply);
        add(divide);
        add(power);


        for (final JButton numberJButton : numberJButtons) {
            numberJButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    textBox.setText(textBox.getText() + numberJButton.getLabel());
                }
            });
        }

        add(answerJButton);

        setTitle("Calculator");
        setSize(500, 600);
        setLayout(new GridLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                temp calc = new temp();
                calc.setVisible(true);
            }
        });
    }
}

