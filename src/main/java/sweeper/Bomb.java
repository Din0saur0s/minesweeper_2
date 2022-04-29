package sweeper;

class Bomb
{
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs)
    {
        this.totalBombs=totalBombs;
        fixBombsCount();
    }

    void start()
    {
        bombMap = new Matrix(Box.ZERO);
        for (int i=0; i<totalBombs; i++)
            placeBomb();
    }

    Box get (Coordinate coord)
    {
        return bombMap.get(coord);
    }

    private void fixBombsCount()
    {
        int maxBombs = Ranges.getSize().x*Ranges.getSize().y/2;
        if (totalBombs > maxBombs)
            totalBombs = maxBombs;
    }

    private void placeBomb()
    {
        while (true)
        {
            Coordinate coord = Ranges.getRandomCoord();
            if (Box.BOMB == bombMap.get(coord))
                continue;
            bombMap.set(coord,Box.BOMB);
            incNumbersAroundBomb(coord);
            break;
        }
    }

    private void incNumbersAroundBomb(Coordinate coord)
    {
        for (Coordinate around: Ranges.getCoordsAround(coord))
            if (Box.BOMB != bombMap.get(around))
                bombMap.set(around,bombMap.get(around).getNextNumberBox());
    }

    int getTotalBombs()
    {
        return totalBombs;
    }
}
