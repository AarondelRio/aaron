$(document).ready(function(){
	$("table").css("display", "inline-block");
    $('#myTable').DataTable({
    	  "pageLength": 10,
    	  "lengthMenu": [[10, 15 ,20, 50, -1], [10, 15 ,20, 50, "All"]],
    	  "order": [[ 0, "desc" ]]
    } );
    
});