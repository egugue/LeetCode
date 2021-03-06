use crate::shared::tree_node::TreeNode;

struct Solution;

use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;

/// https://leetcode.com/problems/path-sum/
impl Solution {
    pub fn has_path_sum(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
        Solution::recursive(root, target_sum)
    }

    /// 0 ms	2.6 MB
    fn recursive(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
        fn helper(node: TreeNode, target_sum: i32) -> bool {
            let node = node;
            let target_sum = target_sum - node.val;
            if target_sum == 0 && node.left.is_none() && node.right.is_none() {
                return true;
            }

            let left_result = match node.left {
                Some(left) => {
                    let left = left.replace(TreeNode::new(0));
                    helper(left, target_sum)
                }
                None => false,
            };

            left_result
                || match node.right {
                    Some(right) => {
                        let right = right.replace(TreeNode::new(0));
                        helper(right, target_sum)
                    }
                    None => false,
                }
        }

        match root {
            Some(root) => helper(root.replace(TreeNode::new(0)), target_sum),
            None => false,
        }
    }

    /// 0 ms	2.5 MB
    fn iterative(root: Option<Rc<RefCell<TreeNode>>>, target_sum: i32) -> bool {
        if root.is_none() {
            return false;
        }
        let mut queue = VecDeque::new();
        let root = root.unwrap().replace(TreeNode::new(0));
        queue.push_front((0, root));

        while let Some((sum, node)) = queue.pop_front() {
            let sum = sum + node.val;
            if sum == target_sum && node.left.is_none() && node.right.is_none() {
                return true;
            }

            if let Some(left) = node.left {
                queue.push_front((sum, left.replace(TreeNode::new(0))));
            }
            if let Some(right) = node.right {
                queue.push_front((sum, right.replace(TreeNode::new(0))));
            }
        }

        false
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
        root,
        target_sum,
        expected,
        case("[]", 0, false),
        case("[1,2]", 1, false),
        case("[1,2]", 0, false),
        case("[1,2,3]", 5, false),
        case("[1,2,3]", 3, true),
        case("[1,2,3]", 4, true),
        case("[5,4,8,11,null,13,4,7,2,null,null,null,1]", 22, true)
    )]
    fn recursive(root: &str, target_sum: i32, expected: bool) {
        let root = TreeNode::from_str_and_wrap(root);
        assert_eq!(Solution::recursive(root, target_sum), expected);
    }

    #[rstest(
        root,
        target_sum,
        expected,
        case("[]", 0, false),
        case("[1,2]", 1, false),
        case("[1,2]", 0, false),
        case("[1,2,3]", 5, false),
        case("[1,2,3]", 3, true),
        case("[1,2,3]", 4, true),
        case("[5,4,8,11,null,13,4,7,2,null,null,null,1]", 22, true)
    )]
    fn iterative(root: &str, target_sum: i32, expected: bool) {
        let root = TreeNode::from_str_and_wrap(root);
        assert_eq!(Solution::iterative(root, target_sum), expected);
    }
}
