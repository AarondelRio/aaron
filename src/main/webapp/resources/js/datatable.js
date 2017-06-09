$(document).ready(function(){
    $('#myTable').DataTable({
    	  "pageLength": 20,
    	  "lengthMenu": [[10, 20, 50, -1], [10, 20, 50, "All"]]
    } );
});