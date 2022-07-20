function redireccionar(){
    window.setTimeout( abrirURL, 5000 ); // 3 segundos
};
    
function abrirURL(){
    window.location = "index.jsp"; 
    console.log("Han pasado 5 segundos");
};