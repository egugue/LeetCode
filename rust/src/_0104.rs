use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::cmp::max;
use std::rc::Rc;

struct Solution;
/// https://leetcode.com/problems/maximum-depth-of-binary-tree/
impl Solution {
    pub fn max_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        // Solution::recursive1(root)
        Solution::recursive2(root)
    }

    /// 0 ms	2.7 MB
    fn recursive1(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        if root.is_none() {
            return 0;
        }

        let root = root.unwrap().replace(TreeNode::new(0));
        return 1 + max(
            Solution::recursive1(root.left),
            Solution::recursive1(root.right),
        );
    }

    /// 0 ms	2.6 MB
    ///
    /// A version of avoiding to replace a node.
    /// Probably it uses slightly less memory than recursive1 function.
    fn recursive2(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        use std::ops::Deref;

        fn helper(node: Option<&Rc<RefCell<TreeNode>>>) -> i32 {
            if node.is_none() {
                return 0;
            }
            let node = node.unwrap();
            let node = node.deref();
            let node = node.borrow();
            return 1 + max(helper(node.left.as_ref()), helper(node.right.as_ref()));
        }

        helper(root.as_ref())
    }
}

mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(
        root,
        expected,
        case("[]", 0),
        case("[1]", 1),
        case("[1,null,2]", 2),
        case("[3,9,20,null,null,15,7]", 3)
    )]
    fn recursive1(root: &str, expected: i32) {
        assert_eq!(
            Solution::recursive1(TreeNode::from_str_and_wrap(root)),
            expected
        );
    }

    #[rstest(
        root,
        expected,
        case("[]", 0),
        case("[1]", 1),
        case("[1,null,2]", 2),
        case("[3,9,20,null,null,15,7]", 3)
    )]
    fn recursive2(root: &str, expected: i32) {
        assert_eq!(
            Solution::recursive2(TreeNode::from_str_and_wrap(root)),
            expected
        );
    }
}
