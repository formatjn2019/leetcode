package problems

var ValidPartition = validPartition

func validPartition(nums []int) bool {
	n := len(nums)
	matrix := make([]bool, n+1)
	matrix[0] = true

	for i := 1; i <= n; i++ {
		// 2
		if i > 1 && nums[i-1] == nums[i-2] {
			matrix[i] = matrix[i] || matrix[i-2]
		}
		//3
		if i > 2 && ((nums[i-1] == nums[i-2] && nums[i-2] == nums[i-3]) || (nums[i-1] == nums[i-2]+1 && nums[i-2] == nums[i-3]+1)) {
			matrix[i] = matrix[i] || matrix[i-3]
		}
	}
	return matrix[n]
}

func validPartition_outmemory(nums []int) bool {
	n := len(nums)
	matrix := make([][]bool, 4)
	matrix[0] = make([]bool, n+1)
	matrix[0][0] = true

	for i := 1; i <= n; i++ {
		matrix[i%4] = make([]bool, n+1)
		// 2
		if i > 1 && nums[i-1] == nums[i-2] {
			matrix[i%4][i-1] = matrix[(i+2)%4][i-2] || matrix[i%4][i-1]
			matrix[i%4][i] = matrix[(i+2)%4][i-2] || matrix[i%4][i]
		}
		//3
		if i > 2 && ((nums[i-1] == nums[i-2] && nums[i-2] == nums[i-3]) || (nums[i-1] == nums[i-2]+1 && nums[i-2] == nums[i-3]+1)) {
			matrix[i%4][i-2] = matrix[(i+1)%4][i-3] || matrix[i%4][i-2]
			matrix[i%4][i-1] = matrix[(i+1)%4][i-3] || matrix[i%4][i-1]
			matrix[i%4][i] = matrix[(i+1)%4][i-3] || matrix[i%4][i]
		}
	}
	return matrix[n%4][n]
}

func validPartition_tiemout(nums []int) bool {
	ck2 := func(nums []int) bool {
		if len(nums) < 2 {
			return false
		}
		return nums[0] == nums[1]
	}

	ck3 := func(nums []int) bool {
		if len(nums) < 3 {
			return false
		}
		return (nums[0] == nums[1] && nums[1] == nums[2]) || (nums[0]+1 == nums[1] && nums[1]+1 == nums[2])
	}

	var vf func(num []int) bool
	vf = func(num []int) bool {
		if len(nums) == 0 {
			return true
		} else {
			return (ck2(nums) && vf(nums[2:])) || (ck3(nums) && vf(nums[3:]))
		}
	}
	return vf(nums)
}
