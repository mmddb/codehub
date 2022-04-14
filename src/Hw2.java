public class Hw2 {

    public static void main(String[] args) {
        System.out.println(calculate("1.0","9.0"));
    }

    public static String calculate(String s1, String s2){
        // s1.len > s2
        if(s2.length() > s1.length()){
            calculate(s2, s1);
        }
        StringBuilder res = new StringBuilder();

        String[] sp1 = s1.split("\\.");
        String[] sp2 = s2.split("\\.");
        // 小数位对齐
        StringBuilder sb2 = new StringBuilder(s2);
        int cha = sp1[1].length() - sp2[1].length();
        while(cha != 0){
            sb2.append("0");
            cha--;
        }
        s2 = sb2.toString();

        // 小数位相加
        int carry = 0;
        int curDigit = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        while(s1.charAt(i) != '.'){
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(j) - '0';
            curDigit = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            res.append(curDigit);
            i--; // left move
            j--;
        }

        i--; j--;
        res.append(".");
        // 整数位相加
        while(i >= 0 && j >= 0){
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(j) - '0';
            curDigit = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            res.append(curDigit);
            i--; // left move
            j--;
        }

        while(i >= 0){
            int c = s1.charAt(i) - '0';
            curDigit = (c + carry) % 10;
            carry = (c + carry) / 10;
            res.append(curDigit);
            i--;
        }

        while(j >= 0){
            int c = s2.charAt(j) - '0';
            curDigit = (c  + carry) % 10;
            carry = (c + carry) / 10;
            res.append(curDigit);
            j--;
        }

        if(carry != 0){
            res.append("1");
        }

        res.reverse();

        return res.toString();
    }




}
