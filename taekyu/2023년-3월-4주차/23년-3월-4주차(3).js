/*
lv1 크레인 인형뽑기 게임
*/
function solution(board, moves) {
  var answer = 0
  let tmp = []
  moves.forEach((move) => {
    for (let i = 0; i < board.length; i++) {
      if (board[i][move - 1] === 0) {
        continue
      } else {
        tmp.push(board[i][move - 1])
        board[i][move - 1] = 0
        break
      }
    }
    if (tmp.length > 1) {
      if (tmp[tmp.length - 1] === tmp[tmp.length - 2]) {
        tmp.pop()
        tmp.pop()
        answer++
        answer++
      }
    }
  })
  return answer
}
