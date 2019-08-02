<#include "layouts/security.ftl">
<#include "layouts/dates.ftl">
<#import "layouts/style1.ftl" as c>

<@c.page>
<div class="form-row">
                <form class="form-inline" method="post" action="filter">
                            <input class="form-control" type="text" name="filter" placeholder="Find by tag">
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button class="btn btn-primary ml-3" type="submit">Find</button>
                        </form>
                 </div>
                 <a class="btn btn-primary mt-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                    Add Message
                   </a>
        <div class="collapse" id="collapseExample">
                        <form class="form-group" method="post" enctype="multipart/form-data">
                         <input type="hidden" name="_csrf" value="${_csrf.token}" />
                         <input type="hidden" name="time" value="${time}"/>
                            <input class="form-control mt-2" type="text" name="text" placeholder="Enter the message" />
                            <input class="form-control mt-2" type="text" name="tag" placeholder="tag"/>
                            <div class="custom-file mt-2">
                                <input type="file" name="file" class="custom-file-input" id="inputGroupFile01"/>
                                <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                            </div>
                            <button class="btn btn-primary mt-2" type="submit">Add</button>
                        </form>
                    </div>
                    <div class="container row mt-2">
                        Messages
                    </div>
             <#list messages as message>
             <div class="container">
                 <!--<b>${message.getId()}</b>-->
                 <div class="row">
                    <p class="font-weight-light">${message.getAuthorName()}:</p> ${message.GetText()} ${message.GetTag()}    ${message.getDatetime()?ifExists}
                 </div>
                 <#if message.getFilename()??>
                 <div class="row">
                    <img src="/images/${message.getFilename()}"/>
                 </div>
                 </#if>
                 <#if isAdmin>
                    <small class="form-text text-muted"><a href="/editMes/${message.id}">Edit</a></small>
                 </#if>
             </div>
             <#else>
             No message
             </#list>
            <div><a href="/peop">Peoples</a></div>
</@c.page>