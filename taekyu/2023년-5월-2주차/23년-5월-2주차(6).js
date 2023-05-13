/*
lv2 방문 길이
*/
function solution(dirs) {
  var answer = 1
  let cur = [0, 0]
  let arr = []

  for (let dir of dirs) {
    let [x, y] = cur

    if (dir == 'L') {
      x -= 1
    }
    if (dir == 'R') {
      x += 1
    }
    if (dir == 'U') {
      y += 1
    }
    if (dir == 'D') {
      y -= 1
    }
    if (x < -5 || x > 5 || y < -5 || y > 5) continue

    arr.push('' + cur[0] + cur[1] + x + y)
    arr.push('' + x + y + cur[0] + cur[1])
    cur = [x, y]
  }
  answer = [...new Set(arr)].length / 2
  return answer
}
