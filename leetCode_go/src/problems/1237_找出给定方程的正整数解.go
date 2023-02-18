package problems

func FindSolution(customFunction func(int, int) int, z int) [][]int {
	return findSolution(customFunction, z)
}
func findSolution(customFunction func(int, int) int, z int) [][]int {
	result := make([][]int, 0)
	//双指针
	prerp := 1000
	for lp := 1; lp <= 1000; lp++ {
		for rp := prerp; rp > 0; rp-- {
			ant := customFunction(lp, rp)
			switch {
			case ant == z:
				prerp = rp
				result = append(result, []int{lp, rp})
			case ant < z:
				break
			}
		}
	}
	return result
}
