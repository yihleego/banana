package io.leego.banana;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.leego.banana.BananaUtils.classpathFont;
import static io.leego.banana.BananaUtils.filesystemFont;

public class BananaUtilsTest {

    @Test
    public void produce_fonts_md() throws IOException {
        try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(Paths.get("docs/FONTS.md"),
                                                                     StandardCharsets.UTF_8))) {
            for (Font font : BananaUtils.fonts()) {
                String fig_letters = BananaUtils.bananaify("Hello, World!", font);

                w.printf(
                        "%s\n" +
                        "\n" +
                        "```java\n" +
                        "BananaUtils.bananaify(\"Hello, World!\", Font.%s);\n" +
                        "```\n" +
                        "\n" +
                        "```\n" +
                        "%s\n" +
                        "```\n" +
                        "\n",
                        font.getName(),
                        font.name(),
                        fig_letters
                );
            }
        }
    }

    @Test
    public void can_pass_user_provided_fonts_on_the_classpath() {
        String renderedText = BananaUtils.bananaify(
                "custom",
                classpathFont(BananaUtilsTest.class.getClassLoader(),
                              "1 Row",
                              "banana/fonts/" + "1Row.flf"));

        Assert.assertEquals(
                "( |_| _\\~ ~|~ () |\\/| \n" +
                "                      ",
                renderedText
        );
    }

    @Test
    public void can_pass_user_provided_fonts_file() {
        String renderedText = BananaUtils.bananaify(
                "custom",
                filesystemFont(
                        "1 Row",
                        "src/main/resources/banana/fonts/" + "1Row.flf"));

        Assert.assertEquals(
                "( |_| _\\~ ~|~ () |\\/| \n" +
                "                      ",
                renderedText
        );
    }
}