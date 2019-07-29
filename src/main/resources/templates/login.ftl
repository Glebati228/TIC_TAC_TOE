
<#import "layouts/style1.ftl" as c>
<#import "layouts/styleAuth.ftl" as s>

<@c.page>
           <div>Login page</div>
           <@s.auth "/login"/>
               <a href="/registration">Go to reg</a>
</@c.page>