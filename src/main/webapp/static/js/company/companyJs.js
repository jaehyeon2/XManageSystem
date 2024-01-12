<script type="text/javascript">

// The title Label
var listModalLabelId = document.getElementById("listModalLabel");
// The Modal
var istModal = document.getElementById("istModal");

var ocdNoId = document.getElementById("ocdNoId");
var ocdNameId = document.getElementById("ocdNameId");
var ocdClientTypeId = document.getElementById("ocdClientTypeId");
var ocdDomainId = document.getElementById("ocdDomainId");
var ocdResourceIdsId = document.getElementById("ocdResourceIdsId");
var ocdWebsiteUriId = document.getElementById("ocdWebsiteUriId");
var ocdRedirectUriId = document.getElementById("ocdRedirectUriId");
var ocdScopeId = document.getElementById("ocdScopeId");
var ocdInformationId = document.getElementById("ocdInformationId");
var ocdClientIdId = document.getElementById("ocdClientIdId");

//the delete button in the modal
var dltBtnId = document.getElementById("dltSubmitId");

//Be ready to change the modal title, trigger when pressing the close button.
istModal.addEventListener('hidden.bs.modal', event => {

	dltBtnId.style.visibility = "hidden";

	ocdNoId.value = "";
	ocdNameId.value = "";
	ocdClientTypeId.value = "";
	ocdDomainId.value = "";
	ocdResourceIdsId.value = "";
	ocdWebsiteUriId.value = "";
	ocdRedirectUriId.value = "";
	ocdScopeId.value = "";
	ocdInformationId.value = "";

	console.log("insert----------");

})

/**
 * Select a data from DB
 */
function sltClient(x, ocdNo, ocdClientId) {

	console.log("ocdClientIdId => " + ocdClientIdId);

	//Show the delete button
	dltBtnId.style.visibility = "visible";
	
	// Set parameters
	param = JSON.stringify({
		ocdNo:ocdNo,
		ocdClientId:ocdClientId
	});

	// For showing the modal
	var myModal = new bootstrap.Modal(istModal, {});

    // Ajax
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState === XMLHttpRequest.DONE) {

			if (xhttp.status === 200) {
				var data = JSON.parse(xhttp.response);

				console.log("oalStatus = " + data.ocdWebsiteUri);

				ocdNoId.value = data.ocdNo;
				ocdNameId.value = data.ocdName;
				ocdClientTypeId.value = data.ocdClientType;
				ocdDomainId.value = data.ocdDomain;
				ocdResourceIdsId.value = data.ocdResourceIds;
				ocdWebsiteUriId.value = data.ocdWebsiteUri;
				ocdRedirectUriId.value = data.ocdRedirectUri;
				ocdScopeId.value = data.ocdScope;
				ocdInformationId.value = data.ocdInformation;
				ocdClientIdId.value = data.ocdClientId;
				
				// Show the modal
				myModal.show();
				listModalLabelId.innerHTML = "크라이언트 정보 수정";
			}

		}
	};
	xhttp.open("POST", "/api/user/client/sltClientAjax", true);
	xhttp.setRequestHeader('Content-Type', 'application/json');
	xhttp.send(param);
}

/**
 * Update the data
 */
function saveSubmit(formId) {
	/*
	if(!validateForm(formId)) {
		return;
	}
	*/
	var subForm = document.getElementById(formId);
	subForm.submit();
}

/**
 * Delete the data
 */
function dltSubmit(formId) {
	// Confirm to delete a list
	if(!confirm('정말로 삭제하시겠습니까?')) {
		console.log("Answer is no");
		return false;
	}
	console.log("Answer is Yes");

	var subForm = document.getElementById(formId);
	subForm.action = "/api/user/client/dltClient";
	subForm.submit();
}
