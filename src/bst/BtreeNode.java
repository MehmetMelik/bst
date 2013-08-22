package bst;

import java.util.*;
class BtreeNode {

    int data;
    BtreeNode L,R;
    static int depth=0; 

    public BtreeNode(){
         data = 0; L = null; R=null;
    }
    public BtreeNode(int key){
         this();data = key;
    }
    public String toString()    {
        return  "["+data+"]";
    }


    public static ArrayList<BtreeNode> asList(BtreeNode node) {
        ArrayList<BtreeNode> result = new ArrayList<BtreeNode>();
        traverse(node, result);
        Collections.sort(result, new Comparator<BtreeNode>() {
            @Override
            public int compare(BtreeNode arg0, BtreeNode arg1) {
                if (arg0.data < arg1.data)
                    return -1;
                else if (arg0.data > arg1.data)
                    return 1;
                return 0;
            }
        });
        return result;
    }

    private static void traverse(BtreeNode node, ArrayList<BtreeNode> result) {
        if (node.L != null) {
            traverse(node.L, result);
        }
        result.add(node);
        if (node.R != null) {
            traverse(node.R, result);
        }
    }

    public static BtreeNode sortedArrayToBST (ArrayList<BtreeNode> result, int start, int end) {
        if (start > end) return null;
          // same as (start+end)/2, avoids overflow.
          int mid = start + (end - start) / 2;
          BtreeNode node = new BtreeNode(result.get(mid).data);
          node.L = sortedArrayToBST(result, start, mid-1);
          node.R = sortedArrayToBST(result, mid+1, end);

          return node;
        }


    public static BtreeNode insOrd(BtreeNode roo, int key){
        if(roo==null)return new BtreeNode(key);

        if(key==roo.data)return roo;
        if(key<roo.data)roo.L=insOrd(roo.L,key);
        else roo.R=insOrd(roo.R,key);
        return roo;
    }

    public static BtreeNode generate(int length) {
        BtreeNode start = null;
        Random rn = new Random();
        for(int i = 0; i < length; i++){
            start = insOrd(start,rn.nextInt(10000));
        }
        return start;
    }

   public static void spc(int n){
    for(int i=0;i<n;i++)System.out.print(" ");
   }

    public static void print(BtreeNode roo){
        if(roo!=null){
            depth++;
            print(roo.R);
            System.out.print("Level "+depth);
            spc(depth);
            System.out.println(roo);
            print(roo.L);
            depth--;
        }
    }

    public static BtreeNode find(BtreeNode roo, int key){
        BtreeNode r=null;
        if(roo==null)return r;
        if(roo.data==key)r= roo;
        if(key>roo.data)r= find(roo.R,key);
        if(key<roo.data)r= find(roo.L,key);
        return r;
    }
}; 
