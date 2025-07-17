import { Link, useNavigate } from 'react-router-dom';
import { useContext } from 'react';
import { AuthContext } from '../../context/AuthContext';
import { logout as logoutService } from '../../services/authService';
import styles from './Navbar.module.scss';

export default function Navbar() {
  const { isLoggedIn, logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = async () => {
    const token = localStorage.getItem('token');
    if (!token) return;

    try {
      await logoutService(token);
    } catch (error) {
      console.error('Error al cerrar sesión:', error);
    }

    logout();
    navigate('/');
  };

  return (
    <nav className={`navbar navbar-expand-lg navbar-dark ${styles.navbar}`}>
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">Gestor de Tareas</Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navContent">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navContent">
          <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
            {!isLoggedIn ? (
              <>
                <li className="nav-item">
                  <Link className="nav-link" to="/login">Login</Link>
                </li>
                <li className="nav-item">
                  <Link className="nav-link" to="/register">Registro</Link>
                </li>
              </>
            ) : (
              <li className="nav-item">
                <button
                  onClick={handleLogout}
                  className="btn btn-link nav-link"
                  style={{ textDecoration: 'none' }}
                >
                  Cerrar sesión
                </button>
              </li>
            )}
          </ul>
        </div>
      </div>
    </nav>
  );
}
