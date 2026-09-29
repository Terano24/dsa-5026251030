import java.util.*;
public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(main.class.getResourceAsStream("order.txt"));
        LinkedList<String[]> foodStock = new LinkedList<>();
        foodStock.add(new String[]{"Bakso","2"});
        foodStock.add(new String[]{"Sate", "1"});
        foodStock.add(new String[]{"Soto", "2"});

        LinkedList<String[]> drinkStock = new LinkedList<>();
        drinkStock.add(new String[]{"EsTeh", "4"});
        drinkStock.add(new String[]{"EsJeruk", "2"});

        LinkedList<String[]> orderRequests = new LinkedList<>();
        LinkedList<String[]> successfull = new LinkedList<>();
        
        Stack<String[]> failedStack = new Stack<>();
        
        while(sc.hasNextLine()){
            String[] parts = sc.nextLine().split(" ");
            orderRequests.add(parts);

        }sc.close();

            Queue<String[]> orderQueue = new LinkedList<>(orderRequests);
            while(!orderQueue.isEmpty()){
                String[] queueNode = orderQueue.poll();
                String name = queueNode[0];
                String sideDish  = queueNode[1];
                String drink = queueNode[2];
                int table =Integer.parseInt(queueNode[3]);

                boolean foodStatus = sideDish.equals("-");
                boolean drinkStatus = drink.equals("-");

                String[] targetFood = null;
                String[] targetDrink = null;
                for(String[] element : foodStock){
                    if(element[0].equals(sideDish)){
                        if(Integer.parseInt(element[1]) > 0){
                            targetFood = element;
                            foodStatus = true;
                        }
                        break;
                    }
                }
                for(String[] element : drinkStock){
                    if(element[0].equals(drink)){
                        if(Integer.parseInt(element[1]) > 0){
                            targetDrink = element;
                            drinkStatus = true;
                        }
                        break;
                    }
                }

                boolean status = foodStatus && drinkStatus;
                if(status){
                    if(targetFood != null){
                    int Food= Integer.parseInt(targetFood[1]);
                    targetFood[1] = String.valueOf(Food - 1);
                    }
                    if(targetDrink != null){
                    int Drink = Integer.parseInt(targetDrink[1]);
                    targetDrink[1] = String.valueOf(Drink - 1);
                    }

                    successfull.add(queueNode);
                }else{
                    failedStack.push(queueNode);
                }
            }

        System.out.println("=== Successfully Processed Orders ===");
        for(String[] element : successfull){
            String customerName = element[0];
            String food  = element[1];
            String DRINK = element[2];
            String TABLE = element[3];
            
            System.out.println(customerName +" "+  food +" "+ DRINK +" "+ TABLE);
        }
        System.out.println("=== Remaining Food Stock ===");
        for(String [] element : foodStock){
            String itemName = element[0];
            String stockLeft = element[1];
            System.out.println(itemName + ": "+ stockLeft);
        }
        System.out.println("=== Remaining Drink Stock ===");
        for(String [] element : drinkStock){
            String itemName = element[0];
            String stockLeft = element[1];
            System.out.println(itemName + ": "+ stockLeft);
        }

        System.out.println("=== Failed Orders ===");
        while(!failedStack.isEmpty()){
            String[] element = failedStack.pop();
            String customerName = element[0];
            String itemName  = element[1];
            String quantity = element[2];
            String money = element[3];
            System.out.println(customerName +" "+ itemName +" "+ quantity+" " +money);
        }
            
        
}}
