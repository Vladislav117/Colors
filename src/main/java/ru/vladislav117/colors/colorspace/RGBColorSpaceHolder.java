package ru.vladislav117.colors.colorspace;

import ru.vladislav117.colors.ColorLike;
import ru.vladislav117.colors.channel.rgb.BlueChannelHolder;
import ru.vladislav117.colors.channel.rgb.GreenChannelHolder;
import ru.vladislav117.colors.channel.rgb.RedChannelHolder;

import java.awt.*;

/**
 * Объекты, реализующие этот интерфейс, находятся в цветовом пространстве RGB.
 */
public interface RGBColorSpaceHolder extends RedChannelHolder, GreenChannelHolder, BlueChannelHolder, ColorSpaceHolder {
    /**
     * Получение значений цветовых каналов RGB.
     *
     * @return Значения цветовых каналов RGB в диапазоне [0; 1].
     */
    default float[] getRGB() {
        return new float[]{getRed(), getGreen(), getBlue()};
    }

    /**
     * Получение значений цветовых каналов RGB.
     *
     * @return Значения цветовых каналов RGB в диапазоне [0; 255].
     */
    default int[] getRGB255() {
        return new int[]{getRed255(), getGreen255(), getBlue255()};
    }

    /**
     * Получение значений цветовых каналов RGB как целое число.
     *
     * @return Значения цветовых каналов RGB как целое число.
     */
    default int getRGBInteger() {
        return (getRed255() << 16) | (getGreen255() << 8) | getBlue255();
    }

    /**
     * Получение значений цветовых каналов RGB как hex-строка.
     *
     * @return Значения цветовых каналов RGB как hex-строка.
     */
    default String getRGBHex() {
        return String.format("#%02X%02X%02X", getRed255(), getGreen255(), getBlue255());
    }

    /**
     * Установка значений цветовых каналов RGB.
     *
     * @param rgb Значения цветовых каналов RGB в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RGBColorSpaceHolder setRGB(float[] rgb) {
        setRed(rgb[0]);
        setGreen(rgb[1]);
        setBlue(rgb[2]);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGB.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 1]
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @param blue  Значение синего цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RGBColorSpaceHolder setRGB(float red, float green, float blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGB.
     *
     * @param rgb Значения цветовых каналов RGB в диапазоне [0; 255]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RGBColorSpaceHolder setRGB255(int[] rgb) {
        setRed255(rgb[0]);
        setGreen255(rgb[1]);
        setBlue255(rgb[2]);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGB.
     *
     * @param red   Значение красного цветового канала в диапазоне [0; 255]
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @param blue  Значение синего цветового канала в диапазоне [0; 255]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RGBColorSpaceHolder setRGB255(int red, int green, int blue) {
        setRed255(red);
        setGreen255(green);
        setBlue255(blue);
        return this;
    }

    /**
     * Установка значений цветовых каналов RGB из целого числа.
     *
     * @param rgb Значения цветовых каналов RGB как целое число
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RGBColorSpaceHolder setRGBInteger(int rgb) {
        setRed255((rgb >> 16) & 0xFF);
        setGreen255((rgb >> 8) & 0xFF);
        setBlue255(rgb & 0xFF);
        return this;
    }

    /**
     * Установка значений цветовых каналов из hex-строки, представляющей собой RGB цвет.
     * Строка может начинаться с символа решётки.
     * Допустимые форматы записи: "#RGB", "#RRGGBB".
     *
     * @param hex Hex-строка, представляющая собой RGB цвет
     * @return Созданный цвет.
     * @throws IllegalArgumentException Если формат записи hex-строки неверный, будет вызвано исключение.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RGBColorSpaceHolder setRGBHex(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        if (hex.length() == 3) {
            char r = hex.charAt(0);
            char g = hex.charAt(1);
            char b = hex.charAt(2);
            hex = "" + r + r + g + g + b + b;
        }
        if (hex.length() == 6) {
            int rgb = Integer.parseInt(hex, 16);
            setRGBInteger(rgb);
            return this;
        } else {
            throw new IllegalArgumentException("Hex color string must be in format #RGB, #RRGGBB");
        }
    }

    /**
     * Установка значений цветовых каналов RGB из объекта.
     *
     * @param rgbColorSpaceHolder Объект в цветовом пространстве RGB
     * @return Этот же объект.
     */
    default RGBColorSpaceHolder setRGB(RGBColorSpaceHolder rgbColorSpaceHolder) {
        setRed(rgbColorSpaceHolder.getRed());
        setGreen(rgbColorSpaceHolder.getGreen());
        setBlue(rgbColorSpaceHolder.getBlue());
        return this;
    }

    /**
     * Установка значений цветовых каналов RGB из другого цвета.
     *
     * @param color Цвет
     * @return Этот же объект.
     */
    default RGBColorSpaceHolder setRGBColor(ColorLike color) {
        setRed(color.getRed());
        setGreen(color.getGreen());
        setBlue(color.getBlue());
        return this;
    }

    /**
     * Установка значений цветовых каналов RGB из цвета awt.
     *
     * @param color Цвет
     * @return Этот же объект.
     * @see java.awt.Color
     */
    default RGBColorSpaceHolder setRGBColor(Color color) {
        setRed(color.getRed() / 255f);
        setGreen(color.getGreen() / 255f);
        setBlue(color.getBlue() / 255f);
        return this;
    }
}
