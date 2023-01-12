
   <%@ include file="common/header.jspf" %> 
   <%@ include file="common/navigation.jspf" %>
   
    <div class="container">
        <h1>welcome ${name}</h1>
        <hr></hr>
        <div><strong>Your Todos are</strong> </div>
        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>username</th>
                    <th>description</th>
                    <th>targetdate</th>     
                    <!-- <th>targettime</th>  -->          
                    <th>done</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
                <tbody>
                     <c:forEach items="${todos}" var="todo">
                         <tr>
                             <td>${todo.id}</td>
                             <td>${todo.username}</td>
                             <td>${todo.description}</td>
                             <td>${todo.targetdate}</td>
                             <%-- <td>${todo.targettime}</td> --%>
                             <td>${todo.done}</td>
                             <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                             <td><a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
                         </tr>
                     </c:forEach>
                </tbody>
        </table>
        <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        
       <%@ include file="common/footer.jspf" %>