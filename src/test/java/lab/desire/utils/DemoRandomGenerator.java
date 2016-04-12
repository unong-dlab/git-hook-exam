package lab.desire.utils;

import lab.desire.domain.CoordiType;
import lab.desire.domain.Product;
import lab.desire.domain.Style;
import lab.desire.domain.Styling;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by unong on 4/11/16.
 */
public class DemoRandomGenerator {
    private DemoRandomGenerator() {}

    public static Style genStyle() {
        return genStyle(RandomStringUtils.randomAlphanumeric(4));
    }

    public static Style genStyle(int idx) {
        return genStyle("Idx" + idx);
    }

    public static Style genStyle(String suffix) {
        return new Style("StyleID" + suffix, "코디" + suffix, "http://localhost/coordi.image." + suffix);
    }

    public static Product genProduct() {
        return genProduct(RandomStringUtils.randomAlphanumeric(4));
    }

    public static Product genProduct(int idx) {
        return genProduct("Idx" + idx);
    }

    public static Product genProduct(String suffix) {
        return new Product("상품ID" + suffix, "상품명" + suffix, "http://localhost/product.image." + suffix);
    }

    public static Styling mapStyling(String sid, String pid, CoordiType t) {
        return new Styling(new Style(sid), new Product(pid), t);
    }
    public static Styling mapStyling(Style style, Product product, CoordiType t) {
        return new Styling(style, product, t);
    }
}