package io.github.ozzyozbourne.tests.threaded;

import io.github.ozzyozbourne.pojos.Threaded;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static io.github.ozzyozbourne.Rdwr.*;
import static io.github.ozzyozbourne.tests.Constants.PATH_PRP_RD;
import static io.github.ozzyozbourne.tests.Constants.PATH_PRP_WR;

@Test
public final class PropRWTest {

    public void PropReaderTestOne() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "One"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "1");
    }

    public void PropReaderTestTwo() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Two"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "2");
    }

    public void PropReaderTestThree() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Three"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "3");
    }

    public void PropReaderTestFour() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Four"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "4");
    }

    public void PropReaderTestFive() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Five"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "5");
    }

    public void PropReaderTestSix() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Six"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "6");
    }

    public void PropReaderTestSeven() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Seven"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "7");
    }

    public void PropReaderTestEight() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Eight"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "8");
    }

    public void PropReaderTestNine() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Nine"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "9");
    }

    public void PropReaderTestTen() throws IOException {
        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_RD, "Ten"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "10");
    }


    public void PropReaderTestEleven() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "One"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"), "1");
    }

    public void PropReaderTestTwelve() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Two"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"), "2");
    }

    public void PropReaderTestThirteen() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Three"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"), "3");
    }

    public void PropReaderTestFourteen() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Four"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"), "4");
    }

    public void PropReaderTestFifteen() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Five"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"),"5");
    }

    public void PropReaderTestSixteen() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Six"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"),"6");
    }

    public void PropReaderTestSeventeen() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Seven"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"),"7");
    }

    public void PropReaderTestEighteen() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Eight"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"), "8");
    }

    public void PropReaderTestNineteen() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Nine"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"), "9");
    }

    public void PropReaderTestTwenty() throws IOException {
        val res = readProp(String.format("%s%s.properties", PATH_PRP_RD, "Ten"));
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().get("orderNo"), "10");
    }

    public void PropWriterTestOne() throws IOException {
        val One = new Threaded("1");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "One"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "One")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "One"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "1");
    }

    public void PropWriterTestTwo() throws IOException {
        val One = new Threaded("2");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Two"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Two")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Two"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "2");
    }

    public void PropWriterTestThree() throws IOException {
        val One = new Threaded("3");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Three"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Three")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Three"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "3");
    }

    public void PropWriterTestFour() throws IOException {
        val One = new Threaded("4");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Four"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Four")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Four"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "4");
    }

    public void PropWriterTestFive() throws IOException {
        val One = new Threaded("5");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Five"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Five")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Five"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "5");
    }

    public void PropWriterTestSix() throws IOException {
        val One = new Threaded("6");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Six"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Six")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Six"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "6");
    }

    public void PropWriterTestSeven() throws IOException {
        val One = new Threaded("7");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Seven"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Seven")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Seven"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "7");
    }

    public void PropWriterTestEight() throws IOException {
        val One = new Threaded("8");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Eight"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Eight")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Eight"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "8");
    }

    public void PropWriterTestNine() throws IOException {
        val One = new Threaded("9");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Nine"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Nine")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Nine"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "9");
    }

    public void PropWriterTestTen() throws IOException {
        val One = new Threaded("10");
        writePojoToProperties(String.format("%s%s.properties", PATH_PRP_WR, "Ten"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "Ten")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "Ten"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "10");
    }

    public void PropWriterTestEleven() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "1");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "OneMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "OneMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "OneMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "1");
    }

    public void PropWriterTestTwelve() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "2");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "TwoMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "TwoMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "TwoMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "2");
    }

    public void PropWriterTestThirteen() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "3");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "ThreeMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "ThreeMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "ThreeMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "3");
    }

    public void PropWriterTestFourteen() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "4");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "FourMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "FourMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "FourMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "4");
    }

    public void PropWriterTestFifteen() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "5");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "FiveMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "FiveMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "FiveMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "5");
    }

    public void PropWriterTestSixteen() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "6");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "SixMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "SixMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "SixMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "6");
    }

    public void PropWriterTestSeventeen() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "7");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "SevenMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "SevenMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "SevenMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "7");
    }

    public void PropWriterTestEighteen() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "8");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "EightMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "EightMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "EightMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "8");
    }

    public void PropWriterTestNineteen() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "9");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "NineMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "NineMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "NineMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "9");
    }

    public void PropWriterTestTwenty() throws IOException {
        val One = new HashMap<String, String>();
        One.put("orderNo", "10");

        writeMapToProperties(String.format("%s%s.properties", PATH_PRP_WR, "TenMap"), One);
        Assert.assertTrue(new File(String.format("%s%s.properties", PATH_PRP_WR, "TenMap")).exists());

        val res = readPropToPojo(String.format("%s%s.properties", PATH_PRP_WR, "TenMap"), Threaded.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "10");
    }
}
