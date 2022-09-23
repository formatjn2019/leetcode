package problems

import (
	"bytes"
	"fmt"
)

func FlipLights(n int, presses int) int {
	if flipLights(n, presses) != flipLights2(n, presses) {
		fmt.Println("eeeeeeeerrror")
	} else {
		println()
	}
	return flipLights(n, presses)
}

// 分情况讨论
func flipLights2(n int, presses int) int {
	if presses == 0 {
		return 1
	} else if n == 1 {
		return 2
	} else if n == 2 {
		if presses == 1 {
			return 3
		} else {
			return 4
		}
	} else {
		if presses == 1 {
			return 4
		} else if presses == 2 {
			return 7
		} else {
			return 8
		}
	}
}
func flipLights(n int, presses int) int {
	types := [4]int{0b111111, 0b101010, 0b010101, 0b100100}

	typeMap := map[int]bool{0: true}
	for i := 0; i < presses; i++ {
		nMap := map[int]bool{}
		for _, operType := range types {
			for typeNum, _ := range typeMap {
				nMap[operType^typeNum] = true
			}
		}
		if len(nMap) == len(typeMap) {
			break
		} else {
			typeMap = nMap
		}
	}

	results := map[int]bool{}
	cover := 0b111111
	if n < 6 {
		cover = cover << (6 - n)
	}
	for typeNum, _ := range typeMap {
		results[typeNum&cover] = true
	}
	return len(results)
}

func flipLights_err(n int, presses int) int {
	types := map[string]bool{}

	var dfs func(int, []bool)

	arr := make([]bool, n)
	dfs = func(depth int, arr []bool) {
		if depth == 0 {
			types[getStr(arr)] = true
			return
		}
		//奇数更新
		for i := 0; i < len(arr); i += 2 {
			arr[i] = !arr[i]
		}
		dfs(depth-1, arr)
		//偶数更新
		for i := 0; i < len(arr); i++ {
			arr[i] = !arr[i]
		}
		dfs(depth-1, arr)
		//回复
		for i := 1; i < len(arr); i += 2 {
			arr[i] = !arr[i]
		}
		//取反
		for i := 0; i < len(arr); i++ {
			arr[i] = !arr[i]
		}
		dfs(depth-1, arr)
		//三的倍数
		for i := 0; i < len(arr); i += 3 {
			arr[i] = !arr[i]
		}
		dfs(depth-1, arr)
		//回复
		for i := 0; i < len(arr); i += 3 {
			arr[i] = !arr[i]
		}
	}
	dfs(presses, arr)

	return len(types)
}

func getStr(arr []bool) string {
	var bf bytes.Buffer
	for _, b := range arr {
		if b {
			bf.WriteString("1")
		} else {
			bf.WriteString("0")
		}
	}
	return bf.String()
}
