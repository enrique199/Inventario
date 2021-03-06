
var imagen ={};
$(document).ready(function(){
 $('#alert').hide();
 document.getElementById ('imagen').addEventListener('change', handleFileSelect, false);

 $('#guardar-btn').on('click', function (){
       var nombre = $('#nombre').val();
       var precio = $('#precio').val();

       var productoDTO = {};
       productoDTO.nombre = nombre;
       productoDTO.precio = precio;
       productoDTO.imagen = {};
       productoDTO.imagen.nombre = imagen.nombre;
       productoDTO.imagen.mimeType = imagen.type;
       productoDTO.imagen.dataBase64 = imagen.base64String;

       $.ajax({
           'type':'POST',
           'url':'/productos/guardar',
           'contentType':'application/json',
           'data':JSON.stringify(productoDTO),
           'dataType':'json',
           'success':function(id){
                 console.log("Producto guardado", id);
                 $('#alert').show(500);
                 setTimeout(function(){
                   $('#alert').hide(500);
                   //window.location.href = "productos/page/productos";
                   }, 2000)
                  },
                  'error':function (err){
                    console.log(err);
                    alert('ocurrio un error al guardar el producto')
                    }
            });
        });
   function handleFileSelect(evt){
   var f = evt.target.files[0];

   imagen.nombre = f.name;

   imagen.type = f.type;
   var reader = new FileReader();
   reader.onload =(function(theFile){
   return function (e){
   var binaryData = e.target.result;
   imagen.base64String = window.btoa(binaryData);
   $('#img-preview').empty();
   $('#img-preview').append('<img width="250px" src="data:'+imagen.type+';base64,'+imagen.base64String+'">')
   };
   })(f);

  reader.readAsBinaryString(f);
  }
});