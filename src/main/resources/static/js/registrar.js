// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready

});
  async  function registrarUsuarios()
  {
    let datos={};
    datos.nombre= document.getElementById('txtNombre').value ;
    datos.apellido= document.getElementById('txtApellido').value ;
    datos.email= document.getElementById('txtEmail').value ;
    datos.password= document.getElementById('txtPassword').value ;

    let repetirPassword=document.getElementById('txtRepetirPassword').value ;

    if(repetirPassword != datos.password){

        alert("Las contraseñas no coinciden!a");
        return;
    }

      const request = await fetch('api/usuarios', {
        method: 'POST',//INSERTAR O CREAR UNA NUEVA ENTIDAD EN LA BASE DE DATOS
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });

        let dirigir=prompt("La cuenta fue creada con exito! Ingrese 'ok' para iniciar sesion!")

        if(dirigir=="ok"){
          window.location.href='index.html';
        }

      }
