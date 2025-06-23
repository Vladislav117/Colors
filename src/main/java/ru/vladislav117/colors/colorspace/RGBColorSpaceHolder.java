package ru.vladislav117.colors.colorspace;

import ru.vladislav117.colors.channel.rgb.BlueChannelHolder;
import ru.vladislav117.colors.channel.rgb.GreenChannelHolder;
import ru.vladislav117.colors.channel.rgb.RedChannelHolder;

/**
 * Объекты, реализующие этот интерфейс, находятся в цветовом пространстве RGB.
 */
public interface RGBColorSpaceHolder extends RedChannelHolder, GreenChannelHolder, BlueChannelHolder, ColorSpaceHolder {
    /**
     * Получение значений цветовых каналов RGB.
     *
     * @return Значение цветовых каналов RGB в диапазоне [0; 1].
     */
    float[] getRGB();

    /**
     * Установка значений цветовых каналов RGB.
     *
     * @param rgb Значения цветовых каналов RGB в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    RGBColorSpaceHolder setRGB(float[] rgb);
}
