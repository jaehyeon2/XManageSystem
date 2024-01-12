<#import "/spring.ftl" as spring/>

<!-- Insert Modal -->
<div id="istModal" class="modal fade modal-xl" tabindex="-1" aria-labelledby="userModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="userModalLabel">사용자 등록</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
	    <form name="istForm" id="istFormId" class="form-horizontal" action="/api/admin/user/saveUser" method="post" >
      	  <div class="modal-body">
			<div class="mb-3">
				<div class="row">
				  <div class="col-4">
					<label for="userIdId" class="form-label">사용자 ID</label>
					<input id="userIdId" name="userId" type="text" class="form-control" placeholder="사용자 ID">
				  </div>
				  <div class="col-4">
					<label for="userNameId" class="form-label">사용자 이름</label>
					<input id="userNameId" name="userName" type="text" class="form-control" placeholder="사용자 이름">
				  </div>
				  <div class="col-4">
					<label for="userPwdId" class="form-label">패스워드</label>
					<input id="userPwdId" name="userPwd" type="text" class="form-control" placeholder="패스워드">
				  </div>
				</div>
			</div>
			<div class="mb-3">
				<div class="row">
				  <div class="col-4">
					<label for="userEmailId" class="form-label">메일 주소</label>
					<input id="userEmailId" name="userEmail" type="text" class="form-control" placeholder="메일 주소">
				  </div>
				  <div class="col-4">
					<label for="userNameId" class="form-label">핸드폰 번호</label>
					<input id="userPhoneId" name="userPhone" type="text" class="form-control" placeholder="핸드폰 번호">
				  </div>
				  <div class="col-4">
					<label for="userStatusId" class="form-label">상태</label>
					<select id="userStatusId" name="userStatus" type="text" class="form-select" aria-label="권한 부여">
					  <option selected value="1">일반</option>
					  <option value="2">보류</option>
					  <option value="3">정지</option>
					</select>
				  </div>
				</div>
			</div>
	  	  </div>
	  	  <input type="hidden" id="userIdNoId" name="userIdNo" value="<#if model??>${model.userIdNo?if_exists}</#if>" />
	      <div class="modal-footer">
	        <button id="dltSubmitId" style="visibility:hidden;" type="button" class="btn btn-danger" onclick="return dltSubmit('istFormId');" >삭제</button>
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" >닫기</button>
	        <button type="button" class="btn btn-primary" onclick="return istSubmit('istFormId');" >저장</button>
	      </div>
      </form>
    </div>
  </div>
</div>
