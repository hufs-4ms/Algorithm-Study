/*
백준 2667번 단지번호붙이기
*/

const fs = require('fs')
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt'
let input = fs.readFileSync(filePath).toString()
input = input.split('\n')

const [n] = input[0].split(' ').map(Number)

let maps = []
for (let i = 1; i <= n; i++) {
  maps.push(input[i].split('').map(Number))
}

function solution(n, maps) {
  let visited = Array.from({ length: n }, () =>
    Array.from({ length: n }, () => false)
  )
  let dx = [1, -1, 0, 0]
  let dy = [0, 0, 1, -1]
  let cnt = 0
  let que = []
  let answer = []
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (maps[i][j] == 1) {
        que.push([i, j])
        while (que.length) {
          let [cury, curx] = que.shift()

          for (let i = 0; i < 4; i++) {
            let nextx = curx + dx[i]
            let nexty = cury + dy[i]

            //out of range
            if (nextx < 0 || nexty < 0 || nextx > n - 1 || nexty > n - 1)
              continue
            //find zero
            if (!maps[nexty][nextx]) continue
            // duplication visited
            if (visited[nexty][nextx]) continue

            if (maps[nexty][nextx] == 1) {
              visited[nexty][nextx] = true
              maps[nexty][nextx] = 0
              cnt++
              que.push([nexty, nextx])
            }
          }
        }
        if (cnt == 0) {
          answer.push(1)
        } else {
          answer.push(cnt)
          cnt = 0
        }
      }
    }
  }
  answer.sort((a, b) => a - b)
  console.log(answer.length)
  for (let i of answer) {
    console.log(i)
  }
}

solution(n, maps)
