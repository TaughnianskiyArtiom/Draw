package ua.opu.model;

import java.awt.*;

/**
 * Класс "Фигура для рисования".
 * Класс содержит начальную и конечную точку, а также различные методы
 */
public class DrawShape {

    // Константы для типов фигур
    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;
    public static final int SHAPE_LINE = 3;
    public static final int SHAPE_QUADCURVE = 4;

    // Начальная и конечная точки
    private Point startPoint;
    private Point endPoint;

    // Конструктор без параметров. В данном случае
    // у нас точки будут null
    public DrawShape() {
        this(new Point(0, 0), new Point(0, 0));
    }

    // Конструктор с начальной и конечной координатами
    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Метод возвращает фигуру, которую можно нарисовать
    public Shape getShape() {
        return this.getShape(startPoint, endPoint);
    }

    public Shape getShape(Point startPoint, Point endPoint) {
            throw new OverrideGetShape();
    };

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

}

class OverrideGetShape extends IllegalArgumentException {
    public OverrideGetShape(){
        super("Нужно переопределить метод getShape() для рисования");
    }
}
