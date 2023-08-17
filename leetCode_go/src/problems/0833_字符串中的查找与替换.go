package problems

import (
	"bytes"
	"sort"
)

func FindReplaceString(s string, indices []int, sources []string, targets []string) string {
	return findReplaceString(s, indices, sources, targets)
}
func findReplaceString(s string, indices []int, sources []string, targets []string) string {
	replList := make([][2]int, 0)
	for i, idx := range indices {
		src := sources[i]
		if idx+len(src) <= len(s) && s[idx:idx+len(src)] == src {
			replList = append(replList, [2]int{i, len(src)})
		}
	}
	sort.Slice(replList, func(i, j int) bool {
		return indices[replList[i][0]] < indices[replList[j][0]]
	})
	start := 0
	var bf bytes.Buffer
	for _, arr := range replList {
		bf.WriteString(s[start:indices[arr[0]]])
		bf.WriteString(targets[arr[0]])
		start = indices[arr[0]] + arr[1]
	}
	bf.WriteString(s[start:])
	return bf.String()
}
