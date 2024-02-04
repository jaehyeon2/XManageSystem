<#import "/layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<div class="p-5 mb-4 bg-body-tertiary rounded-3">
	<div class="container-fluid py-5">
		user
		<#if userList??>
		<table>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>권한</td>
				<td>그룹명</td>
			</tr>
			<#list userList as user>
			<tr>
				<td>${user.userNo}</td>
				<td>${user.userNm}</td>
				<td>${user.userEmail}</td>
				<td>${user.groupNm}</td>
			</tr>
				${user.userNm}
			</#list>
		<table>
		<#else>
			userModel null
		</#if>
	</div>
</div>

</@layout.myLayout>
