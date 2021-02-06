package io.leego.banana;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;

public interface FontSpec {
    String getName();

    String getFilename();

    Charset getCharset();

    InputStream getResourceStream() throws IOException;
}
