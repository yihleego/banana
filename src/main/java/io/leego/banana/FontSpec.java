package io.leego.banana;

import java.nio.charset.Charset;
import java.nio.file.Path;

public interface FontSpec {
    String getName();

    String getFilename();

    Charset getCharset();
}
