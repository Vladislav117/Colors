package ru.vladislav117.colors;

import ru.vladislav117.colors.colorspace.RGBColorSpaceHolder;
import ru.vladislav117.colors.colorspace.TransparencyColorSpaceHolder;

import java.awt.Color;

/**
 * Объекты, реализующие этот интерфейс, являются цветом.
 */
public interface ColorLike extends RGBColorSpaceHolder, TransparencyColorSpaceHolder, Cloneable {
    /**
     * Получение значений цветовых каналов RGBA.
     *
     * @return Значения цветовых каналов RGBA в диапазоне [0; 1].
     */
    default float[] getRGBA() {
        return new float[]{getRed(), getGreen(), getBlue(), getAlpha()};
    }

    /**
     * Получение значений цветовых каналов RGBA.
     *
     * @return Значения цветовых каналов RGBA в диапазоне [0; 255].
     */
    default int[] getRGBA255() {
        return new int[]{getRed255(), getGreen255(), getBlue255(), getAlpha255()};
    }

    /**
     * Получение значений цветовых каналов RGBA как целое число.
     *
     * @return Значения цветовых каналов RGBA как целое число.
     */
    default int getRGBAInteger() {
        return (getRed255() << 24) | (getGreen255() << 16) | (getBlue255() << 8) | getAlpha255();
    }

    /**
     * Получение значений цветовых каналов RGBA как hex-строка.
     *
     * @return Значения цветовых каналов RGBA как hex-строка.
     */
    default String getRGBAHex() {
        return String.format("#%02X%02X%02X%02X", getRed255(), getGreen255(), getBlue255(), getAlpha255());
    }

