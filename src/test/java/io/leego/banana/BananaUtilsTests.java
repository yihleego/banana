package io.leego.banana;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BananaUtilsTests {

    @Test
    public void testExample() {
        // @formatter:off
        String expected =
                "  _   _      _ _          ____                                _ \n" +
                " | | | | ___| | | ___    | __ )  __ _ _ __   __ _ _ __   __ _| |\n" +
                " | |_| |/ _ \\ | |/ _ \\   |  _ \\ / _` | '_ \\ / _` | '_ \\ / _` | |\n" +
                " |  _  |  __/ | | (_) |  | |_) | (_| | | | | (_| | | | | (_| |_|\n" +
                " |_| |_|\\___|_|_|\\___( ) |____/ \\__,_|_| |_|\\__,_|_| |_|\\__,_(_)\n" +
                "                     |/                                         ";
        // @formatter:on
        String actual = BananaUtils.bananaify("Hello, Banana!");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultiline() {
        // @formatter:off
        String expected =
                "     _    ____   ____ ____  _____ _____ ____ _   _ ___    _ _  ___     __  __ _   _  ___  ____   ___  ____  ____ _____ _   ___     ____        ____  ____   _______\n" +
                "    / \\  | __ ) / ___|  _ \\| ____|  ___/ ___| | | |_ _|  | | |/ / |   |  \\/  | \\ | |/ _ \\|  _ \\ / _ \\|  _ \\/ ___|_   _| | | \\ \\   / /\\ \\      / /\\ \\/ /\\ \\ / /__  /\n" +
                "   / _ \\ |  _ \\| |   | | | |  _| | |_ | |  _| |_| || |_  | | ' /| |   | |\\/| |  \\| | | | | |_) | | | | |_) \\___ \\ | | | | | |\\ \\ / /  \\ \\ /\\ / /  \\  /  \\ V /  / / \n" +
                "  / ___ \\| |_) | |___| |_| | |___|  _|| |_| |  _  || | |_| | . \\| |___| |  | | |\\  | |_| |  __/| |_| |  _ < ___) || | | |_| | \\ V /    \\ V  V /   /  \\   | |  / /_ \n" +
                " /_/   \\_\\____/ \\____|____/|_____|_|   \\____|_| |_|___\\___/|_|\\_\\_____|_|  |_|_| \\_|\\___/|_|    \\__\\_\\_| \\_\\____/ |_|  \\___/   \\_/      \\_/\\_/   /_/\\_\\  |_| /____|\n" +
                "   __ _| |__   ___ __| | ___ / _| __ _| |__ (_)(_) | _| |_ __ ___  _ __   ___  _ __   __ _ _ __ ___| |_ _   ___   ____      ____  ___   _ ____                     \n" +
                "  / _` | '_ \\ / __/ _` |/ _ \\ |_ / _` | '_ \\| || | |/ / | '_ ` _ \\| '_ \\ / _ \\| '_ \\ / _` | '__/ __| __| | | \\ \\ / /\\ \\ /\\ / /\\ \\/ / | | |_  /                     \n" +
                " | (_| | |_) | (_| (_| |  __/  _| (_| | | | | || |   <| | | | | | | | | | (_) | |_) | (_| | |  \\__ \\ |_| |_| |\\ V /  \\ V  V /  >  <| |_| |/ /                      \n" +
                "  \\__,_|_.__/ \\___\\__,_|\\___|_|  \\__, |_| |_|_|/ |_|\\_\\_|_| |_| |_|_| |_|\\___/| .__/ \\__, |_|  |___/\\__|\\__,_| \\_/    \\_/\\_/  /_/\\_\\\\__, /___|                     \n" +
                "  _ ____  _____ _  _  ____   __ _|___/___  __|__/___                 _   _ _  |_|      _|_|_   ___  __                              |___/                          \n" +
                " / |___ \\|___ /| || || ___| / /|___  ( _ )/ _ \\ / _ \\    _       _  ( ) ( | ) \\ \\     / / | | |__ \\ \\ \\     _            __/\\__    / /  _____                      \n" +
                " | | __) | |_ \\| || ||___ \\| '_ \\ / // _ \\ (_) | | | |  (_)     (_) |/   V V   \\ \\   | |  | |   / /  | |  _| |_   _____  \\    /   / /  |_____|                     \n" +
                " | |/ __/ ___) |__   _|__) | (_) / /| (_) \\__, | |_| |   _   _   _              \\ \\  | |  |_|  |_|   | | |_   _| |_____| /_  _\\  / /   |_____|                     \n" +
                " |_|_____|____/   |_||____/ \\___/_/  \\___/  /_/ \\___(_) (_) ( ) ( )              \\_\\ | |  (_)  (_)   | |   |_|             \\/   /_/                                \n" +
                "                                                            |/  |/                    \\_\\           /_/                                                            ";
        // @formatter:on
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ\n"
                + "abcdefghijklmnopqrstuvwxyz\n"
                + "1234567890" + ". : , ; ' \" \\ ( ! ? ) + - * / =";
        String actual = BananaUtils.bananaify(s);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFont3DASCII() {
        // @formatter:off
        String expected =
                " ___  ___  _______   ___       ___       ________                ___       __   ________  ________  ___       ________  ___       \n" +
                "|\\  \\|\\  \\|\\  ___ \\ |\\  \\     |\\  \\     |\\   __  \\              |\\  \\     |\\  \\|\\   __  \\|\\   __  \\|\\  \\     |\\   ___ \\|\\  \\      \n" +
                "\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\    \\ \\  \\    \\ \\  \\|\\  \\             \\ \\  \\    \\ \\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\    \\ \\  \\_|\\ \\ \\  \\     \n" +
                " \\ \\   __  \\ \\  \\_|/_\\ \\  \\    \\ \\  \\    \\ \\  \\\\\\  \\  ___        \\ \\  \\  __\\ \\  \\ \\  \\\\\\  \\ \\   _  _\\ \\  \\    \\ \\  \\ \\\\ \\ \\  \\    \n" +
                "  \\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\____\\ \\  \\\\\\  \\|\\  \\        \\ \\  \\|\\__\\_\\  \\ \\  \\\\\\  \\ \\  \\\\  \\\\ \\  \\____\\ \\  \\_\\\\ \\ \\__\\   \n" +
                "   \\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\  \\        \\ \\____________\\ \\_______\\ \\__\\\\ _\\\\ \\_______\\ \\_______\\|__|   \n" +
                "    \\|__|\\|__|\\|_______|\\|_______|\\|_______|\\|_______|\\/  /|        \\|____________|\\|_______|\\|__|\\|__|\\|_______|\\|_______|   ___ \n" +
                "                                                    |\\___/ /                                                                 |\\__\\\n" +
                "                                                    \\|___|/                                                                  \\|__|\n" +
                "                                                                                                                                  ";
        // @formatter:on
        String actual = BananaUtils.bananaify("Hello, World!", Font.THREE_D_ASCII);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFontANSIShadow() {
        // @formatter:off
        String expected =
                "██╗  ██╗███████╗██╗     ██╗      ██████╗        ██╗    ██╗ ██████╗ ██████╗ ██╗     ██████╗ ██╗\n" +
                "██║  ██║██╔════╝██║     ██║     ██╔═══██╗       ██║    ██║██╔═══██╗██╔══██╗██║     ██╔══██╗██║\n" +
                "███████║█████╗  ██║     ██║     ██║   ██║       ██║ █╗ ██║██║   ██║██████╔╝██║     ██║  ██║██║\n" +
                "██╔══██║██╔══╝  ██║     ██║     ██║   ██║       ██║███╗██║██║   ██║██╔══██╗██║     ██║  ██║╚═╝\n" +
                "██║  ██║███████╗███████╗███████╗╚██████╔╝▄█╗    ╚███╔███╔╝╚██████╔╝██║  ██║███████╗██████╔╝██╗\n" +
                "╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝ ╚═╝     ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ ╚═╝\n" +
                "                                                                                              ";
        // @formatter:on
        String actual = BananaUtils.bananaify("Hello, World!", Font.ANSI_SHADOW);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFontSmall() {
        // @formatter:off
        String expected =
                "  _  _     _ _        __      __       _    _ _ \n" +
                " | || |___| | |___    \\ \\    / /__ _ _| |__| | |\n" +
                " | __ / -_) | / _ \\_   \\ \\/\\/ / _ \\ '_| / _` |_|\n" +
                " |_||_\\___|_|_\\___( )   \\_/\\_/\\___/_| |_\\__,_(_)\n" +
                "                  |/                            ";
        // @formatter:on
        String actual = BananaUtils.bananaify("Hello, World!", Font.SMALL);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFontBloody() {
        // @formatter:off
        String expected =
                " ██░ ██ ▓█████  ██▓     ██▓     ▒█████      █     █░ ▒█████   ██▀███   ██▓    ▓█████▄  ▐██▌ \n" +
                "▓██░ ██▒▓█   ▀ ▓██▒    ▓██▒    ▒██▒  ██▒   ▓█░ █ ░█░▒██▒  ██▒▓██ ▒ ██▒▓██▒    ▒██▀ ██▌ ▐██▌ \n" +
                "▒██▀▀██░▒███   ▒██░    ▒██░    ▒██░  ██▒   ▒█░ █ ░█ ▒██░  ██▒▓██ ░▄█ ▒▒██░    ░██   █▌ ▐██▌ \n" +
                "░▓█ ░██ ▒▓█  ▄ ▒██░    ▒██░    ▒██   ██░   ░█░ █ ░█ ▒██   ██░▒██▀▀█▄  ▒██░    ░▓█▄   ▌ ▓██▒ \n" +
                "░▓█▒░██▓░▒████▒░██████▒░██████▒░ ████▓▒░   ░░██▒██▓ ░ ████▓▒░░██▓ ▒██▒░██████▒░▒████▓  ▒▄▄  \n" +
                " ▒ ░░▒░▒░░ ▒░ ░░ ▒░▓  ░░ ▒░▓  ░░ ▒░▒░▒░    ░ ▓░▒ ▒  ░ ▒░▒░▒░ ░ ▒▓ ░▒▓░░ ▒░▓  ░ ▒▒▓  ▒  ░▀▀▒ \n" +
                " ▒ ░▒░ ░ ░ ░  ░░ ░ ▒  ░░ ░ ▒  ░  ░ ▒ ▒░      ▒ ░ ░    ░ ▒ ▒░   ░▒ ░ ▒░░ ░ ▒  ░ ░ ▒  ▒  ░  ░ \n" +
                " ░  ░░ ░   ░     ░ ░     ░ ░   ░ ░ ░ ▒       ░   ░  ░ ░ ░ ▒    ░░   ░   ░ ░    ░ ░  ░     ░ \n" +
                " ░  ░  ░   ░  ░    ░  ░    ░  ░    ░ ░         ░        ░ ░     ░         ░  ░   ░     ░    \n" +
                "                                                                               ░            ";
        // @formatter:on
        String actual = BananaUtils.bananaify("Hello, World!", Font.BLOODY);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLayoutFitted() {
        // @formatter:off
        String expected =
                "  ____                                            _                          _    _            _                                       _                               _               _       _    _                               _  _     \n" +
                " | __ )   __ _  _ __    __ _  _ __    __ _  ___  | |__    __ _ __   __ ___  | |_ | |__    ___ (_) _ __    ___ __      __ _ __     ___ | |__    __ _  _ __  __ _   ___ | |_  ___  _ __ (_) ___ | |_ (_)  ___   ___  _ __ ___    ___ | || |    \n" +
                " |  _ \\  / _` || '_ \\  / _` || '_ \\  / _` |/ __| | '_ \\  / _` |\\ \\ / // _ \\ | __|| '_ \\  / _ \\| || '__|  / _ \\\\ \\ /\\ / /| '_ \\   / __|| '_ \\  / _` || '__|/ _` | / __|| __|/ _ \\| '__|| |/ __|| __|| | / __| / __|| '_ ` _ \\  / _ \\| || |    \n" +
                " | |_) || (_| || | | || (_| || | | || (_| |\\__ \\ | | | || (_| | \\ V /|  __/ | |_ | | | ||  __/| || |    | (_) |\\ V  V / | | | | | (__ | | | || (_| || |  | (_| || (__ | |_|  __/| |   | |\\__ \\| |_ | || (__  \\__ \\| | | | | ||  __/| || | _  \n" +
                " |____/  \\__,_||_| |_| \\__,_||_| |_| \\__,_||___/ |_| |_| \\__,_|  \\_/  \\___|  \\__||_| |_| \\___||_||_|     \\___/  \\_/\\_/  |_| |_|  \\___||_| |_| \\__,_||_|   \\__,_| \\___| \\__|\\___||_|   |_||___/ \\__||_| \\___| |___/|_| |_| |_| \\___||_||_|( ) \n" +
                "                    _   _    _                                                         _  _              _  _                    _    _  _      _                                                                                        |/  \n" +
                "   __ _  _ __    __| | | |_ | |__    ___  _   _    __ _  _ __  ___    ___   __ _  ___ (_)| | _   _    __| |(_)  __ _   ___  ___ | |_ (_)| |__  | |  ___                                                                                      \n" +
                "  / _` || '_ \\  / _` | | __|| '_ \\  / _ \\| | | |  / _` || '__|/ _ \\  / _ \\ / _` |/ __|| || || | | |  / _` || | / _` | / _ \\/ __|| __|| || '_ \\ | | / _ \\                                                                                     \n" +
                " | (_| || | | || (_| | | |_ | | | ||  __/| |_| | | (_| || |  |  __/ |  __/| (_| |\\__ \\| || || |_| | | (_| || || (_| ||  __/\\__ \\| |_ | || |_) || ||  __/ _                                                                                   \n" +
                "  \\__,_||_| |_| \\__,_|  \\__||_| |_| \\___| \\__, |  \\__,_||_|   \\___|  \\___| \\__,_||___/|_||_| \\__, |  \\__,_||_| \\__, | \\___||___/ \\__||_||_.__/ |_| \\___|(_)                                                                                  \n" +
                "                                          |___/                                              |___/             |___/                                                                                                                         ";
        // @formatter:on
        String actual = BananaUtils.bananaify("Bananas have their own characteristic smell, \nand they are easily digestible.", Layout.FITTED, Layout.FITTED);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLayoutSmushU() {
        // @formatter:off
        String expected =
                "  ____                                      _                       _   _          _                                   _                          _            _     _   _                           _ _    \n" +
                " | __ )  __ _ _ __   __ _ _ __   __ _ ___  | |__   __ ___   _____  | |_| |__   ___(_)_ __    _____      ___ __     ___| |__   __ _ _ __ __ _  ___| |_ ___ _ __(_)___| |_(_) ___   ___ _ __ ___   ___| | |   \n" +
                " |  _ \\ / _` | '_ \\ / _` | '_ \\ / _` / __| | '_ \\ / _` \\ \\ / / _ \\ | __| '_ \\ / _ | | '__|  / _ \\ \\ /\\ / | '_ \\   / __| '_ \\ / _` | '__/ _` |/ __| __/ _ | '__| / __| __| |/ __| / __| '_ ` _ \\ / _ | | |   \n" +
                " | |_) | (_| | | | | (_| | | | | (_| \\__ \\ | | | | (_| |\\ V |  __/ | |_| | | |  __| | |    | (_) \\ V  V /| | | | | (__| | | | (_| | | | (_| | (__| ||  __| |  | \\__ | |_| | (__  \\__ | | | | | |  __| | |_  \n" +
                " |____/ \\__,_|_| |_|\\__,_|_| |_|\\__,_|___/ |_| |_|\\__,_| \\_/ \\___|  \\__|_| |__\\___|_|_|     \\___/ \\_/\\_/ |_| |_|_ \\_____| |__\\__,_|_|  \\__,_|\\___|\\__\\___|_|  |_|___/\\__|_|\\___| |___|_| |_| |_|\\___|_|_( ) \n" +
                "   __ _ _ __   __| | | |_| |__   ___ _   _    __ _ _ __ ___    ___  __ _ ___(_| |_   _    __| (_) __ _  ___ ___| |_(_| |__ | | ___                                                                      |/  \n" +
                "  / _` | '_ \\ / _` | | __| '_ \\ / _ | | | |  / _` | '__/ _ \\  / _ \\/ _` / __| | | | | |  / _` | |/ _` |/ _ / __| __| | '_ \\| |/ _ \\                                                                         \n" +
                " | (_| | | | | (_| | | |_| | | |  __| |_| | | (_| | | |  __/ |  __| (_| \\__ | | | |_| | | (_| | | (_| |  __\\__ | |_| | |_) | |  __/_                                                                        \n" +
                "  \\__,_|_| |_|\\__,_|  \\__|_| |_|\\___|\\__, |  \\__,_|_|  \\___|  \\___|\\__,_|___|_|_|\\__, |  \\__,_|_|\\__, |\\___|___/\\__|_|_.__/|_|\\___(_)                                                                       \n" +
                "                                     |___/                                       |___/           |___/                                                                                                      ";
        // @formatter:on
        String actual = BananaUtils.bananaify("Bananas have their own characteristic smell, \nand they are easily digestible.", Layout.SMUSH_U, Layout.SMUSH_U);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGenerateFontDocs() throws IOException, IllegalAccessException {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("docs/FONTS.md"), StandardCharsets.UTF_8))) {
            for (Font font : Font.values()) {
                // @formatter:off
                String format =
                        "%s\n\n" +
                        "```java\n" +
                        "BananaUtils.bananaify(\"Hello, World!\", Font.%s);\n" +
                        "```\n\n" +
                        "```\n" +
                        "%s\n" +
                        "```\n\n";
                // @formatter:on
                String content = BananaUtils.bananaify("Hello, World!", font);
                writer.printf(format, font.getName(), getFieldName(font), content);
            }
        }
    }

    @Test
    public void testGenerateLayoutDocs() throws IOException {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("docs/LAYOUTS.md"), StandardCharsets.UTF_8))) {
            for (Layout h : Layout.values()) {
                for (Layout v : Layout.values()) {
                    // @formatter:off
                    String format =
                            "Horizontal Layout: %s, Vertical Layout: %s\n\n" +
                            "```java\n" +
                            "BananaUtils.bananaify(\"Bananas have their own characteristic smell, \\nand they are easily digestible.\", Layout.%s, Layout.%s);\n" +
                            "```\n\n" +
                            "```\n" +
                            "%s\n" +
                            "```\n\n";
                    // @formatter:on
                    String content = BananaUtils.bananaify("Bananas have their own characteristic smell, \nand they are easily digestible.", h, v);
                    writer.printf(format, h.name(), v.name(), h.name(), v.name(), content);
                }
            }
        }
    }

    @Test
    public void testAllFonts() {
        for (Font font : Font.values()) {
            System.out.println(font.getName());
            System.out.println(BananaUtils.bananaify("Hello, World!", font));
            System.out.println();
        }
    }

    @Test
    public void testAllAnsis() {
        for (Ansi ansi : Ansi.values()) {
            System.out.println(ansi.getAnsi());
            System.out.println(BananaUtils.bananansi("Hello, World!", ansi));
            System.out.println();
        }
    }

    @Test
    public void testAllLayouts() {
        for (Layout h : Layout.values()) {
            for (Layout v : Layout.values()) {
                System.out.println(h.name() + " " + v.name());
                System.out.println(BananaUtils.bananaify("Bananas have their own characteristic smell, \nand they are easily digestible.", h, v));
                System.out.println();
            }
        }
    }

    private <T> String getFieldName(T t) throws IllegalAccessException {
        for (Field field : Font.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())
                    && Modifier.isPublic(field.getModifiers())
                    && field.get(t) == t) {
                return field.getName();
            }
        }
        return null;
    }

}