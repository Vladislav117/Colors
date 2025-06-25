package ru.vladislav117.colors;

import ru.vladislav117.colors.colorspace.RGBColorSpaceHolder;
import ru.vladislav117.colors.colorspace.TransparencyColorSpaceHolder;

import java.util.Objects;

/**
 * Цвет.
 */
public class Color implements ColorLike {
    protected float red = 0;
    protected float green = 0;
    protected float blue = 0;
    protected float alpha = 1;

    /**
     * Создание цвета из значений RGBA каналов.
     *
     * @param rgba Значения цветовых каналов RGBA в диапазоне [0; 1]
     * @return Созданный цвет.
     */
    public static Color fromRGBA(float[] rgba) {
        return (Color) new Color().setRGBA(rgba);
    }

    /**
     * Создание цвета из значений RGBA каналов.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     * @return Созданный цвет.
     */
    public static Color fromRGBA(float red, float green, float blue, float alpha) {
        return (Color) new Color().setRGBA(red, green, blue, alpha);
    }

    /**
     * Создание цвета из значений RGBA каналов.
     *
     * @param rgba Значения цветовых каналов RGBA в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromRGBA255(int[] rgba) {
        return (Color) new Color().setRGBA255(rgba);
    }

    /**
     * Создание цвета из значений RGBA каналов.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 255]
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @param blue  Значение синего цветового канала в диапазоне [0; 255]
     * @param alpha Значение альфа канала в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromRGBA255(int red, int green, int blue, int alpha) {
        return (Color) new Color().setRGBA255(red, green, blue, alpha);
    }

    /**
     * Создание цвета из целого числа, представляющего собой RGBA цвет.
     *
     * @param rgba Значения цветовых каналов RGBA как целое число
     * @return Созданный цвет.
     */
    public static Color fromRGBAInteger(int rgba) {
        return (Color) new Color().setRGBAInteger(rgba);
    }

    /**
     * Создание цвета из hex-строки, представляющей собой RGB или RGBA цвет.
     * Строка может начинаться с символа решётки.
     * Допустимые форматы записи: "#RGB", "#RGBA", "#RRGGBB", "#RRGGBBAA".
     *
     * @param hex Hex-строка, представляющая собой RGB или RGBA цвет
     * @return Созданный цвет.
     * @throws IllegalArgumentException Если формат записи hex-строки неверный, будет вызвано исключение.
     */
    public static Color fromRGBAHex(String hex) {
        return (Color) new Color().setRGBAHex(hex);
    }

    /**
     * Создание цвета из другого цвета с компонентами RGBA.
     *
     * @param color Цвет
     * @return Созданный цвет.
     */
    public static Color fromRGBAColor(ColorLike color) {
        return (Color) new Color().setRGBAColor(color);
    }

    /**
     * Создание цвета из цвета awt с компонентами RGBA.
     *
     * @param color Цвет
     * @return Созданный цвет.
     * @see java.awt.Color
     */
    public static Color fromRGBAColor(java.awt.Color color) {
        return (Color) new Color().setRGBAColor(color);
    }

    /**
     * Создание цвета из значений ARGB каналов.
     *
     * @param argb Значения цветовых каналов ARGB в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromARGB(float[] argb) {
        return (Color) new Color().setARGB(argb);
    }

    /**
     * Создание цвета из значений ARGB каналов.
     *
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @return Созданный цвет.
     */
    public static Color fromARGB(float alpha, float red, float green, float blue) {
        return (Color) new Color().setARGB(alpha, red, green, blue);
    }

    /**
     * Создание цвета из значений ARGB каналов.
     *
     * @param argb Значения цветовых каналов ARGB в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromARGB255(int[] argb) {
        return (Color) new Color().setARGB255(argb);
    }

    /**
     * Создание цвета из значений ARGB каналов.
     *
     * @param alpha Значение альфа канала в диапазоне [0; 255]
     * @param red   Значение красного цветового канала в диапазоне [0; 255]
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @param blue  Значение синего цветового канала в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromARGB255(int alpha, int red, int green, int blue) {
        return (Color) new Color().setARGB255(alpha, red, green, blue);
    }

    /**
     * Создание цвета из целого числа, представляющего собой ARGB цвет.
     *
     * @param argb Значения цветовых каналов ARGB как целое число
     * @return Созданный цвет.
     */
    public static Color fromARGBInteger(int argb) {
        return (Color) new Color().setARGBInteger(argb);
    }

    /**
     * Создание цвета из hex-строки, представляющей собой RGB или ARGB цвет.
     * Строка может начинаться с символа решётки.
     * Допустимые форматы записи: "#RGB", "#ARGB", "#RRGGBB", "#AARRGGBB".
     *
     * @param hex Hex-строка, представляющая собой RGB или ARGB цвет
     * @return Созданный цвет.
     * @throws IllegalArgumentException Если формат записи hex-строки неверный, будет вызвано исключение.
     */
    public static Color fromARGBHex(String hex) {
        return (Color) new Color().setARGBHex(hex);
    }

