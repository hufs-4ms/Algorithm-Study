/*
백준 1260 DFS와 BFS
*/

const fs = require('fs')
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt'
let input = fs.readFileSync(filePath).toString()
input = input.split('\n')

const [n, m, v] = input[0].split(' ').map(Number)

const arr = []
for (let i = 1; i <= m; i++) {
  arr.push(input[i].split(' ').map(Number))
}

function solution(n, m, v, arr) {
  let graph = {}

  for (let i = 1; i <= n; i++) {
    graph[i] = []
  }

  let visited = Array.from({ length: n + 1 }, () => false)

  for (let i of arr) {
    graph[i[0]].push(i[1])
    graph[i[1]].push(i[0])
  }

  for (let i of Object.keys(graph)) {
    graph[i].sort((a, b) => a - b)
  }

  let dfsArr = []
  function dfs(v) {
    if (visited[v]) return
    visited[v] = true
    dfsArr.push(v)
    for (let i = 0; i < graph[v].length; i++) {
      let next = graph[v][i]
      if (!visited[next]) dfs(next)
    }
  }
  dfs(v)
  console.log(dfsArr.join(' '))

  let visited2 = Array.from({ length: n + 1 }, () => false)
  let que = []
  let bfsArr = []
  function bfs(v) {
    que.push(v)

    while (que.length) {
      let cur = que.shift()
      if (visited2[cur]) continue
      bfsArr.push(cur)
      visited2[cur] = true
      for (let i = 0; i < graph[cur].length; i++) {
        let next = graph[cur][i]
        if (!visited2[next]) que.push(next)
      }
    }
  }
  bfs(v)
  console.log(bfsArr.join(' '))
}

solution(n, m, v, arr)
