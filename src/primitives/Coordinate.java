package primitives;
import static primitives.Util.*;
/*
 * 
 */
/**
 * @author Home
 *
 */
public final class Coordinate 
{	
    /**
     * Coordinate value, intentionally "package-friendly" due to performance
     * constraints
     */
    final double coord;
    /**
     * Coordinate constructor receiving a coordinate value
     * 
     * @param coord coordinate value
     */
    public Coordinate(double coord)
    {
        // if it too close to zero make it zero
        this.coord =alignZero(coord);
    }

    /*************** Admin *****************/
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate)obj;
        return isZero(coord - other.coord);
    }

    @Override
    public String toString() {
        return "" + coord;
    }

}
