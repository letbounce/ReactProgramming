import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080',
  // timeout: 10000,
});

// При потребі швидкого базового логіну (Basic Auth) для тестів:
// instance.defaults.auth = { username: '1111', password: '1111' };

// Експортуємо не-функцію, щоб уникнути випадкового виклику як callable-інстансу
const http = {
  get: (...args) => instance.get(...args),
  post: (...args) => instance.post(...args),
  put: (...args) => instance.put(...args),
  delete: (...args) => instance.delete(...args),
  instance,
};

export default http;