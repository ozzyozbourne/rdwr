package io.github.ozzyozbourne.tests.threaded;

import io.github.ozzyozbourne.pojos.threaded.Yaml;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rdwr.readYamlToPojo;
import static io.github.ozzyozbourne.Rdwr.writePojoToYaml;
import static io.github.ozzyozbourne.tests.Constants.PATH_YML_RD;
import static io.github.ozzyozbourne.tests.Constants.PATH_YML_WR;

@Test
public final class YamlRWTest {


    public void YamlReaderTestOne() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "One"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "1");
    }

    public void YamlReaderTestTwo() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Two"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "2");
    }

    public void YamlReaderTestThree() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Three"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "3");
    }

    public void YamlReaderTestFour() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Four"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "4");
    }

    public void YamlReaderTestFive() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Five"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "5");
    }

    public void YamlReaderTestSix() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Six"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "6");
    }

    public void YamlReaderTestSeven() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Seven"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "7");
    }

    public void YamlReaderTestEight() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Eight"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "8");
    }

    public void YamlReaderTestNine() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Nine"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "9");
    }

    public void YamlReaderTestTen() throws IOException {
        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_RD, "Ten"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "10");
    }

    public void YamlWriterTestOne() throws IOException {
        val One = new Yaml("1");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "One"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "One")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "One"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "1");
    }

    public void YamlWriterTestTwo() throws IOException {
        val One = new Yaml("2");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Two"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Two")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Two"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "2");
    }

    public void YamlWriterTestThree() throws IOException {
        val One = new Yaml("3");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Three"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Three")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Three"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "3");
    }

    public void YamlWriterTestFour() throws IOException {
        val One = new Yaml("4");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Four"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Four")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Four"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "4");
    }

    public void YamlWriterTestFive() throws IOException {
        val One = new Yaml("5");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Five"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Five")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Five"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "5");
    }

    public void YamlWriterTestSix() throws IOException {
        val One = new Yaml("6");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Six"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Six")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Six"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "6");
    }

    public void YamlWriterTestSeven() throws IOException {
        val One = new Yaml("7");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Seven"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Seven")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Seven"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "7");
    }

    public void YamlWriterTestEight() throws IOException {
        val One = new Yaml("8");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Eight"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Eight")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Eight"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "8");
    }

    public void YamlWriterTestNine() throws IOException {
        val One = new Yaml("9");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Nine"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Nine")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Nine"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "9");
    }

    public void YamlWriterTestTen() throws IOException {
        val One = new Yaml("10");
        writePojoToYaml(String.format("%s%s.yaml", PATH_YML_WR, "Ten"), One);
        Assert.assertTrue(new File(String.format("%s%s.yaml", PATH_YML_WR, "Ten")).exists());

        val res = readYamlToPojo(String.format("%s%s.yaml", PATH_YML_WR, "Ten"), Yaml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "10");
    }

}