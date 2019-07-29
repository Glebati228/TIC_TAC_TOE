<#import "layouts/style1.ftl" as c>
<#import "layouts/styleAuth.ftl" as s>
<@c.page>
<div>
    Reg Page
</div>
${message?ifExists}
<@s.auth "/registration"/>
</@c.page>