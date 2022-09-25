<template>
     <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center"> {{ nome }}</a>
      </div>
    </nav>

    
</template>

<script>
  export default{
    name: 'LoginComponente',
    data() {
      return {
        nome: "Troca Mangás"
      }
    }
  }
</script>