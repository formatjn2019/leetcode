package problems

func checkIfPrerequisite(numCourses int, prerequisites [][]int, queries [][]int) []bool {
	nodeMap := make([][]int, numCourses)
	inCon := make([]int, numCourses)
	for _, prerequisite := range prerequisites {
		nodeMap[prerequisite[0]] = append(nodeMap[prerequisite[0]], prerequisite[1])
		inCon[prerequisite[1]]++
	}
	//入度为0
	array := []int{}
	for idx, con := range inCon {
		if con == 0 {
			array = append(array, idx)
		}
	}

	matrix := make([][]bool, numCourses)
	for i := 0; i < numCourses; i++ {
		matrix[i] = make([]bool, numCourses)
	}
	for len(array) > 0 {
		node := array[len(array)-1]
		array = array[:len(array)-1]
		for _, nn := range nodeMap[node] {
			matrix[node][nn] = true
			for i := 0; i < numCourses; i++ {
				matrix[i][nn] = matrix[i][nn] || matrix[i][node]
			}
			inCon[nn]--
			if inCon[nn] == 0 {
				array = append(array, nn)
			}
		}
	}

	result := make([]bool, 0, len(queries))
	for _, query := range queries {
		result = append(result, matrix[query[0]][query[1]])
	}
	return result
}

func checkIfPrerequisite_timeout(numCourses int, prerequisites [][]int, queries [][]int) []bool {
	nodeMap := make([][]int, numCourses)
	result := make([]bool, 0, len(queries))
	for _, prerequisite := range prerequisites {
		nodeMap[prerequisite[0]] = append(nodeMap[prerequisite[0]], prerequisite[1])
	}
	var dfs func(start int, expect int) bool
	dfs = func(start int, expect int) bool {
		rt := false
		for _, n := range nodeMap[start] {
			if n == expect || dfs(n, expect) {
				return true
			}
		}
		return rt
	}

	for _, query := range queries {
		result = append(result, dfs(query[0], query[1]))
	}
	return result
}
