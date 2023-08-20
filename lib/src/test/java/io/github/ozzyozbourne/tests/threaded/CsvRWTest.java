package io.github.ozzyozbourne.tests.threaded;

import io.github.ozzyozbourne.pojos.Threaded;
import lombok.val;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.github.ozzyozbourne.Rdwr.*;
import static io.github.ozzyozbourne.tests.Constants.*;

@Test
public final class CsvRWTest {

    public void CsvReaderTestOne() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "One.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "1");
    }

    public void CsvReaderTestTwo() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Two.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "2");
    }

    public void CsvReaderTestThree() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Three.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "3");
    }

    public void CsvReaderTestFour() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Four.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "4");
    }

    public void CsvReaderTestFive() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Five.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "5");
    }

    public void CsvReaderTestSix() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Six.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "6");
    }

    public void CsvReaderTestSeven() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Seven.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "7");
    }

    public void CsvReaderTestEight() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Eight.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "8");
    }

    public void CsvReaderTestNine() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Nine.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "9");
    }

    public void CsvReaderTestTen() throws IOException {
        val csvOptional  = readCsvToPojo(PATH_CSV_RD + "Ten.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "10");
    }

    public void CsvWriterTestOne() throws IOException {
        val One = new Threaded("1");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "One"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "One")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "One.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "1");
    }

    public void YamlWriterTestTwo() throws IOException {
        val One = new Threaded("2");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Two"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Two")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Two.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "2");
    }

    public void YamlWriterTestThree() throws IOException {
        val One = new Threaded("3");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Three"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Three")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Three.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "3");
    }

    public void YamlWriterTestFour() throws IOException {
        val One = new Threaded("4");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Four"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Four")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Four.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "4");
    }

    public void YamlWriterTestFive() throws IOException {
        val One = new Threaded("5");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Five"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Five")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Five.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "5");
    }

    public void YamlWriterTestSix() throws IOException {
        val One = new Threaded("6");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Six"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Six")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Six.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "6");
    }

    public void YamlWriterTestSeven() throws IOException {
        val One = new Threaded("7");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Seven"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Seven")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Seven.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "7");
    }

    public void YamlWriterTestEight() throws IOException {
        val One = new Threaded("8");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Eight"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Eight")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Eight.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "8");
    }

    public void YamlWriterTestNine() throws IOException {
        val One = new Threaded("9");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Nine"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Nine")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Nine.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "9");
    }

    public void YamlWriterTestTen() throws IOException {
        val One = new Threaded("10");
        writePojoToCsv(String.format("%s%s.csv", PATH_CSV_WR, "Ten"), List.of(One), ',', false);
        Assert.assertTrue(new File(String.format("%s%s.csv", PATH_CSV_WR, "Ten")).exists());

        val csvOptional  = readCsvToPojo(PATH_CSV_WR + "Ten.csv", Threaded.class, ',', false);
        Assert.assertTrue(csvOptional.isPresent());
        Assert.assertEquals(csvOptional.get().size(), 1);
        Assert.assertEquals(csvOptional.get().get(0).orderNo(), "10");
    }
}
