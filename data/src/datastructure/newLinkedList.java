package datastructure;

public class newLinkedList<T> {

    newNode head;
    newNode last;
    int length;

    public newLinkedList() {
        head = null;
        last = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T getFirst() {
        return (T) head.value;
    }

    public T getLast() {
        return (T) last.value;
    }

    public T get(int pos) {
        newNode current = head;
        if (isEmpty()||pos<1||pos>length) {
        } else {
            if (length == 1) {
                return (T) head.value;
            } else if (length == pos) {
                return (T) last.value;
            } else {
                for (int i = 1; i < pos; i++) {
                    current = current.next;
                }
                if (current != null) {
                    return (T) current.value;
                }
            }
        }
        return null;
    }

    public int length() {
        return length;
    }

    public void addFirst(Object val) {
        newNode n = new newNode(val);
        if (isEmpty()) {
            last = n;
        }
        n.next = head;
        head = n;
        length++;
    }

    public void addLast(Object val) {
        newNode n = new newNode(val);
        if (isEmpty()) {
            head = n;
        } else {
            last.next = n;
            last = n;
        }
        length++;
    }

    public void add(int pos, Object val) {
        newNode n = new newNode(val);
        if (length == 0) {
            addFirst(val);
        } else if (length == pos) {
            addLast(val);
        } else {
            newNode current = head;
            for (int i = 1; i < pos; i++) {
                current = current.next;
            }
            n.next = current.next;
            current.next = n;
        }
        length++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("linkedlist is empty");
        } else {
            head = head.next;
            length--;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("linkedlist is empty");
        } else {
            newNode current = head.next;
            newNode previous = head;
            while (current != last) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            last = previous;
            length--;
        }
    }

    public void delete(Object key) {
        if (isEmpty()) {
            System.out.println("linkedlist is empty");
        } else {
            length--;
            if (head.value == key) {
                head = head.next;
            }
            newNode current = head.next;
            newNode previous = head;
            while (current != null && current.value != key) {
                previous = current;
                current = current.next;
            }
            if (current == null) {
                System.out.println("not found!");
            } else {
                previous.next = current.next;
            }
        }
    }

    public void reverse() {
        newNode current, previous, nex;
        previous = null;
        current = head;
        nex = current.next;
        while (nex != null) {
            nex = current.next;
            current.next = previous;
            previous = current;
            current = nex;
        }
        head = previous;
    }

    public boolean search(Object element) {
        newNode current = head;
        int pos = 0;
        while (current != null) {
            if (current.value == element) {
                return true;
            }
            current = current.next;
            pos++;
        }
        return false;
    }

    public void display() {
        newNode curr = head;
        System.out.print("Elements : ");
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

}
