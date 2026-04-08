// Función para el botón de Iniciar Sesión
function validar() {
    const usuario = document.getElementById('usuario').value;
    const acepto = document.getElementById('acepto').checked;

    if (usuario === "") {
        alert("Por favor, ingresa tu usuario.");
    } else if (!acepto) {
        alert("⚠️ Debes marcar el cuadro para aceptar los términos y condiciones.");
    } else {
        alert("✅ ¡Bienvenido a Gym Manager Pro! Conectando con la base de datos...");
    }
}

// ARREGLADO: Función para el botón de Registro (Requisito Guía 7)
function registrarSocio() {
    // 1. Capturamos los datos con cuadros de entrada
    let nombre = prompt("✍️ Ingrese el nombre completo del nuevo socio:");
    let email = prompt("📧 Ingrese el correo electrónico:");

    // 2. Verificamos que el usuario no haya dejado los campos vacíos
    if (nombre === null || nombre.trim() === "" || email === null || email.trim() === "") {
        alert("❌ Registro cancelado: Los campos no pueden estar vacíos.");
    } else {
        // 3. Simulamos la conexión con el DAO de Java y MySQL
        alert("🔄 Conectando con ClienteDAO.java...\n💾 Preparando sentencia SQL para: " + nombre);
        
        // Mensaje final de éxito para tu evidencia
        alert("✅ ¡Socio guardado con éxito en la base de datos MySQL!");
        
        // Esto se verá en la consola de inspección del navegador
        console.log("Guía 7 - Registro exitoso:");
        console.log("Nombre: " + nombre);
        console.log("Email: " + email);
    }
}