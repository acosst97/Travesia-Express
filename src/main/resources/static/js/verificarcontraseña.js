/**
 * 
 */
 
 function verificarConcordanciadeContraseña(fieldcomfirmpassword) {
	if (fieldcomfirmpassword.value != $("#clave").val()) {
		fieldcomfirmpassword.setCustomValidity("¡Las contraseñas no coinciden!");
	}  {
		fieldcomfirmpassword.setCustomValidity("");
	}
}

