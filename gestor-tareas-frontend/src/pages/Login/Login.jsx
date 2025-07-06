// src/pages/Login/Login.jsx
import { useState } from 'react';
import { login } from '../../services/authService';
import styles from './Login.module.scss';

export default function Login() {
  const [formData, setFormData] = useState({
    email: '',
    contraseña: '',
  });

  const [mensaje, setMensaje] = useState('');
  const [error, setError] = useState('');
  const [jwt, setJwt] = useState('');

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMensaje('');
    setError('');

    try {
      const response = await login(formData);
      const token = response.data.token;
      setJwt(token);
      setMensaje('Login exitoso');
      localStorage.setItem('token', token);
    } catch (err) {
      setError('Email o contraseña incorrectos');
      console.error(err);
    }
  };

  return (
    <div className={`container ${styles.login}`}>
      <h2 className="text-center mb-4">Iniciar Sesión</h2>
      {mensaje && <div className="alert alert-success">{mensaje}</div>}
      {error && <div className="alert alert-danger">{error}</div>}
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Correo Electrónico</label>
          <input
            type="email"
            className="form-control"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Contraseña</label>
          <input
            type="password"
            className="form-control"
            name="contraseña"
            value={formData.contraseña}
            onChange={handleChange}
            required
          />
        </div>

        <div className="text-center">
          <button type="submit" className="btn btn-danger">Iniciar sesión</button>
        </div>
      </form>
    </div>
  );
}
