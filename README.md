Curl

webFlux 단건 요청
https://8f7e-59-5-180-62.ngrok-free.app/api/flux/

webFlux 다건 요청
https://8f7e-59-5-180-62.ngrok-free.app/api/flux/fluxstream

게시판 생성 (post)
Json 예시
{
    "boardTitle" : “제목입니다”,
    "boardWriter" : "이푸딩",
    "boardContents" : “내용입니다.”
}
https://8f7e-59-5-180-62.ngrok-free.app/api/boards/save

게시글 전체 조회 (GET)
https://8f7e-59-5-180-62.ngrok-free.app/api/boards

해당 id 게시글 조회 (GET)
https://8f7e-59-5-180-62.ngrok-free.app/api/boards/id값

게시글 수정 (PUT)
https://8f7e-59-5-180-62.ngrok-free.app/api/boards/id값

URL로 게시판 수정
https://8f7e-59-5-180-62.ngrok-free.app/api/boards/id값/제목/내용

게시글 삭제 (DELETE)
https://8f7e-59-5-180-62.ngrok-free.app/api/boards/id값
