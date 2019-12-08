<%@ include file="/init.jsp" %>

<aui:form name="testform" method="post" action="${submitFormActionURL}">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Please fill in the form">
			<aui:row>
				<aui:col width="50">
					<aui:input label="liferay-test.form-portlet.name" name="name" type="text" required="true">
						<aui:validator name="required" />
					</aui:input>					
				</aui:col>
				<aui:col width="50">
					<aui:input label="liferay-test.form-portlet.surname" name="surname" type="text" required="true">
						<aui:validator name="required" />
					</aui:input>					
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input label="liferay-test.form-portlet.birthdate" name="birthdate" type="text" placeholder="1980-12-31" required="true" helpMessage="YYYY-MM-DD">
						<aui:validator name="required" />
						<aui:validator name="date" />
					</aui:input>
				</aui:col>				
				<aui:col width="50">
					<aui:input label="liferay-test.form-portlet.email" name="email" type="email" required="true">
						<aui:validator name="required" />
						<aui:validator name="email" />
					</aui:input>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="100">
					<c:if test="${captchaInvalid}">
						<clay:alert message="liferay-test.form-portlet.captcha-failed" style="danger" title="Error" />
					</c:if>
					<liferay-captcha:captcha url="${captchaResourceURL}" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit" />
	</aui:button-row>
</aui:form>