
<#import "layouts/style1.ftl" as c>
<#import "layouts/styleAuth.ftl" as s>

<@c.page>
           <@s.auth "/login" true/>
               <a href="/registration">Go to reg</a>
</@c.page>