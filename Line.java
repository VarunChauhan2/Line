/**
 * The Line class contains fields and methods that create and manipulate straight lines
 * in the form y = mx + b in a Cartesian plane.
 * @author Varun Chauhan
 * Date Last Modified: 2021/06/14
 */
public class Line {
    /** Slope of the Line. */
    double m;
    /** y-intercept of the Line. */
    double b;

    /**
     * Basic constructor for the Line class. Initializes slope and y-intercept to 0.
     */
    public Line() {
    }

    /**
     * Constructor that allows secondary programmer to set the slope and y-intercept of the Line.
     * @param m
     * @param b
     */
    public Line(double m, double b) {
        this.m = m;
        this.b = b;
    }

    /**
     * Returns a String representing the slope-intercept equation (y = mx + b) of the Line.
     */
    public String toString() {
        if(b >= 0) {
            return "y = " + this.m + "x + " + this.b;
        }
        return "y = " + this.m + "x - " + this.b * -1;
    }

    /**
     * Finds the corresponding y value for a given x value on the Line.
     * @param x x value on the Line.
     * @return Corresponding y value on the Line.
     */
    public double getY(double x) {
        return m * x + b;
    }

    /**
     * Finds the corresponding x value for a given y value on the Line.
     * @param y y value on the Line.
     * @return Corresponding x value on the Line.
     */
    public double getX(double y) {
        if(this.m == 0)
            throw new RuntimeException("slope is 0");
        return (y - this.b) / this.m;
    }

    /**
     * Finds the Line perpendicular to the implicit Line with a given y-intercept.
     * @param b The y-intercept of the perpendicular line.
     * @return The Line that is perpendicular to the implicit Line.
     */
    public Line getPerpendicularLine(double b) {
        if(this.m == 0) 
            throw new RuntimeException("slope is 0");
        return new Line(-1 / this.m, b);
    }

    /**
     * Checks if two Lines are the same (same slope and y-intercept).
     * @param other The explicit Line.
     * @return true if both Lines are the same; false if not.
     */
    public boolean equals(Line other) {
        return this.isParallel(other) && round(this.b) == round(other.b);
    }

    /**
     * Checks if two Lines are parallel (same slope).
     * @param other The explicit Line.
     * @return true if both Lines are parallel; false if not.
     */
    public boolean isParallel(Line other) {
        return round(this.m) == round(other.m);
    }

    /**
     * Finds the slope between two points.
     * @param x1 x coordinate of the first point.
     * @param y1 y coordinate of the first point.
     * @param x2 x coordinate of the second point.
     * @param y2 y coordinate of the second point.
     * @return The slope between the two points.
     */
    public static double getSlope(double x1, double y1, double x2, double y2) {
        if(x2 -x1 == 0) 
            throw new RuntimeException("Vertical Line");
        return (y2 - y1) / (x2 - x1);
    }

    /**
     * Helper method that rounds a given double to three decimal places.
     * @param d Given double.
     * @return The double rounded to 3 decimal places.
     */
    private double round(double d) {
        return Math.round(d * 1000) / 1000.0;
    }
}
