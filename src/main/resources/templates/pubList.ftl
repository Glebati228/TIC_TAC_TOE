<#import "style1.ftl" as e>

<@e.page>


    <div class="container">
        <#list publications as publication>
            <div class="row">
            <a href="/public/${publication.getId()}">
                ${publication.getName()} ${publication.getAuthor().getUsername()}
            </a>
            </div>
        </#list>
    </div>
</@e.page>