package ru.vladislav117.colors.channel.rgb;

import ru.vladislav117.colors.channel.ChannelHolder;

/**
 * Объекты, реализующие этот интерфейс, имеют красный цветовой канал.
 */
public interface RedChannelHolder extends ChannelHolder {
    /**
     * Получение значения красного цветового канала.
     *
     * @return Значение красного цветового канала в диапазоне [0; 1].
     */
    float getRed();

    /**
     * Установка значения красного цветового канала.
     *
     * @param red Значение красного цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    RedChannelHolder setRed(float red);
}
