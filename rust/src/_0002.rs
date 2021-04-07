use crate::shared::list_node::ListNode;

struct Solution;

/// https://leetcode.com/problems/add-two-numbers/
impl Solution {
    /// 0 ms	2.1 MB
    pub fn add_two_numbers(
        l1: Option<Box<ListNode>>,
        l2: Option<Box<ListNode>>,
    ) -> Option<Box<ListNode>> {
        let mut carry = 0;
        let mut root = ListNode::new(0);
        let mut cur = &mut root;
        let mut l1 = l1;
        let mut l2 = l2;

        while l1.is_some() || l2.is_some() {
            let sum = l1.as_ref().map_or(0, |l| l.val) + l2.as_ref().map_or(0, |l| l.val) + carry;
            cur.next = Some(Box::new(ListNode::new(sum % 10)));

            carry = sum / 10;
            cur = cur.next.as_deref_mut().unwrap();
            l1 = l1.and_then(|l| l.next);
            l2 = l2.and_then(|l| l.next);
        }

        if carry != 0 {
            cur.next = Some(Box::new(ListNode::new(carry)));
        }

        root.next
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn test() {
        fn assert(l1: &[i32], l2: &[i32], expected: &[i32]) {
            assert_eq!(
                Solution::add_two_numbers(
                    ListNode::in_option_box_from_array(l1),
                    ListNode::in_option_box_from_array(l2)
                ),
                ListNode::in_option_box_from_array(expected)
            )
        }

        assert(&[9], &[9], &[8, 1]);
        assert(&[3], &[1, 2], &[4, 2]);
        assert(&[2, 4, 3], &[5, 6, 4], &[7, 0, 8]);
    }
}
