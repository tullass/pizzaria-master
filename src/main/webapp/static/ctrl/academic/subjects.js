$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-save').on('click', function(){
		var url = 'subjects';
		var dadosIngrediente = $('#form-subject').serialize();
		
		$.post(url, dadosIngrediente)
			.done(function(pagina){
				$('#session-subject').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			});
	});
}


var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#categoria').val('');
};


var aplicarListeners = function(){
	
	$('.btn-edite').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'subjects/'+id;
		
		$.get(url)
			.success(function(ingrediente){
				$('#id').val(ingrediente.id);
				$('#description').val(ingrediente.description);
							});
	});
	
	
	$('.btn-delete').on('click', function(){
		var id = $(this).parents('tr').data('id');
//		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "subjects/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
//				var ingredientes = parseInt( $('#quantidade-ingredientes').text() );
//		    	$('#quantidade-ingredientes').text(ingredientes - 1);
		    }
		});
		
		
	});
	
}