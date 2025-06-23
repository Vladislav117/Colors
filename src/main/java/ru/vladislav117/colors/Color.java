package ru.vladislav117.colors;

import ru.vladislav117.colors.colorspace.RGBColorSpaceHolder;
import ru.vladislav117.colors.colorspace.TransparencyColorSpaceHolder;

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
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     * @return Созданный цвет.
     */
    public static Color fromRGBA(float red, float green, float blue, float alpha) {
        return new Color(red, green, blue, alpha);
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
    public static Color fromRGBA255(float red, float green, float blue, float alpha) {
        return new Color(red / 255f, green / 255f, blue / 255f, alpha / 255f);
    }

    /**
     * Создание цвета из целого числа, представляющего собой RGBA цвет.
     *
     * @param rgba Целое число, представляющее собой RGBA цвет
     * @return Созданный цвет.
     */
    public static Color fromRGBA(int rgba) {
        float red = ((rgba >> 24) & 0xFF) / 255f;
        float green = ((rgba >> 16) & 0xFF) / 255f;
        float blue = ((rgba >> 8) & 0xFF) / 255f;
        float alpha = (rgba & 0xFF) / 255f;
        return new Color(red, green, blue, alpha);
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
        return new Color(red, green, blue, alpha);
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
    public static Color fromARGB255(float alpha, float red, float green, float blue) {
        return new Color(red / 255f, green / 255f, blue / 255f, alpha / 255f);
    }

    /**
     * Создание цвета из целого числа, представляющего собой ARGB цвет.
     *
     * @param argb Целое число, представляющее собой ARGB цвет
     * @return Созданный цвет.
     */
    public static Color fromARGB(int argb) {
        float alpha = ((argb >> 24) & 0xFF) / 255f;
        float red = ((argb >> 16) & 0xFF) / 255f;
        float green = ((argb >> 8) & 0xFF) / 255f;
        float blue = (argb & 0xFF) / 255f;
        return new Color(red, green, blue, alpha);
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
        return new Color(red, green, blue);
    }

    /**
     * Создание цвета из значений RGB каналов.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 255]
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @param blue  Значение синего цветового канала в диапазоне [0; 255]
     * @return Созданный цвет.
     */
    public static Color fromRGB255(float red, float green, float blue) {
        return new Color(red / 255f, green / 255f, blue / 255f);
    }

    /**
     * Создание цвета из целого числа, представляющего собой RGB цвет.
     *
     * @param rgb Целое число, представляющее собой RGB цвет
     * @return Созданный цвет.
     */
    public static Color fromRGB(int rgb) {
        float red = ((rgb >> 16) & 0xFF) / 255f;
        float green = ((rgb >> 8) & 0xFF) / 255f;
        float blue = (rgb & 0xFF) / 255f;
        return new Color(red, green, blue, 1.0f);
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
    public static Color fromHex(String hex) {
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
            return fromRGB(rgb);
        } else if (hex.length() == 8) {
            int rgba = Integer.parseUnsignedInt(hex, 16);
            return fromRGBA(rgba);
        } else {
            throw new IllegalArgumentException("Hex color string must be in format #RGB, #RGBA, #RRGGBB or #RRGGBBAA");
        }
    }

    /**
     * Создание цвета из цвета awt.
     *
     * @param color Цвет
     * @return Созданный цвет.
     * @see java.awt.Color
     */
    public static Color fromAwtColor(java.awt.Color color) {
        return new Color(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f, color.getAlpha() / 255f);
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
     * Создание цвета на основе объекта в пространстве RGB.
     * Значение альфа канала будет равно 1.
     *
     * @param rgb Объект в пространстве RGB
     */
    public Color(RGBColorSpaceHolder rgb) {
        red = rgb.getRed();
        green = rgb.getGreen();
        blue = rgb.getBlue();
    }

    /**
     * Создание цвета на основе объекта в пространстве прозрачности.
     * Значения RGB каналов будет равно 0.
     *
     * @param transparency Объект в пространстве прозрачности
     */
    public Color(TransparencyColorSpaceHolder transparency) {
        alpha = transparency.getAlpha();
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
    public float[] getRGB() {
        return new float[]{red, green, blue};
    }

    @Override
    public Color setRGB(float[] rgb) {
        red = rgb[0];
        green = rgb[1];
        blue = rgb[2];
        return this;
    }

    @Override
    public Color mix(ColorLike other) {
        mix(other, 0.5f);
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
    public Color toMixed(ColorLike other) {
        return clone().mix(other);
    }

    @Override
    public Color toMixed(ColorLike other, float ratio) {
        return clone().mix(other, ratio);
    }
}
