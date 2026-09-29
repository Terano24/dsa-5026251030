import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(main.class.getResourceAsStream("transactions.txt"));
        
        
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customerRecords = new LinkedList<>();
        Queue<String[]> transactionQueue = new LinkedList<>();
        Stack<String[]> failedStack = new Stack<>();
        
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(" ");
            String customerName = parts[0];
            String transactionType = parts[1];
            int amount = Integer.parseInt(parts[2]);
            
            transactions.add(parts);
            
        boolean check = false;
        for(int i = 0; i < customerRecords.size(); i++) {
            String[] nodeData = customerRecords.get(i);
            if (nodeData[0].equals(customerName)) {
                check = true;
                break;
            }
        } if (!check) {
            customerRecords.add(new String[]{customerName, "0"});
            
        }
    }
        for(String[] records : transactions) {
            transactionQueue.add(records);
        }
        while(!transactionQueue.isEmpty()) {
            String[] transaction = transactionQueue.poll();
            String custNameString = transaction[0];
            String transType = transaction[1];
            int AMOUNT = Integer.parseInt(transaction[2]);
            
            for(int i = 0; i < customerRecords.size(); i++) {
                String[] customerRecord = customerRecords.get(i);
                if (customerRecord[0].equals(custNameString)) {
                    int currentBalance = Integer.parseInt(customerRecord[1]);
                    if (transType.equals("DEPOSIT")) {
                        currentBalance += AMOUNT;
                        customerRecord[1] = Integer.toString(currentBalance);
                    }else if (transType.equals("WITHDRAW")) {
                        if (currentBalance >= AMOUNT) {
                            currentBalance -= AMOUNT;
                            customerRecord[1] = Integer.toString(currentBalance);
                        } else {
                            failedStack.push(transaction);
                        }
                    }
                    break;
                }
            }
        }
        

    sc.close();
    System.out.println("=== Final Balances ===");
    for (String[] customerRecord : customerRecords) {
        System.out.println(customerRecord[0] + " : " + customerRecord[1]);
    }
    System.out.println("\n=== Failed Transactions ===");
    while (!failedStack.isEmpty()) {
        String[] failedTransaction = failedStack.pop();
        System.out.println(failedTransaction[0] + " " + failedTransaction[1] + " " + failedTransaction[2]);
    }
}}
