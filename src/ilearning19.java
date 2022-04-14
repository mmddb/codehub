import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class ilearning19 {
    static class AllocatedMemory {
        int[] pool = new int[100];
        int tags = 1;
        HashSet<Integer> set = new HashSet<>();
        AllocatedMemory() {

        }

        // 返回分配的内存首地址(string)，失败返回字符串 "error"
        String request(int size) {

            // 从前往后遍历，找到第一个 空地址
            for(int i = 0; i < 100; i++){
                if(pool[i] == 0){
                    int start = i;
                   // 是否连续 size 个 地址均为空
                    int capacity = 0;
                    int end = start;
                    while(end != 100 && capacity != size && pool[end] == 0){
                        end++;
                        capacity++;
                    }
                    // 可以分配
                    if(capacity == size){
                        // 从 start 染色
                        for(int k = start; k <= start + size - 1; k++){
                            pool[k] = tags;
                        }
                        tags++;
                        set.add(start); // 记录 已经分配的 首地址
                        System.out.println("add " + start);
                        return String.valueOf(start);
                    }else{
                        // 不行的话 再找下一个 start 位置， i 去到 一个不等于 0 的位置
                        // end 可能不等于 0，
                        i = end;
                    }

                }
            }

            // 无法分配
            return "error";
        }

        // 成功返回 true；失败返回 false，失败时框架会自动输出 "error"
        boolean release(int startAddress) {
            // 无需释放
            if(pool[startAddress] == 0 || !set.contains(startAddress)){
                return false;
            }

            int tag = pool[startAddress];

            set.remove(startAddress);

            while(startAddress != 100 && pool[startAddress] == tag){
                pool[startAddress] = 0;
                startAddress++;
            }

            System.out.println("remove " + startAddress);
            return true;
        }
    }

    public static void main(String[] args) {
        AllocatedMemory allocatedMemory = new AllocatedMemory();
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int line = Integer.parseInt(cin.nextLine());
        String[][] ins = new String[line][2];
        for (int i = 0; i < line; i++) {
            ins[i] = cin.nextLine().split("=");
            if (ins[i][0].startsWith("REQUEST")) {
                System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
            } else {
                boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }

        cin.close();
    }

}
