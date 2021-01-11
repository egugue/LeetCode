use crate::shared::list_node::ListNode;
use std::ops::DerefMut;

struct Solution;

/// https://leetcode.com/problems/merge-two-sorted-lists/
impl Solution {
    pub fn merge_two_lists(
        l1: Option<Box<ListNode>>,
        l2: Option<Box<ListNode>>,
    ) -> Option<Box<ListNode>> {
        // Solution::iterate(l1, l2)
        let mut dummy = ListNode::new(0);
        Solution::recursive(&mut dummy, l1, l2);
        dummy.next
    }

    // 0 ms	1.9 MB
    fn iterate(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut dummy = ListNode::new(0);
        let mut cur = &mut dummy;
        let mut cur1 = l1;
        let mut cur2 = l2;

        while cur1.is_some() || cur2.is_some() {
            if cur1.is_none() {
                cur.next = cur2.take();
                break;
            }
            if cur2.is_none() {
                cur.next = cur1.take();
                break;
            }

            let val1 = cur1.as_ref().unwrap().val; // use as_ref because `val` can be copied
            let val2 = cur2.as_ref().unwrap().val;
            if val1 < val2 {
                let (head1, next1) = Solution::separate(cur1);
                cur.next = head1;
                cur1 = next1;
            } else {
                let (head2, next2) = Solution::separate(cur2);
                cur.next = head2;
                cur2 = next2;
            }
            cur = cur.next.as_mut().unwrap();
        }

        dummy.next
    }

    /// 0 ms	2 MB
    fn recursive(cur: &mut ListNode, mut l1: Option<Box<ListNode>>, mut l2: Option<Box<ListNode>>) {
        let mut cur = cur;
        if l1.is_none() || l2.is_none() {
            if l1.is_none() {
                cur.next = l2;
            } else {
                cur.next = l1;
            }
            return;
        }

        let val1 = l1.as_ref().unwrap().val;
        let val2 = l2.as_ref().unwrap().val;
        if val1 < val2 {
            let (head, next) = Solution::separate(l1);
            cur.next = head;
            Solution::recursive(cur.next.as_mut().unwrap().deref_mut(), next, l2)
        } else {
            let (head, next) = Solution::separate(l2);
            cur.next = head;
            Solution::recursive(cur.next.as_mut().unwrap().deref_mut(), l1, next)
        }
    }

    fn separate(mut l: Option<Box<ListNode>>) -> (Option<Box<ListNode>>, Option<Box<ListNode>>) {
        let next = l.as_mut().unwrap().next.take();
        let head = l.take();
        (head, next)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(l1, l2, expected,
    case(&[], &[], &[]),
    case(&[1], &[], &[1]),
    case(&[1, 2], &[], &[1, 2]),
    case(&[1, 2, 4], &[1, 3, 4], &[1, 1, 2, 3, 4, 4]),
    ::trace
    )]
    fn iterate(l1: &[i32], l2: &[i32], expected: &[i32]) {
        assert_eq!(
            Solution::iterate(
                ListNode::in_option_box_from_array(l1),
                ListNode::in_option_box_from_array(l2)
            ),
            ListNode::in_option_box_from_array(expected)
        )
    }

    #[rstest(l1, l2, expected,
    case(&[], &[], &[]),
    case(&[1], &[], &[1]),
    case(&[1, 2], &[], &[1, 2]),
    case(&[1, 2, 4], &[1, 3, 4], &[1, 1, 2, 3, 4, 4]),
    ::trace
    )]
    fn recursive(l1: &[i32], l2: &[i32], expected: &[i32]) {
        let mut dummy = ListNode::new(0);
        Solution::recursive(
            &mut dummy,
            ListNode::in_option_box_from_array(l1),
            ListNode::in_option_box_from_array(l2),
        );
        assert_eq!(dummy.next, ListNode::in_option_box_from_array(expected))
    }

    #[test]
    fn separate() {
        let node = ListNode::from_array(&[1, 2, 3]);
        assert_eq!(
            Solution::separate(node.to_option_box()),
            (
                ListNode::new(1).to_option_box(),
                ListNode::from_array(&[2, 3]).to_option_box()
            )
        );
    }
}
