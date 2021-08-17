package main.java.app;


import java.util.Map;

public class BracketsChecker {

    private final static Map<Character, Character> openBrackets = Map.of('(', ')', '{', '}', '[', ']');
    private final static Map<Character, Character> closeBrackets = Map.of(')','(',  '}','{',  ']', '[');


    public static boolean isCorrectBracketSeq(String seq) {

        if ("".equals(seq)) return true; //пустая строка — правильная скобочная последовательность;
        if (seq.length() % 2 == 1) return false; //подразумевается что будут только скобки, поэтому должно быть четное количество

        int counter = 0; //считаем сколько незакрытых скобок

        for (int i = 0; i < seq.length(); i++) {
            System.out.println(i);
            if (closeBrackets.containsKey(seq.charAt(i)) && counter == 0) return false; //если нет открытых скобок, но есть закрытые, возвращаем dalse
            System.out.println(i);

            if (openBrackets.containsKey(seq.charAt(i))) {
                counter++;
            } else {


                for (int j = 0; j < counter; j++) {
                    System.out.println(j);
                    if (openBrackets.containsKey(seq.charAt(i + j))) return false;
                    if (closeBrackets.containsKey(seq.charAt(i + j)) && !closeBrackets.get(seq.charAt(i + j)).equals(seq.charAt(i - 1 - j))) return false;

                }

                i += counter - 1;
                counter = 0;
            }
            System.out.println(i);

        }

        return true;
    }


}
