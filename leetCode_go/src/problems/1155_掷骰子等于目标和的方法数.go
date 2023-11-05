package problems

const mod = 1e9 + 7

func NumRollsToTarget(n int, k int, target int) int {
	return numRollsToTarget(n, k, target)
}

func numRollsToTarget(n int, k int, target int) int {
	matrix := make([][]int, n)
	for i := 0; i < n; i++ {
		matrix[i] = make([]int, target+1)
	}
	for i := 1; i <= k && i <= target; i++ {
		matrix[0][i] = 1
	}
	for i := 0; i < n-1; i++ {
		for j := 0; j < len(matrix[i]); j++ {
			for l := 1; l <= k; l++ {
				row := j + l
				if row > target {
					continue
				}
				matrix[i+1][row] = (matrix[i+1][row] + matrix[i][j]) % mod
			}
		}
	}
	return matrix[n-1][target]
}

func numRollsToTarget_timeout(n int, k int, target int) int {
	if target == 0 && n == 0 {
		return 1
	} else if target > 0 && n == 0 {
		return 0
	}
	var result int
	for i := 1; i <= k && i <= target-n+1; i++ {
		result = (result + numRollsToTarget_timeout(n-1, k, target-i)) % mod
	}
	return result
}
