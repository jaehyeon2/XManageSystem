<#import "/layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<div class="p-5 mb-4 bg-body-tertiary rounded-3">
	<a href="/admin/addUser">등록</a>
	<div class="container-fluid py-5">
		<form action="/admin/addUser" method="POST">
			<input type="text" name="userNm" id="userName" placeholder="이름">
			<input type="email" name="userEmail" id="userEmail" placeholder="이메일">
			<input type="password" name="userPwd" id="userPwd" placeholder="패스워드">
			<input type="text" name="userPhone" id="userPhone" placeholder="연락처">
			
			<button type="submit" value="등록"></button>
		</form>
	</div>
</div>

</@layout.myLayout>