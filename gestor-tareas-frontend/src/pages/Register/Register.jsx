import { useState } from 'react';
import styles from './Register.module.scss';
import { registrarUsuario } from '../../services/authService';
import { useNavigate } from 'react-router-dom';

export default function Register() {
  const [formData, setFormData] = useState({
    nombre: '',
    email: '',
    contraseña: ''
  });

  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');

    try {
      const response = await registrarUsuario(formData);

      // Guardar token y nombre en localStorage
      const token = response.data.token;
      const nombreUsuario = response.data.nombre;

      localStorage.setItem('token', token);
      localStorage.setItem('usuario', nombreUsuario);

      navigate('/');
    } catch (err) {
      console.error(err);
      setError('Error al registrar usuario.');
    }
  };

  return (
    <div className={`container ${styles.register}`}>
      <h2 className="text-center mb-4">Registro</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="nombre" className="form-label">Nombre</label>
          <input
            type="text"
            name="nombre"
            className="form-control"
            value={formData.nombre}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">Correo Electrónico</label>
          <input
            type="email"
            name="email"
            className="form-control"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="contraseña" className="form-label">Contraseña</label>
          <input
            type="password"
            name="contraseña"
            className="form-control"
            value={formData.contraseña}
            onChange={handleChange}
            required
          />
        </div>
        {error && <div className="alert alert-danger">{error}</div>}
        <div className="text-center">
          <button type="submit" className="btn btn-danger">Registrarse</button>
        </div>
      </form>
    </div>
  );
}
