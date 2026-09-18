import java.util.*;
interface Chargeable{
    public int calculateCharge();
}
abstract class PrintJob implements Chargeable{
    private String id;
    private int pages;

    public PrintJob(String id, int pages){
        if(pages < 1 || pages > 100){
            throw new IllegalArgumentException("Pages must be at least 1 and at most 100");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId(){
        return id;
    }
    public int getPages(){
        return pages;
    }
    @Override
    public int calculateCharge(){
        return pages * 10;
    }
    public int calculateCharge(int copies){
        if(copies < 1 || copies >10){
            throw new IllegalArgumentException("Copies must be at least 1 & at most 10");
        }
        return calculateCharge() * copies;
    }
    public abstract String label();

    public String summary(){
        return id + " | " + label() + " | "  + calculateCharge();
    }
    
}
    class MonoPrint extends PrintJob{
    public MonoPrint(String id, int pages){
        super(id, pages);
    }
    @Override
    public String label(){
        return "Mono Print";
    }
    @Override
    public int calculateCharge(){
        return getPages() * 500;
    }

}
    class ColourPrint extends PrintJob{
    public ColourPrint(String id, int pages){
        super(id, pages);
    }
    @Override
    public String label(){
        return "Color Print";
    }
    @Override
    public int calculateCharge(){
        if(getPages() > 10){
        return (10 * 1500) + (getPages() - 10) * 1000 + 2000;
        }
    else{
        return getPages() * 1500 + 2000;
        }
    }
    }

public class prelab {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(prelab.class.getResourceAsStream("jobs.txt"));
        while(sc.hasNext()){
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();
            PrintJob job;
            if(type.equals("MONO")){
                job = new MonoPrint(id, pages);
            }
            else{
                job = new ColourPrint(id, pages);
            }
            System.out.println(job.summary());
        }
    }
}
