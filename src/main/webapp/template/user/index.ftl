<#import "/layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<div class="p-5 mb-4 bg-body-tertiary rounded-3">
	<div class="container-fluid py-5">
		user
		<#if userList??>
			<#list userList as user>
				${user.userNm}
			</#list>
		<#else>
			userModel null
		</#if>
	</div>
</div>

</@layout.myLayout>
