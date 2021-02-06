package io.leego.banana;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Yihleego
 */
public class Font {
    public static final Font ONE_ROW;
    public static final Font THREE_D;
    public static final Font THREE_D_ASCII;
    public static final Font THREE_D_DIAGONAL;
    public static final Font THREE_FIVE;
    public static final Font FOUR_MAX;
    public static final Font FIVE_LINE_OBLIQUE;
    public static final Font AMC_3_LINE;
    public static final Font AMC_3_LIV1;
    public static final Font AMC_AAA01;
    public static final Font AMC_NEKO;
    public static final Font AMC_RAZOR;
    public static final Font AMC_RAZOR2;
    public static final Font AMC_SLASH;
    public static final Font AMC_SLIDER;
    public static final Font AMC_THIN;
    public static final Font AMC_TUBES;
    public static final Font AMC_UNTITLED;
    public static final Font ANSI_SHADOW;
    public static final Font ASCII_NEW_ROMAN;
    public static final Font ACROBATIC;
    public static final Font ALLIGATOR;
    public static final Font ALLIGATOR2;
    public static final Font ALPHA;
    public static final Font ALPHABET;
    public static final Font ARROWS;
    public static final Font AVATAR;
    public static final Font BANNER;
    public static final Font BANNER3_D;
    public static final Font BANNER3;
    public static final Font BANNER4;
    public static final Font BARBWIRE;
    public static final Font BASIC;
    public static final Font BEAR;
    public static final Font BELL;
    public static final Font BENJAMIN;
    public static final Font BIG;
    public static final Font BIG_CHIEF;
    public static final Font BIG_MONEY_NE;
    public static final Font BIG_MONEY_NW;
    public static final Font BIG_MONEY_SE;
    public static final Font BIG_MONEY_SW;
    public static final Font BIGFIG;
    public static final Font BINARY;
    public static final Font BLOCK;
    public static final Font BLOCKS;
    public static final Font BLOODY;
    public static final Font BOLGER;
    public static final Font BRACED;
    public static final Font BRIGHT;
    public static final Font BROADWAY;
    public static final Font BROADWAY_KB;
    public static final Font BUBBLE;
    public static final Font BULBHEAD;
    public static final Font CALIGRAPHY;
    public static final Font CALIGRAPHY2;
    public static final Font CALVIN_S;
    public static final Font CARDS;
    public static final Font CATWALK;
    public static final Font CHISELED;
    public static final Font CHUNKY;
    public static final Font COINSTAK;
    public static final Font COLA;
    public static final Font COLOSSAL;
    public static final Font COMPUTER;
    public static final Font CONTESSA;
    public static final Font CONTRAST;
    public static final Font COSMIKE;
    public static final Font CRAWFORD;
    public static final Font CRAWFORD2;
    public static final Font CRAZY;
    public static final Font CRICKET;
    public static final Font CURSIVE;
    public static final Font CYBERLARGE;
    public static final Font CYBERMEDIUM;
    public static final Font CYBERSMALL;
    public static final Font CYGNET;
    public static final Font DANC4;
    public static final Font DWHISTLED;
    public static final Font DANCING_FONT;
    public static final Font DECIMAL;
    public static final Font DEF_LEPPARD;
    public static final Font DELTA_CORPS_PRIEST_1;
    public static final Font DIAMOND;
    public static final Font DIET_COLA;
    public static final Font DIGITAL;
    public static final Font DOH;
    public static final Font DOOM;
    public static final Font DOT_MATRIX;
    public static final Font DOUBLE;
    public static final Font DOUBLE_SHORTS;
    public static final Font DR_PEPPER;
    public static final Font EFTI_CHESS;
    public static final Font EFTI_FONT;
    public static final Font EFTI_ITALIC;
    public static final Font EFTI_PITI;
    public static final Font EFTI_ROBOT;
    public static final Font EFTI_WALL;
    public static final Font EFTI_WATER;
    public static final Font ELECTRONIC;
    public static final Font ELITE;
    public static final Font EPIC;
    public static final Font FENDER;
    public static final Font FILTER;
    public static final Font FIRE_FONT_K;
    public static final Font FIRE_FONT_S;
    public static final Font FLIPPED;
    public static final Font FLOWER_POWER;
    public static final Font FOUR_TOPS;
    public static final Font FRAKTUR;
    public static final Font FUN_FACE;
    public static final Font FUN_FACES;
    public static final Font FUZZY;
    public static final Font GEORGI16;
    public static final Font GEORGIA11;
    public static final Font GHOST;
    public static final Font GHOULISH;
    public static final Font GLENYN;
    public static final Font GOOFY;
    public static final Font GOTHIC;
    public static final Font GRACEFUL;
    public static final Font GRADIENT;
    public static final Font GRAFFITI;
    public static final Font GREEK;
    public static final Font HEART_LEFT;
    public static final Font HEART_RIGHT;
    public static final Font HENRY_3D;
    public static final Font HEX;
    public static final Font HIEROGLYPHS;
    public static final Font HOLLYWOOD;
    public static final Font HORIZONTAL_LEFT;
    public static final Font HORIZONTAL_RIGHT;
    public static final Font ICL_1900;
    public static final Font IMPOSSIBLE;
    public static final Font INVITA;
    public static final Font ISOMETRIC1;
    public static final Font ISOMETRIC2;
    public static final Font ISOMETRIC3;
    public static final Font ISOMETRIC4;
    public static final Font ITALIC;
    public static final Font IVRIT;
    public static final Font JS_BLOCK_LETTERS;
    public static final Font JS_BRACKET_LETTERS;
    public static final Font JS_CAPITAL_CURVES;
    public static final Font JS_CURSIVE;
    public static final Font JS_STICK_LETTERS;
    public static final Font JACKY;
    public static final Font JAZMINE;
    public static final Font JERUSALEM;
    public static final Font KATAKANA;
    public static final Font KBAN;
    public static final Font KEYBOARD;
    public static final Font KNOB;
    public static final Font LCD;
    public static final Font LARRY_3D;
    public static final Font LEAN;
    public static final Font LETTERS;
    public static final Font LIL_DEVIL;
    public static final Font LINE_BLOCKS;
    public static final Font LINUX;
    public static final Font LOCKERGNOME;
    public static final Font MADRID;
    public static final Font MARQUEE;
    public static final Font MAXFOUR;
    public static final Font MERLIN1;
    public static final Font MERLIN2;
    public static final Font MIKE;
    public static final Font MINI;
    public static final Font MIRROR;
    public static final Font MNEMONIC;
    public static final Font MODULAR;
    public static final Font MORSE;
    public static final Font MOSCOW;
    public static final Font MSHEBREW210;
    public static final Font MUZZLE;
    public static final Font NSCRIPT;
    public static final Font NT_GREEK;
    public static final Font NV_SCRIPT;
    public static final Font NANCYJ_FANCY;
    public static final Font NANCYJ_UNDERLINED;
    public static final Font NANCYJ;
    public static final Font NIPPLES;
    public static final Font O8;
    public static final Font OS2;
    public static final Font OCTAL;
    public static final Font OGRE;
    public static final Font OLD_BANNER;
    public static final Font PATORJK_HEX;
    public static final Font PATORJK_CHEESE;
    public static final Font PAWP;
    public static final Font PEAKS;
    public static final Font PEAKS_SLANT;
    public static final Font PEBBLES;
    public static final Font PEPPER;
    public static final Font POISON;
    public static final Font PUFFY;
    public static final Font PUZZLE;
    public static final Font PYRAMID;
    public static final Font RAMMSTEIN;
    public static final Font RECTANGLES;
    public static final Font RELIEF;
    public static final Font RELIEF2;
    public static final Font REVERSE;
    public static final Font ROMAN;
    public static final Font ROTATED;
    public static final Font ROUNDED;
    public static final Font ROWAN_CAP;
    public static final Font ROZZO;
    public static final Font RUNIC;
    public static final Font RUNYC;
    public static final Font SL_SCRIPT;
    public static final Font S_BLOOD;
    public static final Font SANTA_CLARA;
    public static final Font SCRIPT;
    public static final Font SERIFCAP;
    public static final Font SHADOW;
    public static final Font SHIMROD;
    public static final Font SHORT;
    public static final Font SLANT;
    public static final Font SLANT_RELIEF;
    public static final Font SLIDE;
    public static final Font SMALL;
    public static final Font SMALL_CAPS;
    public static final Font SMALL_ISOMETRIC1;
    public static final Font SMALL_KEYBOARD;
    public static final Font SMALL_POISON;
    public static final Font SMALL_SCRIPT;
    public static final Font SMALL_SHADOW;
    public static final Font SMALL_SLANT;
    public static final Font SMALL_TENGWAR;
    public static final Font SOFT;
    public static final Font SPEED;
    public static final Font SPLIFF;
    public static final Font STACEY;
    public static final Font STAMPATE;
    public static final Font STAMPATELLO;
    public static final Font STANDARD;
    public static final Font STAR_STRIPS;
    public static final Font STAR_WARS;
    public static final Font STELLAR;
    public static final Font STFOREK;
    public static final Font STICK_LETTERS;
    public static final Font STOP;
    public static final Font STRAIGHT;
    public static final Font STRONGER_THAN_ALL;
    public static final Font SUB_ZERO;
    public static final Font SWAMP_LAND;
    public static final Font SWAN;
    public static final Font SWEET;
    public static final Font THIS;
    public static final Font TANJA;
    public static final Font TENGWAR;
    public static final Font TERM;
    public static final Font TEST1;
    public static final Font THE_EDGE;
    public static final Font THICK;
    public static final Font THIN;
    public static final Font THORNED;
    public static final Font THREE_POINT;
    public static final Font TICKS;
    public static final Font TICKS_SLANT;
    public static final Font TILES;
    public static final Font TINKER_TOY;
    public static final Font TOMBSTONE;
    public static final Font TRAIN;
    public static final Font TREK;
    public static final Font TSALAGI;
    public static final Font TUBULAR;
    public static final Font TWISTED;
    public static final Font TWO_POINT;
    public static final Font USA_FLAG;
    public static final Font UNIVERS;
    public static final Font VARSITY;
    public static final Font WAVY;
    public static final Font WEIRD;
    public static final Font WET_LETTER;
    public static final Font WHIMSY;
    public static final Font WOW;
    public static final Font CIRCLE;
    public static final Font EMBOSS;
    public static final Font EMBOSS2;
    public static final Font FUTURE;
    public static final Font PAGGA;
    public static final Font RUSTO;
    public static final Font RUSTO_FAT;
    public static final Font ASCII9;
    public static final Font ASCII12;
    public static final Font BIG_ASCII9;
    public static final Font BIG_ASCII12;
    public static final Font SMALL_ASCII9;
    public static final Font SMALL_ASCII12;

