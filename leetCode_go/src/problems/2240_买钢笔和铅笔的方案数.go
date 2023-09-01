package problems

func waysToBuyPensPencils(total int, cost1 int, cost2 int) int64 {
	result := int64(0)
	for n1 := 0; n1*cost1 <= total; n1++ {
		result += int64((total-n1*cost1)/cost2 + 1)
	}
	return result
}
