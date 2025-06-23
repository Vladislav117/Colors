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
     * Установка значения альфа канала.
     *
     * @param alpha Значение альфа канала в диапазоне [0; 1]
     * @return Этот же объект.
     */
    @SuppressWarnings("UnusedReturnValue")
    AlphaChannelHolder setAlpha(float alpha);
}
