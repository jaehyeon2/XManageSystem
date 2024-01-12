<#import "/spring.ftl" as spring/>

<!-- Insert Modal -->
<div id="istModal" class="modal fade modal-xl" tabindex="-1" aria-labelledby="listModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="listModalLabel">Client APPS 정보 등록</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
	  <form name="istForm" id="istFormId" class="form-horizontal" action="/api/user/client/saveClient" method="post" >
      <div class="modal-body">
		<div class="row">
		  <div class="col-4">
			<label for="ocdNameId">클라이언트 이름</label>
			<input id="ocdNameId" name="ocdName" type="text" class="form-control" placeholder="채용 인트라넷">
		  </div>
		  <div class="col-4">
			<label for="ocdDomainId">클라이언트 도메인</label>
			<input id="ocdDomainId" name="ocdDomain" type="text" class="form-control" placeholder="bschr.com">
		  </div>
		  <div class="col-4">
		  	<label for="ocdResourceIdsId">사용할 API 선택</label>
			<select id="ocdResourceIdsId" name="ocdResourceIds" type="text" class="form-select" aria-label="사용할 API">
			  <option selected value="0">API 선택</option>
				<#if model.oauthApiListList??>
		    <#if model.oauthApiListList?has_content>
		        <#list model.oauthApiListList as oauthApiListList>
		        <option value="${oauthApiListList.oalNo?if_exists}">${oauthApiListList.oalTitle?if_exists}</option>
		        </#list>
				</#if>
				</#if>
			</select>
		  </div>
		</div>
		<div class="row">
		  <div class="col-4">
			<label for="ocdWebsiteUriId">웹 사이트 주소</label>
			<input id="ocdWebsiteUriId" name="ocdWebsiteUri" type="text" class="form-control" placeholder="https://apt.bschr.com/test">
		  </div>
		  <div class="col-4">
			<label for="ocdRedirectUriId">리다이렉트 URL</label>
			<input id="ocdRedirectUriId" name="ocdRedirectUri" type="text" class="form-control" placeholder="https://api.bschr.com/api/tryout/result">
		  </div>
		  <div class="col-4">
		  <label for="ocdScopeId">클라이언트 타입</label>
			<select id="ocdClientTypeId" name="ocdClientType" type="text" class="form-select" aria-label="타입선택">
			  <option selected value="0">클라이언트 타입선택</option>
			  <option value="web">웹 애플리케이션</option>
			  <option value="app">앱 애플리케이션</option>
			  <option value="api">API 애플리케이션</option>
			  <option value="etc">기타 애플리케이션</option>
			</select>
		  </div>
		</div>
		<div class="row">
		  <div class="col-8">
			<label for="ocdInformationId">설명</label>
			<textarea id="ocdInformationId" name="ocdInformation" class="form-control" rows="7"></textarea>
		  </div>
		  <div class="col-4">
		  	<label for="ocdInformationId">스코프 선택</label>
			<select id="ocdScopeId" class="form-control" name="ocdScope" multiple size="7">
			  <option selected value="result">결과</option>
			  <option value="else">그밖의</option>
			</select>
		  </div>
		</div>
  	  </div>
  	  <input type="hidden" id="ocdNoId" name="ocdNo" value="" />
  	  <input type="hidden" id="ocdClientIdId" name="ocdClientId" value="" />
      <div class="modal-footer">
        <button type="button" id="dltSubmitId" class="btn btn-danger" style="visibility:hidden;" onclick="return dltSubmit('istFormId');" >삭제</button>
        <button type="button" class="btn btn-primary" onclick="return saveSubmit('istFormId');" >저장</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" >닫기</button>
        <!-- <button type="button" class="btn btn-danger" onclick="return alert('작업중');" >승인요청</button> -->
      </div>
      </form>
    </div>
  </div>
</div>
