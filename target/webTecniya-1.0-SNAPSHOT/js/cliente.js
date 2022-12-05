function eliminar(idCliente) {
    let link= `../../ControllerCliente?idCliente=${idCliente}&btnAccion=Eliminar`;
    console.log(link);
    const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: 'Estas seguro de eliminar el cliente?',
  text: "Tendras que registrarlo otra vez!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: "Si, Eliminar",
  cancelButtonText: 'No, cancelar!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
      window.location.href=link;
   
  } else if (result.dismiss === Swal.DismissReason.cancel) {
    swalWithBootstrapButtons.fire(
       'Cancelado',
        '',
      'error'
    )
  }
})
}

function inicio(){
  Swal.fire({
  position: 'center',
  icon: 'success',
  title: 'BIENVENIDO!!',
  timer: 1500 
})
}

function actualizar() {
    let idCliente = document.getElementById("update").value;
    console.log(idCliente);
    let link= `../../ControllerCliente?idCliente=${idCliente}&btnAccion=Actualizar`;
    console.log(link);
    const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: 'Estas seguro de actualizar el cliente?',
  text: "",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: "Si, Actualizar",
  cancelButtonText: 'No, cancelar!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
      window.location.href=link;
   
  } else if (result.dismiss === Swal.DismissReason.cancel) {
    swalWithBootstrapButtons.fire(
       'Cancelado',
        '',
      'error'
    )
  }
})
}


