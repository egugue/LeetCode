class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        # 28 ms	13.8 MB
        split = str.split(" ")
        length = len(pattern)
        if length != len(split):
            return False

        symbol_string = {}
        string_symbol = {}
        for i in range(length):
            symbol = pattern[i]
            if symbol in symbol_string:
                if symbol_string[symbol] != split[i]:
                    return False
            else:
                string = split[i]
                if string in string_symbol:
                    return False
                string_symbol[string] = symbol
                symbol_string[symbol] = string

        return True


if __name__ == '__main__':
    s = Solution()
    print(s.wordPattern("abba", "dog cat cat dog"))
    print(s.wordPattern("abba", "dog cat cat fish"))
    print(s.wordPattern("aaaa", "dog cat cat dog"))
    print(s.wordPattern("abba", "dog dog dog dog"))
