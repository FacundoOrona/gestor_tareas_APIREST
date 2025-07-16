import { useState } from 'react';
import { login } from '../../services/authService';
import styles from './Login.module.scss';
import { useNavigate } from 'react-router-dom';

export default function Login() {
  const [formData, setFormData] = useState({
    email: '',
    contraseña: '',
  });

  const [mensaje, setMensaje] = useState('');
  const [error, setError] = useState('');

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
    setError('');
    setMensaje('');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMensaje('');
    setError('');

    try {
      const response = await login(formData);
      const token = response.data.token;
      const nombreUsuario = response.data.nombre;

      setMensaje('Login exitoso');

      localStorage.setItem('token', token);
      localStorage.setItem('usuario', nombreUsuario);

      navigate('/');  // Redirige al home

    } catch (err) {
      console.error(err);

      if (err.response?.data?.error) {
        setError(err.response.data.error);
      } else {
        setError('Error al iniciar sesión');
      }
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
