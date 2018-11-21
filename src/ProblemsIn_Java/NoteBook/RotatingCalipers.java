package ProblemsIn_Java.NoteBook;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
// In test
public final class RotatingCalipers {
    protected enum Corner { UPPER_RIGHT, UPPER_LEFT, LOWER_LEFT, LOWER_RIGHT }
    public static double getArea(Point2D.Double[] rectangle) {
        double deltaXAB = rectangle[0].x - rectangle[1].x;
        double deltaYAB = rectangle[0].y - rectangle[1].y;
        double deltaXBC = rectangle[1].x - rectangle[2].x;
        double deltaYBC = rectangle[1].y - rectangle[2].y;
        double lengthAB = Math.sqrt((deltaXAB * deltaXAB) + (deltaYAB * deltaYAB));
        double lengthBC = Math.sqrt((deltaXBC * deltaXBC) + (deltaYBC * deltaYBC));
        return lengthAB * lengthBC;
    }
    public static List<Point2D.Double[]> getAllBoundingRectangles(double[][] pointsArray) throws IllegalArgumentException {
        List<Point2D.Double> points = new ArrayList<Point2D.Double>();
        for(int i = 0; i < pointsArray.length; i++)
            points.add(new Point2D.Double(pointsArray[i][0], pointsArray[i][0]));
        return getAllBoundingRectangles(points);
    }
    public static List<Point2D.Double[]> getAllBoundingRectangles(List<Point2D.Double> points) throws IllegalArgumentException {
        //En este punto el poligono debe ser convexo, mirar el convexhull Gramhamscan
        List<Point2D.Double[]> rectangles = new ArrayList<Point2D.Double[]>();

        //List<Point2D.Double> convexHull = GrahamScan.getConvexHull(points);

        Caliper I = new Caliper(points, getIndex(points, Corner.UPPER_RIGHT), 90);
        Caliper J = new Caliper(points, getIndex(points, Corner.UPPER_LEFT), 180);
        Caliper K = new Caliper(points, getIndex(points, Corner.LOWER_LEFT), 270);
        Caliper L = new Caliper(points, getIndex(points, Corner.LOWER_RIGHT), 0);

        while(L.currentAngle < 90.0) {

            rectangles.add(new Point2D.Double[]{
                    L.getIntersection(I),
                    I.getIntersection(J),
                    J.getIntersection(K),
                    K.getIntersection(L)
            });

            double smallestTheta = getSmallestTheta(I, J, K, L);

            I.rotateBy(smallestTheta);
            J.rotateBy(smallestTheta);
            K.rotateBy(smallestTheta);
            L.rotateBy(smallestTheta);
        }

        return rectangles;
    }
    public static Point2D.Double[] getMinimumBoundingRectangle(double[][] pointsArray) throws IllegalArgumentException {
        List<Point2D.Double> points = new ArrayList<Point2D.Double>();
        for(int i = 0; i < pointsArray.length; i++)
            points.add(new Point2D.Double(pointsArray[i][0], pointsArray[i][0]));
        return getMinimumBoundingRectangle(points);
    }
    public static Point2D.Double[] getMinimumBoundingRectangle(List<Point2D.Double> points) throws IllegalArgumentException {

        List<Point2D.Double[]> rectangles = getAllBoundingRectangles(points);

        Point2D.Double[] minimum = null;
        double area = Long.MAX_VALUE;

        for (Point2D.Double[] rectangle : rectangles) {

            double tempArea = getArea(rectangle);

            if (minimum == null || tempArea < area) {
                minimum = rectangle;
                area = tempArea;
            }
        }

        return minimum;
    }
    private static double getSmallestTheta(Caliper I, Caliper J, Caliper K, Caliper L) {

        double thetaI = I.getDeltaAngleNextPoint();
        double thetaJ = J.getDeltaAngleNextPoint();
        double thetaK = K.getDeltaAngleNextPoint();
        double thetaL = L.getDeltaAngleNextPoint();

        if(thetaI <= thetaJ && thetaI <= thetaK && thetaI <= thetaL) {
            return thetaI;
        }
        else if(thetaJ <= thetaK && thetaJ <= thetaL) {
            return thetaJ;
        }
        else if(thetaK <= thetaL) {
            return thetaK;
        }
        else {
            return thetaL;
        }
    }
    protected static int getIndex(List<Point2D.Double> convexHull, Corner corner) {

        int index = 0;
        Point2D.Double point = convexHull.get(index);

        for(int i = 1; i < convexHull.size() - 1; i++) {

            Point2D.Double temp = convexHull.get(i);
            boolean change = false;

            switch(corner) {
                case UPPER_RIGHT:
                    change = (temp.x > point.x || (temp.x == point.x && temp.y > point.y));
                    break;
                case UPPER_LEFT:
                    change = (temp.y > point.y || (temp.y == point.y && temp.x < point.x));
                    break;
                case LOWER_LEFT:
                    change = (temp.x < point.x || (temp.x == point.x && temp.y < point.y));
                    break;
                case LOWER_RIGHT:
                    change = (temp.y < point.y || (temp.y == point.y && temp.x > point.x));
                    break;
            }

            if(change) {
                index = i;
                point = temp;
            }
        }

        return index;
    }
    protected static class Caliper {

