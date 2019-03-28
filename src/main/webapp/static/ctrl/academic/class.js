$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	sum();
   
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-save').on('click', function(){
		var url = 'classss';
		var dadosIngrediente = $('#form-class').serialize();
		
		$.post(url, dadosIngrediente)
			.done(function(pagina){
				$('#session-classs').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(e){
				alert('Erro ao salvar!');
				console.log(e);
			});
	});



};

var clean = function(){
	$('#id').val(ingrediente.id);
	$('#shortname').val('');
	$('#shortname').val('');
	$('#classroom').val('');
	$('#year').val('');
};


var aplicarListeners = function(){
	
	$('.btn-edite').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'classss/'+id;
		
		$.get(url)
			.success(function(ingrediente){
				$('#id').val(ingrediente.id);
				$('#shortname').val(ingrediente.description);
				$('#shortname').val(ingrediente.shortname);
				$('#classroom').val(ingrediente.classroom);
				$('#year').val(ingrediente.year);
							});
	});
	
	
	$('.btn-delete').on('click', function(){
		var id = $(this).parents('tr').data('id');
//		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "classss/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
//				var ingredientes = parseInt( $('#quantidade-ingredientes').text() );
//		    	$('#quantidade-ingredientes').text(ingredientes - 1);
		    	
		    }
		});
		
	});
	
}