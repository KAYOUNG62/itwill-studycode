/**
 * reply.js
 * 댓글 관련 Ajax 기능 구현
 * /post/detail.html에 포함됨.
 */

// 람다표현식 : function(event){} -> () => {} 대체 가능
window.addEventListener('DOMContentLoaded', () => {
    // HTML의 Document Object 들이 모두 로딩이 끝난 후에 코드들이 실행될 수 있도록 하기 위해서.
    readAllReplies(); // 포스트 상세 페이지가 로딩된 후 댓글 목록 화면 출력

    // btnReplyRegister 버튼을 찾고 이벤트 리스너를 등록 
    const btnReplyRegister = document.querySelector('#btnReplyRegister');
    btnReplyRegister.addEventListener('click', registerNewReply);

    // 댓글 작성 함수
    function registerNewReply() {
        // alert('댓글 등록');
        // 포스트 글 번호를 찾음.
        const postId = document.querySelector('#id').value;

        // 댓글 작성자 아이디
        const writer = document.querySelector('#writer').value;

        // 댓글 내용
        const replyText = document.querySelector('#replyText').value;

        // 댓글 작성자와 내용은 비어있으면 안됨
        if (writer == '' || replyText == '') {
            alert('내용을 입력하세요')
            return; // 메서드 종료
        }

        // 댓글 등록 Ajax POST 요청을 보낼 때 서버로 보내는 데이터 작성
        // 자바스크립트에서의 {}은 오브젝트를 의미 배열은 []으로 표시 
        const data = {
            postId: postId, // 댓글이 달릴 포스트 번호
            replyText: replyText, // 댓글 내용
            writer: writer // 댓글 작성자
        };

        // Axios 라이버리를 사용해서 Ajax POST 요청을 보냄. 
        axios.post('/api/reply', data)
            .then(response => {
                console.log(response);
                alert('#' + response.data + '댓글 작성 완료');
                clearInputs(); // 댓글 작성자와 댓글 내용에 작성된 문자열을 삭제
                readAllReplies(); // 댓글 목록을 다시 요청, 갱신
            }) // 성공응답(response)이 도착했을때 실행할 콜백
            .catch(error => {
                console.log(error);
            }); // 응답이 실패했을때 실행할 콜백
    }

    function clearInputs() {
        document.querySelector('#writer').value = '';
        document.querySelector('#replyText').value = '';
    }

    function readAllReplies() {
        const postId = document.querySelector('#id').value; // 댓글이 달려있는 글 번호
        axios.get('/api/reply/all/' + postId)
            .then(response => { updateReplyList(response.data) })
            .catch(err => { console.log(err) });
    }

    function updateReplyList(data) {
        // 댓글들의 배열(data)을 HTML 영역에 보일수 있도록 HTML 코드 작성
        const divReplies = document.querySelector('#replies');

        let str = ''; // div 안에 들어갈 HTML 코드
        for (let r of data) {
            str += '<div class="card my-2">'
                + '<div class="card-header">'
                + '<h5>' + r.writer + '</h5>'
                + '</div>'
                + '<div class="card-body">'
                + '<p>' + r.replyText + '</p>'
                + '<p> 작성시간: ' + r.createdTime + '</p>'
                + '<p> 수정시간: ' + r.modifiedTime + '</p>'
                + '</div>'
                + '<div class="card-footer">'
                + `<button type="button" class="btnModifies btn btn-outline-primary" data-rid="${r.replyId}">수정</button>`
                + '</div>'
                + '</div>'
        }
        divReplies.innerHTML = str;

        // 수정 버튼들이 HTML 요소로 만들어진 이후에, 이벤트 리스너를 등록.
        const buttons = document.querySelectorAll('.btnModifies');
        buttons.forEach(btn => {
            btn.addEventListener('click', getReply);
        });
    }

    function getReply(event) {
        // console.log(event.target); -> 이벤트가 발생한 타켓 (버튼)
        // 클릭된 버튼의 data-rid 속성값을 읽음.
        const rid = event.target.getAttribute('data-rid');
        
        // 해당 댓글 아이디의 댓글 객체를 Ajax GET 방식으로 요청
        axios.get('/api/reply/' + rid)
        .then(response =>{ showModal(response.data) })
        .catch(err => {console.log(err)});
    
    }
    const divModal = document.querySelector('#replyModal');
    const replyModal = new bootstrap.Modal(divModal); // 부트스트랩 Modal 객체 생성
    const modalReplyId = document.querySelector('#modalReplyId');
    const modalReplyText = document.querySelector('#modalReplyText');
    const modalBtnDelete = document.querySelector('#modalBtnDelete');
    const modalBtnUpdate = document.querySelector('#modalBtnUpdate');
    
    function showModal(reply) {
        // Modal 댓글 아이디/내용 채우기
        modalReplyId.value = reply.replyId;
        modalReplyText.value = reply.replyText;
        
        replyModal.show(); // 모달을 화면에 보여주기
    }
    
    modalBtnDelete.addEventListener('click', deleteReply)
    modalBtnUpdate.addEventListener('click', updateReply)
    
    function deleteReply(event){
        const replyId = modalReplyId.value; // 삭제할 댓글 아이디
        const result = confirm('정말 삭제하시겠습니까?')
        if(result) {
            axios
            .delete('/api/reply/' + replyId) // Ajax DELETE 요청 전송
            .then(response =>{ 
                alert(`#${response.data} 댓글 삭제 완료`);
                readAllReplies(); // 댓글 목록 갱신
            }) // 성공(HTTP 200 ok) 응답
            .catch( err =>{console.log(err)} ) // 실패 응답(HTTP 40x, 50x, ... )
            .then(function(){
                // 성공 응답 처리 또는 실패 응답처리가 끝났을때 무조건 실행
                replyModal.hide(); // 모달 닫기
            })
        }
    }
    
    
    function updateReply(event){
        const replyId = modalReplyId.value; // 수정할 댓글 아이디
        const replyText = modalReplyText.value; // 수정할 댓글 내용
        
        if(replyText == '') {
            alert('댓글 내용을 입력하세요');
            return;
        }
        
        const result = confirm('수정하시겠습니까?') 
        if(result) {
            const data = {replyText: replyText}; // Ajax 요청으로 보낼 데이터 객체.
            axios
            .put('/api/reply/' +replyId, data) // Ajax PUT 요청을 전송
            .then( response => {
                alert(`#${response.data} 댓글 수정 성공`)
                readAllReplies(); // 댓글 목록 갱신
            } ) // 성공응답
            .catch( err => {console.log(err)} ) // 실패응답
            .then(function(){ 
                replyModal.hide();
            }); 
        }
    }
});

// 404 err : URL mapping
// 405 err : URL ok, method x
