import java.util.*;
public class main{
    public static void problem1 (Scanner sc){
        LinkedList <String> playlist = new LinkedList<>();
        while(sc.hasNextLine()){
            String[] song = sc.nextLine().split(" ");
            String type = song[0];
            if(type.equals("INSERT")){
                int index = Integer.parseInt(song[1]);
                String title = song[2];
                playlist.add(index,title);
        }else{
            String title = song[1];
            if(type.equals("ADD")){
                playlist.add(title);
            }else if(type.equals("REMOVE")){
                playlist.remove(title);
        }

        }
    }
        System.out.println("===== Problem 1 =====");
        int i = 1;
        for(String result : playlist){

            System.out.println(i +": "+result);
            i++;
            }System.out.println();}

    public static void problem2(Scanner sc){
        Set<String> nameSet = new LinkedHashSet<>();
        int duplicate = 0;
        while(sc.hasNextLine()){
            String name = sc.nextLine();
            if(!nameSet.contains(name)){
                nameSet.add(name);
            }else{
            duplicate +=1 ;
        }
        }sc.close();
        int i = 1;
        
        System.out.println("===== Problem 2 =====");
        for(String out: nameSet){
            System.out.println(i +" :" +out);
            i++;
        }System.out.println("Duplicate registrations: "+ duplicate);
        System.out.println();
    }

    public static void problem3(Scanner sc){
        HashMap<String, Integer> inventory = new HashMap<>();
        int failed = 0;
        while(sc.hasNextLine()){
            String[] input = sc.nextLine().split(" ");
            String operation = input[0];
            String item = input[1];
            int amount = Integer.parseInt(input[2]);
            
            if(!inventory.containsKey(item)){
                if(operation.equals("ADD")){
                    inventory.put(item, amount);
                }else if(operation.equals("SELL")){
                    failed +=1;
                }
        }else{
            int currentStock = inventory.get(item);
            if(operation.equals("ADD")){
                inventory.put(item, currentStock+amount);
            }
            else if(operation.equals("SELL")){
                if(currentStock - amount < 0){
                failed +=1;
                }else{
                inventory.put(item,currentStock-amount);
                }
            }
        }}sc.close();
        System.out.println("===== Problem 3 =====");
        for(Map.Entry entry: inventory.entrySet() ){
            String product = String.valueOf(entry.getKey());
            int stock = inventory.get(product);
            System.out.println(product +": " + stock);
        }System.out.println("Failed sales: "+failed);
    
    }


    public static void main(String[] args){
        Scanner prob1 = new Scanner(main.class.getResourceAsStream("playlist.txt"));
        Scanner prob2 = new Scanner(main.class.getResourceAsStream("participant.txt"));
        Scanner prob3 = new Scanner(main.class.getResourceAsStream("inventory.txt"));

        problem1(prob1);
        problem2(prob2);
        problem3(prob3);
    }}