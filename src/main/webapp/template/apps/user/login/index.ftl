<#import "/api/user/layout/layoutUser.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>

<br/>
<#include "/apps/coach/errors/errorMessage.ftl"/>

<form class="form-signin" style="width: 70%;padding-left: 30%;" role="form" action="/tb/coach/login/auth" name="sform" id="sform" method="POST">
    <h1 class="h3 mb-3 fw-normal">API 사용자 로그인</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" name="userId" placeholder="id">
      <label for="floatingInput">아이디 입력</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" name="userPwd" value="" placeholder="Password">
      <label for="floatingPassword">패스워드 입력</label>
    </div>
    <br/>
    <button type="submit" class="btn btn-info" style="color: white; font-weight: bold;">로그인</button>
</form>

</@layout.myLayout>