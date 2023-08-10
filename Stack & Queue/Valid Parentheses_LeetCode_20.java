class Solution {
    public char getOpenBracket(char ch){
        if(ch == ')'){
            return '(';
        }
        else if(ch == '}'){
            return '{';
        }
        else{
            return '[';
        }
    }
    public boolean isValid(String s) {
        
        Stack<Character> st =  new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='}' || ch ==')' || ch ==']'){
                if(st.isEmpty() || st.pop() != getOpenBracket(ch)){
                    return false;
                }
            }
            else{
                st.push(ch);
            }
        }
        return st.isEmpty() && true;
        
    }
}