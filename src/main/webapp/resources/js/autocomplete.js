$(function() {
  console.debug('buscador.js ready');
  
  $( "#buscadorCurso" ).autocomplete({
      source: function( request, response ) {
        $.ajax( {
          url: "/formacion/api/curso/?filtro=" + $("#autocomplete").val(),
          dataType: "json",
          success: function( data ) {
        	var aString = [];
            $.each(data, function(index, rec){
            	aString.push({"label":rec.nombre, "value":rec.id});
        	});
            response( aString );
          }
        } );
      },
      minLength: 3,
      select: function( event, ui ) {
        console.debug( "Selected: " + ui.item.value + " id " + ui.item.label );
        var url = "view/"+ ui.item.value;
        window.location.href = url;
      }
    } );
  
});