reloj.value = "00:00:00:00";
let idIntervalo;
let audio = new Audio('audios/audio.mp3')
//crear array con los valores del reloj
const relojDividido = reloj.value.split(':');

let milesimas = parseInt(relojDividido[3]);;
let segundos = parseInt(relojDividido[2]);
let minutos = parseInt(relojDividido[1]);
let horas = parseInt(relojDividido[0]);

let milesimasString;
let segundosString;
let minutosString;
let horasString;


function iniciarCronometro() {
    document.getElementById('boton1').style.display = 'none';
    document.getElementById('boton2').style.display = 'inline';
    //validar si se esta reanudando el cronometro despues de una pausa
    if (document.getElementById('boton4').style.display == 'none') {
        document.getElementById('boton4').style.display = 'inline';
        document.getElementById('boton3').style.display = 'none';
    }
    idIntervalo = setInterval(aumentarReloj, 10);
}

function aumentarReloj() {
    //usar funcion agregar cero para valores entre 0-9
    milesimasString = agregarCero(milesimas);
    segundosString = agregarCero(segundos);
    minutosString = agregarCero(minutos);
    horasString = agregarCero(horas);
    
    //en cada intervalo se actualizan los valores del reloj
    reloj.value = horasString + ":" + minutosString +":"+ segundosString +":" + milesimasString;
    validarMilesimas();
}

function validarMilesimas() {
    if (milesimas < 99) {
        milesimas++; 
    }else{
        milesimas = 0;
        validarSegundos(segundos);
    }
}

function validarSegundos(){
    if (segundos == 59) {
        audio.play();
        segundos = 0;
        validarMinutos();
    }else{
        audio.play();
        segundos ++;
    }
}

function validarMinutos(){
    if (minutos == 59) {
        minutos = 0;
        validarHoras();
    }else{
        minutos ++;
    }
}

function validarHoras(){
    if (horas == 23) {
        horas = 0;
    }else{
        horas ++;
    }
}
//Funcion para agregar un cero al valor del reloj, en lugar de estar 00:00:00:1, aparece 00:00:00:01
function agregarCero(valorDeTiempo) {
    let auxiliarString;
    if (valorDeTiempo >= 0 && valorDeTiempo <=9) {
        auxiliarString = "0" + valorDeTiempo.toString();
        return auxiliarString;
    }else{
        auxiliarString = valorDeTiempo.toString();
        return auxiliarString;
    }
}

function pausarCronometro(){
    clearInterval(idIntervalo);
    audio.pause();
    document.getElementById('boton2').style.display = 'none';
    document.getElementById('boton4').style.display = 'none';
    document.getElementById('boton1').style.display = 'inline';
    document.getElementById('boton3').style.display = 'inline';
}

function pausarYBorrarCronometro(){
    clearInterval(idIntervalo);
    audio.pause();

    document.getElementById('boton2').style.display = 'none';
    document.getElementById('boton4').style.display = 'none';
    document.getElementById('boton1').style.display = 'inline';
    document.getElementById('boton3').style.display = 'inline';
    
    milesimas = 0;
    segundos = 0;
    minutos = 0;
    horas = 0;
}

function pararCronometro() {
    clearInterval(idIntervalo);
    document.getElementById('boton1').style.display = 'inline';
    document.getElementById('boton4').style.display = 'inline';
    document.getElementById('boton3').style.display = 'none';
    reloj.value = "00:00:00:00";
    milesimas = 0;
    segundos = 0;
    minutos = 0;
    horas = 0;
}
