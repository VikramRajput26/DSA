package com.app.advance;

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        headA.next.next = intersection;
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        IntersectionNode solution = new IntersectionNode();
        ListNode result = solution.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection node value: " + result.val);
        } else {
            System.out.println("No intersection");
        }
    }
}

