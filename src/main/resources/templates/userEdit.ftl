<#import "layouts/style1.ftl" as c>
<@c.page>
        <form action="/user" method="post">
            <input type="text" name="username" value="${user.getUsername()}"/>
            <#list roles as role>
            <label><input type="checkbox" name="${role}" ${user.getRoles()?seq_contains(role)?string("checked", "")}/>${role}</label>
            </#list>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="${user.getId()}"/>
            <button type="submit">Save</button>
        </form>
</@c.page>