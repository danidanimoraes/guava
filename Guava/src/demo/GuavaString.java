package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class GuavaString {

    private static final String TEXT = "    as2djdah2  13 AA1";

    public static void main(String[] args) {

//        testJoiner();
//        testSplitter();
//        testCharMatcher();
          testCaseFormat();
    }

    private static void testCaseFormat() {
        System.out.println(CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_UNDERSCORE).convert("daniMoraes"));
          System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, "dani-moraes"));
    }

    private static void testCharMatcher() {
        System.out.println("Original: " + TEXT);
        System.out.println("Count digits: " + CharMatcher.digit().countIn(TEXT));
        System.out.println("Remove digits: " + CharMatcher.digit().removeFrom(TEXT));
        System.out.println("Retain digits: " + CharMatcher.digit().retainFrom(TEXT));
        System.out.println("Index digits: " + CharMatcher.digit().indexIn(TEXT));
        System.out.println("Collapse digits: " + CharMatcher.digit().collapseFrom(TEXT, '*'));
        System.out.println("Index digits from pos 13: " + CharMatcher.digit().indexIn(TEXT, 13));
        System.out.println("Last index digits: " + CharMatcher.digit().lastIndexIn(TEXT));
        System.out.println("Is 'a' a digit?: " + CharMatcher.digit().matches('a'));
        System.out.println("Are all characters digits?: " + CharMatcher.digit().matchesAllOf(TEXT));
        System.out.println("Is any character a digit?: " + CharMatcher.digit().matchesAnyOf(TEXT));
        System.out.println("Is none character a digit?: " + CharMatcher.digit().matchesNoneOf(TEXT));
        System.out.println("Replace digit by '*': " + CharMatcher.digit().replaceFrom(TEXT, '*'));
        System.out.println("Replace digit by 'num': " + CharMatcher.digit().replaceFrom(TEXT, "num"));
        System.out.println("Test digit matcher: " + CharMatcher.digit().test('1'));
        System.out.println("Trim: " + CharMatcher.digit().trimFrom(TEXT));
        System.out.println("Trim leading: " + CharMatcher.digit().trimLeadingFrom(TEXT));
        System.out.println("Trim trailing: " + CharMatcher.digit().trimTrailingFrom(TEXT));
        System.out.println("Digit and Java upper case: " + CharMatcher.digit().and(CharMatcher.javaUpperCase()).retainFrom(TEXT));
        System.out.println("Negate digits: " + CharMatcher.digit().negate().retainFrom(TEXT));
        System.out.println("Digits or Java upper case from 'AA': " + CharMatcher.digit().or(CharMatcher.javaUpperCase()).retainFrom("AA"));
        System.out.println("Digits and Java upper case from 'AA': " + CharMatcher.digit().and(CharMatcher.javaUpperCase()).retainFrom("AA"));
        System.out.println("Precomputed digits: " + CharMatcher.digit().precomputed());
        System.out.println("From 'a' to 'z': " + CharMatcher.inRange('a', 'z').retainFrom(TEXT));
        System.out.println("Remove breaking whitespace: " + CharMatcher.breakingWhitespace().removeFrom(TEXT));
        System.out.println("Remove invisible: " + CharMatcher.invisible().removeFrom(TEXT));
    }

    private static void testSplitter() {
        String a = "Strings - -  pa--ra -te  ste-1ww   ";
        // é iterable mas e ae
//        ArrayList<String> aa = Splitter.on("-").split(a);
        String[] arr = a.split("-");
        System.out.println("Sem splitter: " + arr[1]);
        System.out.println("Normal: " + Splitter.on("-").split(a));
        System.out.println("Fixed lenght = 3: " + Splitter.fixedLength(3).splitToList(a));
        System.out.println("Limit to 2 splits: " + Splitter.on("-").limit(2).split(a));
        System.out.println("Omit empty strings: " + Splitter.on("-").omitEmptyStrings().split(a));
        System.out.println("Trim: " + Splitter.on("-").trimResults().split(a));

        CharMatcher cm = CharMatcher.javaUpperCase();
        System.out.println("Trim w: " + Splitter.on("-").trimResults(cm).split(a));
        
        String mapa =  "1=a, 2=b, 3=c";
        System.out.println("Map: " +  Splitter.on(", ").withKeyValueSeparator("=").split(mapa));
    }

    private static void testJoiner() {
        System.out.println("Normal: " + Joiner.on(", ").join("banana", "maçã", "uva", "pêra"));
        // npe:
        // System.out.println("With null: " + Joiner.on(", ").join("banana",
        // "maçã", "uva", "pêra", null));
        System.out.println("Skip nulls: " + Joiner.on(", ").skipNulls().join("banana", "maçã", "uva", "pêra", null));
        System.out.println(
                "Use for null: " + Joiner.on(", ").useForNull("sei lá").join("banana", "maçã", "uva", "pêra", null));

        Map<String, String> mapa = new HashMap<>();
        mapa.put("1", "banana");
        mapa.put("2", "maçã");
        mapa.put("3", "uva");
        mapa.put("4", "pêra");
        System.out.println("Join map: " + Joiner.on(" e ").withKeyValueSeparator("=").join(mapa));

        StringBuilder sb = new StringBuilder();
        System.out.println("appendTo sb and list: " + Joiner.on("*").appendTo(sb, Arrays.asList("a", "p", "p", "e", "n", "d")));
        System.out.println("appendTo sb and map: " + Joiner.on("*").withKeyValueSeparator("~").appendTo(sb, mapa));
        System.out.println("Two ons: " + Joiner.on("#").on("?").join("o", "i", "e"));
        System.out.println("toString: " + Joiner.on("#").toString());
    }
}
