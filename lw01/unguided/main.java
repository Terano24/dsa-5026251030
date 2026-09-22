import java.util.*;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(main.class.getResourceAsStream("washes.txt"));
        int count = sc.nextInt();
        WashService[] washService = new WashService[count];
        int[] units = new int[count];

        for (int i = 0; i < count; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            units[i] = sc.nextInt();

            if (type.equals("MOTORCYCLE")) {
                washService[i] = new MotorcycleWash(id, days);
            } else if (type.equals("CAR")) {
                washService[i] = new CarWash(id, days);
            }
            System.out.println(washService[i].summary(units[i]));
            
        }sc.close();
        
        }

    }
