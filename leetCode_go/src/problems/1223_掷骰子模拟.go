package problems

import "fmt"

func DieSimulator(n int, rollMax []int) int {
	result := dieSimulator(n, rollMax)
	fmt.Println(result)
	return result
}
func dieSimulator(n int, rollMax []int) int {
	matrix, mod := make([][6]int, n+1), 1000000007
	sum := func(arr []int, sub int) int {
		result := sub
		for _, num := range arr {
			result = (result + num + mod) % mod
		}
		return result % mod
	}
	//首行填充
	for i := 0; i < 6; i++ {
		matrix[1][i] = 1
	}
	//动态计算
	for i := 2; i <= n; i++ {
		for j := 0; j < 6; j++ {
			matrix[i][j] = sum(matrix[i-1][:], 0)
			if i > rollMax[j] {
				idx := i - rollMax[j] - 1
				arrSum := sum(matrix[idx][:], -matrix[idx][j])
				if arrSum == 0 {
					matrix[i][j]--
				} else {
					matrix[i][j] -= arrSum
				}
			}

		}
	}
	for _, arr := range matrix {
		fmt.Println(arr)
	}
	return sum(matrix[len(matrix)-1][:], 0)
}
