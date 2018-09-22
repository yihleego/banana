package com.leego.standard.banana;

import java.util.List;

/**
 * Created by YihLeego on 2018.09.23 02:41
 *
 * @author YihLeego
 * @version 1.0.0
 */
public class BananaTester {
    private static final String TEST_1 = "0123456789";
    private static final String TEST_2 = "qwertyuiopasdfghjklzxcvbnm";
    private static final String TEST_3 = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String TEST_4 = "[]\\;',./~!@#$%^&*()_+/*-+.";
    private static final String HELLO_N_WORLD = "Hello,\nWorld!";
    private static final String HELLO_WORLD = "Hello world!";
    private static final String CUT_LINE = "======================================================================================\n\n\n";

    public static void main(String[] args) {
        System.out.println("[Test String]");
        System.out.println(BananaUtils.bananaify(TEST_1));
        System.out.println(BananaUtils.bananaify(TEST_2));
        System.out.println(BananaUtils.bananaify(TEST_3));
        System.out.println(BananaUtils.bananaify(TEST_4));
        System.out.println(CUT_LINE);

        System.out.println("[Test Line Feed]");
        System.out.println(BananaUtils.bananaify(HELLO_N_WORLD));
        System.out.println(CUT_LINE);

        List<String> fonts = BananaUtils.fonts();
        for (String font : fonts) {
            String result = BananaUtils.bananaify(HELLO_WORLD, font);
            System.out.println("[" + font + "]\n" + result + "\n\n");
        }
        System.out.println(CUT_LINE);
    }
}
