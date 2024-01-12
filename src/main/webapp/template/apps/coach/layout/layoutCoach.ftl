<#macro myLayout title="FreeMarker index">
<!DOCTYPE html>
<#include "headerCoach.ftl"/>
<body>
<#include "naviCoach.ftl"/>
<div class="container-fluid">
<div class="row">

<#include "/apps/coach/layout/sideMenu.ftl"/>
  <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" style="padding-top: 20px;">

<#nested/>

  </main>

</div>
</div>
<#include "tailCoach.ftl"/>
<#include "footerCoach.ftl"/>

</body>
</html>

</#macro>