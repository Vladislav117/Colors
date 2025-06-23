package ru.vladislav117.colors.channel.rgb;

import ru.vladislav117.colors.channel.ChannelHolder;

/**
 * Объекты, реализующие этот интерфейс, имеют синий цветовой канал.
 */
public interface BlueChannelHolder extends ChannelHolder {
    /**
     * Получение значения синего цветового канала.
     *
     * @return Значение синего цветового канала в диапазоне [0; 1].
     */
    float getBlue();

    /**
     * Установка значения синего цветового канала.
     *
     * @param blue Значение синего цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    BlueChannelHolder setBlue(float blue);
}
