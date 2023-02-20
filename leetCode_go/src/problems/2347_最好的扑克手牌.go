package problems

func BestHand(ranks []int, suits []byte) string {
	return bestHand(ranks, suits)
}
func bestHand(ranks []int, suits []byte) string {
	rankMap, suitMap, maxRank, maxSuit := map[int]int{}, map[byte]int{}, 0, 0
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	for i := 0; i < 5; i++ {
		rankMap[ranks[i]] += 1
		suitMap[suits[i]] += 1
		maxRank = max(maxRank, rankMap[ranks[i]])
		maxSuit = max(maxSuit, suitMap[suits[i]])
	}
	switch {
	case maxSuit == 5:
		return "Flush"
	case maxRank > 2:
		return "Three of a Kind"
	case maxRank > 1:
		return "Pair"
	default:
		return "High Card"
	}
}
