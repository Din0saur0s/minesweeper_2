package sweeper;

class Matrix
{
    private Box[][] matrix;

    Matrix (Box defaultBox)
    {
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Coordinate coord: Ranges.getAllCords())
            matrix[coord.x][coord.y] = defaultBox;
    }

    Box get (Coordinate coord)
    {
        if (Ranges.inRange(coord ))
            return matrix[coord.x][coord.y];
        return null;
    }

    void set (Coordinate coord, Box box)
    {
        if (Ranges.inRange(coord ))
            matrix[coord.x][coord.y]=box;
    }

}
