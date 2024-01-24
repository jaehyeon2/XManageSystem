<#import "/layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

login
<div>
	<form action="/login/auth" method="POST">
		ID: <input type="email" id="userEmail" name="userEmail">
		PW: <input type="password" id="userPwd" name="userPwd">
		<input type="submit" value="login">
	</form>
</div>

</@layout.myLayout>
