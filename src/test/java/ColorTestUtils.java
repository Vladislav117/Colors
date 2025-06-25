import org.junit.jupiter.api.Assertions;
import ru.vladislav117.colors.Color;
import ru.vladislav117.colors.ColorLike;

public final class ColorTestUtils {
    public static Color firstRGB() {
        return new Color(0.1f, 0.2f, 0.3f);
    }

    public static Color secondRGB() {
        return new Color(0.4f, 0.5f, 0.6f);
    }

    public static Color firstRGBA() {
        return new Color(0.1f, 0.2f, 0.3f, 0.4f);
    }

    public static Color secondRGBA() {
        return new Color(0.5f, 0.6f, 0.7f, 0.8f);
    }

    static boolean aBitSimilarNumber(float expected, float actual) {
        float difference = 0.02f;
        return (expected - difference) <= actual && actual <= (expected + difference);
    }

    public static boolean aBitSimilar(ColorLike expected, ColorLike actual) {
        return aBitSimilarNumber(expected.getRed(), actual.getRed()) && aBitSimilarNumber(expected.getGreen(), actual.getGreen()) && aBitSimilarNumber(expected.getBlue(), actual.getBlue()) && aBitSimilarNumber(expected.getAlpha(), actual.getAlpha());
    }
}
