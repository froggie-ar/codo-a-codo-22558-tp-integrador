// debugger;

// JavaScript for disabling form submissions if there are invalid fields
(() => {

	'use strict'
	
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')
    
    // Loop over them and prevent submission
    Array.from(forms).forEach (form => {

      form.addEventListener ('submit', event => {
        
        // console.log('en callback de submit. ', event);

        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        };
  
        form.classList.add('was-validated');

      }, false);

    });
  })();


const botonVolver = document.querySelector("#agregar-persona-boton-volver");

botonVolver.addEventListener('click', volver);
