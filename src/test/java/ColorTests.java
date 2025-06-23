import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.colors.Color;

public class ColorTests {
    @Test
    public void testColorFromRGBA() {
        Color color = Color.fromRGBA(0.1f, 0.2f, 0.3f, 0.4f);

        Assertions.assertEquals(0.1f, color.getRed());
        Assertions.assertEquals(0.2f, color.getGreen());
        Assertions.assertEquals(0.3f, color.getBlue());
        Assertions.assertEquals(0.4f, color.getAlpha());
    }

    @Test
    public void testColorFromRGBA255() {
        Color color = Color.fromRGBA255(255, 255 / 2f, 0, 0);

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(0.5f, color.getGreen());
        Assertions.assertEquals(0f, color.getBlue());
        Assertions.assertEquals(0f, color.getAlpha());
    }

    @Test
    public void testColorFromRGBAInt() {
        Color color = Color.fromRGBA(-32768);

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(1f, color.getGreen());
        Assertions.assertEquals(128f / 255f, color.getBlue());
        Assertions.assertEquals(0f, color.getAlpha());
    }

    @Test
    public void testColorFromARGB() {
        Color color = Color.fromARGB(0.4f, 0.1f, 0.2f, 0.3f);

        Assertions.assertEquals(0.1f, color.getRed());
        Assertions.assertEquals(0.2f, color.getGreen());
        Assertions.assertEquals(0.3f, color.getBlue());
        Assertions.assertEquals(0.4f, color.getAlpha());
    }

    @Test
    public void testColorFromARGB255() {
        Color color = Color.fromARGB255(0, 255, 255 / 2f, 0);

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(0.5f, color.getGreen());
        Assertions.assertEquals(0f, color.getBlue());
        Assertions.assertEquals(0f, color.getAlpha());
    }

    @Test
    public void testColorFromARGBInt() {
        Color color = Color.fromARGB(-32768);

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(128f / 255f, color.getGreen());
        Assertions.assertEquals(0f, color.getBlue());
        Assertions.assertEquals(1f, color.getAlpha());
    }

    @Test
    public void testColorFromRGB() {
        Color color = Color.fromRGB(0.1f, 0.2f, 0.3f);

        Assertions.assertEquals(0.1f, color.getRed());
        Assertions.assertEquals(0.2f, color.getGreen());
        Assertions.assertEquals(0.3f, color.getBlue());
    }

    @Test
    public void testColorFromRGB255() {
        Color color = Color.fromRGB255(255, 255 / 2f, 0);

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(0.5f, color.getGreen());
        Assertions.assertEquals(0f, color.getBlue());
    }

    @Test
    public void testColorFromRGBInt() {
        Color color = Color.fromARGB(16744448);

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(128f / 255f, color.getGreen());
        Assertions.assertEquals(0f, color.getBlue());
    }

    @Test
    public void testColorFromHex() {
        Color color = Color.fromHex("#ff00ff");

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(0f, color.getGreen());
        Assertions.assertEquals(1f, color.getBlue());
    }

    @Test
    public void testColorFromAwtColor() {
        Color color = Color.fromAwtColor(java.awt.Color.red);

        Assertions.assertEquals(1f, color.getRed());
        Assertions.assertEquals(0f, color.getGreen());
        Assertions.assertEquals(0f, color.getBlue());
    }

    @Test
    public void testRedChannelSetting() {
        Color color = new Color();

        color.setRed(0.1f);

        Assertions.assertEquals(0.1f, color.getRed());
    }

    @Test
    public void testGreenChannelSetting() {
        Color color = new Color();

        color.setGreen(0.2f);

        Assertions.assertEquals(0.2f, color.getGreen());
    }

    @Test
    public void testBlueChannelSetting() {
        Color color = new Color();

        color.setBlue(0.3f);

        Assertions.assertEquals(0.3f, color.getBlue());
    }

    @Test
    public void testAlphaChannelSetting() {
        Color color = new Color();

        color.setAlpha(0.4f);

        Assertions.assertEquals(0.4f, color.getAlpha());
    }

    @Test
    public void testRGBChannelsSetting() {
        Color color = new Color();

        color.setRGB(new float[]{0.1f, 0.2f, 0.3f});

        Assertions.assertEquals(0.1f, color.getRGB()[0]);
        Assertions.assertEquals(0.2f, color.getRGB()[1]);
        Assertions.assertEquals(0.3f, color.getRGB()[2]);
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
