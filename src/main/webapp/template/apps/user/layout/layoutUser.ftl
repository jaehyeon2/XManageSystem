<#macro myLayout title="FreeMarker index">
<!DOCTYPE html>
<#include "headerUser.ftl"/>
<body>
<#include "naviUser.ftl"/>

<#nested/>

<#include "tailUser.ftl"/>
<#include "footerUser.ftl"/>

</body>
</html>

</#macro>