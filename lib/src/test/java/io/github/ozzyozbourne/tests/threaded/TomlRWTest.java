package io.github.ozzyozbourne.tests.threaded;

import io.github.ozzyozbourne.pojos.threaded.Toml;
import io.github.ozzyozbourne.pojos.threaded.Yaml;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.github.ozzyozbourne.Rdwr.readTomlToPojo;
import static io.github.ozzyozbourne.Rdwr.writePojoToToml;
import static io.github.ozzyozbourne.tests.Constants.PATH_TML_RD;
import static io.github.ozzyozbourne.tests.Constants.PATH_TML_WR;

@Test
public final class TomlRWTest {

    public void TomlReaderTestOne() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "One"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "1");
    }

    public void TomlReaderTestTwo() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Two"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "2");
    }

    public void TomlReaderTestThree() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Three"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "3");
    }

    public void TomlReaderTestFour() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Four"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "4");
    }

    public void TomlReaderTestFive() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Five"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "5");
    }

    public void TomlReaderTestSix() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Six"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "6");
    }

    public void TomlReaderTestSeven() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Seven"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "7");
    }

    public void TomlReaderTestEight() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Eight"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "8");
    }

    public void TomlReaderTestNine() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Nine"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "9");
    }

    public void TomlReaderTestTen() throws IOException {
        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_RD, "Ten"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "10");
    }

    public void TomlWriterTestOne() throws IOException {
        val One = new Yaml("1");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "One"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "One")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "One"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "1");
    }

    public void TomlWriterTestTwo() throws IOException {
        val One = new Yaml("2");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Two"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Two")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Two"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "2");
    }

    public void TomlWriterTestThree() throws IOException {
        val One = new Yaml("3");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Three"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Three")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Three"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "3");
    }

    public void TomlWriterTestFour() throws IOException {
        val One = new Yaml("4");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Four"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Four")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Four"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "4");
    }

    public void TomlWriterTestFive() throws IOException {
        val One = new Yaml("5");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Five"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Five")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Five"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "5");
    }

    public void TomlWriterTestSix() throws IOException {
        val One = new Yaml("6");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Six"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Six")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Six"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "6");
    }

    public void TomlWriterTestSeven() throws IOException {
        val One = new Yaml("7");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Seven"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Seven")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Seven"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "7");
    }

    public void TomlWriterTestEight() throws IOException {
        val One = new Yaml("8");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Eight"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Eight")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Eight"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "8");
    }

    public void TomlWriterTestNine() throws IOException {
        val One = new Yaml("9");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Nine"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Nine")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Nine"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "9");
    }

    public void TomlWriterTestTen() throws IOException {
        val One = new Yaml("10");
        writePojoToToml(String.format("%s%s.toml", PATH_TML_WR, "Ten"), One);
        Assert.assertTrue(new File(String.format("%s%s.toml", PATH_TML_WR, "Ten")).exists());

        val res = readTomlToPojo(String.format("%s%s.toml", PATH_TML_WR, "Ten"), Toml.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "10");
    }
}
