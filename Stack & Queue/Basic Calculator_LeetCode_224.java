class Solution {
    public int calculate(String s) {
        
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int sum =0;
        int sign = 1;

        for(int i=0;i<n;i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10+s.charAt(i)-'0';
                    i++;
                }

                sum+=num*sign;
                i--;
            }
            else if(s.charAt(i)=='+'){
                sign = 1;
            }
            else if(s.charAt(i)=='-'){
                sign = -1;
            }
            else if(s.charAt(i)=='('){
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            }
            else if(s.charAt(i)==')'){
                sum = st.pop()*sum;
                sum+=st.pop();
            }
        }

        return sum;
    }
}