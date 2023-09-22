package problems

func findLonelyPixel(picture [][]byte) int {
	var result int
	lc, rc := make([]int, len(picture)), make([]int, len(picture[0]))
	for i, line := range picture {
		for j, p := range line {
			if p == 'B' {
				lc[i]++
				rc[j]++
			}
		}
	}
	for i, line := range picture {
		for j, p := range line {
			if p == 'B' && lc[i] == 1 && rc[j] == 1 {
				result++
			}
		}
	}
	return result
}
