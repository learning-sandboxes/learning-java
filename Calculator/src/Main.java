import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Dmitry
 * Date: 17.06.12
 * Time: 4:46
 * To change this template use File | Settings | File Templates.
 */
public class Main implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField expression;
    JLabel result;
    public static void main(String[] args) {
        new Main();
    }
    public Main() {
        frame = new JFrame("The calculator");
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        expression = new JTextField();
        panel.add(expression);
        JButton calc = new JButton("Calculate");
        panel.add(calc);
        calc.addActionListener(this);
        result = new JLabel();
        panel.add(result);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculator c = new CalculatorImpl();
        result.setText(c.evaluate(expression.getText()));
        Subsequence s = new SubsequenceImpl();
        System.out.println(s.find(Arrays.asList("A", "B", "C", "D"), Arrays.asList("BD", "A", "ABC", "B", "M", "D", "M", "C", "DC", "D")));

    }
}
