class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        # 36 ms	13.9 MB
        different_bits = x ^ y

        count = 0
        while different_bits != 0:
            if different_bits & 1:
                count += 1
            different_bits >>= 1

        return count


if __name__ == '__main__':
    s = Solution()
    print(s.hammingDistance(1, 4))
    print(s.hammingDistance(1, 8))
    print(s.hammingDistance(3, 1))
