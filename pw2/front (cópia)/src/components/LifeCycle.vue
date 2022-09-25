<template>
    <div>
        <h1> Meu nome é: {{ nome }}</h1>
    </div>
</template>

<script>

export default {
    name: 'LifeCycle',
    data() {
        return {
            nome: 'Alexandre.'
        }
    },
    created(){
        setTimeout(() => {
         this.nome = 'Mario'
        }, 1000);
       
    }
}
</script>
