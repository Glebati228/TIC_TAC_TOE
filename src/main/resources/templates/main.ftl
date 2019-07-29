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
        <div>
                        <form method="post">
                            <input type="text" name="text" placeholder="Enter the message" />
                            <input type="text" name="tag" placeholder="tag">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button type="submit">Add</button>
                        </form>
                    </div>
                    <div>Messages</div>
             <div>
                    <form method="post" action="filter">
                        <input type="text" name="filter">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit">Find by tag</button>
                    </form>
             </div>
             <#list messages as message>
             <div>
                 <b>${message.getId()}</b>
                 <span>${message.GetText()}</span>
                 <i>${message.GetTag()}</i>
                 <strong>${message.getAuthorName()}</strong>
             </div>
             <#else>
             No message
             </#list>
</@c.page>

