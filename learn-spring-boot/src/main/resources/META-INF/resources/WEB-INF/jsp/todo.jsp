<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>


<div class="container">
<h1>welcome ${name} </h1>
<hr/>
<h1>Enter Todo Details</h1>
<br>

<form:form method="post" modelAttribute="todo">
<fieldset class="mb-3">
<form:label path="description">Description</form:label>: 
<form:input path="description" type="text" name="description" required="required"/>
<form:errors path="description" cssClass="text-warning"/>
</fieldset>

<fieldset class="mb-3">
<form:label path="targetdate">Target Date</form:label>: 
<form:input path="targetdate" type="text" name="description" required="required"/>
<form:errors path="targetdate" cssClass="text-warning"/>
</fieldset>


<form:input path="id"  type="hidden"  />
<form:input path="done" type="hidden" />
<input type ="submit" class="btn btn-success" onClick="check()"/>
</form:form>
</div>

<%@ include file="common/footer.jspf" %>
<!-- <script>
function check()
{
	
	alert("hello");
	}
</script> -->
<script>
$('#targetdate').datepicker({
    format: 'yyyy-mm-dd'
  
});

</script>


