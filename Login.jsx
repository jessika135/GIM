import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Login() {
  const navigate = useNavigate();
  const [usuario, setUsuario] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    if (usuario === 'admin' && password === '1234') {
      navigate('/admin');
    } else {
      alert('Usuario o contrasena incorrectos');
    }
  };

  return (
    <div className="main-container">
      <img src="/img/logo.jpg" alt="Logo Gym Manager Pro" className="logo-principal" />

      <div className="login-card">
        <h1>GYM MANAGER PRO</h1>
        <p className="tagline">Sistema de Gestion de Gimnasio</p>

        <form id="loginForm" onSubmit={handleLogin}>
          <div className="input-group">
            <input
              type="text"
              id="usuario"
              placeholder="Usuario o Correo electronico"
              value={usuario}
              onChange={e => setUsuario(e.target.value)}
              required
            />
          </div>

          <div className="input-group">
            <input
              type="password"
              id="password"
              placeholder="Contrasena"
              value={password}
              onChange={e => setPassword(e.target.value)}
              required
            />
          </div>

          <button type="submit" className="btn-login">
            Iniciar sesion
          </button>

          <button
            type="button"
            className="btn-register"
            onClick={() => navigate('/registro')}
          >
            Registro de usuario
          </button>
        </form>

        <a href="#" className="forgot-link">
          Olvidaste tu contrasena?
        </a>

        <div className="checkbox-container">
          <input type="checkbox" id="acepto" />
          <label htmlFor="acepto">Acepto los terminos y condiciones</label>
        </div>
      </div>

      <footer className="legal-footer">
        <p>
          Al iniciar sesion aceptas nuestros{' '}
          <a href="#">terminos y condiciones</a> y autorizas la{' '}
          <a href="#">politica de privacidad y tratamiento de datos</a>.
        </p>
      </footer>
    </div>
  );
}

export default Login;