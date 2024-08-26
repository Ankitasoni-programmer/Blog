<%@page import="java.util.List"%>
<%@page import="com.entities.Post"%>
<%@page import="com.dao.Postdao"%>
<%@page import="com.helper.Connectionprovider"%>


<div class="row">
<%
Postdao d =new Postdao(Connectionprovider.getConnection());
List<Post>posts =d.getAllPosts();
for(Post p:posts)
{
%>







<div class="col-md-6">
    
    <div class="card">
        
        
        
        <div class="card-body">
            <img class="card-img-top" src="blogpic/"<%=p.getPpic()%>alt="Card image cap">
            
            <b><%=p.getPtitle()%></b>
            <p><%=p.getPcontent()%></p>
            <pre><%=p.getPcode()%></pre>
            
        </div>
    </div>
    
    
    
</div>
<%
}


%>
</div>