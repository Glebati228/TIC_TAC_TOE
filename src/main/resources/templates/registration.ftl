<#import "layouts/style1.ftl" as c>
<#import "layouts/styleAuth.ftl" as s>
<@c.page>
    <div class="text-danger">
        ${message?ifExists}
        <br/>${usernameError?ifExists}
        <br/>${passwordError?ifExists}
        <br/>${password2Error?ifExists}
        ${emailError?ifExists}
    </div>
    <@s.auth "/registration" false/>
</@c.page>