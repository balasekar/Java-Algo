package matchingparanthesis;

import java.util.Stack;

public class MatchParanthesis {

    public static void main(String[] args) {
        MatchParanthesis matchParanthesis = new MatchParanthesis();
        System.out.println("1st string:: "+ matchParanthesis.isMatchingParanthesis("{()[]}"));
        System.out.println("2nd string:: "+ matchParanthesis.isMatchingParanthesis("{()[]}())"));
    }

    private String isMatchingParanthesis(String str) {
        Stack<Character> leftChars = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                leftChars.push(str.charAt(i));
            } else if (!leftChars.isEmpty() &&
                    (
                        str.charAt(i) == ')' && leftChars.peek() == '(' ||
                        str.charAt(i) == '}' && leftChars.peek() == '{' ||
                        str.charAt(i) == ']' && leftChars.peek() == '['
                    )){
                leftChars.pop();
            } else {
                leftChars.push(str.charAt(i));
            }
        }
        return leftChars.isEmpty() ? "Balanced" : "Not Balanced";
    }
}
