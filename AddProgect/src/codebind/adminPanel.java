package codebind;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adminPanel extends JFrame {
    String textIdCar;

    Connection con = null;
    Connection con1 = null;

    private JPanel adminPanel;
    private JButton delete;
    private JButton back;
    private JTable tableBuyCar;
    private JTextField idCar;

    public adminPanel() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(adminPanel);
        setVisible(true);

        try {
            String URL = "jdbc:mysql://localhost:3308/buycar";
            String USER = "root";
            String PASSWORD = "root";

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement statement = con.prepareStatement("SELECT * FROM carbuy WHERE 1");

            ResultSet rs = statement.executeQuery();
            tableBuyCar.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textIdCar = idCar.getText();

                try {
                    String URL = "jdbc:mysql://localhost:3308/buycar";
                    String USER = "root";
                    String PASSWORD = "root";

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    con1 = DriverManager.getConnection(URL, USER, PASSWORD);

                    PreparedStatement statement = con1.prepareStatement("DELETE FROM carbuy WHERE id = '"+textIdCar+"'");

                    statement.executeUpdate();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }

                try {
                    String URL = "jdbc:mysql://localhost:3308/buycar";
                    String USER = "root";
                    String PASSWORD = "root";

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    con = DriverManager.getConnection(URL, USER, PASSWORD);

                    PreparedStatement statement = con.prepareStatement("SELECT * FROM carbuy WHERE 1");

                    ResultSet rs = statement.executeQuery();
                    tableBuyCar.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}

