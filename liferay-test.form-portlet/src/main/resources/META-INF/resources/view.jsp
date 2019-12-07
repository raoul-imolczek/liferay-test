<%@ include file="/init.jsp" %>

<form name="testform" method="POST" action="${submitFormActionURL}">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Please fill in the form">
			<aui:row>
				<aui:col width="50">
					<aui:input label="Name" name="name" type="text" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Surname" name="surname" type="text" />
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<label for="<portlet:namespace/>birthdate">Birth date</label>
					<liferay-ui:input-date name="birthdate" yearValue="1990" monthValue="0" dayValue="1" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Email" name="email" type="email" />
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="100">
					<c:if test="${captchaInvalid}">
						<clay:alert message="You failed to submit captcha" style="danger" title="Error" />
					</c:if>
					<liferay-captcha:captcha url="${captchaResourceURL}" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit" />
	</aui:button-row>
</form>