    protected static final List<Font> VALUES;
    protected static final Map<String, Font> MAP;
    protected static final String ROOT_DIR_PATH = "banana";
    protected static final String FONT_DIR_PATH = ROOT_DIR_PATH + "/fonts/";

    static {
        List<Font> values = new ArrayList<>();
        values.add(ONE_ROW = new Font("1Row", "1Row.flf"));
        values.add(THREE_D = new Font("3-D", "3-D.flf"));
        values.add(THREE_D_ASCII = new Font("3D-ASCII", "3D-ASCII.flf"));
        values.add(THREE_D_DIAGONAL = new Font("3D Diagonal", "3D_Diagonal.flf"));
        values.add(THREE_FIVE = new Font("3x5", "3x5.flf"));
        values.add(FOUR_MAX = new Font("4Max", "4Max.flf"));
        values.add(FIVE_LINE_OBLIQUE = new Font("5 Line Oblique", "5_Line_Oblique.flf"));
        values.add(AMC_3_LINE = new Font("AMC 3 Line", "AMC_3_Line.flf"));
        values.add(AMC_3_LIV1 = new Font("AMC 3 Liv1", "AMC_3_Liv1.flf"));
        values.add(AMC_AAA01 = new Font("AMC AAA01", "AMC_AAA01.flf"));
        values.add(AMC_NEKO = new Font("AMC Neko", "AMC_Neko.flf"));
        values.add(AMC_RAZOR = new Font("AMC Razor", "AMC_Razor.flf"));
        values.add(AMC_RAZOR2 = new Font("AMC Razor2", "AMC_Razor2.flf"));
        values.add(AMC_SLASH = new Font("AMC Slash", "AMC_Slash.flf"));
        values.add(AMC_SLIDER = new Font("AMC Slider", "AMC_Slider.flf"));
        values.add(AMC_THIN = new Font("AMC Thin", "AMC_Thin.flf"));
        values.add(AMC_TUBES = new Font("AMC Tubes", "AMC_Tubes.flf"));
        values.add(AMC_UNTITLED = new Font("AMC Untitled", "AMC_Untitled.flf"));
        values.add(ANSI_SHADOW = new Font("ANSI Shadow", "ANSI_Shadow.flf"));
        values.add(ASCII_NEW_ROMAN = new Font("ASCII New Roman", "ASCII_New_Roman.flf"));
        values.add(ACROBATIC = new Font("Acrobatic", "Acrobatic.flf"));
        values.add(ALLIGATOR = new Font("Alligator", "Alligator.flf"));
        values.add(ALLIGATOR2 = new Font("Alligator2", "Alligator2.flf"));
        values.add(ALPHA = new Font("Alpha", "Alpha.flf"));
        values.add(ALPHABET = new Font("Alphabet", "Alphabet.flf"));
        values.add(ARROWS = new Font("Arrows", "Arrows.flf"));
        values.add(AVATAR = new Font("Avatar", "Avatar.flf"));
        values.add(BANNER = new Font("Banner", "Banner.flf"));
        values.add(BANNER3_D = new Font("Banner3-D", "Banner3-D.flf"));
        values.add(BANNER3 = new Font("Banner3", "Banner3.flf"));
        values.add(BANNER4 = new Font("Banner4", "Banner4.flf"));
        values.add(BARBWIRE = new Font("Barbwire", "Barbwire.flf"));
        values.add(BASIC = new Font("Basic", "Basic.flf"));
        values.add(BEAR = new Font("Bear", "Bear.flf"));
        values.add(BELL = new Font("Bell", "Bell.flf"));
        values.add(BENJAMIN = new Font("Benjamin", "Benjamin.flf"));
        values.add(BIG = new Font("Big", "Big.flf"));
        values.add(BIG_CHIEF = new Font("Big Chief", "Big_Chief.flf"));
        values.add(BIG_MONEY_NE = new Font("Big Money-ne", "Big_Money-ne.flf"));
        values.add(BIG_MONEY_NW = new Font("Big Money-nw", "Big_Money-nw.flf"));
        values.add(BIG_MONEY_SE = new Font("Big Money-se", "Big_Money-se.flf"));
        values.add(BIG_MONEY_SW = new Font("Big Money-sw", "Big_Money-sw.flf"));
        values.add(BIGFIG = new Font("Bigfig", "Bigfig.flf"));
        values.add(BINARY = new Font("Binary", "Binary.flf"));
        values.add(BLOCK = new Font("Block", "Block.flf"));
        values.add(BLOCKS = new Font("Blocks", "Blocks.flf"));
        values.add(BLOODY = new Font("Bloody", "Bloody.flf"));
        values.add(BOLGER = new Font("Bolger", "Bolger.flf"));
        values.add(BRACED = new Font("Braced", "Braced.flf"));
        values.add(BRIGHT = new Font("Bright", "Bright.flf"));
        values.add(BROADWAY = new Font("Broadway", "Broadway.flf"));
        values.add(BROADWAY_KB = new Font("Broadway KB", "Broadway_KB.flf"));
        values.add(BUBBLE = new Font("Bubble", "Bubble.flf"));
        values.add(BULBHEAD = new Font("Bulbhead", "Bulbhead.flf"));
        values.add(CALIGRAPHY = new Font("Caligraphy", "Caligraphy.flf"));
        values.add(CALIGRAPHY2 = new Font("Caligraphy2", "Caligraphy2.flf"));
        values.add(CALVIN_S = new Font("Calvin S", "Calvin_S.flf"));
        values.add(CARDS = new Font("Cards", "Cards.flf"));
        values.add(CATWALK = new Font("Catwalk", "Catwalk.flf"));
        values.add(CHISELED = new Font("Chiseled", "Chiseled.flf"));
        values.add(CHUNKY = new Font("Chunky", "Chunky.flf"));
        values.add(COINSTAK = new Font("Coinstak", "Coinstak.flf"));
        values.add(COLA = new Font("Cola", "Cola.flf"));
        values.add(COLOSSAL = new Font("Colossal", "Colossal.flf"));
        values.add(COMPUTER = new Font("Computer", "Computer.flf"));
        values.add(CONTESSA = new Font("Contessa", "Contessa.flf"));
        values.add(CONTRAST = new Font("Contrast", "Contrast.flf"));
        values.add(COSMIKE = new Font("Cosmike", "Cosmike.flf"));
        values.add(CRAWFORD = new Font("Crawford", "Crawford.flf"));
        values.add(CRAWFORD2 = new Font("Crawford2", "Crawford2.flf"));
        values.add(CRAZY = new Font("Crazy", "Crazy.flf"));
        values.add(CRICKET = new Font("Cricket", "Cricket.flf"));
        values.add(CURSIVE = new Font("Cursive", "Cursive.flf"));
        values.add(CYBERLARGE = new Font("Cyberlarge", "Cyberlarge.flf"));
        values.add(CYBERMEDIUM = new Font("Cybermedium", "Cybermedium.flf"));
        values.add(CYBERSMALL = new Font("Cybersmall", "Cybersmall.flf"));
        values.add(CYGNET = new Font("Cygnet", "Cygnet.flf"));
        values.add(DANC4 = new Font("DANC4", "DANC4.flf"));
        values.add(DWHISTLED = new Font("DWhistled", "DWhistled.flf"));
        values.add(DANCING_FONT = new Font("Dancing Font", "Dancing_Font.flf"));
        values.add(DECIMAL = new Font("Decimal", "Decimal.flf"));
        values.add(DEF_LEPPARD = new Font("Def Leppard", "Def_Leppard.flf"));
        values.add(DELTA_CORPS_PRIEST_1 = new Font("Delta Corps Priest 1", "Delta_Corps_Priest_1.flf"));
        values.add(DIAMOND = new Font("Diamond", "Diamond.flf"));
        values.add(DIET_COLA = new Font("Diet Cola", "Diet_Cola.flf"));
        values.add(DIGITAL = new Font("Digital", "Digital.flf"));
        values.add(DOH = new Font("Doh", "Doh.flf"));
        values.add(DOOM = new Font("Doom", "Doom.flf"));
        values.add(DOT_MATRIX = new Font("Dot Matrix", "Dot_Matrix.flf"));
        values.add(DOUBLE = new Font("Double", "Double.flf"));
        values.add(DOUBLE_SHORTS = new Font("Double Shorts", "Double_Shorts.flf"));
        values.add(DR_PEPPER = new Font("Dr Pepper", "Dr_Pepper.flf"));
        values.add(EFTI_CHESS = new Font("Efti Chess", "Efti_Chess.flf"));
        values.add(EFTI_FONT = new Font("Efti Font", "Efti_Font.flf"));
        values.add(EFTI_ITALIC = new Font("Efti Italic", "Efti_Italic.flf"));
        values.add(EFTI_PITI = new Font("Efti Piti", "Efti_Piti.flf"));
        values.add(EFTI_ROBOT = new Font("Efti Robot", "Efti_Robot.flf"));
        values.add(EFTI_WALL = new Font("Efti Wall", "Efti_Wall.flf"));
        values.add(EFTI_WATER = new Font("Efti Water", "Efti_Water.flf"));
        values.add(ELECTRONIC = new Font("Electronic", "Electronic.flf"));
        values.add(ELITE = new Font("Elite", "Elite.flf"));
        values.add(EPIC = new Font("Epic", "Epic.flf"));
        values.add(FENDER = new Font("Fender", "Fender.flf"));
        values.add(FILTER = new Font("Filter", "Filter.flf"));
        values.add(FIRE_FONT_K = new Font("Fire Font-k", "Fire_Font-k.flf"));
        values.add(FIRE_FONT_S = new Font("Fire Font-s", "Fire_Font-s.flf"));
        values.add(FLIPPED = new Font("Flipped", "Flipped.flf"));
        values.add(FLOWER_POWER = new Font("Flower Power", "Flower_Power.flf"));
        values.add(FOUR_TOPS = new Font("Four Tops", "Four_Tops.flf"));
        values.add(FRAKTUR = new Font("Fraktur", "Fraktur.flf"));
        values.add(FUN_FACE = new Font("Fun Face", "Fun_Face.flf"));
        values.add(FUN_FACES = new Font("Fun Faces", "Fun_Faces.flf"));
        values.add(FUZZY = new Font("Fuzzy", "Fuzzy.flf"));
        values.add(GEORGI16 = new Font("Georgi16", "Georgi16.flf"));
        values.add(GEORGIA11 = new Font("Georgia11", "Georgia11.flf"));
        values.add(GHOST = new Font("Ghost", "Ghost.flf"));
        values.add(GHOULISH = new Font("Ghoulish", "Ghoulish.flf"));
        values.add(GLENYN = new Font("Glenyn", "Glenyn.flf"));
        values.add(GOOFY = new Font("Goofy", "Goofy.flf"));
        values.add(GOTHIC = new Font("Gothic", "Gothic.flf"));
        values.add(GRACEFUL = new Font("Graceful", "Graceful.flf"));
        values.add(GRADIENT = new Font("Gradient", "Gradient.flf"));
        values.add(GRAFFITI = new Font("Graffiti", "Graffiti.flf"));
        values.add(GREEK = new Font("Greek", "Greek.flf"));
        values.add(HEART_LEFT = new Font("Heart Left", "Heart_Left.flf"));
        values.add(HEART_RIGHT = new Font("Heart Right", "Heart_Right.flf"));
        values.add(HENRY_3D = new Font("Henry 3D", "Henry_3D.flf"));
        values.add(HEX = new Font("Hex", "Hex.flf"));
        values.add(HIEROGLYPHS = new Font("Hieroglyphs", "Hieroglyphs.flf"));
        values.add(HOLLYWOOD = new Font("Hollywood", "Hollywood.flf"));
        values.add(HORIZONTAL_LEFT = new Font("Horizontal Left", "Horizontal_Left.flf"));
        values.add(HORIZONTAL_RIGHT = new Font("Horizontal Right", "Horizontal_Right.flf"));
        values.add(ICL_1900 = new Font("ICL-1900", "ICL-1900.flf"));
        values.add(IMPOSSIBLE = new Font("Impossible", "Impossible.flf"));
        values.add(INVITA = new Font("Invita", "Invita.flf"));
        values.add(ISOMETRIC1 = new Font("Isometric1", "Isometric1.flf"));
        values.add(ISOMETRIC2 = new Font("Isometric2", "Isometric2.flf"));
        values.add(ISOMETRIC3 = new Font("Isometric3", "Isometric3.flf"));
        values.add(ISOMETRIC4 = new Font("Isometric4", "Isometric4.flf"));
        values.add(ITALIC = new Font("Italic", "Italic.flf"));
        values.add(IVRIT = new Font("Ivrit", "Ivrit.flf"));
        values.add(JS_BLOCK_LETTERS = new Font("JS Block Letters", "JS_Block_Letters.flf"));
        values.add(JS_BRACKET_LETTERS = new Font("JS Bracket Letters", "JS_Bracket_Letters.flf"));
        values.add(JS_CAPITAL_CURVES = new Font("JS Capital Curves", "JS_Capital_Curves.flf"));
        values.add(JS_CURSIVE = new Font("JS Cursive", "JS_Cursive.flf"));
        values.add(JS_STICK_LETTERS = new Font("JS Stick Letters", "JS_Stick_Letters.flf"));
        values.add(JACKY = new Font("Jacky", "Jacky.flf"));
        values.add(JAZMINE = new Font("Jazmine", "Jazmine.flf"));
        values.add(JERUSALEM = new Font("Jerusalem", "Jerusalem.flf"));
        values.add(KATAKANA = new Font("Katakana", "Katakana.flf"));
        values.add(KBAN = new Font("Kban", "Kban.flf"));
        values.add(KEYBOARD = new Font("Keyboard", "Keyboard.flf"));
        values.add(KNOB = new Font("Knob", "Knob.flf"));
        values.add(LCD = new Font("LCD", "LCD.flf"));
        values.add(LARRY_3D = new Font("Larry 3D", "Larry_3D.flf"));
        values.add(LEAN = new Font("Lean", "Lean.flf"));
        values.add(LETTERS = new Font("Letters", "Letters.flf"));
        values.add(LIL_DEVIL = new Font("Lil Devil", "Lil_Devil.flf"));
        values.add(LINE_BLOCKS = new Font("Line Blocks", "Line_Blocks.flf"));
        values.add(LINUX = new Font("Linux", "Linux.flf"));
        values.add(LOCKERGNOME = new Font("Lockergnome", "Lockergnome.flf"));
        values.add(MADRID = new Font("Madrid", "Madrid.flf"));
        values.add(MARQUEE = new Font("Marquee", "Marquee.flf"));
        values.add(MAXFOUR = new Font("Maxfour", "Maxfour.flf"));
        values.add(MERLIN1 = new Font("Merlin1", "Merlin1.flf"));
        values.add(MERLIN2 = new Font("Merlin2", "Merlin2.flf"));
        values.add(MIKE = new Font("Mike", "Mike.flf"));
        values.add(MINI = new Font("Mini", "Mini.flf"));
        values.add(MIRROR = new Font("Mirror", "Mirror.flf"));
        values.add(MNEMONIC = new Font("Mnemonic", "Mnemonic.flf"));
        values.add(MODULAR = new Font("Modular", "Modular.flf"));
        values.add(MORSE = new Font("Morse", "Morse.flf"));
        values.add(MOSCOW = new Font("Moscow", "Moscow.flf"));
        values.add(MSHEBREW210 = new Font("Mshebrew210", "Mshebrew210.flf"));
        values.add(MUZZLE = new Font("Muzzle", "Muzzle.flf"));
        values.add(NSCRIPT = new Font("NScript", "NScript.flf"));
        values.add(NT_GREEK = new Font("NT Greek", "NT_Greek.flf"));
        values.add(NV_SCRIPT = new Font("NV Script", "NV_Script.flf"));
        values.add(NANCYJ_FANCY = new Font("Nancyj-Fancy", "Nancyj-Fancy.flf"));
        values.add(NANCYJ_UNDERLINED = new Font("Nancyj-Underlined", "Nancyj-Underlined.flf"));
        values.add(NANCYJ = new Font("Nancyj", "Nancyj.flf"));
        values.add(NIPPLES = new Font("Nipples", "Nipples.flf"));
        values.add(O8 = new Font("O8", "O8.flf"));
        values.add(OS2 = new Font("OS2", "OS2.flf"));
        values.add(OCTAL = new Font("Octal", "Octal.flf"));
        values.add(OGRE = new Font("Ogre", "Ogre.flf"));
        values.add(OLD_BANNER = new Font("Old Banner", "Old_Banner.flf"));
        values.add(PATORJK_HEX = new Font("Patorjk-HeX", "Patorjk-HeX.flf"));
        values.add(PATORJK_CHEESE = new Font("Patorjk Cheese", "Patorjk_Cheese.flf"));
        values.add(PAWP = new Font("Pawp", "Pawp.flf"));
        values.add(PEAKS = new Font("Peaks", "Peaks.flf"));
        values.add(PEAKS_SLANT = new Font("Peaks Slant", "Peaks_Slant.flf"));
        values.add(PEBBLES = new Font("Pebbles", "Pebbles.flf"));
        values.add(PEPPER = new Font("Pepper", "Pepper.flf"));
        values.add(POISON = new Font("Poison", "Poison.flf"));
        values.add(PUFFY = new Font("Puffy", "Puffy.flf"));
        values.add(PUZZLE = new Font("Puzzle", "Puzzle.flf"));
        values.add(PYRAMID = new Font("Pyramid", "Pyramid.flf"));
        values.add(RAMMSTEIN = new Font("Rammstein", "Rammstein.flf"));
        values.add(RECTANGLES = new Font("Rectangles", "Rectangles.flf"));
        values.add(RELIEF = new Font("Relief", "Relief.flf"));
        values.add(RELIEF2 = new Font("Relief2", "Relief2.flf"));
        values.add(REVERSE = new Font("Reverse", "Reverse.flf"));
        values.add(ROMAN = new Font("Roman", "Roman.flf"));
        values.add(ROTATED = new Font("Rotated", "Rotated.flf"));
        values.add(ROUNDED = new Font("Rounded", "Rounded.flf"));
        values.add(ROWAN_CAP = new Font("Rowan Cap", "Rowan_Cap.flf"));
        values.add(ROZZO = new Font("Rozzo", "Rozzo.flf"));
        values.add(RUNIC = new Font("Runic", "Runic.flf"));
        values.add(RUNYC = new Font("Runyc", "Runyc.flf"));
        values.add(SL_SCRIPT = new Font("SL Script", "SL_Script.flf"));
        values.add(S_BLOOD = new Font("S Blood", "S_Blood.flf"));
        values.add(SANTA_CLARA = new Font("Santa Clara", "Santa_Clara.flf"));
        values.add(SCRIPT = new Font("Script", "Script.flf"));
        values.add(SERIFCAP = new Font("Serifcap", "Serifcap.flf"));
        values.add(SHADOW = new Font("Shadow", "Shadow.flf"));
        values.add(SHIMROD = new Font("Shimrod", "Shimrod.flf"));
        values.add(SHORT = new Font("Short", "Short.flf"));
        values.add(SLANT = new Font("Slant", "Slant.flf"));
        values.add(SLANT_RELIEF = new Font("Slant Relief", "Slant_Relief.flf"));
        values.add(SLIDE = new Font("Slide", "Slide.flf"));
        values.add(SMALL = new Font("Small", "Small.flf"));
        values.add(SMALL_CAPS = new Font("Small Caps", "Small_Caps.flf"));
        values.add(SMALL_ISOMETRIC1 = new Font("Small Isometric1", "Small_Isometric1.flf"));
        values.add(SMALL_KEYBOARD = new Font("Small Keyboard", "Small_Keyboard.flf"));
        values.add(SMALL_POISON = new Font("Small Poison", "Small_Poison.flf"));
        values.add(SMALL_SCRIPT = new Font("Small Script", "Small_Script.flf"));
        values.add(SMALL_SHADOW = new Font("Small Shadow", "Small_Shadow.flf"));
        values.add(SMALL_SLANT = new Font("Small Slant", "Small_Slant.flf"));
        values.add(SMALL_TENGWAR = new Font("Small Tengwar", "Small_Tengwar.flf"));
        values.add(SOFT = new Font("Soft", "Soft.flf"));
        values.add(SPEED = new Font("Speed", "Speed.flf"));
        values.add(SPLIFF = new Font("Spliff", "Spliff.flf"));
        values.add(STACEY = new Font("Stacey", "Stacey.flf"));
        values.add(STAMPATE = new Font("Stampate", "Stampate.flf"));
        values.add(STAMPATELLO = new Font("Stampatello", "Stampatello.flf"));
        values.add(STANDARD = new Font("Standard", "Standard.flf"));
        values.add(STAR_STRIPS = new Font("Star Strips", "Star_Strips.flf"));
        values.add(STAR_WARS = new Font("Star Wars", "Star_Wars.flf"));
        values.add(STELLAR = new Font("Stellar", "Stellar.flf"));
        values.add(STFOREK = new Font("Stforek", "Stforek.flf"));
        values.add(STICK_LETTERS = new Font("Stick Letters", "Stick_Letters.flf"));
        values.add(STOP = new Font("Stop", "Stop.flf"));
        values.add(STRAIGHT = new Font("Straight", "Straight.flf"));
        values.add(STRONGER_THAN_ALL = new Font("Stronger Than All", "Stronger_Than_All.flf"));
        values.add(SUB_ZERO = new Font("Sub-Zero", "Sub-Zero.flf"));
        values.add(SWAMP_LAND = new Font("Swamp Land", "Swamp_Land.flf"));
        values.add(SWAN = new Font("Swan", "Swan.flf"));
        values.add(SWEET = new Font("Sweet", "Sweet.flf"));
        values.add(THIS = new Font("THIS", "THIS.flf"));
        values.add(TANJA = new Font("Tanja", "Tanja.flf"));
        values.add(TENGWAR = new Font("Tengwar", "Tengwar.flf"));
        values.add(TERM = new Font("Term", "Term.flf"));
        values.add(TEST1 = new Font("Test1", "Test1.flf"));
        values.add(THE_EDGE = new Font("The Edge", "The_Edge.flf"));
        values.add(THICK = new Font("Thick", "Thick.flf"));
        values.add(THIN = new Font("Thin", "Thin.flf"));
        values.add(THORNED = new Font("Thorned", "Thorned.flf"));
        values.add(THREE_POINT = new Font("Three Point", "Three_Point.flf"));
        values.add(TICKS = new Font("Ticks", "Ticks.flf"));
        values.add(TICKS_SLANT = new Font("Ticks Slant", "Ticks_Slant.flf"));
        values.add(TILES = new Font("Tiles", "Tiles.flf"));
        values.add(TINKER_TOY = new Font("Tinker-Toy", "Tinker-Toy.flf"));
        values.add(TOMBSTONE = new Font("Tombstone", "Tombstone.flf"));
        values.add(TRAIN = new Font("Train", "Train.flf"));
        values.add(TREK = new Font("Trek", "Trek.flf"));
        values.add(TSALAGI = new Font("Tsalagi", "Tsalagi.flf"));
        values.add(TUBULAR = new Font("Tubular", "Tubular.flf"));
        values.add(TWISTED = new Font("Twisted", "Twisted.flf"));
        values.add(TWO_POINT = new Font("Two Point", "Two_Point.flf"));
        values.add(USA_FLAG = new Font("USA Flag", "USA_Flag.flf"));
        values.add(UNIVERS = new Font("Univers", "Univers.flf"));
        values.add(VARSITY = new Font("Varsity", "Varsity.flf"));
        values.add(WAVY = new Font("Wavy", "Wavy.flf"));
        values.add(WEIRD = new Font("Weird", "Weird.flf"));
        values.add(WET_LETTER = new Font("Wet Letter", "Wet_Letter.flf"));
        values.add(WHIMSY = new Font("Whimsy", "Whimsy.flf"));
        values.add(WOW = new Font("Wow", "Wow.flf"));
        values.add(CIRCLE = new Font("Circle", "circle.tlf"));
        values.add(EMBOSS = new Font("Emboss", "emboss.tlf"));
        values.add(EMBOSS2 = new Font("Emboss 2", "emboss2.tlf"));
        values.add(FUTURE = new Font("Future", "future.tlf"));
        values.add(PAGGA = new Font("Pagga", "pagga.tlf"));
        values.add(RUSTO = new Font("Rusto", "rusto.tlf"));
        values.add(RUSTO_FAT = new Font("Rusto Fat", "rustofat.tlf"));
        values.add(ASCII9 = new Font("ASCII 9", "ascii9.tlf"));
        values.add(ASCII12 = new Font("ASCII 12", "ascii12.tlf"));
        values.add(BIG_ASCII9 = new Font("Big ASCII 9", "bigascii9.tlf"));
        values.add(BIG_ASCII12 = new Font("Big ASCII 12", "bigascii12.tlf"));
        values.add(SMALL_ASCII9 = new Font("Small ASCII 9", "smascii9.tlf"));
        values.add(SMALL_ASCII12 = new Font("Small ASCII 12", "smascii12.tlf"));
        Map<String, Font> map = new HashMap<>(values.size());
        for (Font v : values) {
            map.put(v.name, v);
        }
        VALUES = Collections.unmodifiableList(values);
        MAP = Collections.unmodifiableMap(map);
    }

