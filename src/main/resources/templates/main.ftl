<#import "layouts/style1.ftl" as e>
<#import "layouts/styleAuth.ftl" as s>
<@e.page>

        <@s.logout/>
        <div>
            <form method="post">
                <input type="text" name="text" placeholder="Enter the message" />
                <input type="text" name="tag" placeholder="tag">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Add</button>
            </form>
        </div>
        <div>Messages</div>
        <form method="post" action="filter">
            <input type="text" name="filter">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Find by tag</button>
        </form>
        <#list messages as message>
            <div>
                <b>${message?ifExists}</b>
                <span>${item.text?ifExists}</span>
                <i>${item.tag?ifExists}</i>
                <b>${item.AuthorName?ifExists}</b>
            </div>
            <#else>
            No Messages
        </#list>
</@e.page>