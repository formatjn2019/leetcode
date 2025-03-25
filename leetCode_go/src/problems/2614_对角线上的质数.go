package problems

import "math"

func DiagonalPrime(nums [][]int) int {
	return diagonalPrime(nums)
}

func diagonalPrime(nums [][]int) int {
	isPrime := func(n int) bool {
		if n < 2 {
			return false
		}

		for i := 2; i <= int(math.Sqrt(float64(n))); i++ {
			if n%i == 0 {
				return false
			}
		}

		return true
	}

	result, l := 0, len(nums)
	for i := 0; i < len(nums); i++ {
		for j := 0; j < len(nums[i]); j++ {
			if (i == j || i+j == l-1) && isPrime(nums[i][j]) && result < nums[i][j] {
				result = nums[i][j]
			}
		}
	}
	return result
}
