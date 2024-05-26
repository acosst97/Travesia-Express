function enviar(){
    swal({
    title: "registro exitoso?",
    icon: "success",
    
  })
  
  }
  
  function cancelar(){
    swal("Esta seguro?", {
    dangerMode: true,
    buttons: true,
  });
  }