    /**
     * Установка значений цветовых каналов RGBA.
     *
     * @param rgba Значения цветовых каналов RGBA в диапазоне [0; 1]
     * @return Этот же объект.
     */
    default ColorLike setRGBA(float[] rgba) {
        setRed(rgba[0]);
        setGreen(rgba[1]);
        setBlue(rgba[2]);
        setAlpha(rgba[3]);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGBA.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    default ColorLike setRGBA(float red, float green, float blue, float alpha) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        setAlpha(alpha);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGBA.
     *
     * @param rgba Значения цветовых каналов RGBA в диапазоне [0; 255]
     * @return Этот же объект.
     */
    default ColorLike setRGBA255(int[] rgba) {
        setRed255(rgba[0]);
        setGreen255(rgba[1]);
        setBlue255(rgba[2]);
        setAlpha255(rgba[3]);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGBA.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 255]
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @param blue  Значение синего цветового канала в диапазоне [0; 255]
     * @param alpha Значение альфа канала в диапазоне [0; 255]
     * @return Этот же объект.
     */
    default ColorLike setRGBA255(int red, int green, int blue, int alpha) {
        setRed255(red);
        setGreen255(green);
        setBlue255(blue);
        setAlpha255(alpha);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGBA из целого числа.
     *
     * @param rgba Значения цветовых каналов RGBA как целое число
     * @return Этот же объект.
     */
    default ColorLike setRGBAInteger(int rgba) {
        setRed255((rgba >> 24) & 0xFF);
        setGreen255((rgba >> 16) & 0xFF);
        setBlue255((rgba >> 8) & 0xFF);
        setAlpha255(rgba & 0xFF);
        return this;
    }

    /**
     * Установка значений цветовых каналов из hex-строки, представляющей собой RGB или RGBA цвет.
     * Строка может начинаться с символа решётки.
     * Допустимые форматы записи: "#RGB", "#RGBA", "#RRGGBB", "#RRGGBBAA".
     *
     * @param hex Hex-строка, представляющая собой RGB или RGBA цвет
     * @return Созданный цвет.
     * @throws IllegalArgumentException Если формат записи hex-строки неверный, будет вызвано исключение.
     */
    default ColorLike setRGBAHex(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        if (hex.length() == 3) {
            char r = hex.charAt(0);
            char g = hex.charAt(1);
            char b = hex.charAt(2);
            hex = "" + r + r + g + g + b + b;
        } else if (hex.length() == 4) {
            char r = hex.charAt(0);
            char g = hex.charAt(1);
            char b = hex.charAt(2);
            char a = hex.charAt(3);
            hex = "" + r + r + g + g + b + b + a + a;
        }
        if (hex.length() == 6) {
            int rgb = Integer.parseInt(hex, 16);
            setRGBInteger(rgb);
            return this;
        } else if (hex.length() == 8) {
            int rgba = Integer.parseUnsignedInt(hex, 16);
            setRGBAInteger(rgba);
            return this;
        } else {
            throw new IllegalArgumentException("Hex color string must be in format #RGB, #RGBA, #RRGGBB or #RRGGBBAA");
        }
    }

    /**
     * Установка значений цветовых каналов RGBA из другого цвета.
     *
     * @param color Цвет
     * @return Этот же объект.
     */
    default ColorLike setRGBAColor(ColorLike color) {
        setRed(color.getRed());
        setGreen(color.getGreen());
        setBlue(color.getBlue());
        setAlpha(color.getAlpha());
        return this;
    }

    /**
     * Установка значений цветовых каналов RGBA из цвета awt.
     *
     * @param color Цвет
     * @return Этот же объект.
     * @see java.awt.Color
     */
    default ColorLike setRGBAColor(Color color) {
        setRed(color.getRed() / 255f);
        setGreen(color.getGreen() / 255f);
        setBlue(color.getBlue() / 255f);
        setAlpha(color.getAlpha() / 255f);
        return this;
    }

    /**
     * Получение значений цветовых каналов ARGB.
     *
     * @return Значения цветовых каналов ARGB в диапазоне [0; 1].
     */
    default float[] getARGB() {
        return new float[]{getAlpha(), getRed(), getGreen(), getBlue()};
    }

    /**
     * Получение значений цветовых каналов ARGB.
     *
     * @return Значения цветовых каналов ARGB в диапазоне [0; 255].
     */
    default int[] getARGB255() {
        return new int[]{getAlpha255(), getRed255(), getGreen255(), getBlue255()};
    }

    /**
     * Получение значений цветовых каналов ARGB как целое число.
     *
     * @return Значения цветовых каналов ARGB как целое число.
     */
    default int getARGBInteger() {
        return (getAlpha255() << 24) | (getRed255() << 16) | (getGreen255() << 8) | getBlue255();
    }

    /**
     * Получение значений цветовых каналов ARGB как hex-строка.
     *
     * @return Значения цветовых каналов ARGB как hex-строка.
     */
    default String getARGBHex() {
        return String.format("#%02X%02X%02X%02X",  getAlpha255(), getRed255(), getGreen255(), getBlue255());
    }

    /**
     * Установка значений цветовых каналов ARGB.
     *
     * @param argb Значения цветовых каналов ARGB в диапазоне [0; 1]
     * @return Этот же объект.
     */
    default ColorLike setARGB(float[] argb) {
        setAlpha(argb[0]);
        setRed(argb[1]);
        setGreen(argb[2]);
        setBlue(argb[3]);
        return this;
    }

    /**
     * Установка значений цветовых каналов ARGB.
     *
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    default ColorLike setARGB(float alpha, float red, float green, float blue) {
        setAlpha(alpha);
        setRed(red);
        setGreen(green);
        setBlue(blue);
        return this;
    }

    /**
     * Установка значений цветовых каналов ARGB.
     *
     * @param argb Значения цветовых каналов ARGB в диапазоне [0; 255]
     * @return Этот же объект.
     */
    default ColorLike setARGB255(int[] argb) {
        setAlpha255(argb[0]);
        setRed255(argb[1]);
        setGreen255(argb[2]);
        setBlue255(argb[3]);
        return this;
    }

    /**
     * Установка значений цветовых каналов ARGB.
     *
     * @param alpha Значение альфа канала в диапазоне [0; 255]
     * @param red   Значение красного цветового канала в диапазоне [0; 255]
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @param blue  Значение синего цветового канала в диапазоне [0; 255]
     * @return Этот же объект.
     */
    default ColorLike setARGB255(int alpha, int red, int green, int blue) {
        setAlpha255(alpha);
        setRed255(red);
        setGreen255(green);
        setBlue255(blue);
        return this;
    }

    /**
     * Установка значений цветовых каналов ARGB из целого числа.
     *
     * @param argb Значения цветовых каналов ARGB как целое число
     * @return Этот же объект.
     */
    default ColorLike setARGBInteger(int argb) {
        setAlpha255((argb >> 24) & 0xFF);
        setRed255((argb >> 16) & 0xFF);
        setGreen255((argb >> 8) & 0xFF);
        setBlue255(argb & 0xFF);
        return this;
    }

    /**
     * Установка значений цветовых каналов из hex-строки, представляющей собой RGB или ARGB цвет.
     * Строка может начинаться с символа решётки.
     * Допустимые форматы записи: "#RGB", "#ARGB", "#RRGGBB", "#AARRGGBB".
     *
     * @param hex Hex-строка, представляющая собой RGB или ARGB цвет
     * @return Созданный цвет.
     * @throws IllegalArgumentException Если формат записи hex-строки неверный, будет вызвано исключение.
     */
    default ColorLike setARGBHex(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        if (hex.length() == 3) {
            char r = hex.charAt(0);
            char g = hex.charAt(1);
            char b = hex.charAt(2);
            hex = "" + r + r + g + g + b + b;
        } else if (hex.length() == 4) {
            char a = hex.charAt(0);
            char r = hex.charAt(1);
            char g = hex.charAt(2);
            char b = hex.charAt(3);
            hex = "" + a + a + r + r + g + g + b + b;
        }
        if (hex.length() == 6) {
            int rgb = Integer.parseInt(hex, 16);
            setRGBInteger(rgb);
            return this;
        } else if (hex.length() == 8) {
            int argb = Integer.parseUnsignedInt(hex, 16);
            setARGBInteger(argb);
            return this;
        } else {
            throw new IllegalArgumentException("Hex color string must be in format #RGB, #ARGB, #RRGGBB or #AARRGGBB");
        }
    }

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
    default ColorLike mix(ColorLike other) {
        mix(other, 0.5f);
        return this;
    }

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
    default ColorLike toMixed(ColorLike other) {
        return clone().mix(other);
    }

    /**
     * Создание цвета в результате смешивания этого цвета с другим цветом.
     * Соотношение применяется к другому цвету (например, соотношение 0.1 будет означать 90% этого цвета и 10% другого).
     *
     * @param other Другой цвет
     * @param ratio Соотношение цветов в диапазоне [0; 1]
     * @return Новый цвет.
     */
    default ColorLike toMixed(ColorLike other, float ratio) {
        return clone().mix(other, ratio);
    }

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
