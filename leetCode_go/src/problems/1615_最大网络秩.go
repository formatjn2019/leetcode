package problems

import (
	"fmt"
)

func MaximalNetworkRank(n int, roads [][]int) int {
	result := maximalNetworkRank(n, roads)
	fmt.Println(result)
	return result
}
func maximalNetworkRank(n int, roads [][]int) int {
	cityMaps := make([]map[int]bool, n)
	for i := 0; i < n; i++ {
		cityMaps[i] = map[int]bool{}
	}
	//预处理
	for _, arr := range roads {
		cityMaps[arr[0]][arr[1]] = true
		cityMaps[arr[1]][arr[0]] = true
	}
	//贪心
	result, preMaxArr := 0, []map[int]bool{{}}
	for idx, cityMap := range cityMaps {
		// 几率更新最大值,则尝试
		if len(preMaxArr[0])+len(cityMap) > result {
			for i := 0; i < len(preMaxArr) && len(preMaxArr[0])+len(cityMap) > result; i++ {
				if _, ok := preMaxArr[i][idx]; ok {
					result = len(preMaxArr[0]) + len(cityMap) - 1
				} else {
					result = len(preMaxArr[0]) + len(cityMap)
				}
			}
		}
		//更新前置最大值
		if len(preMaxArr[0]) < len(cityMap) {
			preMaxArr = []map[int]bool{cityMap}
		} else if len(preMaxArr[0]) == len(cityMap) {
			preMaxArr = append(preMaxArr, cityMap)
		}
	}
	return result
}
