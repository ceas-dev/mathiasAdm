import { signIn, signInToken } from "../service/firebase-service.js";
import { verifyToken } from "../service/service.js";
import { saveToken } from "../utils/token-handler.js";
import { navigateTo } from "../utils/router.js";

class View {
    #events
    constructor() {
        this.formLogin = document.getElementById('form-login')
        this.inputEmail = document.getElementById('input-email')
        this.inputPassword = document.getElementById('input-password');
        this.btnSignIn = document.getElementById('btn-sign-in');
        this.btnSignUp = document.getElementById('btn-sign-up');
        this.#events = {
            onLogin(){
                navigateTo('home');
                alert('Logado')
            }
        }
    }
    getValueEmail = () => this.inputEmail.value;
    getValuePassword = () => this.inputPassword.value;

    setValueEmail(email) {
        this.inputEmail.value = email;
    }

    setValuePassword(password) {
        this.inputPassword.value = password;
    }

    addEventLogin(loginEvent) {
        this.formLogin.addEventListener('submit', event => {
            event.preventDefault();
            if (loginEvent) {
                loginEvent(this.getValueEmail(), this.getValuePassword());
            }
        })
    }

    getEvents(){
        return this.#events;
    }
}


function getMessageError(error) {
    switch (error.code) {
        case 'auth/invalid-credential':
            return 'Credencias invalidas'
        default:
            return error.message;
    }
}

const view = new View();
view.setValueEmail('carlos.teste@hotmail.com');
view.setValuePassword('12345678');

view.btnSignUp.addEventListener('click', event=>{
    navigateTo('home')
})

view.addEventLogin((email, password)=>{
    signInToken(email, password)
    .then(token => verifyToken(token))
    .then(tokenInfo =>{
        alert(JSON.stringify(tokenInfo))
        saveToken(tokenInfo)
        view.getEvents().onLogin();
    })
    .catch(e => alert(getMessageError(e)));
});




