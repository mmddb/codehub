import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ilearning39 {


    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        try {
            System.out.println(calculator(s));
        } catch (Exception e){
            System.out.println("error");
        }

    }

    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }


    private static int calculator(String s) throws Exception{

        char preSign = '+';
        int res = 0;
        int num = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(!Character.isDigit(c) || i == len - 1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-1 * num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        if(num == 0){
                            throw new Exception();
                        }
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = c;
                num = 0;
            }
        }

        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }










}
