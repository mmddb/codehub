import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ilearning35 {

    static class Phone{
        double income;
        double quantity;

        @Override
        public String toString() {
            return "Phone{" +
                    "income=" + income +
                    ", quantity=" + quantity +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        double demand = cin.nextInt();
        double[] inventory = new double[n];
        List<Phone> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            inventory[i] = cin.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            Phone p = new Phone();
            p.income = cin.nextDouble();
            p.quantity = inventory[i];
            list.add(p);
        }

        list.sort((o1, o2) -> Double.compare(o2.income/o2.quantity,o1.income/o1.quantity));
        //list.forEach(System.out::println);

        double total_income = 0;
        for (Phone phone : list) {
            if(phone.quantity <= demand){
                total_income += phone.income;
                demand -= phone.quantity;
            }else {
                total_income += (demand / phone.quantity) * phone.income;
                break;
            }
        }

        // ****************************
        System.out.printf("%.2f%n",total_income);
    }
}
