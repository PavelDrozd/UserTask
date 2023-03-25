$(function() {
	const $createBtn = $("button.create");
	$createBtn.on("click", sendData);

	function sendData(e) {
		e.preventDefault();
		const firstName = $("#input-firstname").val();
		const lastName = $("#input-lastname").val();
		const patronymic = $("#input-patronymic").val();
		const email = $("#input-email").val();
		const role = processRadio().id;
		const user = {firstName, lastName, patronymic, email, role};
		$.ajax({
			type: "POST",
			url: "/api/users/register",
			data: JSON.stringify(user),
			success: processCreated,
			error: processError,
			dataType: "json",
			contentType: "application/json"
		});
	}


    function processRadio() {
		const rad = document.getElementsByName('role');
	    for (var i=0;i < rad.length; i++) {
	        if (rad[i].checked) {
                return rad[i];
            }
        }
    }
	function processCreated(data, status, $XHR) {
		$(".error").remove();
		if ($XHR.status === 201) {
			const uri = $XHR.getResponseHeader("Location");
			window.location.href = uri;
		} else {
			alert("Couldn't create user. Server error");
		}
	}

	function processError(response) {
    		$(".error").remove();
    		if (response.status === 422) {
    			const validationError = response.responseJSON;
    			for (const field in validationError.messages) {
    				validationError.messages[field].forEach(msg => {
    					$("form").prepend($(`<div class="error">${field}: ${msg}</div>`));
    				})
    			}
    		}
    }
});
