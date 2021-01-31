package ru.vlad.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppWindow {
    private JTextField surname;
    private JTextField name;
    private JTextField data;
    private JTextField numberLesson;
    private JTextField klass;
    private JTextField numberPK;
    private JTextField pK;

    private final JPanel jPanel = new JPanel();
    private final JFrame jFrame = new JFrame();

    private JButton button = new JButton("Сохранить");
    private Toolkit toolkit;

    private String path;
    private String text;

    private final String[] s = {"Фамилия:", "Имя:", "Дата:", "Номер урока:",
            "Класс:", "Номер ПК: ", "Примечание к пк: "};

    private final String[] d = {"По образцу: Краснов", "По образцу: Иван",
            "По образцу: 17.08.2014", "По образцу: 2", "По образцу: 8А", "По образцу: 12"};

    private int f = 20;
    private int i = 20;

    public void frameJ() {
        jFrame.add(jPanel);
        jFrame.setTitle("Регистрация пользователя");
        toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 600);
        jPanel.setLayout(null);
    }

    public void jLabelLeft() {
        for (String value : s) {
            JLabel jLabels = new JLabel(value);
            jLabels.setBounds(6, i, 120, 20);
            jPanel.add(jLabels);
            i += 40;
        }
    }

    public void jLabelRight() {
        for (String s1 : d) {
            JLabel jLabeled = new JLabel(s1);
            jLabeled.setBounds(290, f, 200, 20);
            jPanel.add(jLabeled);
            f += 40;
        }
    }

    public void jTextFieldSurname() {
        surname = new JTextField(140);
        surname.setBounds(135, 20, 150, 20);
        jPanel.add(surname);

        name = new JTextField(140);
        name.setBounds(135, 60, 150, 20);
        jPanel.add(name);

        data = new JTextField(140);
        data.setBounds(135, 100, 150, 20);
        jPanel.add(data);

        numberLesson = new JTextField(140);
        numberLesson.setBounds(135, 140, 150, 20);
        jPanel.add(numberLesson);

        klass = new JTextField(140);
        klass.setBounds(135, 180, 150, 20);
        jPanel.add(klass);

        numberPK = new JTextField(140);
        numberPK.setBounds(135, 220, 150, 20);
        jPanel.add(numberPK);

        pK = new JTextField(140);
        pK.setBounds(135, 260, 150, 20);
        jPanel.add(pK);
    }


    public void setButton() {
        button.setBounds(250, 500, 100, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = surname.getText() + "\n" + name.getText() + "\n" + data.getText() +
                        "\n" + numberLesson.getText() + "\n" + klass.getText() +
                        "\n" + numberPK.getText() + "\n" + pK.getText();

                path = "E:/Vlad/" + data.getText() + "/" + numberLesson.getText()
                        + "/" + klass.getText() + "/" + numberPK.getText() + "/" + surname.getText() +
                        " " + name.getText();

                new File(path).mkdirs();

                File name = new File(path + "/" + surname.getText() + ".txt");
                try (FileWriter fileWrite = new FileWriter(name)) {
                    BufferedWriter bufferWriter = new BufferedWriter(fileWrite);
                    bufferWriter.write(text);
                    bufferWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        jPanel.add(button);
    }

    public void getVisible() {
        jFrame.setVisible(true);
    }
}