        final static double SIGMA = 0.00000000001;

        final List<Point2D.Double> convexHull;
        int pointIndex;
        double currentAngle;

        Caliper(List<Point2D.Double> convexHull, int pointIndex, double currentAngle) {
            this.convexHull = convexHull;
            this.pointIndex = pointIndex;
            this.currentAngle = currentAngle;
        }

        double getAngleNextPoint() {

            Point2D.Double p1 = convexHull.get(pointIndex);
            Point2D.Double p2 = convexHull.get((pointIndex + 1) % convexHull.size());

            double deltaX = p2.x - p1.x;
            double deltaY = p2.y - p1.y;

            double angle = Math.atan2(deltaY, deltaX) * 180 / Math.PI;

            return angle < 0 ? 360 + angle : angle;
        }

        double getConstant() {

            Point2D.Double p = convexHull.get(pointIndex);

            return p.y - (getSlope() * p.x);
        }

        double getDeltaAngleNextPoint() {

            double angle = getAngleNextPoint();

            angle = angle < 0 ? 360 + angle - currentAngle : angle - currentAngle;

            return angle < 0 ? 360 : angle;
        }

        Point2D.Double getIntersection(Caliper that) {

            // the x-intercept of 'this' and 'that': x = ((c2 - c1) / (m1 - m2))
            double x;
            // the y-intercept of 'this' and 'that', given 'x': (m*x) + c
            double y;

            if(this.isVertical()) {
                x = convexHull.get(pointIndex).x;
            }
            else if(this.isHorizontal()) {
                x = that.convexHull.get(that.pointIndex).x;
            }
            else {
                x = (that.getConstant() -  this.getConstant()) / (this.getSlope() - that.getSlope());
            }

            if(this.isVertical()) {
                y = that.getConstant();
            }
            else if(this.isHorizontal()) {
                y = this.getConstant();
            }
            else {
                y = (this.getSlope() * x) + this.getConstant();
            }

            return new Point2D.Double(x, y);
        }

        double getSlope() {
            return Math.tan(Math.toRadians(currentAngle));
        }

        boolean isHorizontal() {
            return (Math.abs(currentAngle) < SIGMA) || (Math.abs(currentAngle - 180.0) < SIGMA);
        }

        boolean isVertical() {
            return (Math.abs(currentAngle - 90.0) < SIGMA) || (Math.abs(currentAngle - 270.0) < SIGMA);
        }

        void rotateBy(double angle) {

            if(this.getDeltaAngleNextPoint() == angle) {
                pointIndex++;
            }

            this.currentAngle += angle;
        }
    }
}