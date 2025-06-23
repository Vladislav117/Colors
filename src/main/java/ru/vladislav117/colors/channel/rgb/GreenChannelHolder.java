package ru.vladislav117.colors.channel.rgb;

import ru.vladislav117.colors.channel.ChannelHolder;

/**
 * Объекты, реализующие этот интерфейс, имеют зелёный цветовой канал.
 */
public interface GreenChannelHolder extends ChannelHolder {
    /**
     * Получение значения зелёного цветового канала.
     *
     * @return Значение зелёного цветового канала в диапазоне [0; 1].
     */
    float getGreen();

    /**
     * Установка значения зелёного цветового канала.
     *
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    GreenChannelHolder setGreen(float green);
}
