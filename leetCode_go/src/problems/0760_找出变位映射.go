package problems

func anagramMappings(nums1 []int, nums2 []int) []int {
	idxMap := map[int]int{}
	for idx, num := range nums2 {
		idxMap[num] = idx
	}
	result := make([]int, 0, len(nums1))
	for _, num := range nums1 {
		result = append(result, idxMap[num])
	}
	return result
}
