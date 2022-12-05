function eliminar(idCita) {
    let link= `../../ControllerCita?idCita=${idCita}&btnAccion=Eliminar`;
    console.log(link);
    const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: 'Estas seguro de eliminar la cita?',
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