import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.colors.Color;

public final class RGBColorSpaceHolderTests {
    @Test
    public void testSetRGB() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGB(expected.getRGB());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGB0() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGB(expected.getRed(), expected.getGreen(), expected.getBlue());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGB255() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGB255(expected.getRGB255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGB2550() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGB255(expected.getRed255(), expected.getGreen255(), expected.getBlue255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBInteger() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGBInteger(expected.getRGBInteger());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBHex() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGBHex(expected.getRGBHex());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSetRGBColor() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGBColor(expected);
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }


    @Test
    public void testSetRGBColor0() {
        Color color = ColorTestUtils.firstRGB();
        Color expected = ColorTestUtils.secondRGB();
        color.setRGBColor(new java.awt.Color(expected.getRed(), expected.getGreen(), expected.getBlue()));
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }
}
