package problems

import "sort"

func MiceAndCheese(reward1 []int, reward2 []int, k int) int {
	return miceAndCheese(reward1, reward2, k)
}
func miceAndCheese(reward1 []int, reward2 []int, k int) int {
	indexArr := make([]int, len(reward1))
	for i := 0; i < len(indexArr); i++ {
		indexArr[i] = i
	}
	sort.Slice(indexArr, func(i, j int) bool {
		return reward1[indexArr[i]]-reward2[indexArr[i]] > reward1[indexArr[j]]-reward2[indexArr[j]]
	})
	result := 0
	for i := 0; i < len(reward1); i++ {
		if i < k {
			result += reward1[indexArr[i]]
		} else {
			result += reward2[indexArr[i]]
		}
	}
	return result
}
