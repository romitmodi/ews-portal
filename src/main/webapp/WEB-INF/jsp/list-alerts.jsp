<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div id="table1" style="width: 100%; height: 50%; overflow: auto;">
		<table class="table table-striped">
			<caption>New Alerts</caption>
			<thead>
				<tr>
					<th>EWS_ID</th>
					<th>Rundate</th>
					<th>DSID</th>
					<th>JobName</th>
					<th>TestID</th>
					<th>TestCaseDescription</th>
					<th>PriorResult</th>
					<th>MinResult</th>
					<th>Result</th>
					<th>MaxResult</th>
					<th>TestStatus</th>
					<th>Classification</th>
					<th>Measure</th>
					<th>Summary</th>
					<th>DetailComments</th>
					<th>Severity</th>
					<th>RallyDefect</th>
					<th>ServiceNowTix</th>
					<th>Status</th>
					<th>Owner</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${alertDataList}" var="alertData">
					<tr>
						<td>${alertData.ewsID}</td>
						<td><fmt:formatDate value="${alertData.rundate}"
								pattern="dd/MM/yyyy" /></td>
						<td>${alertData.dsId}</td>
						<td>${alertData.jobName}</td>
						<td>${alertData.testID}</td>
						<td>${alertData.testCaseDescription}</td>
						<td>${alertData.priorResult}</td>
						<td>${alertData.minResult}</td>
						<td>${alertData.result}</td>
						<td>${alertData.maxResult}</td>
						<td>${alertData.testStatus}</td>
						<td><input type="text" value="${alertData.classification}"></td>
						<td><input type="text" value="${alertData.measure}"></td>
						<td><input type="text" value="${alertData.summary}"></td>
						<td><input type="text" value="${alertData.detailComments}"></td>
						<td><input type="text" value="${alertData.severity}"></td>
						<td><input type="text" value="${alertData.rallyDefect}"></td>
						<td><input type="text" value="${alertData.serviceNowTix}"></td>
						<td><input type="text" value="${alertData.status}"></td>
						<td><input type="text" value="${alertData.owner}"></td>
						<td><a type="button" class="btn btn-success"
							href="/update-alert?id=${alertData.ewsID}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="table2" style="width: 100%; height: 50%; overflow: auto;">
		<table class="table table-striped">
			<caption>Open Issues</caption>
			<thead>
				<tr>
					<th>JobName</th>
					<th>JobDescription</th>
					<th>Status</th>
					<th>Measure</th>
					<th>Summary</th>
					<th>DetailComments</th>
					<th>Owner</th>
					<th>Resolution_PlanToClose</th>
					<th>TestSteps</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${alertDataListByStatus}" var="alertData">
					<tr>
						<td>${alertData.jobName}</td>
						<td>${alertData.jobDescription}</td>
						<td><input type="text" value="${alertData.status}"></td>
						<td><input type="text" value="${alertData.measure}"></td>
						<td><input type="text" value="${alertData.summary}"></td>
						<td><input type="text" value="${alertData.detailComments}"></td>
						<td><input type="text" value="${alertData.owner}"></td>
						<td><input type="text"
							value="${alertData.resolutionPlanToClose}"></td>
						<td>${alertData.executionStep}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-alert?id=${alertData.ewsID}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="common/footer.jspf"%>
