<template>
  <div id="app">
    <img src="./assets/logo1.png">
    <img src="./assets/logo.png">
    <img :src="absolutePath + '/static/logo.png'">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      absolutePath: ''
    }
  },
  created () {
    let path = location.pathname
    this.absolutePath = path.substring(0, path.lastIndexOf('/'))
  }
}
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
