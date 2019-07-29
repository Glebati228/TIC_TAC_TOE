<#import "layouts/style1.ftl" as c>
<@c.page>
    <b>Edit</b>
        <form action="/editMessage" method="post">
        <input type="hidden" name="id" value="${message.getId()}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div>
                <i>Text</i>
                <input type="text" name="text" value="${message.GetText()?ifExists}"/>
            </div>
            <div>
                <i>Tag</i>
                <input type="text" name="tag" value="${message.GetTag()?ifExists}"/>
            </div>
                <button type="submit">Save</button>
         </form>
    <b>Delete</b>
    <form action="/editMessage/deleteMessage" method="post">
         <input type="hidden" name="id" value="${message.getId()}"/>
         <input type="hidden" name="_csrf" value="${_csrf.token}"/>
         <button type="submit">Delete</button>
    </form>
</@c.page>