import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.colors.Color;

public final class ColorLikeTests {
    @Test
    public void testSetRGBA() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBA(expected.getRGBA());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBA0() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBA(expected.getRed(), expected.getGreen(), expected.getBlue(), expected.getAlpha());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBA255() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBA255(expected.getRGBA255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBA2550() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBA255(expected.getRed255(), expected.getGreen255(), expected.getBlue255(), expected.getAlpha255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBAInteger() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBAInteger(expected.getRGBAInteger());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBAHex() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBAHex(expected.getRGBAHex());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBAColor() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBAColor(expected);
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }


    @Test
    public void testSetRGBAColor0() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setRGBAColor(new java.awt.Color(expected.getRed(), expected.getGreen(), expected.getBlue(), expected.getAlpha()));
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetARGB() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setARGB(expected.getARGB());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetARGB0() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setARGB(expected.getAlpha(), expected.getRed(), expected.getGreen(), expected.getBlue());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetARGB255() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setARGB255(expected.getARGB255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetARGB2550() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setARGB255(expected.getAlpha255(), expected.getRed255(), expected.getGreen255(), expected.getBlue255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetARGBInteger() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setARGBInteger(expected.getARGBInteger());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetARGBHex() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = ColorTestUtils.secondRGBA();
        color.setARGBHex(expected.getARGBHex());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testMixing() {
        Color color1 = new Color(0.5f, 0, 0);
        Color color2 = new Color(0, 0.5f, 0);

        color1.mix(color2);

        Assertions.assertEquals(0.25f, color1.getRed());
        Assertions.assertEquals(0.25f, color1.getGreen());
        Assertions.assertEquals(0, color1.getBlue());
    }

    @Test
    public void testMixingWithRatio() {
        Color color1 = new Color(1, 0, 0);
        Color color2 = new Color(0, 1, 0);

        color1.mix(color2, 0.1f);

        Assertions.assertEquals(0.9f, color1.getRed());
        Assertions.assertEquals(0.1f, color1.getGreen());
        Assertions.assertEquals(0, color1.getBlue());
    }

    @Test
    public void testComparing() {
        Color color1 = new Color(1, 0, 0);
        Color color2 = new Color(1, 0, 0, 0);
        Color color3 = new Color(1, 0, 0, 1);

        boolean equals2 = color1.equals(color2);
        boolean equals3 = color1.equals(color3);

        Assertions.assertFalse(equals2);
        Assertions.assertTrue(equals3);
    }
}
