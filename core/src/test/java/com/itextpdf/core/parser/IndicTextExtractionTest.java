package com.itextpdf.core.parser;

import com.itextpdf.basics.geom.Rectangle;
import com.itextpdf.core.pdf.PdfDocument;
import com.itextpdf.core.pdf.PdfReader;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class IndicTextExtractionTest extends ExtendedITextTest {

    private static final String sourceFolder = "./src/test/resources/com/itextpdf/core/parser/IndicTextExtractionTest/";

    @Test
    @Ignore("Seems to be a problem with decode. Also note that /ActualText is parsed. For pure content stream parsing set" +
            "useActualText to false")
    public void test01() throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(sourceFolder + "test01.pdf"));

        final String expectedText[] = new String[]{
                "\u0928\u093F\u0930\u094D\u0935\u093E\u091A\u0915",
                "\u0928\u0917\u0930\u0928\u093F\u0917\u092E / " +
                        "\u0928\u0917\u0930\u092A\u0930\u093F\u0937\u0926" +
                        " / \u0928\u0917\u0930\u092A\u093E\u0932\u093F\u0915\u093E \u0915\u093E \u0928\u093E\u092E",
                "\u0935 " + "\u0938\u0902\u0916\u094D\u092F\u093E",
                "\u0938\u0902\u0915\u094D\u0937\u093F\u092A\u094D\u0924 \u092A\u0941\u0928\u0930\u0940\u0915\u094D\u0937\u0923",
                "\u092E\u0924\u0926\u093E\u0928 " + "\u0915\u0947\u0928\u094D\u0926\u094D\u0930" +
                        "\u0915\u093E",
                "\u0906\u0930\u0902\u092D\u093F\u0915 " + "\u0915\u094D\u0930\u092E\u0938\u0902\u0916\u094D\u092F\u093E"};

        final Rectangle[] regions = new Rectangle[]{
                new Rectangle(30, 779, 45, 20),
                new Rectangle(30, 745, 210, 20),
                new Rectangle(30, 713, 42, 20),
                new Rectangle(30, 679, 80, 20),
                new Rectangle(30, 647, 73, 20),
                new Rectangle(30, 612, 93, 20)
        };

        final TextRegionEventFilter[] regionFilters = new TextRegionEventFilter[regions.length];
        for (int i = 0; i < regions.length; i++)
            regionFilters[i] = new TextRegionEventFilter(regions[i]);

        FilteredEventListener listener = new FilteredEventListener();
        LocationTextExtractionStrategy[] extractionStrategies = new LocationTextExtractionStrategy[regions.length];
        for (int i = 0; i < regions.length; i++)
            extractionStrategies[i] = listener.attachEventListener(new LocationTextExtractionStrategy().setUseActualText(true), regionFilters[i]);

        new PdfContentStreamProcessor(listener).processPageContent(pdfDocument.getPage(1));

        for (int i = 0; i < regions.length; i++) {
            String actualText = extractionStrategies[i].getResultantText();
            Assert.assertEquals(expectedText[i], actualText);
        }
    }

    @Test
    @Ignore("Seems to be a problem with decode. Also note that /ActualText is parsed. For pure content stream parsing set" +
            "useActualText to false")
    public void test02() throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(sourceFolder + "test01.pdf"));
        String text = "\u0926\u0947\u0935\u0928\u093E\u0917\u0930\u0940 \u090F\u0915 \u0932\u093F\u092A\u093F \u0939\u0948 \u091C\u093F\u0938\u092E\u0947\u0902 \u0905\u0928\u0947\u0915 \u092D\u093E\u0930\u0924\u0940\u092F \u092D\u093E\u0937\u093E\u090F\u0901 \u0924\u0925\u093E \u0915\u0941\u091B \u0935\u093F\u0926\u0947\u0936\u0940 \u092D\u093E\u0937\u093E\u090F\u0902 \u0932\u093F\u0916\u0940\u0902 \u091C\u093E\u0924\u0940 \u0939\u0948\u0902\u0964 \u0926\u0947\u0935\u0928\u093E\u0917\u0930\u0940 \u092C\u093E\u092F\u0947\u0902 \u0938\u0947 \u0926\u093E\u092F\u0947\u0902 \u0932\u093F\u0916\u0940 \u091C\u093E\u0924\u0940 \u0939\u0948, \u0907\u0938\u0915\u0940 \u092A\u0939\u091A\u093E\u0928 \u090F\u0915 \u0915\u094D\u0937\u0948\u0924\u093F\u091C \u0930\u0947\u0916\u093E \u0938\u0947 \u0939\u0948 \u091C\u093F\u0938\u0947 \'\u0936\u093F\u0930\u093F\u0930\u0947\u0916\u093E\' \u0915\u0939\u0924\u0947 \u0939\u0948\u0902\u0964 \u0938\u0902\u0938\u094D\u0915\u0943\u0924, \u092A\u093E\u0932\u093F, \u0939\u093F\u0928\u094D\u0926\u0940, \u092E\u0930\u093E\u0920\u0940, \u0915\u094B\u0902\u0915\u0923\u0940, \u0938\u093F\u0928\u094D\u0927\u0940, \u0915\u0936\u094D\u092E\u0940\u0930\u0940, \u0921\u094B\u0917\u0930\u0940, \u0928\u0947\u092A\u093E\u0932\u0940, \u0928\u0947\u092A\u093E\u0932 \u092D\u093E\u0937\u093E (\u0924\u0925\u093E \u0905\u0928\u094D\u092F \u0928\u0947\u092A\u093E\u0932\u0940 \u0909\u092A\u092D\u093E\u0937\u093E\u090F\u0901), \u0924\u093E\u092E\u093E\u0919 \u092D\u093E\u0937\u093E, \u0917\u0922\u093C\u0935\u093E\u0932\u0940, \u092C\u094B\u0921\u094B, \u0905\u0902\u0917\u093F\u0915\u093E, \u092E\u0917\u0939\u0940, \u092D\u094B\u091C\u092A\u0941\u0930\u0940, \u092E\u0948\u0925\u093F\u0932\u0940, \u0938\u0902\u0925\u093E\u0932\u0940 \u0906\u0926\u093F \u092D\u093E\u0937\u093E\u090F\u0901 \u0926\u0947\u0935\u0928\u093E\u0917\u0930\u0940 \u092E\u0947\u0902 \u0932\u093F\u0916\u0940 \u091C\u093E\u0924\u0940 \u0939\u0948\u0902\u0964 \u0907\u0938\u0915\u0947 \u0905\u0924\u093F\u0930\u093F\u0915\u094D\u0924 \u0915\u0941\u091B \u0938\u094D\u0925\u093F\u0924\u093F\u092F\u094B\u0902 \u092E\u0947\u0902 \u0917\u0941\u091C\u0930\u093E\u0924\u0940, \u092A\u0902\u091C\u093E\u092C\u0940, \u092C\u093F\u0937\u094D\u0923\u0941\u092A\u0941\u0930\u093F\u092F\u093E \u092E\u0923\u093F\u092A\u0941\u0930\u0940, \u0930\u094B\u092E\u093E\u0928\u0940 \u0914\u0930 \u0909\u0930\u094D\u0926\u0942 \u092D\u093E\u0937\u093E\u090F\u0902 \u092D\u0940 \u0926\u0947\u0935\u0928\u093E\u0917\u0930\u0940 \u092E\u0947\u0902 \u0932\u093F\u0916\u0940 \u091C\u093E\u0924\u0940 \u0939\u0948\u0902\u0964";
        Assert.assertEquals(text, TextExtractor.getTextFromPage(pdfDocument.getPage(1), new LocationTextExtractionStrategy().setUseActualText(true)));
    }

}