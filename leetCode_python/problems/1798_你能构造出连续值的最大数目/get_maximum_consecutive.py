class Solution(object):
    def getMaximumConsecutive_timeout(self, coins):
        """
        :type coins: List[int]
        :rtype: int
        """
        coins.sort()

        num_set, pre_number, index, sum, new_set = set(), 0, 0, 0, {0}
        for index in range(len(coins)):
            # 新数字重置累加
            # 老数字累加
            if pre_number == coins[index]:
                sum += pre_number
            else:
                sum = pre_number = coins[index]
                num_set = num_set.union(new_set)
                new_set = set()
                # 剪枝
                if sum - 1 not in num_set:
                    break

            for appended in num_set:
                new_set.add(sum + appended)
        num_set = num_set.union(new_set)
        # print(num_set)
        result = 0
        while result in num_set:
            result += 1
        return result

    def getMaximumConsecutive(self, coins):
        coins.sort()
        max = 0
        for coin in coins:
            if coin - 1 <= max:
                max += coin
            else:
                break
        return max + 1


if __name__ == '__main__':
    sl = Solution()
    print(sl.getMaximumConsecutive([1, 3]))
    print(sl.getMaximumConsecutive([1, 1, 1, 4]))
    print(sl.getMaximumConsecutive([1, 4,2, 9, 23, 55, 99, 2342, 4323, 43, 342, 10, 3, 1]))
