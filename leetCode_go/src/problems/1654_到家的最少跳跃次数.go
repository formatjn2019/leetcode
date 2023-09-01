package problems

import "fmt"

func MinimumJumps(forbidden []int, a int, b int, x int) int {
	return minimumJumps(forbidden, a, b, x)
}

func minimumJumps(forbidden []int, a int, b int, x int) int {
	mem := map[int]int{}
	//位移为后跳次数
	for _, num := range forbidden {
		mem[(num << 1)] = -1
		mem[(num<<1)|1] = -1
	}
	var dfs func(int, int, bool) int
	dfs = func(count, idx int, backJumped bool) int {
		if idx == x {
			return 0
		} else if mem[(idx<<1)|1]+mem[(idx<<1)] == -2 || idx-b > x || idx < 0 {
			return -1
		}
		if _, ok := mem[(idx+a)<<1]; !ok {
			mem[(idx+a)<<1] = dfs(count+1, idx+a, false)
		}
		rt := mem[(idx+a)<<1]
		if !backJumped {
			if _, ok := mem[((idx-b)<<1)|1]; !ok {
				mem[((idx-b)<<1)|1] = dfs(count+1, idx-b, true)
			}
			if rt == -1 || (mem[((idx-b)<<1)|1] != -1 && mem[((idx-b)<<1)|1] < rt) {
				rt = mem[((idx-b)<<1)|1]
			}
		}
		if rt == -1 {
			return rt
		}
		return rt + 1
	}
	tt := dfs(0, 0, true)
	for k, v := range mem {
		fmt.Println(k, v)
	}
	return tt
}

func minimumJumps2(forbidden []int, a int, b int, x int) int {
	//result := -1
	mem := map[int]int{}
	for _, num := range forbidden {
		mem[num] = -1
	}
	var dfs func(int, int, bool) int
	dfs = func(count, idx int, backJumped bool) int {
		if _, ok := mem[idx]; idx-2*b > x || idx < 0 || ok {
			return -1
		} else if idx == x {
			return 0
		}

		rt := dfs(count+1, idx+a, false)
		if !backJumped {
			if tp := dfs(count+1, idx-b, true); rt == -1 || (tp != -1 && tp < rt) {
				rt = tp
			}
		}
		if rt == -1 {
			return rt
		}
		return rt + 1
	}
	return dfs(0, 0, false)
}
