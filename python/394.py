class Solution:
    def decodeString(self, s: str) -> str:
        # 394. Decode String
        length = len(s)
        if length == 0:
            return ""

        num_stack = []
        string_stack = [""]
        i = 0
        while i < length:
            ch = s[i]
            if ch.isdecimal():
                left = i
                while s[i].isdecimal():
                    i += 1
                    if i == length:
                        break
                num_stack.append(int(s[left:i]))
                continue

            if ch == '[':
                string_stack.append("")
                i += 1
                continue

            if ch == ']':
                i += 1
                string = string_stack.pop()
                repeat = num_stack.pop()
                string_stack[-1] += string * repeat

            else:
                encoded_left_index = i
                while not (s[i].isdecimal() or s[i] == '[' or s[i] == ']'):
                    i += 1
                    if i == length:
                        break
                string_stack[-1] += s[encoded_left_index:i]

        result = ""
        for i in range(len(string_stack)):
            result += string_stack[i]
        print(result)
        return result


if __name__ == '__main__':
    s = Solution()
    assert s.decodeString("3[a]2[bc]") == "aaabcbc"
    assert s.decodeString("3[a2[c]]") == "accaccacc"
    assert s.decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef"
    assert s.decodeString("3[a]2[b4[F]c]") == "aaabFFFFcbFFFFc"
    print(s.decodeString("10[a]"))
