<template>
  <HeaderAppVue />
  <LoginComponenteVue />
  <LifeCycleVue />
</template>


<script>

  import HeaderAppVue from './components/HeaderApp.vue'
  import LoginComponenteVue from './components/LoginComponente.vue'
  import LifeCycleVue from './components/LifeCycle.vue'
  
  export default{
    name: 'App',
    components: {
    HeaderAppVue,
    LoginComponenteVue,
    LifeCycleVue
    
}
  }
</script>

<style>

</style>
