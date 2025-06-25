import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.colors.Color;

public class AlphaChannelHolderTests {
    @Test
    public void testSet() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setAlpha(0.1f);
        color.setAlpha(expected.getAlpha());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet255() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setAlpha(0.1f);
        color.setAlpha255(expected.getAlpha255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet0() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setAlpha(0.1f);
        color.setAlpha(expected);
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }
}
