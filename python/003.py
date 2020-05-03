class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        appeared = set()
        longest = 0
        left, right = 0, 0
        while right < len(s):
            char = s[right]
            if char in appeared:
                appeared.remove(s[left])
                left += 1
            else:
                appeared.add(char)
                longest = max(longest, len(appeared))
                right += 1

        return longest
