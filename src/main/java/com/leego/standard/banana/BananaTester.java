package com.leego.standard.banana;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by YihLeego on 2018.09.23 02:41
 *
 * @author YihLeego
 * @version 1.0.0
 */
public class BananaTester {
    private static final Logger logger = Logger.getLogger("BANANA");
    private static final String TEST_1 = "0123456789";
    private static final String TEST_2 = "qwertyuiopasdfghjklzxcvbnm";
    private static final String TEST_3 = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String TEST_4 = "[]\\;',./~!@#$%^&*()_+/*-+.";
    private static final String HELLO_N_WORLD = "Hello,\nWorld!";
    private static final String HELLO_WORLD = "Hello world!";
    private static final String CUT_LINE = "======================================================================================\n\n\n";

    public static void main(String[] args) {
        logger.info("[Test String]");
        logger.info(BananaUtils.bananaify(TEST_1));
        logger.info(BananaUtils.bananaify(TEST_2));
        logger.info(BananaUtils.bananaify(TEST_3));
        logger.info(BananaUtils.bananaify(TEST_4));
        logger.info(CUT_LINE);

        logger.info("[Test Line Feed]");
        logger.info(BananaUtils.bananaify(HELLO_N_WORLD));
        logger.info(CUT_LINE);

        List<String> fonts = BananaUtils.fonts();
        for (String font : fonts) {
            String result = BananaUtils.bananaify(HELLO_WORLD, font);
            logger.info("Font name : " + font + "\n" + result + "\n\n");
        }
        logger.info(CUT_LINE);
    }
}
