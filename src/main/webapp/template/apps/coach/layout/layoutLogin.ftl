<#macro myLayout title="FreeMarker index">
<!DOCTYPE html>
<#include "headerCoach.ftl"/>
<body>
<#include "naviCoach.ftl"/>

<#nested/>

<#include "tailCoach.ftl"/>
<#include "footerCoach.ftl"/>

</body>
</html>

</#macro>