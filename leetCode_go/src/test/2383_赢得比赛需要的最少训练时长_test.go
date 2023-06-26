package test

import (
	"src/problems"
	"testing"
)

func TestMinNumberOfHours(t *testing.T) {
	//initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [2,6,3,1]
	problems.MinNumberOfHours(5, 3, []int{1, 4, 3, 2}, []int{2, 6, 3, 1})
}
