/*
lv2 [1차] 뉴스 클러스터링
*/
function solution(str1, str2) {
  //12:30
  var answer = 0
  str1 = str1.replace(/[^a-zA-Z]/g, ' ')
  str2 = str2.replace(/[^a-zA-Z]/g, ' ')
  str1 = str1.split('')
  str2 = str2.split('')
  let arr1 = []
  let arr2 = []
  for (let i = 0; i < str1.length - 1; i++) {
    if (str1[i] !== ' ' && str1[i + 1] !== ' ') {
      arr1.push(str1[i] + str1[i + 1])
    }
  }
  for (let i = 0; i < str2.length - 1; i++) {
    if (str2[i] !== ' ' && str2[i + 1] !== ' ') {
      arr2.push(str2[i] + str2[i + 1])
    }
  }

  arr1 = arr1.map((d) => d.toUpperCase())
  arr2 = arr2.map((d) => d.toUpperCase())
  let len1 = arr1.length
  let len2 = arr2.length

  let arr = [...arr1]
  let q = 0

  for (let i of arr) {
    let a = Math.min(
      arr1.filter((d) => d == i).length,
      arr2.filter((d) => d == i).length
    )
    arr1 = arr1.filter((d) => d != i)
    arr2 = arr2.filter((d) => d != i)
    q += a
  }
  let w = len1 + len2 - q
  if (q == 0 && w == 0) {
    q = 1
    w = 1
  }
  answer = Math.floor((q / w) * 65536)
  return answer
}
