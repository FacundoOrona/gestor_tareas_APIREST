import { useState, useContext } from 'react';
import styles from './Register.module.scss';
import { registrarUsuario } from '../../services/authService';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from '../../context/AuthContext';

export default function Register() {
  const [formData, setFormData] = useState({ nombre: '', email: '', contraseña: '' });
  const [errors, setErrors] = useState({});
  const { login } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
    setErrors({ ...errors, [e.target.name]: '', general: '' });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrors({});

    try {
      const response = await registrarUsuario(formData);

      const token = response.data.token;
      const nombreUsuario = response.data.nombre;

      login(token, nombreUsuario);

      navigate('/');
    } catch (err) {
      console.error(err);

      if (err.response?.data) {
        const data = err.response.data;

        if (typeof data === 'string') {
          setErrors({ general: data });
        } else if (typeof data === 'object') {
          if (data.error) {
            setErrors({ general: data.error });
          } else {
            setErrors(data);
          }
        } else {
          setErrors({ general: 'Error al registrar usuario.' });
        }
      } else {
        setErrors({ general: 'Error al registrar usuario.' });
      }
    }
  };

  return (
    <div className={`container ${styles.register}`}>
      <h2 className="text-center mb-4">Registro</h2>

      {errors.general && (
        <div className="alert alert-danger" role="alert">
          {errors.general}
        </div>
      )}

      <form onSubmit={handleSubmit} noValidate>
        <div className="mb-3">
          <label htmlFor="nombre" className="form-label">Nombre</label>
          <input
            type="text"
            name="nombre"
            id="nombre"
            className={`form-control ${errors.nombre ? 'is-invalid' : ''}`}
            value={formData.nombre}
            onChange={handleChange}
            required
          />
          {errors.nombre && (
            <div className="invalid-feedback">{errors.nombre}</div>
          )}
        </div>

        <div className="mb-3">
          <label htmlFor="email" className="form-label">Correo Electrónico</label>
          <input
            type="email"
            name="email"
            id="email"
            className={`form-control ${errors.email ? 'is-invalid' : ''}`}
            value={formData.email}
            onChange={handleChange}
            required
          />
          {errors.email && (
            <div className="invalid-feedback">{errors.email}</div>
          )}
        </div>

        <div className="mb-3">
          <label htmlFor="contraseña" className="form-label">Contraseña</label>
          <input
            type="password"
            name="contraseña"
            id="contraseña"
            className={`form-control ${errors.contraseña ? 'is-invalid' : ''}`}
            value={formData.contraseña}
            onChange={handleChange}
            required
          />
          {errors.contraseña && (
            <div className="invalid-feedback">{errors.contraseña}</div>
          )}
        </div>

        <div className="text-center">
          <button type="submit" className="btn btn-danger">
            Registrarse
          </button>
        </div>
      </form>
    </div>
  );
}
