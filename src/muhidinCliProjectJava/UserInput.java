package muhidinCliProjectJava;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInput {

    public static void main(String args[]){
        action();

    }

    public static void action() {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button1 = new JButton("SEND INFO");
        JTextField text= new JTextField(10);
        JPanel panel = new JPanel();
        final String[] userInput = new String[1];
        String a = text.getText();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b;
                userInput[0] = text.getText();
                System.out.println(userInput[0]);

            }
        });
        panel.add(text);
        panel.add(button1);
        frame.getContentPane().add(BorderLayout.SOUTH,panel);
        frame.setVisible(true);
    }
}
