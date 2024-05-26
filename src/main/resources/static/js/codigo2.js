function enviar(){
    swal({
    title: "Esta seguro de Enviar?",
    text: "asegurese que la informacion es correcta ",
    icon: "warning",
    buttons: true,
    dangerMode: true,
  })
  .then((willDelete) => {
    if (willDelete) {
      swal("Su registro ha sido guardado  correctamente", {
        icon: "success",
      });
    } else {
      swal("Ha cancelado el envio de su registro");
    }
  });
  }
  
  function cancelar(){
    swal("Esta seguro?", {
    dangerMode: true,
    buttons: true,
  });
  }