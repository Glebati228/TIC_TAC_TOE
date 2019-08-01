<#import "layouts/style1.ftl" as c>
<@c.page>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td> ${user.getUsername()}</td>
            <td><#list user.getRoles() as role>${role}</#list></td>
            <td><a href="/user/${user.getId()}">Edit</a>  <a href="/del/${user.getId()}">Delete</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>