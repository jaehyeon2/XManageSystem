<#import "/spring.ftl" as spring/>

<script type="text/javascript">

// The title Label
var userModalLabelId = document.getElementById("userModalLabel");
// The Modal
var istModal = document.getElementById("istModal");

var userIdId = document.getElementById("userIdId");
var userNameId = document.getElementById("userNameId");
var userPwdId = document.getElementById("userPwdId");
var userEmailId = document.getElementById("userEmailId");
var userPhoneId = document.getElementById("userPhoneId");
var userStatusId = document.getElementById("userStatusId");

//the delete button in the modal
var dltBtn = document.getElementById("dltSubmitId");

//Be ready to change the modal title, trigger when pressing the close button.
istModal.addEventListener('hidden.bs.modal', event => {
	userModalLabelId.innerHTML = "관리자 등록";
	// Hidden the delete button
	dltBtn.style.visibility = "hidden";

	userIdId.value = "";
	userNameId.value = "";
	userPwdId.value = "";
	userEmailId.value = "";
	userPhoneId.value = "";
	userStatusId.value = "";

	console.log("insert----------");
})

/**
 * Select a data from DB
 */
function sltUser(x, userNo, userId) {

	// Show the delete button
	dltBtn.style.visibility = "visible";

	// Set parameters
	param = JSON.stringify({
		userNo:userNo,
		userId:userId
	});

	// For showing the modal
	var myModal = new bootstrap.Modal(istModal, {});

    // Ajax
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState === XMLHttpRequest.DONE) {

			if (xhttp.status === 200) { 
				var data = JSON.parse(xhttp.response);

				console.log("userName = " + data.userName);

				userIdId.value = data.userId;
				userNameId.value = data.userName;
				userEmailId.value = data.userEmail;
				userPhoneId.value = data.userPhone;
				userStatusId.value = data.userStatus;

				// Show the modal
				myModal.show();
				userModalLabelId.innerHTML = "사용자 수정";
			}

		}
	};
	xhttp.open("POST", "/api/admin/user/sltUserAjax", true);
	xhttp.setRequestHeader('Content-Type', 'application/json');
	xhttp.send(param);
}

/**
 * Insert a new data or Update the data
 */
function istSubmit(formId) {
	/*
	if(!validateForm(formId)) {
		return;
	}
	*/
	var subForm = document.getElementById(formId);
	subForm.submit();
}

/**
 * Insert a new data or Update the data
 */
function dltSubmit(formId) {
	// Confirm to delete a user
	if(!confirm('정말로 삭제하시겠습니까?')) {
		console.log("Answer is no");
		return false;
	}
	console.log("Answer is Yes");

	var subForm = document.getElementById(formId);
	subForm.action = "/api/admin/user/dltUser";
	subForm.submit();
}

</script>

