<template>
  <router-view />
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
body {
  font-family: "Segoe UI", Arial, sans-serif;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  min-height: 100vh;
}
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}
.card {
  background: #fff;
  padding: 40px;
  border-radius: 12px;
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.15);
  width: 360px;
}
.card h2 {
  text-align: center;
  margin-bottom: 24px;
  color: #333;
}
.form-item {
  margin-bottom: 16px;
}
.form-item input {
  width: 100%;
  padding: 10px 12px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 14px;
  outline: none;
  transition: border-color 0.2s;
}
.form-item input:focus {
  border-color: #667eea;
}
.btn {
  width: 100%;
  padding: 10px;
  background: #667eea;
  color: #fff;
  border: none;
  border-radius: 6px;
  font-size: 15px;
  cursor: pointer;
  transition: background 0.2s;
}
.btn:hover {
  background: #5568d3;
}
.tip {
  text-align: center;
  margin-top: 16px;
  font-size: 13px;
  color: #888;
}
.tip a {
  color: #667eea;
  text-decoration: none;
}
.msg {
  margin-top: 12px;
  text-align: center;
  font-size: 13px;
}
.msg.ok {
  color: #52c41a;
}
.msg.err {
  color: #f5222d;
}
</style>
