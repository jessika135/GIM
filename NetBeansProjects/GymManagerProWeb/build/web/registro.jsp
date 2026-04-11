<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro - GymManagerPro</title>
    <link rel="stylesheet" href="estilos.css">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)), 
                        url('img/gim.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-container {
            background: rgba(255,255,255,0.95);
            padding: 30px;
            border-radius: 15px;
            max-width: 500px;
            width: 90%;
            margin: 30px auto;
        }
        .step { display: none; }
        .step.active { display: block; }
        .progress {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
            margin-bottom: 20px;
        }
        .circle {
            width: 35px; height: 35px;
            border-radius: 50%;
            background: #ccc;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: bold;
        }
        .circle.active { background: #002366; }
        .line {
            flex: 1;
            height: 3px;
            background: #ccc;
        }
        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-sizing: border-box;
        }
        label { font-weight: bold; color: #333; }
        .btn-siguiente {
            background: #002366;
            color: white;
            padding: 12px;
            width: 100%;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
        }
        .btn-anterior {
            background: #ccc;
            color: #333;
            padding: 12px;
            width: 100%;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
        }
        .btn-finalizar {
            background: #ff8c00;
            color: white;
            padding: 12px;
            width: 100%;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
        }
        h2 { color: #002366; text-align: center; }
        .fecha-jsp {
            font-size: 12px;
            color: #888;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <img src="img/logo.jpg" alt="Logo" style="width:80px; display:block; margin:0 auto 10px;">
    <h2>Registro de Nuevo Cliente</h2>
    <p class="fecha-jsp">Fecha de registro: <%= new java.util.Date() %></p>

    <div class="progress">
        <div class="circle active" id="c1">1</div>
        <div class="line"></div>
        <div class="circle" id="c2">2</div>
    </div>

    <form action="ClienteServlet" method="POST">
        <input type="hidden" name="accion" value="insertar">

        <!-- PASO 1 -->
        <div class="step active" id="paso1">
            <h3>Datos Personales</h3>
            <label>Nombre</label>
            <input type="text" name="nombre" placeholder="Ingresa tu nombre" required>
            <label>Apellido</label>
            <input type="text" name="apellido" placeholder="Ingresa tu apellido" required>
            <label>Documento</label>
            <input type="text" name="cedula" placeholder="Número de documento" required>
            <label>Teléfono</label>
            <input type="text" name="telefono" placeholder="Número de teléfono" required>
            <label>Correo Electrónico</label>
            <input type="email" name="email" placeholder="Correo electrónico" required>
            <label>Plan de Membresía</label>
            <select name="tipoMembresia">
                <option value="">Selecciona un plan</option>
                <option value="Mensual">Mensual</option>
                <option value="Trimestral">Trimestral</option>
                <option value="Anual">Anual</option>
            </select>
            <button type="button" class="btn-siguiente" onclick="siguiente()">
                Siguiente →
            </button>
        </div>

        <!-- PASO 2 -->
        <div class="step" id="paso2">
            <h3>Información de Membresía</h3>
            <label>Fecha de inicio de membresía</label>
            <input type="date" name="fechaInicio">
            <label>Restricciones Médicas</label>
            <textarea name="restricciones" rows="3" 
                placeholder="Ej. Alergias, lesiones previas..."></textarea>
            <label>Contacto de Emergencia</label>
            <input type="text" name="contactoEmergencia" 
                placeholder="Nombre completo del contacto">
            <label>Teléfono del Contacto</label>
            <input type="text" name="telEmergencia" 
                placeholder="Ej. 3001234567">
            <button type="button" class="btn-anterior" onclick="anterior()">
                ← Anterior
            </button>
            <button type="submit" class="btn-finalizar">
                Finalizar Registro ✓
            </button>
        </div>
    </form>
</div>

<script>
    function siguiente() {
        document.getElementById('paso1').classList.remove('active');
        document.getElementById('paso2').classList.add('active');
        document.getElementById('c1').classList.remove('active');
        document.getElementById('c2').classList.add('active');
    }
    function anterior() {
        document.getElementById('paso2').classList.remove('active');
        document.getElementById('paso1').classList.add('active');
        document.getElementById('c2').classList.remove('active');
        document.getElementById('c1').classList.add('active');
    }
</script>
</body>
</html>