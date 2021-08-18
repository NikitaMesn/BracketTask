package main.java.app;


import java.util.Map;

public class BracketsChecker {

    private final static Map<Character, Character> openBracketsMap = Map.of('(', ')', '{', '}', '[', ']');
    private final static Map<Character, Character> closeBracketsMap = Map.of(')','(',  '}','{',  ']', '[');


    public static boolean isCorrectBracketSeq(String seq) {

        if ("".equals(seq)) return true; //пустая строка — правильная скобочная последовательность;
        if (seq.length() % 2 == 1) return false; //подразумевается что будут только скобки, поэтому должно быть четное количество

        return isCorrectBracketByRecursion(new StringBuilder(), new StringBuilder(seq));
    }


    private static boolean isCorrectBracketByRecursion(StringBuilder openBrackets, StringBuilder bracketsSequence) {

        if (openBrackets.length() == 0 && bracketsSequence.length() == 0) {
            return true;
        }

        //если открытых скобок больше, чем в оставшейся строке
        // или строка начинается с закрытых скобок возвращаем false
        if (openBrackets.length() > bracketsSequence.length() ||
                openBrackets.length() == 0 && closeBracketsMap.containsKey(bracketsSequence.charAt(0)) ) {
            return false;
        }


        //создаем строку содержащую открытые скобки
        if (openBracketsMap.containsKey(bracketsSequence.charAt(0))) {

            return isCorrectBracketByRecursion(openBrackets.append(bracketsSequence.charAt(0)),
                    bracketsSequence.deleteCharAt(0));
        }

        //удаляем соответствующие скобки, если они подходят
        if (closeBracketsMap.get(bracketsSequence.charAt(0))
                .equals(openBrackets.charAt(openBrackets.length() - 1))) {


            return isCorrectBracketByRecursion(openBrackets.deleteCharAt(openBrackets.length() - 1),
                    bracketsSequence.deleteCharAt(0));
        }

        return false;
    }
}
