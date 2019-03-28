$(document).ready(function(){
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	cal();mask();
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-save').on('click', function(){
		var url = 'grades';
		var dadosIngrediente = $('#form-grade').serialize();
		
		$.post(url, dadosIngrediente)
			.done(function(pagina){
				$('#session-grade').html(pagina)
				aplicarListeners();		
			})
			.fail(function(e){
				alert('Erro ao salvar!');
				console.log(e);
			});
	});
};

function mask(){
	document.getElementById('btn-save').disabled = true; 
	$('#description').mask("00º");
};
	
var typewatch = function(){
	  var timer = 0;
	    return function(callback, ms){
	        clearTimeout (timer);
	        timer = setTimeout(callback, ms);
	    }  ;	

	}();
	
	function cb(obj){   
		var d = new Date(); 
		document.getElementById('description').value += ' Classe '+ d.getFullYear();		
		document.getElementById('btn-save').disabled = false; 
	};
	
	var jData = '[{"fname":"Mark", "lname":"Wood", "company":"Apple"},' +
	  '{"fname":"Steve", "lname":"Jones", "company":"Amazon"},' +
	  '{"fname":"Bill", "lname":"Peterson", "company":"HP"},' +
	  '{"fname":"Peter", "lname":"Jacobs", "company":"Dell"}]';

	var seperator = ',';
	$('#json').html(jData);
	$('#btnConvert').click(function() {
	  ConvertToTable(jData);
	});

	function ConvertToTable(jData) {
	  var arrJSON = typeof jData != 'object' ? JSON.parse(jData) : jData;
	  var $table = $('<table/>');
	  var $headerTr = $('<tr/>');
	  
	  for (var index in arrJSON[0]) {
	    $headerTr.append($('<th/>').html(index));
	  }
	  $table.append($headerTr);
	  for (var i = 0; i < arrJSON.length; i++) {
	   var $tableTr = $('<tr/>');
	    for (var index in arrJSON[i]) {
	      $tableTr.append($('<td/>').html(arrJSON[i][index]));
	    }
	    $table.append($tableTr);
	  }
	  $('body').append($table);
	};

function cal(){
	sum();
    $("#price").on("keydown keyup", function() {
        sum();
    });
}

function sum() { 
    var num1 = document.getElementById('price').value;
    $('#awaitedvalue').val('');        
    
	var result =  parseFloat(num1) * parseInt(10);
    if (!isNaN(result)) {
        document.getElementById('awaitedvalue').value = result+' Mtn';   
   }
};

var clean = function(){
	$('#id').val(ingrediente.id);
	$('#description').val('');
	$('#shortname').val('');
	$('#price').val('');
	$('#year').val('');
};


var aplicarListeners = function(){
	
	$('.btn-edite').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'classss/'+id;
		
		$.get(url)
			.success(function(ingrediente){
				$('#id').val(ingrediente.id);
				$('#description').val(ingrediente.description);
				$('#shortname').val(ingrediente.shortname);
				$('#price').val(ingrediente.price);
				$('#year').val(ingrediente.year);
							});
	});
	
	
	$('.btn-delete').on('click', function(){
		var id = $(this).parents('tr').data('id');
//		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "grades/"+id,
			type: 'DELETE',
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
//				var ingredientes = parseInt( $('#quantidade-ingredientes').text() );
//		    	$('#quantidade-ingredientes').text(ingredientes - 1);
		    			    }
		});
		
	});
}