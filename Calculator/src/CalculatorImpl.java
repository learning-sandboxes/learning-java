import java.util.ArrayList;
import java.util.Stack;

/**
 * Calculator implementation
 */
public class CalculatorImpl implements Calculator {
    private int priority(char op) {
        if ("*/".indexOf(op) >= 0) {
            return 3;
        }
        if ("+-".indexOf(op) >= 0) {
            return 2;
        }
        if ("(".indexOf(op) >= 0) {
            return 1;
        }
        return -1;
    }


    public String evaluate(String text) {
        ArrayList<String> actions = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        String number = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c) || (c == '.')) {
                number += c;
            } else {
                if (!number.isEmpty()) {
                    actions.add(number);
                    number = "";
                }
                int prio = this.priority(c);
                if ("+-*/".indexOf(c) >= 0) {
                    if (stack.empty() || (this.priority(stack.peek().charAt(0)) < prio)) {
                        stack.push(String.valueOf(c));
                    } else {
                        while (!stack.empty()) {
                            actions.add(stack.pop());
                        }

                        stack.push(String.valueOf(c));
                    }
                } else {
                    if (c == '(') {
                        stack.push(String.valueOf(c));
                    } else {
                        if (c == ')') {
                            while (!stack.isEmpty() && (stack.peek().charAt(0) != '(')) {
                                actions.add(stack.pop());
                            }
                            if (stack.isEmpty()) {
                                return null;
                            }

                            stack.pop();
                        } else {
                            return null;
                        }
                    }
                }
            }
        }
        if (!number.isEmpty()) {
            actions.add(number);
        }
        while (!stack.empty()) {
            actions.add(stack.pop());
        }
        try {
            for (String s : actions) {
                if ("+-*/".contains(s)) {
                    double n2 = Double.parseDouble(stack.pop());
                    double n1 = Double.parseDouble(stack.pop());
                    switch (s.charAt(0)) {
                        case '+':
                            stack.push(Double.toString(n1 + n2));
                            break;
                        case '-':
                            stack.push(Double.toString(n1 - n2));
                            break;
                        case '*':
                            stack.push(Double.toString(n1 * n2));
                            break;
                        case '/':
                            stack.push(Double.toString(n1 / n2));
                            break;
                        default:
                            return null;
                    }
                } else {
                    stack.push(s);
                }
            }
            return String.format("%.4f", Double.parseDouble(stack.pop()));
        } catch (Exception e) {
            return null;
        }
    }
}
