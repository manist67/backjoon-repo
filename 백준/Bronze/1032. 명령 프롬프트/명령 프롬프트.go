package main

import "fmt"

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	var arr []string
	for i := 0; i < n; i++ {
		var s string
		fmt.Scanf("%s\n", &s)
		arr = append(arr, s)
	}

	l := len(arr[0])

	ans := ""
	for i := 0; i < l; i++ {
		isAllCorrect := true

		controlChar := string(arr[0][i])

		for j := 1; j < n; j++ {
			if controlChar != string(arr[j][i]) {
				isAllCorrect = false
				break
			}
		}

		if isAllCorrect {
			ans += controlChar
		} else {
			ans += "?"
		}
	}

	fmt.Printf("%s\n", ans)
}
