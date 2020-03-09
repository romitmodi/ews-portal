<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" commandName="alertData">
		<form:hidden path="rundate" />
		<fieldset class="form-group">
			<form:label path="jobName">Job Name</form:label>
			<form:input path="jobName" type="text" class="form-control" />
			<form:errors path="jobName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="jobDescription">Job Description</form:label>
			<form:input path="jobDescription" type="text" class="form-control"
				disabled="true" />
			<form:errors path="jobDescription" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="status">Status</form:label>
			<form:input path="status" type="text" class="form-control" />
			<form:errors path="status" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="measure">Measure</form:label>
			<form:input path="measure" type="text" class="form-control" />
			<form:errors path="maxResult" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="summary">Summary</form:label>
			<form:input path="summary" type="text" class="form-control" />
			<form:errors path="summary" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="detailComments">Detail Comments</form:label>
			<form:input path="detailComments" type="text" class="form-control" />
			<form:errors path="detailComments" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="owner">Owner</form:label>
			<form:input path="owner" type="text" class="form-control" />
			<form:errors path="owner" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="resolutionPlanToClose">Resolution Plan To Close</form:label>
			<form:input path="resolutionPlanToClose" type="text"
				class="form-control" />
			<form:errors path="resolutionPlanToClose" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="executionStep">Execution Step</form:label>
			<form:input path="executionStep" type="text" class="form-control"
				disabled="true" />
			<form:errors path="executionStep" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Update</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>