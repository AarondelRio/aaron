$(document).ready(function(){
	//$("table").css("display", "inline-block");
    $('#myTable').DataTable({
    	  "pageLength": 10,
    	  "lengthMenu": [[10, 15 ,20, 50, -1], [10, 15 ,20, 50, "All"]],
    	  "order": [[ 0, "desc" ]],
    	  "language":{
		       "lengthMenu":"Mostrar _MENU_ registros por pagina.",
		       "zeroRecords": "Lo sentimos. No se encontraron registros.",
		             "info": "Mostrando pagina _PAGE_ de _PAGES_",
		             "infoEmpty": "No hay registros aún.",
		             "infoFiltered": "(filtrados de un total de _MAX_ registros)",
		             "search" : "Busqueda",
		             "LoadingRecords": "Cargando ...",
		             "Processing": "Procesando...",
		             "SearchPlaceholder": "Comience a teclear...",
		             "paginate": {
		     "previous": "Anterior",
		     "next": "Siguiente", 
		     }
         }
    } );
    
});