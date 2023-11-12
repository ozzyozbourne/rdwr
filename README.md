[![Maven Central](https://img.shields.io/maven-central/v/io.github.ozzyozbourne/rdwr.svg?label=Maven%20Central)](https://search.maven.org/artifact/io.github.ozzyozbourne/rdwr)

# Rdwr

rdwr is a versatile Java library that provides readers and writers for various data formats, making it easier for developers to work with different file types, including Toml, Yaml, CSV, Json, Xml, and Property files. This library simplifies the process of reading data from these formats into Java objects and writing Java objects back into these formats.

## Features

- Read data from and write data to Toml files.
- Read data from and write data to Yaml files.
- Read data from and write data to CSV files.
- Read data from and write data to Json files.
- Read data from and write data to Xml files.
- Read data from and write data to Property files.

## Getting Started

### Installation

To start using rdwr in your Java project, you can include it as a dependency using Maven or Gradle. Here's an example of how to do it with Maven:

```xml
<dependency>
    <groupId>io.github.ozzyozbourne</groupId>
    <artifactId>rdwr</artifactId>
    <version>0.4.1</version>
</dependency>
```
### Usage 

#### Reader

```java
@Test
public final class ReaderTests {


    public void YamlTestOne() throws IOException {
        val res = readYamlToPojo(PATH_TO_RD + "YamlTest.yaml", Order.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "A001");
    }

    public void YamlTestTwo() throws IOException {
        val res = srcInYaml("$.ORDER_NO", PATH_TO_RD + "YamlTest.yaml");
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get(), "A001");
    }


    public void TomlTestOne() throws IOException {
        val res = readTomlToPojo(PATH_TO_RD + "TomlTest.toml", Order.class);
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get().orderNo(), "A001");
    }

    public void TomlTestTwo() throws IOException {
        Optional<String> res = srcInToml("$.ORDER_NO", PATH_TO_RD + "TomlTest.toml");
        Assert.assertTrue(res.isPresent());
        Assert.assertEquals(res.get(), "A001");
    }
}
```
#### Writer

```java
@Test
public final class WriterTests {

    public void YamlTestOne() throws IOException {
        val res = readYamlToPojo(PATH_TO_RD + "YamlTest.yaml", Order.class);
        Assert.assertTrue(res.isPresent());

        writePojoToYaml(PATH_TO_WR + "YamlTest.yaml", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "YamlTest.yaml").exists());
    }

    public void TomlTestOne() throws IOException {
        val res = readTomlToPojo(PATH_TO_RD + "TomlTest.toml", Order.class);
        Assert.assertTrue(res.isPresent());

        writePojoToToml(PATH_TO_WR + "TomlTest.toml", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "TomlTest.toml").exists());
    }

    public void PropTestOne() throws IOException {
        val res = readProp(PATH_TO_RD + "Test.properties");
        Assert.assertTrue(res.isPresent());

        writePojoToProperties(PATH_TO_WR + "Test.properties", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "Test.properties").exists());
    }

    public void PropTestTwo() throws IOException {
        val res = readPropToPojo(PATH_TO_RD + "Test.properties", Prop.class);
        Assert.assertTrue(res.isPresent());

        writePojoToProperties(PATH_TO_WR + "TestTwo.properties", res.get());
        Assert.assertTrue(new File(PATH_TO_WR + "TestTwo.properties").exists());
    }
}
```

A comprehensive usage is present in the tests directory

### Contribution

Contributions to this library are welcome. Feel free to open issues or submit pull requests to improve the functionality or add support for additional data formats.


