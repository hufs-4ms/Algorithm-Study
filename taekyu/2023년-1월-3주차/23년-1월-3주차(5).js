/*
프로그래머스 lv1 같은 숫자는 싫어
*/

function solution(arr)
{
    var answer = [];

    arr.forEach(e=>{
        if(answer[answer.length-1]!=e){
          answer.push(e) 
        }
    })

    return answer;
}