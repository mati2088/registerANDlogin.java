// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready

});
  async  function iniciarSesion()
  {
    let datos={};
    datos.email= document.getElementById('txtEmail').value ;
    datos.password= document.getElementById('txtPassword').value ;


      const request = await fetch('api/login', {
        method: 'POST',//INSERTAR O CREAR UNA NUEVA ENTIDAD EN LA BASE DE DATOS
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)//pasa los datos necesarios para hacer el login
      });

      const respuesta = await request.text();
      if(respuesta =="ok"){
        window.location.href='usuarios.html';
      }else{
      alert("La informacion es incorrecta, Por favor intentelo nuevamente");
      }


      }
