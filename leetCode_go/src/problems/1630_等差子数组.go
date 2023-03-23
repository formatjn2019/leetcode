package problems

import (
	"fmt"
	"sort"
	"strings"
)

func CheckArithmeticSubarrays(nums []int, l []int, r []int) []bool {
	fmt.Println(nums)
	fmt.Println(l)
	fmt.Println(r)
	fmt.Println(strings.Repeat("*", 100))
	result := checkArithmeticSubarrays(nums, l, r)
	fmt.Println(result)
	return result
}

func checkArithmeticSubarrays(nums []int, l []int, r []int) []bool {
	result := make([]bool, len(l))
	isDc := func(arr []int) bool {
		minN, maxN, al, used := arr[0], arr[0], len(arr), map[int]bool{}
		for i := 1; i < al; i++ {
			if maxN < arr[i] {
				maxN = arr[i]
			}
			if minN > arr[i] {
				minN = arr[i]
			}
		}
		dif := (maxN - minN) / (al - 1)
		for _, num := range arr {
			if dif == 0 && num != minN {
				return false
			} else if dif != 0 {
				t := (num - minN) / dif
				if _, ok := used[t]; ok || t < 0 || t >= al || (num-minN)%dif != 0 {
					return false
				}
				used[t] = true
			}
		}
		return true
	}
	for i := 0; i < len(l); i++ {
		li, ri := l[i], r[i]
		if ri-li < 2 {
			result[i] = true
		} else {
			result[i] = isDc(nums[li : ri+1])
		}
	}
	return result
}

func checkArithmeticSubarraysSort(nums []int, l []int, r []int) []bool {
	m, n := len(nums), len(l)
	result := make([]bool, n)
	tpArr := make([]int, m)
	isDc := func(arr []int) bool {
		sort.Ints(arr)
		dif := arr[1] - arr[0]
		for i := 2; i < len(arr); i++ {
			if arr[i]-arr[i-1] != dif {
				return false
			}
		}
		return true
	}
	for i := 0; i < n; i++ {
		li, ri := l[i], r[i]
		if ri-li < 2 {
			result[i] = true
		} else {
			tArr := tpArr[0 : ri-li+1]
			copy(tArr, nums[li:ri+1])
			result[i] = isDc(tArr)
		}
	}
	return result
}
