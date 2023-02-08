package problems

import (
	"fmt"
	"sort"
	"strings"
)

func RemoveSubfolders(folder []string) []string {
	fmt.Println(folder)
	result := removeSubfolders(folder)
	fmt.Println(result)
	return result
}

func removeSubfolders(folder []string) []string {
	treeMap := map[string]bool{}
	var createTree func([]string, string) bool
	createTree = func(pathlist []string, prefix string) bool {
		// 叶子节点标记
		if len(pathlist) == 1 {
			treeMap[prefix+"/"+pathlist[0]] = true
			return false
		}
		if pathlist[0] == "" {
			return createTree(pathlist[1:], prefix)
		} else {
			//当前路径
			path := prefix + "/" + pathlist[0]
			if _, ok := treeMap[path]; !ok {
				treeMap[path] = false
			} else {
				if treeMap[path] {
					return true
				}
			}
			return createTree(pathlist[1:], prefix+"/"+pathlist[0])
		}
	}
	//排序,省去乱序的处理
	sort.Strings(folder)
	result := make([]string, 0)
	for _, folder := range folder {
		pathList := strings.Split(folder, "/")
		if !createTree(pathList, "") {
			result = append(result, folder)
		}
	}
	return result
}
