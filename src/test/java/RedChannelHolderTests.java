import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vladislav117.colors.Color;

public class RedChannelHolderTests {
    @Test
    public void testSet() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setRed(0.1f);
        color.setRed(expected.getRed());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet255() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setRed(0.1f);
        color.setRed255(expected.getRed255());
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }

    @Test
    public void testSet0() {
        Color color = ColorTestUtils.firstRGBA();
        Color expected = color.clone().setRed(0.1f);
        color.setRed(expected);
        Assertions.assertTrue(ColorTestUtils.aBitSimilar(expected, color));
    }
}
