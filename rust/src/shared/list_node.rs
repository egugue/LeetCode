#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

impl From<&[i32]> for ListNode {
    fn from(array: &[i32]) -> Self {
        let mut current = None;

        for &num in array.iter().rev() {
            let mut node = ListNode::new(num);
            node.next = current;
            current = Some(Box::new(node));
        }

        *current.unwrap()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn from_array() {
        let expected = ListNode::new(10);
        assert_eq!(ListNode::from(&[10] as &[i32]), expected);

        let expected = ListNode {
            val: 10,
            next: Some(Box::new(ListNode {
                val: 20,
                next: Some(Box::new(ListNode {
                    val: 30,
                    next: None,
                })),
            })),
        };
        assert_eq!(ListNode::from(&[10, 20, 30] as &[i32]), expected)
    }

    #[test]
    #[should_panic]
    fn from_array_panic() {
        ListNode::from(&[] as &[i32]);
    }
}
