import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.colors.Color;

public class BlueChannelHolderTests {
    @Test
    public void testSet() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setBlue(0.1f);
        color.setBlue(expected.getBlue());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet255() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setBlue(0.1f);
        color.setBlue255(expected.getBlue255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet0() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setBlue(0.1f);
        color.setBlue(expected);
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }
}
