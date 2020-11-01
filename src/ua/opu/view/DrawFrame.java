package ua.opu.view;

import ua.opu.model.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Главное окно программы. Фрейм (класс JFrame)
 * является контейнером верхнего уровня
 */
public class DrawFrame extends JFrame {

    // Область для рисования фигур
    private PaintSurface surface;

    // В конструкторе создаем GUI
    public DrawFrame(String title) {

        // Обратите внимание, что мы вызываем
        // конструктор базового класса. Внутри него
        // выполняется вся работа по прорисовке окна
        // Нам остается только использовать код суперкласса
        super(title);

        // Говорим фрейму, что при закрытии окна, программа завершала работу
        // (если это не указать, то программа будет "висеть" в процессах
        // после того как вы закроете окно программмы
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Устанавливаем менеджер разметки
        // (он отвечает за то - как будут
        // располагаться элементы внутри фрейма
        this.setLayout(new BorderLayout());

        // Добавляем верхнюю панель с тремя кнопками
        this.add(setButtonPanel(), BorderLayout.NORTH);

        // Создаем объект области рисования
        surface = new PaintSurface();

        // Добавляем область для рисования фигур во фрейм
        this.add(surface, BorderLayout.CENTER);

        // Этот метод изменяет размер фрейма так
        // чтобы были видны все элементы внутри него
        this.pack();

        // "Показывает" фрейм на экране
        // (устанавливаем видимость фрейма)
        this.setVisible(true);
    }

    /**
     * Данный метод создает и настраивает
     * верхнюю панель с кнопками.
     *
     * @return ссылка на объект панели
     */
    private JPanel setButtonPanel() {

        // Создаем панель для кнопок
        JPanel buttonPanel = new JPanel(true);

        // Сообщаем панели, что элементы внутри него
        // должны идти друг за другом слева направо
        // с выравниваем слева
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        // Цвет фона панели
        buttonPanel.setBackground(Color.CYAN);
        // Граница панели (черная окантовка вокруг панели)
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        // *** Добавляем кнопки на панель ***

        // 1. Кнопка для прямоугольника
        BigTextButton rect = new BigTextButton("Rectangle");
        // Это т.н. слушатель (Listener). Слушатель - объект некоторого
        // класса, который внутри себя содержит некоторый метод.
        // Этот объект передается кнопке и когда наступает определенное
        // событие, связанное с этой кнопкой (например, мы нажали на эту кнопку),
        // кнопка берет этот слушатель и вызывает его метод.
        // Таким образом, мы можем прописать тот код, который будет
        // выполняться при наступлении определенных событий (например, нажатие на кнопку)
        // *** Этот метод будет выполнен, когда пользователь нажмет на кнопку ***
        rect.addActionListener(e -> {
            // Меняем поле внутри объекта области рисования
            // Чтобы он знал, что теперь нужно рисовать прямоугольники
            surface.setShapeType(DrawShape.SHAPE_RECTANGLE);
        });
        // Добавляем первую кнопку на верхнюю панель
        buttonPanel.add(rect);

        // 2. Кнопка для скругленного прямоугольника
        BigTextButton rounded_rect = new BigTextButton("Rounded rect.");
        rounded_rect.addActionListener(e -> {
            // Говорим области рисования, что теперь нужно
            // рисовать скругленные прямоугольники
            surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT);
        });
        // Добавляем вторую кнопку на верхнюю панель
        buttonPanel.add(rounded_rect);

        // 3. Кнопка для єллипса
        BigTextButton ellipse = new BigTextButton("Ellipse");
        ellipse.addActionListener(e -> {
            // Меняем поле внутри объекта области рисования
            // Чтобы он знал, что теперь нужно єллипс
            surface.setShapeType(DrawShape.SHAPE_ELLIPSE);
        });
        // Добавляем третью кнопку на верхнюю панель
        buttonPanel.add(ellipse);

        // 4. Кнопка для линий
        BigTextButton line = new BigTextButton("Line");
        line.addActionListener(e ->
            // Меняем поле внутри объекта области рисования
            // Чтобы он знал, что теперь линия
            surface.setShapeType(DrawShape.SHAPE_LINE)
        );
        // Добавляем четвертую кнопку на верхнюю панель
        buttonPanel.add(line);

        // 5. Кнопка для квад. линий
        BigTextButton quadCurve = new BigTextButton("QuadCurve");
        quadCurve.addActionListener(e ->
            // Меняем поле внутри объекта области рисования
            // Чтобы он знал, что теперь нужно квад. линий
            surface.setShapeType(DrawShape.SHAPE_QUADCURVE)
        );
        // Добавляем пятую кнопку на верхнюю панель
        buttonPanel.add(quadCurve);

        // 6. Кнопка для очитски
        BigTextButton clear = new BigTextButton("Clear");
        clear.addActionListener(e ->
            surface.clear()
        );
        buttonPanel.add(clear);
        return buttonPanel;
    }
}

