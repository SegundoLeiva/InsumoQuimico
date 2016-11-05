

<script type="text/javascript">


$(document).ready(function() {
	var password1 = document.getElementById('nuevaPassword');
	var password2 = document.getElementById('confPassword');

	var checkPasswordValidity = function() {
	    if (password1.value != password2.value) {
	        password1.setCustomValidity('Las Contraseñas NO coinciden.');
	    } else {
	        password1.setCustomValidity('');
	    }        
	};

	password1.addEventListener('change', checkPasswordValidity, false);
	password2.addEventListener('change', checkPasswordValidity, false);
});


</script>