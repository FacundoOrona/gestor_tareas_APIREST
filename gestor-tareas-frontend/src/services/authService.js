import axios from 'axios';

const API_BASE = 'http://localhost:8080/auth'; // Cambiá si usás otro puerto

export const registrarUsuario = (data) => {
  return axios.post(`${API_BASE}/register`, data);
};

export const login = async (data) => {
  return axios.post(`${API_BASE}/login`, data);
};