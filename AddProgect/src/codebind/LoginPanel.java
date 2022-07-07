package codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginPanel extends JFrame{
    public JPanel LoginPanel;
    private JButton Enter;
    private JButton Back;
    private JTextField loginTextField;
    private JPasswordField passwordField;

    public LoginPanel() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(LoginPanel);
        setVisible(true);

        Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginText;
                char[] passwordText;
                char[] correctPassword = new char[] {'q', 'w', 'e', 'r', 't', 'y'};

                loginText = loginTextField.getText();
                passwordText = passwordField.getPassword();
                passwordField.setEchoChar('*');

                if(loginText.equalsIgnoreCase("admin") && Arrays.equals(passwordText, correctPassword)){
                    dispose();
                    JFrame adminPanel = new adminPanel();
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    adminPanel.setSize(1500,700);
                    adminPanel.setResizable(false);
                    adminPanel.setLocationRelativeTo (null);
                    adminPanel.setVisible(true);
                }else{
                    loginTextField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(null, "Логин или пароль введены неверно");
                }
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
