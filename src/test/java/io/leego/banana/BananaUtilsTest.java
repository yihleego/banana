package io.leego.banana;


import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BananaUtilsTest {

    @Test
    public void produce_fonts_md() throws IOException {
        try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(Paths.get("docs/FONTS.md"),
                                                                     StandardCharsets.UTF_8))) {
            for (Font font : Font.values()) {
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
}