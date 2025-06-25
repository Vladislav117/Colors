package ru.vladislav117.colors.channel.transparency;

import ru.vladislav117.colors.channel.ChannelHolder;

/**
 * Объекты, реализующие этот интерфейс, имеют альфа канал.
 */
public interface AlphaChannelHolder extends ChannelHolder {
    /**
     * Получение значения альфа канала.
     *
     * @return Значение альфа канала в диапазоне [0; 1].
     */
    float getAlpha();

    /**
     * Получение значения альфа канала.
     *
     * @return Значение альфа канала в диапазоне [0; 255].
     */
    default int getAlpha255() {
        return (int) (getAlpha() * 255);
    }

    /**
     * Установка значения альфа канала.
     *
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    AlphaChannelHolder setAlpha(float alpha);

    /**
     * Установка значения альфа канала.
     *
     * @param alpha Значение альфа канала в диапазоне [0; 255]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default AlphaChannelHolder setAlpha255(int alpha) {
        setAlpha(alpha / 255f);
        return this;
    }

    /**
     * Установка значения альфа канала из значения объекта.
     *
     * @param alphaChannelHolder Объект с альфа каналом
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    default AlphaChannelHolder setAlpha(AlphaChannelHolder alphaChannelHolder) {
        setAlpha(alphaChannelHolder.getAlpha());
        return this;
    }
}
