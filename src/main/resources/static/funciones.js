function eliminar(id) {
	swal({
		title: "Estás seguro?",
		text: "Una vez eliminado, no podrá recuperar el registro!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
		})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/eliminar/" + id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("Atención! Registro eliminado satisfactoriamente!", {
					icon: "success",
				}).then((ok) => {
					if (ok) {
						location.href = "/listar";
					}
				});
			} else {
				swal("El registro no fue eliminado!");
			}
		});
}