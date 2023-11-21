$(document).on("click", ".btn-delete-cita", function () {
    let id = $(this).attr("data-id");
    const url = $("#url-delete").val();

    swal({
        title: "¿Estas seguro de eliminar esta cita?",
        text: "¡Una vez eliminado no se podra restaurar!",
        icon: "warning",
        buttons: true,
        dangerMode: true
    })
            .then((willDelete) => {
                if (willDelete) {
                    $.ajax({
                        type: "POST",
                        url: url + id,
                        dataType: "json",
                        success: function (respuesta) {
                            if (!respuesta.error) {
                                swal("La cita fue eliminada correctamente.", {
                                    icon: "success"
                                }).then(() => {
                                    window.location.reload();
                                });
                            }
                        },
                        error: function (e) {
                            swal("Algo salio mal en el servidor!!.", {
                                icon: "info"
                            });
                            console.log("ERROR: ", e);
                        },
                        done: function (e) {
                            console.log("DONE");
                        }
                    });


                }
            });

});