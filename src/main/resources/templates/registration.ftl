<#import "layouts/style1.ftl" as c>
<#import "layouts/styleAuth.ftl" as s>
<@c.page>
        <#if message??>
            <div class="alert alert-danger">
                ${message?ifExists}
            </div>
        </#if>

        <#if usernameError??>
            <div class="alert alert-danger">
                ${usernameError}
            </div>
        </#if>

        <#if passwordError??>
            <div class="alert alert-danger">
                ${passwordError}
            </div>
        </#if>

        <#if password2Error??>
            <div class="alert alert-danger">
                ${password2Error}
            </div>
        </#if>

         <#if emailError??>
            <div class="alert alert-danger">
                ${emailError}
            </div>
         </#if>

    <@s.auth "/registration" false/>
</@c.page>