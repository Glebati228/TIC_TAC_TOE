<#import "layouts/style1.ftl" as e>
<@e.page>
    <form action="gedit" method="post">
        <input type="hidden" name="id" value="${message.getId()}"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="text" name="text" value="${message.GetText()}"/>
        <input type="text" name="tag" value="${message.GetTag()}"/>
        <button type="submit">Save</button>
    </form>
    <div>
    <form action="gdelete" method="post">
            <input type="hidden" name="id" value="${message.getId()}"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Delete</button>
        </form>
    </div>
</@e.page>