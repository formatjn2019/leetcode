package problems

import "sort"

func NumFactoredBinaryTrees(arr []int) int {
	return numFactoredBinaryTrees(arr)
}
func numFactoredBinaryTrees(arr []int) int {
	MOD := 1000000007
	mem, result := map[int]int{}, 0
	sort.Ints(arr)
	for _, num := range arr {
		mem[num] = -1
	}
	for i, nr := range arr {
		mem[nr] = 1
		for _, nl := range arr[:i] {
			if con, ok := mem[nr/nl]; ok && nr%nl == 0 {
				if nr == nl*nl {
					mem[nr] = (mem[nr] + mem[nl]*mem[nl]) % MOD
				} else {
					mem[nr] = (mem[nr] + mem[nl]*con) % MOD
				}
			}
		}
		result = (mem[nr] + result) % MOD
	}
	return result
}
