package main

import "fmt"

func main() {
	var T int
	if _, err := fmt.Scanf("%d\n", &T); err != nil {
		return
	}

	for i := 0; i < T; i++ {
		var k, n int
		if _, err := fmt.Scanf("%d\n%d\n", &k, &n); err != nil {
			return
		}

		ans := solve(k, n)
		fmt.Printf("%d\n", ans)
	}
}

func solve(k int, n int) int {
	dp := make([][]int, k)
	for idx := range dp {
		dp[idx] = make([]int, n+1)
	}

	// 0번째 줄
	for i := 1; i < n+1; i++ {
		dp[0][i] = dp[0][i-1] + i
	}

	for j := 1; j < k; j++ {
		for i := 1; i <= n; i++ {
			dp[j][i] = dp[j][i-1] + dp[j-1][i]
		}
	}

	return dp[k-1][n]
}