    protected final String name;
    protected final String filename;
    protected final Charset charset;

    protected Font(String name) {
        this.name = name;
        this.filename = null;
        this.charset = StandardCharsets.UTF_8;
    }

    protected Font(String name, String filename) {
        this.name = name;
        this.filename = filename;
        this.charset = StandardCharsets.UTF_8;
    }

    protected Font(String name, String filename, Charset charset) {
        this.name = name;
        this.filename = filename;
        this.charset = charset;
    }

    public String getName() {
        return name;
    }

    public String getFilename() {
        return filename;
    }

    public Charset getCharset() {
        return charset;
    }

    public InputStream getInputStream() throws IOException {
        InputStream inputStream = Font.class.getClassLoader().getResourceAsStream(FONT_DIR_PATH + filename);
        if (inputStream == null) {
            throw new RuntimeException("Failed to load font '" + this.name + "', the specified font does not exist.");
        }
        return convertIfZipped(inputStream);
    }

    /**
     * Returns a {@link ZipInputStream} if the input stream can be converted.
     * @param inputStream the input stream.
     * @return a {@link ZipInputStream} if the input stream can be converted.
     * @throws IOException if an exception occurs during converting.
     */
    protected static InputStream convertIfZipped(InputStream inputStream) throws IOException {
        // Detects zipped font.
        BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
        if (isZipped(bufferedInputStream)) {
            // Expects a single anonymous entry.
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
            ZipEntry entry = zipInputStream.getNextEntry();
            if (entry == null) {
                throw new RuntimeException("Failed to convert the InputStream.");
            }
            return zipInputStream;
        } else {
            return bufferedInputStream;
        }
    }

