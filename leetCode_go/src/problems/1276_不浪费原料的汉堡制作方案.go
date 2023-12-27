package problems

func NumOfBurgers(tomatoSlices int, cheeseSlices int) []int {
	return numOfBurgers(tomatoSlices, cheeseSlices)
}

func numOfBurgers(tomatoSlices int, cheeseSlices int) []int {
	if cheeseSlices*2 > tomatoSlices || cheeseSlices*4 < tomatoSlices {
		return []int{}
	}
	result := make([]int, 2)
	result[0] = (tomatoSlices - 2*cheeseSlices) / 2
	result[1] = cheeseSlices - result[0]
	if result[0]*4+result[1]*2 != tomatoSlices {
		return []int{}
	}
	return result
}
