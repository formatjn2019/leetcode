package problems

func averageValue(nums []int) int {
	sum, con := 0, 0
	for _, num := range nums {
		if num%6 == 0 {
			sum += num
			con++
		}
	}
	if sum != 0 {
		return sum / con
	}
	return sum
}