    /**
     * Returns {@code true} if the buffered input stream start with {@code 0x504b0304}.
     * @param bufferedInputStream the buffered input stream.
     * @return {@code true} if the buffered input stream start with {@code 0x504b0304}.
     * @throws IOException if an exception occurs during detecting.
     */
    protected static boolean isZipped(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] buf = new byte[4];
        bufferedInputStream.mark(4);
        bufferedInputStream.read(buf);
        bufferedInputStream.reset();
        return Arrays.equals(buf, new byte[]{0x50, 0x4b, 0x03, 0x04});
    }

    /**
     * Returns all fonts.
     * @return all fonts.
     */
    public static List<Font> values() {
        return VALUES;
    }

    /**
     * Returns the font with the specified name, or {@code null} if the font does not exist.
     * @param name the font name.
     * @return the font with the specified name, or {@code null} if the font does not exist.
     */
    public static Font get(String name) {
        return MAP.get(name);
    }

    /**
     * Returns the font with the specified name, or {@code defaultValue} if the font does not exist.
     * @param name         the font name.
     * @param defaultValue the default font.
     * @return the font with the specified name, or {@code defaultValue} if the font does not exist.
     */
    public static Font getOrDefault(String name, Font defaultValue) {
        Font font;
        return (font = MAP.get(name)) != null ? font : defaultValue;
    }

}
