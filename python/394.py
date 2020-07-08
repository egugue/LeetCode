class Solution:
    def decodeString(self, s: str) -> str:
        # 36 ms	13.7 MB
        length = len(s)
        if length == 0:
            return ""

        num_stack = []
        string_stack = []
        num = 0
        string = ""
        for char in s:
            if char == '[':
                string_stack.append(string)
                num_stack.append(num)
                num = 0
                string = ""
            elif char == ']':
                repeat = num_stack.pop()
                prev_string = string_stack.pop()
                string = prev_string + string * repeat
            elif char.isdigit():
                num = num * 10 + int(char)
            else:
                string += char

        return string


if __name__ == '__main__':
    s = Solution()
    assert s.decodeString("3[a]2[bc]") == "aaabcbc"
    assert s.decodeString("3[a2[c]]") == "accaccacc"
    assert s.decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef"
    assert s.decodeString("3[a]2[b4[F]c]") == "aaabFFFFcbFFFFc"
    print(s.decodeString("10[a]"))
