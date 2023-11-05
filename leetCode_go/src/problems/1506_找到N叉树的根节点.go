package problems

func findRoot(tree []*Node) *Node {
	nodeMap := map[*Node]bool{}
	for _, tn := range tree {
		nodeMap[tn] = true
	}
	for _, tn := range tree {
		for _, sb := range tn.Children {
			nodeMap[sb] = false
		}
	}
	for _, tn := range tree {
		if nodeMap[tn] {
			return tn
		}
	}
	return nil
}
