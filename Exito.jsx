import React from 'react';
import { useNavigate } from 'react-router-dom';

function Exito() {
  const navigate = useNavigate();

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
        maxWidth: '450px',
        boxShadow: '0 10px 25px rgba(0,0,0,0.5)',
        textAlign: 'center'
      }}>
        <img src="/img/logo.jpg" alt="Logo" style={{width: '80px', borderRadius: '10px', marginBottom: '20px'}} />
        <div style={{fontSize: '70px'}}>✅</div>
        <h1 style={{color: '#002366', marginBottom: '10px'}}>Registro Exitoso!</h1>
        <p style={{color: '#666', marginBottom: '25px'}}>
          El cliente ha sido registrado en el sistema GymManagerPro.
        </p>
        <button
          onClick={() => navigate('/')}
          style={{width: '100%', padding: '12px', background: '#002366', color: 'white', border: 'none', borderRadius: '8px', cursor: 'pointer', fontWeight: 'bold', marginBottom: '10px'}}>
          Volver al Inicio
        </button>
        <button
          onClick={() => navigate('/registro')}
          style={{width: '100%', padding: '12px', background: '#ff8c00', color: 'white', border: 'none', borderRadius: '8px', cursor: 'pointer', fontWeight: 'bold'}}>
          Registrar otro cliente
        </button>
      </div>
    </div>
  );
}

export default Exito;