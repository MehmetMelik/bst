package bst;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        public static void main(String[] args){
            int N;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number if tree items:");
            N=sc.nextInt();
            BtreeNode c = BtreeNode.generate(N);
            BtreeNode.print(c);
            System.out.println("********************");
        /*
            System.out.println("This tree has "+
                    BtreeNode.weight(c)+" nodes and "+
                    BtreeNode.height(c)+" levels.");
        */
            ArrayList<BtreeNode> result = BtreeNode.asList(c);
            for (BtreeNode btreeNode : result) {
                System.out.println(btreeNode.data);
            }

        // insert in sorted order
            c = result.get(0);
            for (int i = 1; i < result.size(); i++) {
                BtreeNode.insOrd(c, result.get(i).data);
            }
            BtreeNode.print(c);

            System.out.println("********************");

            BtreeNode d = BtreeNode.generate(N); 
            BtreeNode.print(d);

            System.out.println("********************");

            ArrayList<BtreeNode> result2 = BtreeNode.asList(d);

            for (BtreeNode btreeNode : result2) {
                System.out.println(btreeNode.data);
            }

            System.out.println("********************");

            BtreeNode.print(BtreeNode.sortedArrayToBST(result2, 0, result2.size()-1));
        }
}