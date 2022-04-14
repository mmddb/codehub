import java.util.Scanner;

public class ilearning33 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String instr = scanner.next();

        char[] ins = instr.toCharArray();
        double[] pos = new double[]{0,0};
        double angle = 0;
        for (int i = 0; i < ins.length; i++) {
            char c = ins[i];

            if(c == 'G'){
                double y = Math.cos(Math.toRadians(angle));
                double x = Math.sin(Math.toRadians(angle));
                pos[1] += y;
                pos[0] += x;
                System.out.println(pos[0] + " " + pos[1]);
            }
            if(c == 'L'){
                angle = angle - 90 ;
            }
            if(c == 'R'){
                angle = angle + 90;
            }
        }

        pos[0] = Math.round(pos[0]);
        pos[1] = Math.round(pos[1]);

        System.out.println("("+ (int)pos[0] + "," + (int)pos[1] + ")");
    }
}
