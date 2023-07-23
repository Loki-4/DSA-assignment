class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortLinkedList {
    public static void main(String[] args) {
        Node head1 = createLinkedList(new int[]{25, 35, 12, 4, 36, 48});
        Node head2 = createLinkedList(new int[]{8, 32, 22, 45, 63, 49});

        Node mergedList = mergeLinkedLists(head1, head2);
        Node sortedList = sortLinkedList(mergedList);

        printLinkedList(sortedList);
    }

    public static Node createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static Node mergeLinkedLists(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node mergedHead;
        if (head1.data < head2.data) {
            mergedHead = head1;
            mergedHead.next = mergeLinkedLists(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = mergeLinkedLists(head1, head2.next);
        }
        return mergedHead;
    }

    public static Node sortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null;

        Node left = sortLinkedList(head);
        Node right = sortLinkedList(midNext);

        return merge(left, right);
    }

    public static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node left, Node right) {
        Node merged = new Node(0);
        Node curr = merged;

        while (left != null && right != null) {
            if (left.data < right.data) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }

        return merged.next;
    }

    public static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
