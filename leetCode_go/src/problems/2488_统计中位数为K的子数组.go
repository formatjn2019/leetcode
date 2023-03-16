package problems

func CountSubarrays(nums []int, k int) int {
	return countSubarrays(nums, k)
}
func countSubarrays(nums []int, k int) int {
	prefixSum := make([]int, len(nums))
	//数组预处理，同时寻找索引
	idx := 0
	for i, num := range nums {
		if num == k {
			idx = i
			break
		}
	}
	prefixsumMap := map[int64]int{0: 1}
	//双向前缀和-l
	for i := idx - 1; i >= 0; i-- {
		if nums[i] < k {
			prefixSum[i] = prefixSum[i+1] - 1
		} else {
			prefixSum[i] = prefixSum[i+1] + 1
		}
		if (idx-i)%2 == 0 {
			prefixsumMap[int64(prefixSum[i])]++
		} else {
			prefixsumMap[1<<32+int64(prefixSum[i])]++
		}
	}
	//fmt.Println(prefixsumMap)
	//双向前缀和
	for i := idx + 1; i < len(nums); i++ {
		if nums[i] < k {
			prefixSum[i] = prefixSum[i-1] - 1
		} else {
			prefixSum[i] = prefixSum[i-1] + 1
		}
	}
	//fmt.Println(prefixSum)
	result := 0
	for rp := idx; rp < len(nums); rp++ {
		//奇数
		if (rp-idx)%2 == 1 {
			if num, ok := prefixsumMap[1<<32+int64(-prefixSum[rp])]; ok {
				result += num
			}
			if num, ok := prefixsumMap[int64(+1-prefixSum[rp])]; ok {
				result += num
			}
		} else {
			if num, ok := prefixsumMap[int64(-prefixSum[rp])]; ok {
				result += num
			}
			if num, ok := prefixsumMap[1<<32+int64(+1-prefixSum[rp])]; ok {
				result += num
			}
		}

	}
	return result
}
func countSubarraysTimeout(nums []int, k int) int {
	prefixSum := make([]int, len(nums))
	//数组预处理，同时寻找索引
	idx := 0
	for i, num := range nums {
		if num == k {
			idx = i
			break
		}
	}
	//双向前缀和
	for i := idx - 1; i >= 0; i-- {
		if nums[i] < k {
			prefixSum[i] = prefixSum[i+1] - 1
		} else {
			prefixSum[i] = prefixSum[i+1] + 1
		}
	}
	//双向前缀和
	for i := idx + 1; i < len(nums); i++ {
		if nums[i] < k {
			prefixSum[i] = prefixSum[i-1] - 1
		} else {
			prefixSum[i] = prefixSum[i-1] + 1
		}
	}
	result := 0
	//双指针
	for lp := idx; lp >= 0; lp-- {
		for rp := idx; rp < len(nums); rp++ {
			//奇数
			if (rp-lp)%2 == 0 {
				if prefixSum[lp]+prefixSum[rp] == 0 {
					result++
				}
			} else {
				if prefixSum[lp]+prefixSum[rp] == 1 {
					result++
				}
			}
		}
	}
	return result
}
