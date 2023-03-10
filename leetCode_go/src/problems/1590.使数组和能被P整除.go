package problems

import "fmt"

func MinSubarray(nums []int, p int) int {
	result := minSubarray(nums, p)
	fmt.Println(nums, p, result)
	return result
}
func minSubarray(nums []int, p int) int {
	prefixSumArr, sum := make([]int, len(nums)+1), 0
	for idx, num := range nums {
		prefixSumArr[idx] = sum % p
		sum += num
	}
	prefixSumArr[len(prefixSumArr)-1] = sum % p
	sub := sum % p
	result := -1
	if sum < p {
		return -1
	} else if sum%p == 0 {
		return 0
	}
	//逆序搜索
	idxMap := map[int]int{}
	for i := len(prefixSumArr) - 1; i >= 0; i-- {
		expect := (sub + prefixSumArr[i]) % p
		if idx, ok := idxMap[expect]; ok {
			if (result == -1 && idx-i < len(nums)) || result > idx-i {
				result = idx - i
			}
		}
		idxMap[prefixSumArr[i]] = i
	}
	return result
}
