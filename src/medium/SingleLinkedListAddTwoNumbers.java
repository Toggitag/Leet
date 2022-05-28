package medium;

/**
 * Definition for singly-linked list.
 
 **/
 
public class SingleLinkedListAddTwoNumbers {
      int val;
    SingleLinkedListAddTwoNumbers next;
    SingleLinkedListAddTwoNumbers() {}
      SingleLinkedListAddTwoNumbers(int val) { this.val = val; }
      SingleLinkedListAddTwoNumbers(int val, SingleLinkedListAddTwoNumbers next) { this.val = val; this.next = next; }
  }
class Solution {
    public SingleLinkedListAddTwoNumbers addTwoNumbers(SingleLinkedListAddTwoNumbers l1, SingleLinkedListAddTwoNumbers l2) {
        SingleLinkedListAddTwoNumbers dummy = new SingleLinkedListAddTwoNumbers();
        SingleLinkedListAddTwoNumbers temp = dummy;
        int sum=0, carry=0;
        while( l1 != null || l2 != null || carry!=0 ){
            sum=0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum/10;
            SingleLinkedListAddTwoNumbers node = new SingleLinkedListAddTwoNumbers(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}

