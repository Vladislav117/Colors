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
     * Получение значения красного цветового канала.
     *
     * @return Значение красного цветового канала в диапазоне [0; 255].
     */
    default int getRed255() {
        return (int) (getRed() * 255);
    }

    /**
     * Установка значения красного цветового канала.
     *
     * @param red Значение красного цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    RedChannelHolder setRed(float red);

    /**
     * Установка значения красного цветового канала.
     *
     * @param red Значение красного цветового канала в диапазоне [0; 255]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RedChannelHolder setRed255(int red) {
        setRed(red / 255f);
        return this;
    }

    /**
     * Установка значения красного цветового канала из значения объекта.
     *
     * @param redChannelHolder Объект с красным цветовым каналом
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default RedChannelHolder setRed(RedChannelHolder redChannelHolder) {
        setRed(redChannelHolder.getRed());
        return this;
    }
}
