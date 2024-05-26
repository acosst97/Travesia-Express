function enviar(){
  swal({
  title: "Esta seguro de Enviar?",
  text: "Asegurese que el archivo es el correcto",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((willDelete) => {
  if (willDelete) {
    swal("Su archivo ha sido enviado correctamente", {
      icon: "success",
    });
  } else {
    swal("Ha cancelado el envio de su archivo");
  }
});
}

function cancelar(){
  swal("Esta seguro?", {
  dangerMode: true,
  buttons: true,
});
}
