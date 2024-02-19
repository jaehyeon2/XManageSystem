<#import "/layout/layout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<div class="p-5 mb-4 bg-body-tertiary rounded-3">
	<a href="/admin/addUser">등록</a>
	<div class="container-fluid py-5">
		<#--<#if groupList??>
		<table>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>level</td>
				<td>편집</td>
				<td>삭제</td>
			</tr>
			<#list groupList as group>
			<tr>
				<td>${group.groupId}</td>
				<td>${group.groupNm}</td>
				<td>level</td>
				<td>편집</td>
				<td>삭제</td>
			</tr>
			</#list>
		<table>
		<#else>
			userModel null
		</#if>-->
	</div>
	<div if="test">
	</div>
</div>
<script src="/static/libs/orgchart-8.13.34/orgchart.js"></script>
<script>
	var groupList = ${groupList};
	var chart = new OrgChart(document.getElementById("test"), {
			nodeBinding:{
				field_0:'name'
			}
		}
	)
</script>
</@layout.myLayout>