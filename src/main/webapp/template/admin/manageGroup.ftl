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
	<div id="tree">
	</div>
</div>
<script src="/static/libs/orgchart-8.13.34/orgchart.js"></script>
<script>
	var data = ${groupList};
	console.log(data);
	let chart = new OrgChart(document.getElementById("tree"), {
		nodeBinding: {
			field_0: "name",
				field_1: "id"
			},
		nodes: data
	});
	chart.on('click', function (sender, args) {
		// args.node가 클릭된 노드입니다.
		// 해당 노드의 url 속성이 정의되어 있으면 페이지를 해당 URL로 이동합니다.
		if (args.node.url) {
			console.log("test");
			window.location.href = args.node.url;
		}
	});
</script>
</@layout.myLayout>