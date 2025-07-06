import styles from './Home.module.scss';
import { motion } from 'framer-motion';
import tareasImg from '../../assets/tareas.svg';

export default function Home() {
  return (
    <div className={styles.home}>
      <motion.div
        className={styles.card}
        initial={{ opacity: 0, y: 30 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.8 }}
      >
        <img src={tareasImg} alt="Bienvenida" className={styles.illustration} />
        <h1>Bienvenido a <span className={styles.brand}>Gestor de Tareas</span></h1>
        <p className="text-muted">Organizá tu día. Prioridades. Tiempo. Todo desde un solo lugar.</p>
      </motion.div>
    </div>
  );
}
