package sweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame
{
    public Menu() {
        setTitle("Меню");
        setResizable(false);
        setVisible(false);
        setSize(200, 250);
        setLocationRelativeTo(null);
        Panel pnl = new Panel();          // Panel is a container
        GridLayout experimentLayout = new GridLayout(5, 1);
        pnl.setLayout(experimentLayout);


        Button btn = new Button("Таблица рекордов");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Records records = new Records();
                records.pack();
                records.setVisible(true);
            }
        });
        pnl.add(btn);



        add(pnl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }
}
