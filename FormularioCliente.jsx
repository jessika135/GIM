import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function FormularioCliente() {
  const navigate = useNavigate();
  const [paso, setPaso] = useState(1);
  const [error, setError] = useState('');
  const [cliente, setCliente] = useState({
    nombre: '',
    cedula: '',
    telefono: '',
    email: '',
    plan: '',
    fechaInicio: '',
    restricciones: '',
    contactoEmergencia: '',
    telEmergencia: '',
  });

  const handleChange = (e) => {
    setCliente({ ...cliente, [e.target.name]: e.target.value });
    setError('');
  };

  const siguiente = () => {
    if (!cliente.nombre) {
      setError('El nombre es requerido');
      return;
    }
    if (!cliente.cedula) {
      setError('El documento es requerido');
      return;
    }
    if (!cliente.telefono) {
      setError('El telefono es requerido');
      return;
    }
    if (!cliente.email || !cliente.email.includes('@')) {
      setError('Ingresa un email valido');
      return;
    }
    if (!cliente.plan) {
      setError('Selecciona un plan');
      return;
    }
    setError('');
    setPaso(2);
  };

  const anterior = () => {
    setError('');
    setPaso(1);
  };

  const guardar = (e) => {
    e.preventDefault();
    if (!cliente.fechaInicio) {
      setError('La fecha de inicio es requerida');
      return;
    }
    navigate('/exito');
  };

  const inputStyle = {
    width: '100%',
    padding: '10px',
    margin: '5px 0 10px',
    border: '1px solid #ddd',
    borderRadius: '8px',
    boxSizing: 'border-box',
    fontSize: '14px'
  };

  return (
    <div style={{
      minHeight: '100vh',
      background: 'linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)), url(/img/gim.jpg) no-repeat center center fixed',
      backgroundSize: 'cover',
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      fontFamily: 'Segoe UI, sans-serif'
    }}>
      <div style={{
        background: 'white',
        padding: '40px',
        borderRadius: '15px',
        width: '90%',
        maxWidth: '500px',
        boxShadow: '0 10px 25px rgba(0,0,0,0.5)',
        margin: '20px'
      }}>

        {/* Logo */}
        <div style={{textAlign: 'center', marginBottom: '15px'}}>
          <img src="/img/logo.jpg" alt="Logo" style={{width: '80px', borderRadius: '10px'}} />
        </div>

        {/* Titulo */}
        <h2 style={{textAlign: 'center', color: '#002366', marginBottom: '5px'}}>
          Registro de Nuevo Cliente
        </h2>

        {/* Fecha */}
        <p style={{textAlign: 'center', color: '#888', fontSize: '12px', marginBottom: '20px'}}>
          Fecha de registro: {new Date().toLocaleDateString()}
        </p>

        {/* Progreso */}
        <div style={{display: 'flex', alignItems: 'center', marginBottom: '25px'}}>
          <div style={{
            width: '35px', height: '35px', borderRadius: '50%',
            background: paso >= 1 ? '#002366' : '#ccc',
            color: 'white', display: 'flex', alignItems: 'center',
            justifyContent: 'center', fontWeight: 'bold', fontSize: '14px'
          }}>1</div>
          <div style={{flex: 1, height: '3px', background: paso === 2 ? '#002366' : '#ccc'}}></div>
          <div style={{
            width: '35px', height: '35px', borderRadius: '50%',
            background: paso === 2 ? '#002366' : '#ccc',
            color: 'white', display: 'flex', alignItems: 'center',
            justifyContent: 'center', fontWeight: 'bold', fontSize: '14px'
          }}>2</div>
        </div>

        {/* Mensaje de error integrado */}
        {error && (
          <div style={{
            background: '#f8d7da',
            color: '#721c24',
            padding: '12px 15px',
            borderRadius: '8px',
            marginBottom: '15px',
            fontSize: '14px',
            border: '1px solid #f5c6cb',
            display: 'flex',
            alignItems: 'center',
            gap: '8px'
          }}>
            ⚠️ {error}
          </div>
        )}

        <form onSubmit={guardar}>

          {/* PASO 1 */}
          {paso === 1 && (
            <div>
              <h3 style={{color: '#333', marginBottom: '15px'}}>Datos Personales</h3>

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Nombre Completo *</label>
              <input name="nombre" value={cliente.nombre} onChange={handleChange}
                placeholder="Ingresa tu nombre" style={inputStyle} />

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Documento *</label>
              <input name="cedula" value={cliente.cedula} onChange={handleChange}
                placeholder="Numero de documento" style={inputStyle} />

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Telefono *</label>
              <input name="telefono" value={cliente.telefono} onChange={handleChange}
                placeholder="Numero de telefono" style={inputStyle} />

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Correo Electronico *</label>
              <input name="email" value={cliente.email} onChange={handleChange}
                placeholder="Correo electronico" style={inputStyle} />

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Plan *</label>
              <select name="plan" value={cliente.plan} onChange={handleChange} style={inputStyle}>
                <option value="">Selecciona un plan</option>
                <option value="Mensual">Mensual</option>
                <option value="Trimestral">Trimestral</option>
                <option value="Anual">Anual</option>
              </select>

              <button type="button" onClick={siguiente} style={{
                width: '100%', padding: '12px', background: '#002366',
                color: 'white', border: 'none', borderRadius: '8px',
                cursor: 'pointer', fontWeight: 'bold', marginTop: '10px', fontSize: '15px'
              }}>
                Siguiente →
              </button>
            </div>
          )}

          {/* PASO 2 */}
          {paso === 2 && (
            <div>
              <h3 style={{color: '#333', marginBottom: '15px'}}>Informacion de Membresia</h3>

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Fecha de inicio *</label>
              <input type="date" name="fechaInicio" value={cliente.fechaInicio}
                onChange={handleChange} style={inputStyle} />

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Restricciones Medicas</label>
              <textarea name="restricciones" value={cliente.restricciones}
                onChange={handleChange}
                placeholder="Ej. Alergias, lesiones previas..."
                style={{...inputStyle, height: '80px', resize: 'none'}} />

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Contacto de Emergencia</label>
              <input name="contactoEmergencia" value={cliente.contactoEmergencia}
                onChange={handleChange}
                placeholder="Nombre completo del contacto" style={inputStyle} />

              <label style={{fontWeight: 'bold', fontSize: '14px'}}>Telefono del Contacto</label>
              <input name="telEmergencia" value={cliente.telEmergencia}
                onChange={handleChange}
                placeholder="Ej. 3001234567" style={inputStyle} />

              <div style={{display: 'flex', gap: '10px', marginTop: '10px'}}>
                <button type="button" onClick={anterior} style={{
                  flex: 1, padding: '12px', background: '#002366',
                  color: 'white', border: 'none', borderRadius: '8px',
                  cursor: 'pointer', fontWeight: 'bold', fontSize: '15px'
                }}>
                  ← Anterior
                </button>
                <button type="submit" style={{
                  flex: 1, padding: '12px', background: '#ff8c00',
                  color: 'white', border: 'none', borderRadius: '8px',
                  cursor: 'pointer', fontWeight: 'bold', fontSize: '15px'
                }}>
                  Finalizar ✓
                </button>
              </div>
            </div>
          )}
        </form>
      </div>
    </div>
  );
}

export default FormularioCliente;