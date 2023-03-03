package problems

import (
	"fmt"
	"strings"
)

func GetFolderNames(names []string) []string {
	result := getFolderNames(names)
	fmt.Println(strings.Repeat("*", 100))
	fmt.Println(names)
	fmt.Println(result)
	return result
}
func getFolderNames(names []string) []string {
	nameCount := map[string]int{}
	result := make([]string, 0, len(names))
	for _, name := range names {
		//新名称
		if idx, ok := nameCount[name]; !ok {
			result = append(result, name)
			nameCount[name] = idx + 1
		} else {
			newName := fmt.Sprintf("%s(%d)", name, idx)
			for ; nameCount[newName] > 0; idx++ {
				newName = fmt.Sprintf("%s(%d)", name, idx)
			}
			result = append(result, newName)
			nameCount[newName] = 1
			nameCount[name] = idx
		}

	}
	return result
}

func getFolderNames_timeout(names []string) []string {
	nameSet := map[string]bool{}
	result := make([]string, 0, len(names))
	for _, name := range names {
		idx, newName := 1, name
		for ; nameSet[newName]; idx++ {
			newName = fmt.Sprintf("%s(%d)", name, idx)
		}
		result = append(result, newName)
		nameSet[newName] = true
	}
	return result
}
