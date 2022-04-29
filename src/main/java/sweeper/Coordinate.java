
package sweeper;

import java.util.Objects;

    public class Coordinate
    {
        public int  x;
        public int  y;

        public Coordinate(int x, int y)
        {
            this.x=x;
            this.y=y;

        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof sweeper.Coordinate)
            {
                sweeper.Coordinate to = (sweeper.Coordinate)o;
                return to.x==x && to.y==y;
            }
            return super.equals(o);

        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


