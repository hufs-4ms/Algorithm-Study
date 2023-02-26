/*
 lv1 소수 찾기
*/
function solution(n) {
  const prime = new Array(n + 1).fill(1)
  console.log(prime)
  let count = n - 1
  for (let i = 2; i < Math.sqrt(n); i++)
    if (prime[i])
      for (let j = i ** 2; j <= n; j += i) if (prime[j]) count--, (prime[j] = 0)
  return count
}
