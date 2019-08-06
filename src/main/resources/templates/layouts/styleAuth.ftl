<#macro auth path isLogin>

<#if isLogin>
    <h4>
        Login form
    </h4>
<#else>
    <h4>
        Registration form
    </h4>
</#if>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-form-label">User Name:</label>
        <input class="form-control" type="text" name="username"/>
            <small class="form-text text-muted">Your brilliant name.</small>
    </div>
    <div class="form-group row">
            <label class="col-form-label">Password:</label>
            <input class="form-control" type="password" name="password"/>
            <small class="form-text text-muted">Your brilliant password.</small>
            <#if !isLogin>
            <input class="form-control" type="password" name="password2"/>
                <small class="form-text text-muted">Confirm password.</small>
            <div class="container row mr-3">
                <label class="col-form-label">Email:</label></div>
                <input class="form-control" type="email" name="email"/>
                <small class="form-text text-muted">Your brilliant email.</small>
            </#if>
            <#if !isLogin>
            <br/>
            <div class="form-group mt-5">
                <div class="g-recaptcha" data-sitekey="6LdmjLEUAAAAAEtxzZmU6oezAZQqqWZjmG6rsRGh"></div>
                <#if captchaError??>
                    <div class="alert alert-danger" role="alert">
                        ${captchaError}
                    </div>
                </#if>
            </div>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="container mt-3">
                <button class="btn btn-primary" type="submit"/><#if isLogin>Sign in<#else>Sign Up</#if></button>
            </div>
    </div>
</form>

</#macro>

<#macro logout>

<div>
    <form action="/logout" method="post">
       <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit"/>Sign out</button>
    </form>
</div>

</#macro>