package problems

func findRestaurant(list1 []string, list2 []string) []string {
	countMap := map[string]int{}
	for i, str := range list1 {
		countMap[str] = i
	}
	result := make([]string, 0)
	min := len(list1) + len(list2)
	for i, str := range list2 {
		index, ok := countMap[str]
		if ok {
			if index+i < min {
				result = []string{str}
				min = index + i
			} else if index+i == min {
				result = append(result, str)
			}
		}
	}
	return result
}
