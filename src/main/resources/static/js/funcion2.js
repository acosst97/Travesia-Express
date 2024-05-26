function eliminar(idventa) {
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
		url:"/eliminarventa/"+idventa,
		 success: function(res){
			console.log(res);
		}
	});
    swal("Tu archivo imaginario ha sido eliminado!", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/listarventas";
	}
	
} );
      
  } else {
    swal("has cancelado la eliminacion del objeto");
  }
});
	
	
}