package sweeper;

public class Game
{
    private Bomb bomb ;
    private Flag flag;
    private GameState state;

    public GameState getState() {
        return state;
    }

    public Game(int colons , int rows, int bombs)
    {
        Ranges.setSize(new Coordinate(colons,rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start()
    {
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    };

    public Box getBox(Coordinate coord)
    {
        if (flag.get(coord) == Box.OPENED)
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    public void pressedLeftButton(Coordinate coord)
    {
        //flag.setOpenedToBox(coord);
        if (gameOver()) return;
        openBox(coord);
        checkWinner();
    }

    private void checkWinner()
    {
        if (state==GameState.PLAYED)
            if (flag.getCountOfClosedBoxes()== bomb.getTotalBombs())
                state = GameState.WINNER;
    }

    private void openBox(Coordinate coord)
    {
        switch (flag.get(coord))
        {
            case OPENED : setOpenedToClosedBoxesAroundNumber(coord); return;
            case FLAGED : return;
            case CLOSED :
                switch (bomb.get(coord))
                {
                    case ZERO : openBoxesAround(coord); return;
                    case BOMB : openBombs(coord); return;
                    default : flag.setOpenedToBox(coord); return;
                }
        }
    }

    private void setOpenedToClosedBoxesAroundNumber(Coordinate coord)
    {
        if (bomb.get(coord)!=Box.BOMB)
            if (flag.getCountOfFlagedBoxesAround(coord) == bomb.get(coord).getNumber())
                for (Coordinate around: Ranges.getCoordsAround(coord))
                    if (flag.get(around)==Box.CLOSED)
                        openBox(around);


    }

    private void openBombs(Coordinate bombed)
    {
        state = GameState.BOMBED;
        flag.setBombedToBox(bombed);
        for (Coordinate coord: Ranges.getAllCords())
            if (bomb.get(coord)==Box.BOMB)
                flag.setOpenedToClosedBombBox(coord);
            else
                flag.setNoBombToFlagedSafeBox(coord);
        Registration Registration = new Registration();
        Registration.pack();
        Registration.setVisible(true);
    }

    private void openBoxesAround(Coordinate coord)
    {
        flag.setOpenedToBox(coord);
        for (Coordinate around: Ranges.getCoordsAround(coord))
            openBox(around);
    }

    public void pressedRightButton(Coordinate coord)
    {
        if (gameOver()) return;
        flag.toggleFlagedToBox(coord);
    }

    private boolean gameOver()
    {
        if (state==GameState.PLAYED)
            return false;
        // —ﬁƒ¿ ¬—“¿¬»“‹ Ã≈Õﬁ
        start();
        return true;

    }
}
