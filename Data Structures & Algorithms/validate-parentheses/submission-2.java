class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for ( char c : s.toCharArray()){
            if ( c == '(' || c == '{'|| c == '['){
                bracketStack.push(c);
            } else {
                if (bracketStack.isEmpty()){
                    return false;
                }
                char top = bracketStack.pop();
                if ( c == ')' && top !='(')
                    return false;
                if ( c == '}' && top !='{')
                    return false;
                if ( c == ']' && top !='[')
                    return false;
            }
        }
        return bracketStack.isEmpty();
    }
}
