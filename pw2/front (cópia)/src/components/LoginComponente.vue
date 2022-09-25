<template>
  <div>
    <h1>Olá Login</h1>
    <p>Meu nome é {{ nome }}</p>
  </div>
</template>

<script>
  export default{
    name: 'LoginComponente',
    data() {
      return {
        nome: "Alexandre"
      }
    }
  }
</script>