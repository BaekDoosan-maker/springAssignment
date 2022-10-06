 [![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https://github.com/BaekDoosan-maker/Doosan.git)](https://hits.seeyoufarm.com)      
<h1>요구사항</h1>
1. 전체 게시글 목록 조회 API <br>
- 제목, 작성자명, 작성 날짜를 조회하기  <br>
- 작성 날짜 기준으로 내림차순 정렬하기   <br>
<br>
2. 게시글 작성 API<br>
- 제목, 작성자명, 비밀번호, 작성 내용을 입력하기  <br>
<br>
3. 게시글 조회 API<br>
- 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기   <br>
 (검색 기능이 아닙니다. 간단한 게시글 조회만 구현)  <br>
 <br>
4. 게시글 비밀번호 확인 API <br>
- 비밀번호를 입력 받아 해당 게시글의 비밀번호와 일치여부 판단하기  <br>
<br>
5. 게시글 수정 API<br>
- 제목, 작성자명, 비밀번호, 작성 내용을 수정되게 하기  <br>
<br>
6. 게시글 삭제 API<br>
- 글이 삭제되게 하기  <br>
<br>
<br>
 <h1>API 명세서</h1> 기술매니저님의 피드백으로 Bulletinboardposts는 지나치게 이름이 길어서 이름을 board로 변경하였습니다.

|Function|Method|url|request|respond|
|---|---|---|---|---|
|전체<br> 게시글<br> 목록조회|*GET*|/api/boards||[{ "createAt": "날짜/시간", "modifiedAt": "날짜/시간", "id": 아이디(숫자), "title": "제목", "username": "유저이름", "password": "비밀번호(숫자)", "contents": "글내용"},{ "createAt": "날짜/시간", "modifiedAt": "날짜/시간", "id": 아이디(숫자), "title": "제목", "username": "유저이름", "password": "비밀번호(숫자)", "contents": "글내용"} ]|
|게시글<br>  작성|*POST*|/api/boards |{ "title" : "글제목", "username" : "유저이름","password" : "비밀번호(숫자)", "contents" : "글내용"}  |{"title" : "제목", "username" : "유저이름", "password" : "비밀번호(숫자)", "contents" : "글내용" } |
|게시글<br>  조회|*GET*|/api/boards{id}||{ "createAt": "날짜/시간", "modifiedAt": "날짜/시간", "id": 아이디(숫자), "title": "제목", "username": "유저이름", "password": "비밀번호(숫자)", "contents": "글내용"}|
|게시글<br>  비밀번호<br>  확인|*POST*|/api/boards{id}|password : 숫자 password : 숫자|false|
|게시글 수정|*PUT*|/api/boards{id}|{"title": "제목", "username": "유저이름", "password": "비밀번호", "contents": "내용"}|수정 완료 {"createAt": "날짜/시간", "modifiedAt": "날짜/시간", "id": 아이디(숫자), "title": "제목", "username": "유저이름", "password": "비밀번호(숫자)", "contents": "내용"}|
|게시글 삭제|*DELETE*|/api/boards{id}||삭제 완료| <br>
 <br> 
 
 <h1>3계층 설계하기 <h1>
1. Controller <br>
<br>BoardController

<br>2. Service <br>
BoardService
<br>
<br>3.Repository<br>
Board : 게시글 <br>
<br>BoardRepository : 게시글 조회, 저장 <br>
<br>BoardRequestDto : 게시글 입력하기 <br>
<br>BoardEditRequestDto : 게시글 수정하기  <br>
<br>BoardCheckRequestDto : 비밀번호 확인하기 <br>
<br>BoardDeleteRequestDto : 게시글 삭제하기 <br>


 다이어그램<br><br>
![image](https://user-images.githubusercontent.com/57098232/194226107-f91b2d76-8c53-4883-b0a0-aaf3dda19940.png)
