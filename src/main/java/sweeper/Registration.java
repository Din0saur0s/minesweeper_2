package sweeper;

import org.json.JSONObject;
import org.json.simple.JSONArray;

//import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Registration extends JFrame {

    Flag flag = new Flag();


    public JTextField name;

    public Registration() {
        setTitle("Регистрация");
        setResizable(false);
        setVisible(false);

        //JLabel label = new JLabel("Welcome!");

        setSize(400, 500);
        Button btn = new Button("Отправить");

        Panel pnl = new Panel();          // Panel is a container
        GridLayout experimentLayout = new GridLayout(5, 1);
        pnl.setLayout(experimentLayout);
        name = new JTextField("Имя");
        pnl.add(new JLabel("Введите ваше имя:"));
        pnl.add(name);
        pnl.add(new JLabel("Набранные очки:"));
        String rec = points(flag.countOfClosedBoxes);
        pnl.add(new JLabel(rec));

        pnl.add(btn);
        add(pnl);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = name.getText();
                writeToRecords(textFieldValue, rec);
            }
        });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);



    }


    void writeToRecords(String name, String rec) {
        JSONObject players = new JSONObject();
        players.put("firstName", name);
        players.put("records", rec);
        JSONObject player = new JSONObject();
        player.put("player", players);

        JSONArray playerList = new JSONArray();
        playerList.add(player);

        try (FileWriter file = new FileWriter("G://records.json",true)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(playerList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String points(int closedBoxes)
    {
        //this.boxes=
        int result=0;
        result=81-closedBoxes+10;
        //result=closedBoxes;
        String res = Integer.toString(result);
        return res;
        // int max = flag.
        //flag.getCountOfClosedBoxes();
    }

    // public class TestActionListener implements ActionListener {
    // public void actionPerformed(ActionEvent e) {
    //Код, который нужно выполнить при нажатии


    //Menu Menu = new Menu();
    //Menu.pack();
    //Menu.setVisible(true);
}


