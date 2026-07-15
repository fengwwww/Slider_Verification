import axios from 'axios'

const api = axios.create({
  baseURL: '/api',
  timeout: 10000
})

export const login = (data) => api.post('/user/login', data)
export const register = (data) => api.post('/user/register', data)

export default api
