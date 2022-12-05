const form = document.getElementById('user-form');
const submitButton = document.getElementById('submit-btn');

let timeout = null;

document.querySelectorAll('.form-box').forEach((box) =>{
    const boxInput= box.querySelector('input');

    boxInput.addEventListener('keydown',(event) =>{

        clearTimeout(timeout);
        timeout = setTimeout(() =>{

            console.log(`I nput ${boxInput.nombreUsuario} value: `, boxInput.value );
             
            validation(box, boxInput)
        }, 300);
    });
});

validation = (box, boxInput) =>{
    if (boxInput.nombreUsuario == 'nombreUsuario'){
        console,log('validacion para nombre')
        if (boxInput.value == '') {
            box.classList.remove('form-seccess')
            box.classList.add('form-error')
        }else{}
    }
}