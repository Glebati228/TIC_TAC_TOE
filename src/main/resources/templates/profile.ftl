<#import "layouts/style1.ftl" as c>
<#import "layouts/styleAuth.ftl" as s>

<@c.page>
${message?ifExists}
${username}
        <form method="post">
            <div class="form-group row">
                <label class="col-form-label">Password:</label>
                <input class="form-control" type="password" name="password"/>
                <small class="form-text text-muted">Your new password.</small>
                <div class="container row mr-3">
                    <label class="col-form-label">Email:</label></div>
                    <input class="form-control" type="email" name="email" value="${email!''}"/>
                    <small class="form-text text-muted">Your new email.</small>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="container mt-3">
                    <button class="btn btn-primary" type="submit"/>Save</button>
                </div>
            </div>
        </form>
</@c.page>