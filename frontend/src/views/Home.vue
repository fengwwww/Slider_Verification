<template>
  <div class="container">
    <div class="card">
      <h2>欢迎，{{ username }}！</h2>
      <p class="tip" style="margin-bottom: 16px;">登录成功，已进入首页。</p>
      <button class="btn" @click="logout">退出登录</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const username = ref(localStorage.getItem('username') || '用户')

const logout = () => {
  localStorage.removeItem('username')
  router.push('/login')
}
</script>
