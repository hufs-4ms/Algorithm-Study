/*
백준 2178번 미로 탐색
*/
const fs = require('fs')
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt'
let input = fs.readFileSync(filePath).toString()
input = input.split('\n')

const [n, m] = input[0].split(' ').map(Number)

const maps = []
for (let i = 1; i <= n; i++) {
  maps.push(input[i].split('').map(Number))
}

function solution(n, m, maps) {
  let visited = Array.from({ length: n }, () =>
    Array.from({ length: m }, () => false)
  )
  visited[0][0] = true
  let que = [[0, 0]]
  let dx = [0, 0, 1, -1]
  let dy = [1, -1, 0, 0]
  while (que.length) {
    const [cury, curx] = que.shift()
    for (let i = 0; i < 4; i++) {
      let nextx = curx + dx[i]
      let nexty = cury + dy[i]

      //out of line
      if (nextx < 0 || nextx > m - 1 || nexty < 0 || nexty > n - 1) continue
      //wall
      if (!maps[nexty][nextx]) continue
      //duplication
      if (visited[nexty][nextx]) continue

      visited[nexty][nextx] = true
      maps[nexty][nextx] = maps[cury][curx] + 1
      que.push([nexty, nextx])
    }
  }
}
solution(n, m, maps)
console.log(maps[n - 1][m - 1])
