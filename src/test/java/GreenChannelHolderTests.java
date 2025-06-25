import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.colors.Color;

public class GreenChannelHolderTests {
    @Test
    public void testSet() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setGreen(0.1f);
        color.setGreen(expected.getGreen());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet255() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setGreen(0.1f);
        color.setGreen255(expected.getGreen255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet0() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setGreen(0.1f);
        color.setGreen(expected);
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }
}
