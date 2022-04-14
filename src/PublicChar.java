import java.nio.charset.StandardCharsets;
import java.util.*;

public class PublicChar {

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
//        int nValue = cin.nextInt();
//        int mValue = cin.nextInt();
//
//        String[] strings = new String[mValue];
//        for (int i = 0; i < mValue; i++) {
//            strings[i] = cin.next();
//        }
//        cin.close();

        //char[] nTimesCharacter = getNTimesCharacter(2, new String[]{"aabbccFFFFx2x2", "aaccddFFFFx2x2", "aabcdFFFFx2x2"});

        //System.out.println(nTimesCharacter);
        List<String> strings = new ArrayList<>();
        strings.add("C 13300000000");
        strings.add("W 13144444444");
        strings.add("C 13144444444");
        strings.add("C 03712832444");
        strings.add("C 03712832233");
        strings.add("W 03712832*");
        strings.add("C 03712832444");
        getPhoneRecord(strings);
    }

    private static char[] getNTimesCharacter(int nValue, String[] strings) {
        int m = strings.length;
        int[][] counter = new int[m][128]; // 0-9 + A-Z +  a-z  idx: 0-9 10-35 36-61
        // 构建数组
        for(int i = 0; i < m; i++){
            for(int j = 0; j < strings[i].length(); j++){
                char c = strings[i].charAt(j);
                counter[i][c]++;
            }
        }

        ArrayList<Character> ans = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            int j = 0;
            while(j < m && counter[j][i] >= nValue){
                j++;
            }
            if(j == m){
                System.out.println(i);
                ans.add((char) i);
            }
        }

        char[] res = new char[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private static boolean checkInvalid(String num){
        char[] nums = num.toCharArray();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == '4'){
                return false;
            }
            if(nums[i] == '8' && i > 0 && nums[i-1] == '1'){
                return false;
            }
        }
        return true;
    }


    private static String[][] getPhoneRecord(List<String> records) {

        List<String> white1 = new ArrayList<>(); // * 通配符的
        Set<String> white2 = new HashSet<>();

        HashMap<String, Integer> calls = new HashMap<>();
        HashMap<String, Integer> denys = new HashMap<>();

        LinkedHashSet<String> tels = new LinkedHashSet<>();

        for (String record : records) {
            String tel = record.substring(2);
            // add to white record
            if(record.startsWith("W")){
                if(record.endsWith("*")){
                    white1.add(tel.substring(0, tel.length() - 1));
                }else{
                    white2.add(tel);
                }
            }else{
                tels.add(tel);
                if(inWhiteRecord(tel, white1, white2)){
                    calls.put(tel, calls.getOrDefault(tel, 0) + 1);
                }else{
                    denys.put(tel, denys.getOrDefault(tel, 0) + 1);
                }
            }
        }

        String[][] res = new String[tels.size()][3];
        int j = 0;
        for (String tel : tels) {
            res[j][0] = tel;
            j++;
        }
        for (int i = 0; i < res.length; i++) {
            res[i][1] = calls.getOrDefault(res[i][0],0).toString();
            res[i][2] = denys.getOrDefault(res[i][0], 0).toString();
        }

       // System.out.println(white1);
       // System.out.println(white2);

//        for (String[] result : res) {
//            System.out.println(String.join(" ", Arrays.asList(result)));
//        }

        return  res;
    }

    private static boolean inWhiteRecord(String tel, List<String> white1, Set<String> white2){
        if(white2.contains(tel)){
            return true;
        }
        for (String s : white1) {
            if(tel.startsWith(s)){
                return true;
            }
        }
        return false;
    }
}
