package Adapter;

public class LinkedListAdapter implements Stack {
    
    LinkedList list;

    LinkedListAdapter() {
        list = new LinkedList();
    }

    public boolean push(Object o) {
        // Method implementation
        try {
            list.insertHead(o);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Object pop() {
        // Method implementation
        Object head = list.getHead();
        list.removeHead();
        return head;
    }

    public Object top() {
        // Method implementation
        return list.getHead();
    }
}
