<#import "layouts/style1.ftl" as e>
<#import "layouts/styleAuth.ftl" as c>

<@e.page>
   <form action="/del" method="post">
       <div class="form-group row">
           <input type="hidden" name="_csrf" value="${_csrf.token}" />
           <label class="col-form-label">Are you sure want to delete this user?</label>
           <input type="hidden" name="id" value="${user.getId()}"/>
       </div>
       <button class="btn btn-primary" type="submit"/>Delete</button>
   </form>
</@e.page>