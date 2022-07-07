//set global time_zone = '-3:00'
package codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Interface extends JFrame {
    public JPanel PanelMain;
    private JButton buyerButton;
    private JButton sellerButton;
    private JButton buttonExit;
    private JButton adminPanel;

    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3308/buycar";
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try{
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }


    public Interface() {
        buyerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame PanelB = new PanelB();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                PanelB.setSize(1500,700);
                PanelB.setResizable(false);
                PanelB.setLocationRelativeTo(null);
            }
        });
        sellerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame PanelS = new PanelS();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                PanelS.setSize(1000,2000);
                PanelS.setResizable(false);
                PanelS.setLocationRelativeTo(null);
            }
        });
        adminPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame LoginPanel = new LoginPanel();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                LoginPanel.setSize(500,200);
                LoginPanel.setResizable(false);
                LoginPanel.setLocationRelativeTo (null);
                LoginPanel.setVisible(true);

            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        JFrame panel = new JFrame("CarBuy");
        panel.setContentPane(new Interface().PanelMain);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(500,150);
        panel.setResizable(false);
        panel.setLocationRelativeTo (null);
        panel.setVisible(true);
    }
}
