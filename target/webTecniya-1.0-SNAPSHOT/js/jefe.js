function eliminar(idUsuario) {
    let link= `../../ControllerUsuario?idUsuario=${idUsuario}&btnAccion=Eliminar`;
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



function actualizar() {
    let idUsuario = document.getElementById("update").value;
    console.log(idUsuario);
    let link= `../../ControllerUsuario?idUsuario=${idUsuario}&btnAccion=Actualizar`;
    console.log(link);
    const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: 'Estas seguro de eliminar el Usuario?',
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
      'Cancelled',
      'Your imaginary file is safe :)',
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
  showConfirmButton: false,
  timer: 1500 
})}





