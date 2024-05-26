function eliminar(matriculavehiculo) {
	swal({
  title: "estas seguro de eliminar?",
  text: "Una vez eliminado, ¡no podrá recuperar este archivo !",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {	
	$.ajax({
		url:"/eliminar/"+matriculavehiculo,
		 success: function(res){
			console.log(res);
		}
	});
    swal("Tu archivo imaginario ha sido eliminado!", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/vehiculos";
	}
	
} );
      
  } else {
    swal("has cancelado la eliminacion del objeto");
  }
});
	
	
}