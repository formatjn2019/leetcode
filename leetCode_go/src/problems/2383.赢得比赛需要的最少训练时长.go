package problems

func MinNumberOfHours(initialEnergy int, initialExperience int, energy []int, experience []int) int {
	result := minNumberOfHours(initialEnergy, initialExperience, energy, experience)
	println(result)
	return result
}
func minNumberOfHours(initialEnergy int, initialExperience int, energy []int, experience []int) int {
	n := len(energy)
	result := 0
	for i := 0; i < n; i++ {
		if initialEnergy <= energy[i] {
			result += (energy[i] - initialEnergy) + 1
			initialEnergy = energy[i] + 1
		}
		if initialExperience <= experience[i] {
			result += (experience[i] - initialExperience) + 1
			initialExperience = experience[i] + 1
		}
		initialEnergy -= energy[i]
		initialExperience += experience[i]
	}
	return result
}
