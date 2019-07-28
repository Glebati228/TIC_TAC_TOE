<#import "layouts/style1.ftl" as e>
<#import "layouts/styleAuth.ftl" as c>

<@e.page>
        <div>
            Reg Page
        </div>
        ${message?ifExists}
<@c.auth "/registration"/>
</@e.page>
