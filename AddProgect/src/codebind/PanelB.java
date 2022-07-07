package codebind;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PanelB extends JFrame {
    Connection con = null;

    public JPanel PanelB;
    private JButton buttonBack;
    private JTable tableBuyCar;
    private JButton Search;
    private JTextField Manufacture;
    private JTextField yearRelese;
    private JTextField Transmission;
    private JButton allAds;

    String textManufacture;
    String textTransmissin;
    String textyearRelese;

    public PanelB() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(PanelB);
        setVisible(true);


        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textManufacture = Manufacture.getText();
                textTransmissin = Transmission.getText();
                textyearRelese = yearRelese.getText();

                try {
                    String URL = "jdbc:mysql://localhost:3308/buycar";
                    String USER = "root";
                    String PASSWORD = "root";

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    con = DriverManager.getConnection(URL, USER, PASSWORD);

                   PreparedStatement statement = con.prepareStatement("SELECT `Производитель`, `Марка_авто`," +
                            "`Страна_производства`, `Год_выпуска`, `Объем_двигателя`, `КПП`, `Мощность_двигателя`," +
                            "`Количество_собственников`, `Тип_кузова`, `Пробег`, `Цена`, `Имя_владельца`, `Номер_телефона`" +
                            "FROM carbuy WHERE Производитель = '"+textManufacture+"' AND КПП = '"+textTransmissin+"'" +
                           "AND Год_выпуска = '"+textyearRelese+"'");


                    ResultSet rs = statement.executeQuery();
                    tableBuyCar.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        allAds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String URL = "jdbc:mysql://localhost:3308/buycar";
                    String USER = "root";
                    String PASSWORD = "root";

                    Class.forName("com.mysql.cj.jdbc.Driver");

                    con = DriverManager.getConnection(URL, USER, PASSWORD);

                    PreparedStatement statement = con.prepareStatement("SELECT `Производитель`, `Марка_авто`," +
                            "`Страна_производства`, `Год_выпуска`, `Объем_двигателя`, `КПП`, `Мощность_двигателя`," +
                            "`Количество_собственников`, `Тип_кузова`, `Пробег`, `Цена`, `Имя_владельца`, " +
                            "`Номер_телефона` FROM carbuy WHERE 1");

                    ResultSet rs = statement.executeQuery();
                    tableBuyCar.setModel(DbUtils.resultSetToTableModel(rs));

                    tableBuyCar.getColumnModel().getColumn(0).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(1).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(2).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(3).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(4).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(5).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(6).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(7).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(8).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(9).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(10).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(11).setPreferredWidth(300);
                    tableBuyCar.getColumnModel().getColumn(12).setPreferredWidth(300);

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}
