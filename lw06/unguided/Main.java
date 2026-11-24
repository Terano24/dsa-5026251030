import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst = new BinarySearchTree();

        String line = read.nextLine();
        Scanner lineSc = new Scanner(line);
        while (lineSc.hasNextInt()) {
            bst.insert(lineSc.nextInt());
        }
        lineSc.close();

        int target = read.nextInt();
        read.close();

        System.out.print("Preorder  : ");
        bst.preOrder();

        System.out.print("Inorder   : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Nodes     : " + bst.countNodes());
        System.out.println("Leaves    : " + bst.countLeaves());
    }
}