    /**
     * Создание цвета из значений RGB каналов.
     *
     * @param rgb Значения цветовых каналов RGB в диапазоне [0; 1]
     * @return Созданный цвет.
     */
    public static Color fromRGB(float[] rgb) {
        return (Color) new Color().setRGB(rgb);
    }

    /**
     * Создание цвета из значений RGB каналов.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @return Созданный цвет.
     */
    public static Color fromRGB(float red, float green, float blue) {
        return (Color) new Color().setRGB(red, green, blue);
    }

    /**
     * Создание цвета из значений RGB каналов.
     *
     * @param rgb Значения цветовых каналов RGB в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromRGB255(int[] rgb) {
        return (Color) new Color().setRGB255(rgb);
    }

    /**
     * Создание цвета из значений RGB каналов.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 255]
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @param blue  Значение синего цветового канала в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromRGB255(int red, int green, int blue) {
        return (Color) new Color().setRGB255(red, green, blue);
    }

    /**
     * Создание цвета из целого числа, представляющего собой RGB цвет.
     *
     * @param rgb Целое число, представляющее собой RGB цвет
     * @return Созданный цвет.
     */
    public static Color fromRGBInteger(int rgb) {
        return (Color) new Color().setRGBInteger(rgb);
    }

    /**
     * Создание цвета из hex-строки, представляющей собой RGB цвет.
     * Строка может начинаться с символа решётки.
     * Допустимые форматы записи: "#RGB", "#RRGGBB".
     *
     * @param hex Hex-строка, представляющая собой RGB цвет
     * @return Созданный цвет.
     * @throws IllegalArgumentException Если формат записи hex-строки неверный, будет вызвано исключение.
     */
    public static Color fromRGBHex(String hex) {
        return (Color) new Color().setRGBHex(hex);
    }

    /**
     * Создание цвета из цветовых каналов RGB из объекта.
     *
     * @param rgbColorSpaceHolder Объект в цветовом пространстве RGB
     * @return Созданный цвет.
     */
    public static Color fromRGB(RGBColorSpaceHolder rgbColorSpaceHolder) {
        return (Color) new Color().setRGB(rgbColorSpaceHolder);
    }

    /**
     * Создание цвета из другого цвета с компонентами RGB.
     *
     * @param color Цвет
     * @return Созданный цвет.
     */
    public static Color fromRGBColor(ColorLike color) {
        return (Color) new Color().setRGBColor(color);
    }

    /**
     * Создание цвета из цвета awt с компонентами RGB.
     *
     * @param color Цвет
     * @return Созданный цвет.
     * @see java.awt.Color
     */
    public static Color fromRGBColor(java.awt.Color color) {
        return (Color) new Color().setRGBColor(color);
    }

    /**
     * Создание цвета.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     */
    public Color(float red, float green, float blue, float alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    /**
     * Создание цвета. Значение альфа канала будет равно 1.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     */
    public Color(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Создание цвета на основе другого цвета.
     *
     * @param color Другой цвет
     */
    public Color(ColorLike color) {
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
        alpha = color.getAlpha();
    }

    /**
     * Создание цвета.
     * Значения RGB каналов будет равно 0.
     * Значение альфа канала будет равно 1.
     */
    public Color() {
    }

    @Override
    public Color clone() {
        try {
            Color color = (Color) super.clone();
            color.red = red;
            color.green = green;
            color.blue = blue;
            color.alpha = alpha;
            return color;
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public float getRed() {
        return red;
    }

    @Override
    public Color setRed(float red) {
        this.red = red;
        return this;
    }

    @Override
    public float getGreen() {
        return green;
    }

    @Override
    public Color setGreen(float green) {
        this.green = green;
        return this;
    }

    @Override
    public float getBlue() {
        return blue;
    }

    @Override
    public Color setBlue(float blue) {
        this.blue = blue;
        return this;
    }

    @Override
    public float getAlpha() {
        return alpha;
    }

    @Override
    public Color setAlpha(float alpha) {
        this.alpha = alpha;
        return this;
    }

    @Override
    public Color mix(ColorLike other, float ratio) {
        red = red * (1 - ratio) + other.getRed() * (ratio);
        green = green * (1 - ratio) + other.getGreen() * (ratio);
        blue = blue * (1 - ratio) + other.getBlue() * (ratio);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue, alpha);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorLike other)) return false;
        return red == other.getRed() && green == other.getGreen() && blue == other.getBlue() && alpha == other.getAlpha();
    }

    @Override
    public String toString() {
        return "(" + red + ", " + green + ", " + blue + ", " + alpha + ")";
    }
}
