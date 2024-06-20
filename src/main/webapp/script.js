function validateForm() {
    // Get the input values
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    // Check the conditions
    if (email !== 'ibrakd234@gmail.com' && password !== '123456789') { 
     prompt("error")
    } else {
        window.location.href = '.html'; // Redirect to createUser.html 
    }
}
function rep(){
    var password = document.getElementById('password')
    var repeat = document.getElementById('reppass')

    if (password !== repaeat){
        prompt("please check and type your password again")
    }else{
        prompt("good to go")
    }
}

function rep(){
    var password = document.getElementById('password')
    var repeat = document.getElementById('reppass')

    if (password !== repaeat){
        prompt("please check and type your password again")
    }else{
        prompt("good to go")
    }
}