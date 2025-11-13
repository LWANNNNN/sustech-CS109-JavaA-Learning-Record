package homework03.CollinerPoints;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CollinerPoints
{
    public static boolean sameLine(int[][] points)
    {
        if (points.length == 0) {
            return false;
        } else if (points.length <= 2) {
            return true;
        }

        long x0 = points[0][0];
        long y0 = points[0][1];
        long x1 = points[0][0];
        long y1 = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (x0 != points[i][0] || y0 != points[i][1]) {
                x1 = points[i][0];
                y1 = points[i][1];
                break;
            }
        }

        long dx = x1 - x0;
        long dy = y1 - y0;
        for (int i = 1; i < points.length; i++) {
            long k1 = dx * (y0 - points[i][1]);
            long k2 = dy * (x0 - points[i][0]);
            if (k1 != k2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 6}};
        System.out.println(sameLine(points)); // should print false
    }
}
