struct Solution;

use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;

/// 111. Minimum Depth of Binary Tree
impl Solution {
    pub fn min_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        Solution::recursive(root)
    }

    /// 36 ms	13.7 MB
    fn recursive(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        use std::cmp::min;

        fn min_depth(node: TreeNode, cur_depth: i32) -> i32 {
            if node.left.is_none() && node.right.is_none() {
                return cur_depth;
            }

            let left_depth = if let Some(left) = node.left {
                min_depth(left.replace(TreeNode::new(0)), cur_depth + 1)
            } else {
                std::i32::MAX
            };
            let right_depth = if let Some(right) = node.right {
                min_depth(right.replace(TreeNode::new(0)), cur_depth + 1)
            } else {
                std::i32::MAX
            };
            min(left_depth, right_depth)
        }

        if let Some(root) = root {
            min_depth(root.replace(TreeNode::new(0)), 1)
        } else {
            0
        }
    }

    /// 40 ms	13.1 MB
    fn recursive_ref(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        use std::cmp::min;
        use std::ops::Deref;

        fn min_depth(node: &TreeNode, cur_depth: i32) -> i32 {
            if node.left.is_none() && node.right.is_none() {
                return cur_depth;
            }

            let left_depth = if let Some(node) = node.left.as_ref() {
                let node_ref = node.deref().borrow();
                min_depth(node_ref.deref(), cur_depth + 1)
            } else {
                std::i32::MAX
            };

            let right_depth = if let Some(node) = node.right.as_ref() {
                let node_ref = node.deref().borrow();
                min_depth(node_ref.deref(), cur_depth + 1)
            } else {
                std::i32::MAX
            };

            min(left_depth, right_depth)
        }

        if let Some(node) = root.as_ref() {
            let node_ref = node.deref().borrow();
            min_depth(node_ref.deref(), 1)
        } else {
            0
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
        tree,
        expected,
        case("[]", 0),
        case("[3]", 1),
        case("[3, 1]", 2),
        case("[3,9,20,null,null,15,7]", 2),
        case("[2,null,3,null,4,null,5,null,6]", 5)
    )]
    fn recursive(tree: &str, expected: i32) {
        assert_eq!(
            Solution::recursive(TreeNode::from_str_and_wrap(tree)),
            expected
        );
    }
}
