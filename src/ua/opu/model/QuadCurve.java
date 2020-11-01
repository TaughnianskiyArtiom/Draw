package ua.opu.model;

import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class QuadCurve extends DrawShape {
    public QuadCurve() {}

    public QuadCurve(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }
    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        return new QuadCurve2D.Double(startPoint.getX(),startPoint.getY(), Math.abs((startPoint.getX() + endPoint.getX())/2),
                Math.abs((startPoint.getY() + endPoint.getY())/2) + startPoint.getY() - endPoint.getY() + 105,
                endPoint.getX(), endPoint.getY());
    }
}
