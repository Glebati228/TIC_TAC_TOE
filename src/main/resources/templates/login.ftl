<#import "layouts/style1.ftl" as e>
<#import "layouts/styleAuth.ftl" as s>

<@e.page>
    <div>Login page</div>
    <@s.auth "/login" />
    <a href="/registration">Go to reg</a>
</@e.page>