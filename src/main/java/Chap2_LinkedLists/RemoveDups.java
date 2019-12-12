package Chap2_LinkedLists;


import java.util.HashSet;

public class RemoveDups {

    public static void main(String[] args){
        //TODO: test remove duplicates

    }

    public static void removeDuplicates(LinkedListNode headNode){
        LinkedListNode curr = headNode;
        LinkedListNode prev = null;
        HashSet<Integer> set = new HashSet<>();

        while(curr != null){
            if(set.contains(curr.data)){
                prev.next = curr.next;
            }else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }
}
