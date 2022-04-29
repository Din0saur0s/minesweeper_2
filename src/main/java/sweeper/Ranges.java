package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges
{


    private static Coordinate size;
    private static ArrayList<Coordinate> allCords;
    private static Random random = new Random();
    static void setSize(Coordinate _size)
    {
        size=_size;
        allCords = new ArrayList<Coordinate>();
        for (int y=0; y < size.y; y++)
            for (int x=0; x < size.x; x++)
                allCords.add(new Coordinate(x,y));

    }

    public static Coordinate getSize() {
        return size;
    }

    public static ArrayList<Coordinate> getAllCords()
    {
        return allCords;
    }

    static boolean inRange(Coordinate coord)
    {
        return coord.x>=0 && coord.x< size.x && coord.y>=0 && coord.y< size.y;
    }

    static Coordinate getRandomCoord ()
    {
        return new Coordinate(random.nextInt(size.x), random.nextInt(size.y));
    }

    static ArrayList<Coordinate> getCoordsAround(Coordinate coord)
    {
        Coordinate around;
        ArrayList<Coordinate> list = new ArrayList<Coordinate>();
        for (int x = coord.x-1; x<= coord.x+1; x++)
            for (int y = coord.y-1; y<= coord.y+1; y++)
                if (inRange(around = new Coordinate(x,y )))
                    if (!around.equals(coord))
                        list.add(around);
        return list;
    }
}
