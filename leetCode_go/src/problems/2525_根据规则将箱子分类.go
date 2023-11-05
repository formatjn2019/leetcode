package problems

func categorizeBox(length int, width int, height int, mass int) string {
	area := length * width * height
	bullkyFlag := area >= 1e9 || length >= 1e4 || width >= 1e4 || height >= 1e4
	HeavyFlag := mass >= 100
	if bullkyFlag && HeavyFlag {
		return "Both"
	} else if !bullkyFlag && !HeavyFlag {
		return "Neither"
	} else if bullkyFlag {
		return "Bulky"
	} else {
		return "Heavy"
	}
}
