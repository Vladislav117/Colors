package ru.vladislav117.colors;

import ru.vladislav117.colors.colorspace.RGBColorSpaceHolder;
import ru.vladislav117.colors.colorspace.TransparencyColorSpaceHolder;

/**
 * Объекты, реализующие этот интерфейс, являются цветом.
 */
public interface ColorLike extends RGBColorSpaceHolder, TransparencyColorSpaceHolder, Cloneable {
    /**
     * Клонирование цвета.
     *
     * @return Копия цвета.
     */
    ColorLike clone();

    /**
     * Смешивание этого цвета с другим цветом.
     *
     * @param other Другой цвет
     * @return Этот же цвет.
     */
    @SuppressWarnings("UnusedReturnValue")
    ColorLike mix(ColorLike other);

    /**
     * Смешивание этого цвета с другим цветом.
     * Соотношение применяется к другому цвету (например, соотношение 0.1 будет означать 90% этого цвета и 10% другого).
     *
     * @param other Другой цвет
     * @param ratio Соотношение цветов в диапазоне [0; 1]
     * @return Этот же цвет.
     */
    @SuppressWarnings("UnusedReturnValue")
    ColorLike mix(ColorLike other, float ratio);

    /**
     * Создание цвета в результате смешивания этого цвета с другим цветом.
     *
     * @param other Другой цвет
     * @return Новый цвет.
     */
    ColorLike toMixed(ColorLike other);

    /**
     * Создание цвета в результате смешивания этого цвета с другим цветом.
     * Соотношение применяется к другому цвету (например, соотношение 0.1 будет означать 90% этого цвета и 10% другого).
     *
     * @param other Другой цвет
     * @param ratio Соотношение цветов в диапазоне [0; 1]
     * @return Новый цвет.
     */
    ColorLike toMixed(ColorLike other, float ratio);

    /**
     * Вычисление хеш-кода цвета.
     *
     * @return Хеш-код цвета.
     */
    int hashCode();

    /**
     * Сравнивание цветов.
     * Цвет может быть сравнён только с ColorLike цветом или объектом класса, наследуемого от ColorLike.
     *
     * @param obj Цвет, с которым будет проводиться сравнение
     * @return Равенство цветов
     */
    boolean equals(Object obj);

    /**
     * Преобразование цвета к строке.
     *
     * @return Строка.
     */
    String toString();
}
