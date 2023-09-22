package problems

func smallestCommonElement(mat [][]int) int {
	countMap := map[int]int{}
	for _, line := range mat {
		for idx, num := range line {
			if idx+1 == len(line) || line[idx+1] != num {
				countMap[num]++
			}
		}
	}
	result := -1
	for num, _ := range countMap {
		if countMap[num] == len(mat) && (result == -1 || result > num) {
			result = num
		}
	}
	return result
}
