import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ilearning37 {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String before = cin.next();
        char[] bef = before.toCharArray();

        List<Character> nums = new ArrayList<>();
        List<Character> lowerLetter = new ArrayList<>();
        List<Character> higherLetter = new ArrayList<>();

        for (char c : bef) {
            if(Character.isDigit(c)){
                nums.add(c);
            }else if(c >= 'a' && c <= 'z'){
                lowerLetter.add(c);
            }else{
                higherLetter.add(c);
            }
        }
        Collections.sort(nums);
        Collections.sort(lowerLetter);
        Collections.sort(higherLetter);

//        nums.forEach(System.out::println);
//        lowerLetter.forEach(System.out::println);
//        higherLetter.forEach(System.out::println);

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k = 0;
        for (char c : bef) {
            if(Character.isDigit(c)){
                sb.append(nums.get(i));
                i++;
            }else if(j < lowerLetter.size()){
                sb.append(lowerLetter.get(j));
                j++;
            }else{
                sb.append(higherLetter.get(k));
                k++;
            }
        }
        System.out.println(sb.toString());
    }
}
