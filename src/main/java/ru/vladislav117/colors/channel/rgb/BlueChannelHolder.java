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
     * Получение значения синего цветового канала.
     *
     * @return Значение синего цветового канала в диапазоне [0; 255].
     */
    default int getBlue255() {
        return (int) (getBlue() * 255);
    }

    /**
     * Установка значения синего цветового канала.
     *
     * @param blue Значение синего цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    BlueChannelHolder setBlue(float blue);

    /**
     * Установка значения синего цветового канала.
     *
     * @param blue Значение синего цветового канала в диапазоне [0; 255]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default BlueChannelHolder setBlue255(int blue) {
        setBlue(blue / 255f);
        return this;
    }

    /**
     * Установка значения синего цветового канала из значения объекта.
     *
     * @param blueChannelHolder Объект с синим цветовым каналом
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default BlueChannelHolder setBlue(BlueChannelHolder blueChannelHolder) {
        setBlue(blueChannelHolder.getBlue());
        return this;
    }
}
