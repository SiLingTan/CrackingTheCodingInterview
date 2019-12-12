package Chap2_LinkedLists;

public class FindKthElementFromLast {

    public static void main(String[] args){
        LinkedListNode lastNode = new LinkedListNode(3, null);
        LinkedListNode thirdNode = new LinkedListNode(5, lastNode);
        LinkedListNode secNode = new LinkedListNode(2, thirdNode);
        LinkedListNode firstNode = new LinkedListNode(4, secNode);

        LinkedList myLinkedList = new LinkedList(firstNode);
        LinkedListNode kthElementFromLast = kthElementToLast(myLinkedList, 3);
        System.out.println(kthElementFromLast.data);
    }

    private static LinkedListNode kthElementToLast(LinkedList myLinkedList, int k){
        int numOfElemFromFront;
        int countNumOfElem = 1;
        int pointer = 1;
        LinkedListNode currNode = myLinkedList.getHead();

        while(currNode.next != null){
            currNode = currNode.next;
            countNumOfElem ++;
        }
        numOfElemFromFront = countNumOfElem - k + 1;
        currNode = myLinkedList.getHead();
        while((pointer != numOfElemFromFront) && (currNode != null)){
            currNode = currNode.next;
            pointer++;
        }

        if((currNode != null) && (pointer == numOfElemFromFront)){
            return currNode;
        }

        return null;
    }
}
