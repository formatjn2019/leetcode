package problems

import "fmt"

func FindLongestSubarray(array []string) []string {
	result := findLongestSubarray(array)
	fmt.Println(array, "\n", result, "\n", findLongestSubarray_reverse(array))
	return result
}

func findLongestSubarray(array []string) []string {
	idxMap, result := map[int]int{0: -1}, make([]string, 0)
	sum := 0
	for idx, str := range array {
		if c := []rune(str)[0]; c >= '0' && c <= '9' {
			sum++
		} else {
			sum--
		}
		if start, ok := idxMap[sum]; ok {
			if idx-start > len(result) {
				result = array[start+1 : idx+1]
			}
		} else {
			idxMap[sum] = idx
		}
	}
	return result
}
func findLongestSubarray_reverse(array []string) []string {
	result := make([]string, 0)

	for i := 0; i < len(array); i++ {
		nc, wc := 0, 0
		for j := i; j < len(array); j++ {
			if c := []rune(array[j])[0]; c >= '0' && c <= '9' {
				nc++
			} else {
				wc++
			}
			if nc == wc && j-i+1 > len(result) {
				result = array[i : j+1]
			}
		}

	}
	return result
}
