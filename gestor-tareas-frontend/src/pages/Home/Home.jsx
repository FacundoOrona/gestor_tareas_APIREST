import styles from './Home.module.scss';
import { motion } from 'framer-motion';
import tareasImg from '../../assets/tareas.svg';
import { useNavigate } from 'react-router-dom';

export default function Home() {
  const usuario = localStorage.getItem('usuario') || 'Invitado';
  const navigate = useNavigate();

  const handleClick = () => {
    navigate('/misproyectos');
  };

  return (
    <div className={styles.home}>
      <motion.div
        className={styles.card}
        initial={{ opacity: 0, y: 30 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.8 }}
      >
        <h2 className={styles.bienvenida}>Bienvenido {usuario}</h2>

        <img src={tareasImg} alt="Bienvenida" className={styles.illustration} />
        <h1>Bienvenido a <span className={styles.brand}>Gestor de Tareas</span></h1>
        <p className="text-muted">Organizá tu día. Prioridades. Tiempo. Todo desde un solo lugar.</p>

        <button
          className={styles.botonProyectos}
          onClick={handleClick}
        >
          Gestionar mis proyectos
        </button>
      </motion.div>
    </div>
  );
}

