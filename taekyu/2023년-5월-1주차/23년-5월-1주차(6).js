/*
lv2 k진수에서 소수 개수 구하기
*/
function solution(n, k) {
  var answer = 0
  let arr = []
  while (n > 0) {
    arr.unshift(n % k)
    n = Math.floor(n / k)
  }
  arr = arr.join('').split(0).map(Number)
  for (let i of arr) {
    if (isPrime(i)) answer++
  }
  return answer
}
function isPrime(num) {
  if (num == 1 || num == 0) return false
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i == 0) return false
  }
  return true
}
