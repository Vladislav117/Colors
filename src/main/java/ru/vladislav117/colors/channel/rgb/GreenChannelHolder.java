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
     * Получение значения зелёного цветового канала.
     *
     * @return Значение зелёного цветового канала в диапазоне [0; 255].
     */
    default int getGreen255() {
        return (int) (getGreen() * 255);
    }

    /**
     * Установка значения зелёного цветового канала.
     *
     * @param green Значение зелёного цветового канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    GreenChannelHolder setGreen(float green);

    /**
     * Установка значения зелёного цветового канала.
     *
     * @param green Значение зелёного цветового канала в диапазоне [0; 255]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default GreenChannelHolder setGreen255(int green) {
        setGreen(green / 255f);
        return this;
    }

    /**
     * Установка значения зелёного цветового канала из значения объекта.
     *
     * @param greenChannelHolder Объект с зелёным цветовым каналом
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default GreenChannelHolder setGreen(GreenChannelHolder greenChannelHolder) {
        setGreen(greenChannelHolder.getGreen());
        return this;
    }
}
