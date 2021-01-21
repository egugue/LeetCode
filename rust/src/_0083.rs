use crate::shared::list_node::ListNode;

struct Solution;
/// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
impl Solution {
    /// 0 ms	2 MB
    pub fn delete_duplicates(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if head.is_none() || head.as_ref().unwrap().next.is_none() {
            return head;
        }

        let (head, cur) = Solution::separate(head);
        let mut head: ListNode = *head.unwrap();
        let mut first_same_node: &mut ListNode = &mut head;
        let mut cur: Option<Box<ListNode>> = cur;

        while cur.is_some() {
            let cur_val = cur.as_ref().unwrap().val;
            if first_same_node.val == cur_val {
                cur = cur.unwrap().next;
                continue;
            }

            let (different_head, different_next) = Solution::separate(cur);
            first_same_node.next = different_head;
            first_same_node = first_same_node.next.as_mut().unwrap();
            cur = different_next;
        }

        Some(Box::new(head))
    }

    fn separate(mut l: Option<Box<ListNode>>) -> (Option<Box<ListNode>>, Option<Box<ListNode>>) {
        let next = l.as_mut().unwrap().next.take();
        let head = l.take();
        (head, next)
    }
}

mod test {
    use super::*;
    use crate::shared::list_node::ListNode;
    use rstest::rstest;

    #[rstest(head, expected,
    case(&[], &[]),
    case(&[1], &[1]),
    case(&[1, 2, 3], &[1, 2, 3]),
    case(&[1, 1, 1], &[1]),
    case(&[1, 1, 2], &[1, 2]),
    case(&[1, 1, 2, 3, 3], &[1, 2, 3]),
    // ::trace
    )]
    fn delete_duplicates(head: &[i32], expected: &[i32]) {
        assert_eq!(
            Solution::delete_duplicates(ListNode::in_option_box_from_array(head)),
            ListNode::in_option_box_from_array(expected),
        )
    }
}
