from typing import List


class Solution:
    def countBits(self, num: int) -> List[int]:
        # 80 ms	20.7 MB
        if num == 0:
            return [0]
        bits = [0] * (num + 1)
        bits[1] = 1

        power = 2
        while power <= num:
            bits[power] = 1
            next_power = power << 1
            for i in range(power + 1, next_power):
                if i > num:
                    break
                bits[i] = 1 + bits[i - power]
            power = next_power

        return bits


if __name__ == '__main__':
    s = Solution()
    print(s.countBits(1))
    print(s.countBits(2))
    print(s.countBits(8))
