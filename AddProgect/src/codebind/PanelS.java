package codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PanelS extends JFrame {
    Connection con = null;

    double true_false;
    JTextField jTextFields;

    private JPanel PanelS;
    private JButton buttonBack;
    private JButton buttonEnter;

    private JTextField numberOwners;
    private JTextField enginePower;
    private JTextField Transmission;
    private JTextField capacityEngine;
    private JTextField yearRelese;
    private JTextField countryManufacture;
    private JTextField brandCar;
    private JTextField Manufacture;
    private JTextField typeBody;
    private JTextField Mileage;
    private JTextField Price;
    private JTextField nameOwner;
    private JTextField numberPhone;

    public PanelS() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(PanelS);
        setVisible(true);


        buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JTextField[] textField = {Manufacture, brandCar, countryManufacture, yearRelese, capacityEngine,
                            Transmission, enginePower, numberPhone, typeBody, Mileage, Price, numberOwners, nameOwner,
                            numberPhone};
                    true_false = 1;
                    for (int i = 0; i < textField.length; i++) {
                        jTextFields = textField[i];
                        String textValue = jTextFields.getText().trim();
                        if (textValue.length() == 0) {
                            jTextFields.setBackground(Color.RED);
                            true_false = 0;
                        }
                        if (textValue.length() != 0) {
                            jTextFields.setBackground(Color.white);
                            true_false = 0;
                        }
                    }

                    if (true_false == 1) {
                        for (int i = 0; i < textField.length; i++) {
                            jTextFields = textField[i];
                            String textValue = jTextFields.getText().trim();
                            if (textValue.length() != 0) {
                                jTextFields.setBackground(Color.white);
                                true_false = 0;
                            }
                        }

                        String URL = "jdbc:mysql://localhost:3308/buycar";
                        String USER = "root";
                        String PASSWORD = "root";

                        Class.forName("com.mysql.cj.jdbc.Driver");

                        con = DriverManager.getConnection(URL, USER, PASSWORD);


                        PreparedStatement statement = con.prepareStatement("INSERT INTO carbuy (Производитель," +
                                "Марка_авто, Страна_производства, Год_выпуска, Объем_двигателя, КПП, Мощность_двигателя," +
                                "Количество_собственников, Тип_кузова, Пробег, Цена, Имя_владельца, Номер_телефона)" +
                                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

                        statement.setString(1, Manufacture.getText());
                        statement.setString(2, brandCar.getText());
                        statement.setString(3, countryManufacture.getText());
                        statement.setString(4, yearRelese.getText());
                        statement.setString(5, capacityEngine.getText());
                        statement.setString(6, Transmission.getText());
                        statement.setString(7, enginePower.getText());
                        statement.setString(8, numberOwners.getText());
                        statement.setString(9, typeBody.getText());
                        statement.setString(10, Mileage.getText());
                        statement.setString(11, Price.getText());
                        statement.setString(12, nameOwner.getText());
                        statement.setString(13, numberPhone.getText());

                        statement.executeUpdate();

                        Manufacture.setText("");
                        brandCar.setText("");
                        countryManufacture.setText("");
                        yearRelese.setText("");
                        capacityEngine.setText("");
                        Transmission.setText("");
                        enginePower.setText("");
                        numberOwners.setText("");
                        typeBody.setText("");
                        Mileage.setText("");
                        Price.setText("");
                        nameOwner.setText("");
                        numberPhone.setText("");

                        JOptionPane.showMessageDialog(null, "Ваше объявление подано");
                    } else {
                        true_false = 1;
                        JOptionPane.showMessageDialog(null, "Вы заполнили не все данные. Проверьте!");
                        return;
                    }
                } catch (Exception ex){
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
