package com.stringutil;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.google.common.collect.ImmutableMap;

public class StringSimplifier {
    public static final char DEFAULT_REPLACE_CHAR = '-';
    public static final String DEFAULT_REPLACE = String.valueOf(DEFAULT_REPLACE_CHAR);
    private static final ImmutableMap<String, String> NONDIACRITICS = ImmutableMap.<String, String>builder()
        .put(".", "")
        .put("\"", "")
        .put("'", "")     
        .put(" ", DEFAULT_REPLACE)
        .put("]", DEFAULT_REPLACE)
        .put("[", DEFAULT_REPLACE)
        .put(")", DEFAULT_REPLACE)
        .put("(", DEFAULT_REPLACE)
        .put("=", DEFAULT_REPLACE)
        .put("!", DEFAULT_REPLACE)
        .put("/", DEFAULT_REPLACE)
        .put("\\", DEFAULT_REPLACE)
        .put("&", DEFAULT_REPLACE)
        .put(",", DEFAULT_REPLACE)
        .put("?", DEFAULT_REPLACE)
        .put("�", DEFAULT_REPLACE) 
        .put("|", DEFAULT_REPLACE)
        .put("<", DEFAULT_REPLACE)
        .put(">", DEFAULT_REPLACE)
        .put(";", DEFAULT_REPLACE)
        .put(":", DEFAULT_REPLACE)
        .put("_", DEFAULT_REPLACE)
        .put("#", DEFAULT_REPLACE)
        .put("~", DEFAULT_REPLACE)
        .put("+", DEFAULT_REPLACE)
        .put("*", DEFAULT_REPLACE)
        .put("\u0141", "l") 
        .put("\u0142", "l") 
        .put("�", "ss")
        .put("�", "ae")
        .put("�", "o")
        .put("�", "c")
        .put("\u00D0", "d") // All � � from http://de.wikipedia.org/wiki/%C3%90
        .put("\u00F0", "d")
        .put("\u0110", "d")
        .put("\u0111", "d")
        .put("\u0189", "d")
        .put("\u0256", "d")
        .put("\u00DE", "th") // thorn �
        .put("\u00FE", "th") // thorn �
        .build();


    public static String simplifiedString(String orig) {
        String str = orig;
        if (str == null) {
            return null;
        }
        str = stripDiacritics(str);
        str = stripNonDiacritics(str);
        if (str.length() == 0) {
            // Ugly special case to work around non-existing empty strings
            // in Oracle. Store original crapstring as simplified.
            // It would return an empty string if Oracle could store it.
            return orig;
        }
        return str.toLowerCase();
    }

    private static String stripNonDiacritics(String orig) {
        StringBuffer ret = new StringBuffer();
        String lastchar = null;
        for (int i = 0; i < orig.length(); i++) {
            String source = orig.substring(i, i + 1);
            String replace = NONDIACRITICS.get(source);
            String toReplace = replace == null ? String.valueOf(source) : replace;
            if (DEFAULT_REPLACE.equals(lastchar) && DEFAULT_REPLACE.equals(toReplace)) {
                toReplace = "";
            } else {
                lastchar = toReplace;
            }
            ret.append(toReplace);
        }
        if (ret.length() > 0 && DEFAULT_REPLACE_CHAR == ret.charAt(ret.length() - 1)) {
            ret.deleteCharAt(ret.length() - 1);
        }
        return ret.toString();
    }

    /*
    Special regular expression character ranges relevant for simplification -> see http://docstore.mik.ua/orelly/perl/prog3/ch05_04.htm
    InCombiningDiacriticalMarks: special marks that are part of "normal" �, �, � etc..
        IsSk: Symbol, Modifier see http://www.fileformat.info/info/unicode/category/Sk/list.htm
        IsLm: Letter, Modifier see http://www.fileformat.info/info/unicode/category/Lm/list.htm
     */
    public static final Pattern DIACRITICS_AND_FRIENDS
        = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");


    private static String stripDiacritics(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
        return str;
    }
}