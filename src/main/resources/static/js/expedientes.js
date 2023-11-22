$(document).on("click", ".btn-delete-expediente", function () {
    let id = $(this).attr("data-id");
    const url = $("#url-delete").val();
    
    console.log({id, url})

    swal({
        title: "¿Estas seguro de eliminar este expediente?",
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
                                swal("El expediente fue eliminado correctamente.", {
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