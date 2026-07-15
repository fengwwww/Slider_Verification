<template>
  <div class="container">
    <div class="card">
      <h2>登录</h2>
      <div class="form-item">
        <input v-model="form.username" placeholder="请输入用户名" />
      </div>
      <div class="form-item">
        <input v-model="form.password" type="password" placeholder="请输入密码" />
      </div>
      <button class="btn" @click="handleLogin">登录</button>
      <p class="tip">还没有账号？<router-link to="/register">去注册</router-link></p>
      <p v-if="msg" :class="['msg', success ? 'ok' : 'err']">{{ msg }}</p>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { login } from '../api'
import { showCaptcha } from '../captcha'

const router = useRouter()
const form = reactive({ username: '', password: '' })
const msg = ref('')
const success = ref(false)

const handleLogin = async () => {
  if (!form.username || !form.password) {
    msg.value = '请填写完整信息'
    success.value = false
    return
  }
  // 先完成滑块验证，拿到 ticket 与 randstr
  let captcha
  try {
    captcha = await showCaptcha()
  } catch (e) {
    msg.value = '请完成滑块验证'
    success.value = false
    return
  }
  try {
    const res = await login({ ...form, ticket: captcha.ticket, randstr: captcha.randstr })
    success.value = res.data.code === 200
    msg.value = res.data.message
    if (success.value) {
      localStorage.setItem('username', form.username)
      setTimeout(() => router.push('/home'), 500)
    }
  } catch (e) {
    msg.value = '登录失败，请检查网络或后端服务'
    success.value = false
  }
}
</script>