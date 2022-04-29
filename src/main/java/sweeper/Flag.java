package sweeper;

class Flag
{
    private Matrix flagMap;
    public static int countOfClosedBoxes;
    public static int ClosedBoxesForRegistration;

    int exchangeWithReg(){
        ClosedBoxesForRegistration=getCountOfClosedBoxes();
        return ClosedBoxesForRegistration;
    }

    void  start()
    {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().x*Ranges.getSize().y;
    }

    Box get (Coordinate coord)
    {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coordinate coord)
    {
        flagMap.set(coord, Box.OPENED);
        countOfClosedBoxes--;
    }

    void toggleFlagedToBox(Coordinate coord)
    {
        switch (flagMap.get(coord))
        {
            case FLAGED : setClosedToBox(coord); break;
            case CLOSED : setFlagedToBox(coord); break;
            //case FLAGED : setClosedToBox(); break;
        }
    }

    private void setClosedToBox(Coordinate coord)
    {
        flagMap.set(coord, Box.CLOSED);
    }

    private void setFlagedToBox(Coordinate coord)
    {
        flagMap.set(coord, Box.FLAGED);
    }


    public int getCountOfClosedBoxes()
    {
        return countOfClosedBoxes;
    }

    void setBombedToBox(Coordinate coord)
    {
        flagMap.set(coord,Box.BOMBED);
    }

    void setOpenedToClosedBombBox(Coordinate coord)
    {
        if (flagMap.get(coord)==Box.CLOSED)
            flagMap.set(coord, Box.OPENED);
    }

    void setNoBombToFlagedSafeBox(Coordinate coord)
    {
        if (flagMap.get(coord)==Box.FLAGED)
            flagMap.set(coord, Box.NOBOMB);
    }



    int getCountOfFlagedBoxesAround(Coordinate coord)
    {
        int count = 00;
        for (Coordinate around : Ranges.getCoordsAround(coord))
            if (flagMap.get(around)== Box.FLAGED)
                count++;
        return count;
    }
}
