package problems

func minOperations_1598(logs []string) int {
	result := 0
	for _, op := range logs {
		switch op {
		case "../":
			if result > 0 {
				result--
			}
		case "./":
			continue
		default:
			result++
		}
	}
	return result
}
