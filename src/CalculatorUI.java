import sumitvar.evaluator.lib.Expression;
import sumitvar.evaluator.lib.Parser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class CalculatorUI extends JFrame {
    public CalculatorUI() {
        createUI();
    }

    private void createUI() {
        final TextArea textBox = new TextArea(1, 60);
        JButton answerJButton = new JButton("Show Answer");

        answerJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String exp = textBox.getText();
                Parser parser = new Parser(exp.trim());
                Expression expression = parser.giveExpression();
                textBox.setText(String.valueOf(expression.evaluate()));
            }
        });
        add(textBox);

        List<JButton> numberJButtons = new ArrayList();

        for (int i = 0; i < 10; i++) {
            final JButton num = new JButton("" + i);
            numberJButtons.add(num);
            add(numberJButtons.get(i));
        }

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
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
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

