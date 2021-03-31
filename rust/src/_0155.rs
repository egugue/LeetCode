/// https://leetcode.com/problems/min-stack/
/// 4 ms	5.6 MB
struct MinStack {
    stack: Vec<i32>,
    min: i32,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MinStack {
    /** initialize your data structure here. */
    fn new() -> Self {
        Self {
            stack: Vec::new(),
            min: i32::max_value(),
        }
    }

    /// pushes the element val onto the stack.
    fn push(&mut self, val: i32) {
        if val <= self.min {
            self.stack.push(self.min);
            self.min = val;
        }
        self.stack.push(val);
    }

    /// removes the element on the top of the stack.
    fn pop(&mut self) {
        if self.stack.pop().unwrap() == self.min {
            self.min = self.stack.pop().unwrap();
        }
    }

    /// gets the top element of the stack.
    fn top(&self) -> i32 {
        *self.stack.last().unwrap()
    }

    /// retrieves the minimum element in the stack.
    fn get_min(&self) -> i32 {
        if self.stack.len() <= 1 {
            panic!();
        }
        self.min
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn example_case() {
        let mut stack = MinStack::new();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assert_eq!(stack.get_min(), -3); // return -3
        stack.pop();
        assert_eq!(stack.get_min(), -2); // return -3
        assert_eq!(stack.top(), 0); // return 0
        assert_eq!(stack.get_min(), -2); // return -2

        stack.pop(); // pop 0
        stack.pop(); // pop -2
    }

    #[test]
    #[should_panic]
    fn example_case_last_min() {
        let mut stack = MinStack::new();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.get_min();
    }

    #[test]
    #[should_panic]
    fn i32_max_last_min() {
        let mut stack = MinStack::new();
        stack.push(i32::max_value());
        stack.pop();
        stack.get_min();
    }
}
