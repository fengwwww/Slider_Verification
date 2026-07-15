<template>
  <div class="container">
    <div class="card">
      <h2>注册</h2>
      <div class="form-item">
        <input v-model="form.username" placeholder="请输入用户名" />
      </div>
      <div class="form-item">
        <input v-model="form.password" type="password" placeholder="请输入密码" />
      </div>
      <div class="form-item">
        <input v-model="form.confirm" type="password" placeholder="请确认密码" />
      </div>
      <button class="btn" @click="handleRegister">注册</button>
      <p class="tip">已有账号？<router-link to="/login">去登录</router-link></p>
      <p v-if="msg" :class="['msg', success ? 'ok' : 'err']">{{ msg }}</p>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { register } from '../api'
import { showCaptcha } from '../captcha'

const router = useRouter()
const form = reactive({ username: '', password: '', confirm: '' })
const msg = ref('')
const success = ref(false)

const handleRegister = async () => {
  if (!form.username || !form.password || !form.confirm) {
    msg.value = '请填写完整信息'
    success.value = false
    return
  }
  if (form.password !== form.confirm) {
    msg.value = '两次密码不一致'
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
    const res = await register({ username: form.username, password: form.password, ticket: captcha.ticket, randstr: captcha.randstr })
    success.value = res.data.code === 200
    msg.value = res.data.message
    if (success.value) {
      setTimeout(() => router.push('/login'), 1000)
    }
  } catch (e) {
    msg.value = '注册失败，请检查网络或后端服务'
    success.value = false
  }
}
</script>