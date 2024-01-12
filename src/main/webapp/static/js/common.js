function isEmpty(str) {
    return (!str || 0 === str.length);
}

function validateField(inputTag, tagName) {
	var isError = true;

	if(inputTag.length < 1) {
		alert("적어도 하나의 필드에 입력을 하셔야 합니다.");
		return false;
	}

	for (i=0; i < inputTag.length; i++) {

		if(inputTag[i].name == tagName) {
			console.log("===> " + inputTag[i].name);
			continue;
		}

	    if (isEmpty(inputTag[i].value)) {
	    	// Only focus for the first tag field
	    	if(isError) {
	    		console.log("tag name in errors. name=" + inputTag[i].name);
	    		inputTag[i].focus();
	    		inputTag[i].scrollIntoView();
	    	}
	    	inputTag[i].style.border = "1px solid red";
	        isError = false;
	    } else {
	    	inputTag[i].style.border = "";
	    }
	}

	return isError;
}

function validateForm(formId) {
	var table = document.getElementById(formId);

	var inputTag = table.getElementsByTagName("input");
	// noNo is excepted
	if(!validateField(inputTag, "noNo")) {
		return false;
	}
	//var textareaTag = table.getElementsByTagName("textarea");
	//if(!validateField(textareaTag, "")) {
	//	return false;
	//}
	return true;
}

function isAllNumber(obj) {
	
	var numbers = /^[-+]?[0-9]+$/;

	if(obj.value.match(numbers)) {
		console.log("this is a number");
		return true;
	} else {
		console.log("error");
		return false;
	}
}

/**
 * Check email format
 * 
 * @param str
 * @returns
 */
function checkEmail(str) {
     var regEmail = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

     if(!regEmail.test(str)) {
    	 console.log("checkEmail false ");
         return false;
     } else {
    	 console.log("checkEmail true ");
         return true;
     }
}

