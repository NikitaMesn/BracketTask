package main.java.app;



public class Main {

    public static void main(String[] args) {

        String s1 = "{[()]}";
        String s2 = "()";
        String s3 = "(){[()]}()";
        String s4 = "(){[()][}]";
        String s5 = "()(){}[]{{}}()(({[]}))";

        String s6 = "()((([])()(){}[]{{}}()(({[]}))"; // false
        String s7 = "()())(";

        System.out.println(BracketsChecker.isCorrectBracketSeq(s7));
    }
}
