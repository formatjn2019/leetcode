package problems

import "sort"

func FrequencySort(nums []int) []int {
	return frequencySort(nums)
}

func frequencySort(nums []int) []int {
	numsCount := map[int]int{}
	for _, num := range nums {
		numsCount[num]++
	}
	contArr := make([][]int, len(nums))
	for k, v := range numsCount {
		contArr[v-1] = append(contArr[v-1], k)
	}
	for _, arr := range contArr {
		sort.Slice(arr, func(i, j int) bool {
			return arr[i] > arr[j]
		})
	}
	index := 0
	for count, arr := range contArr {
		for _, num := range arr {
			for i := 0; i <= count; i++ {
				nums[index] = num
				index++
			}
		}
	}
	return nums
}
