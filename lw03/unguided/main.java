import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scRegistrations = new Scanner(main.class.getResourceAsStream("registrations.txt"));
        Scanner scCheckins = new Scanner(main.class.getResourceAsStream("checkins.txt"));
        int registered = 0;
        int SuccesfulCheckins = 0;
        int rejectedAttempts = 0;
        
        Set<String> uniqueRegistrations = new LinkedHashSet<>();
        Set<String> checkedInStudents = new HashSet<>();
        
        List<String> checkinResults = new LinkedList<>();
        
        while (scRegistrations.hasNextLine()) {
            String name = scRegistrations.nextLine();
            if (uniqueRegistrations.add(name)) {
                registered++;
            }
        }
        scRegistrations.close();

        while (scCheckins.hasNextLine()) {
            String name = scCheckins.nextLine();
            if (uniqueRegistrations.contains(name)) {
                if (checkedInStudents.contains(name)) {
                    rejectedAttempts++;
                    checkinResults.add(name + ": Rejected (already checked in)");
                } else {
                    SuccesfulCheckins++;
                    checkedInStudents.add(name);
                    checkinResults.add(name + ": Checked in");
                }
            } else {
                rejectedAttempts++;
                checkinResults.add(name + ": Rejected (not registered)");
            }
        }
        scCheckins.close();

        System.out.println("===== Event Check-In Results =====");
        for (String result : checkinResults) {
            System.out.println(result);
        }
        System.out.println("\n===== Final Event Summary =====");
        System.out.println("Total Registered Students: " + registered);
        System.out.println("Successful Check-Ins: " + SuccesfulCheckins);
        System.out.println("Absent Students: " + (registered - SuccesfulCheckins));
        System.out.println("Rejected Attempts: " + rejectedAttempts);
    }
}

