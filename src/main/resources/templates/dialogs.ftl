<#import "layouts/style1.ftl" as e>
<@e.page>
   <strong>${user.getUsername()?ifExists}</strong>
   <form action="send" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="text" name="text" placeholder="Enter the message"/>
        <button type="submit">Send</button>
   </form>
</@e.page>