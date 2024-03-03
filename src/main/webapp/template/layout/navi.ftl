<#-- <@spring.message "system.config.environment"/>-->
<br/>

<nav class="navbar navbar-expand-lg bg-body-tertiary" style="background-color: #e3f2fd;">
<div class="container-fluid">
	<ul>
		<li>
			<a href="/admin">admin</a>
		</li>
		<li>
			<a href="/user">user</a>
		</li>
		
		<li>
			<a href="/board">board</a>
		</li>
		<#if user.userNm??>
			${user.userNm}님
		<#else>
			<li>
				<a href="/login">login</a>
			</li>
		</#if>
	</ul>
	
</div>
</nav>