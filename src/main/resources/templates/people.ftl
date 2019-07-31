<#import "layouts/style1.ftl" as e>
<@e.page>
    <#list peoples as user>
        <a href="/dialog/${user.getId()}">${user.getUsername()}</a>
    </#list>
</@e.page>