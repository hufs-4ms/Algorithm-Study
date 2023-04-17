/*
lv2 피보나치 수
*/
function solution(n) {
  //1:18
  var answer = 0

  let dp = [0, 1]

  for (let i = 2; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
  }

  answer = dp[n]
  return answer
}
