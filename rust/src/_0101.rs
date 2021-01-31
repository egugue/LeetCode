use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;

struct Solution;
/// https://leetcode.com/problems/symmetric-tree/
impl Solution {
    pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        // Solution::recursive(root)
        Solution::iterative(root)
    }

    /// 0 ms	2.2 MB
    fn recursive(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        fn is_sym(
            left: Option<Rc<RefCell<TreeNode>>>,
            right: Option<Rc<RefCell<TreeNode>>>,
        ) -> bool {
            match (left, right) {
                (Some(l), Some(r)) => {
                    let l = l.borrow();
                    let r = r.borrow();
                    l.val == r.val
                        && is_sym(l.left.clone(), r.right.clone())
                        && is_sym(l.right.clone(), r.left.clone())
                }
                (None, None) => true,
                _ => false,
            }
        }

        if let Some(r) = root {
            let node = r.replace(TreeNode::new(1));
            is_sym(node.left, node.right)
        } else {
            true
        }
    }

    /// 0 ms	2.1 MB
    fn iterative(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        if root.is_none() {
            return true;
        }

        let root = root.unwrap().replace(TreeNode::new(1));
        let mut queue = VecDeque::new();
        queue.push_front((root.left, root.right));

        while !queue.is_empty() {
            match queue.pop_back().unwrap() {
                (Some(l), Some(r)) => {
                    let l = l.borrow();
                    let r = r.borrow();
                    if l.val != r.val {
                        return false;
                    }
                    queue.push_front((l.left.clone(), r.right.clone()));
                    queue.push_front((l.right.clone(), r.left.clone()));
                }
                (None, None) => {}
                _ => return false,
            }
        }

        true
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
        root,
        expected,
        case("[]", true),
        case("[1]", true),
        case("[1,2,2,3,4,4,3]", true),
        case("[1,2,2,null,3,null,3]", false)
    )]
    fn recursive(root: &str, expected: bool) {
        assert_eq!(
            Solution::recursive(TreeNode::from_str_and_wrap(root)),
            expected
        )
    }

    #[rstest(
        root,
        expected,
        case("[]", true),
        case("[1]", true),
        case("[1,2,2,3,4,4,3]", true),
        case("[1,2,2,null,3,null,3]", false)
    )]
    fn iterative(root: &str, expected: bool) {
        assert_eq!(
            Solution::iterative(TreeNode::from_str_and_wrap(root)),
            expected
        )
    }
}
