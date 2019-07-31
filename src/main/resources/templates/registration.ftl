<#import "layouts/style1.ftl" as c>
<#import "layouts/styleAuth.ftl" as s>
<@c.page>
    <div class="text-danger">
        ${message?ifExists}
    </div>
    <@s.auth "/registration" false/>
</@c.page>