package medium;

import java.util.Stack;

public class ValidInValidParentheses {

    public static void main(String[] args) {
        String validString = "{[()]}";
        String inValidString ="}[()[]";
        boolean valid = validInValidP(validString);
        boolean inValid = validInValidP(inValidString);
        System.out.println(valid);
        System.out.println(inValid);
    }

    private static boolean validInValidP(String str) {
        if(str.length() == 0 || str.isBlank() || str.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '[' || c == '{' || c=='('){
               stack.add(c);
           }
            else if(!stack.isEmpty() && c == ')' && stack.peek()=='('){
                stack.pop();
            }
            else if(!stack.isEmpty() && c == '}'&& stack.peek()=='{'){
                stack.pop();
            }
            else if(!stack.isEmpty() && c == ']'&& stack.peek()=='['){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
