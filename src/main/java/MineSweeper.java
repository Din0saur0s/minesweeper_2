import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import sweeper.Box;
import sweeper.Coordinate;
import sweeper.Game;
import sweeper.Menu;
import sweeper.Ranges;

public class MineSweeper extends JFrame
{
    private Game game;


    private JPanel panel;

    private JLabel label;
    private final int colons=9;
    private final int rows=9;
    private final int image_size=50;
    private final int bombs=10;

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Код, который нужно выполнить при нажатии
            Menu Menu = new Menu();
            Menu.pack();
            Menu.setVisible(true);

            // game.start();
            // panel.repaint();
        }
    }

    public static void main(String[] args)
    {
        new MineSweeper();
    }

    private  MineSweeper()
    {
        game = new Game(colons,rows, bombs);
        game.start();
        //Ranges.setSize(new Coordinate(colons,rows));
        setImages();
        initLabel();
        initPanel();
        initFrame();




    }

    private void initLabel()
    {
        label = new JLabel("Welcome!");
        add(label, BorderLayout.SOUTH);
    };

    private void initPanel()
    {
        JButton b=new JButton("Меню /   Новая игра"){};
        //b.setBounds(0,rows*image_size+20,95,20);
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coordinate coord : Ranges.getAllCords())
                {
                    // Coordinate coord = new Coordinate(box.ordinal()*image_size,0);

                    g.drawImage((Image)game.getBox(coord).image,coord.x*image_size,coord.y*image_size,this);
                }

            }

        };
        panel.setLayout(new BorderLayout());
        panel.add(b, BorderLayout.SOUTH);


        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                int x = e.getX()/image_size;
                int y = e.getY()/image_size;
                Coordinate coord = new Coordinate(x,y);
                if (e.getButton()==MouseEvent.BUTTON1)
                    game.pressedLeftButton(coord);
                if (e.getButton()==MouseEvent.BUTTON3)
                    game.pressedRightButton(coord);
                label.setText(getMessage());
                panel.repaint();

            }

        });

        ActionListener actionListener = new TestActionListener();
        b.addActionListener(actionListener);

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x*image_size,
                Ranges.getSize().y*image_size+25));

        add(panel);

        Menu menu = new Menu();

    }

    private String getMessage() {
        switch (game.getState())
        {
            case PLAYED: return "Игра идёт";
            case BOMBED: return "YOU DIED";
            case WINNER: return "Победа!";
            default: return "Welcome.";

        }
    }

    private void initFrame()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Сапёр");
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
        setLocationRelativeTo(null);

    }



    private void setImages()
    {
        for (Box box: Box.values())
            box.image = getImage(box.name());
    }

    private Image getImage(String name)
    {
        String filename = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();

    }

}
