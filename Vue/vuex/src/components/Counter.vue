<template>
    <div>
        <button class="btn btn-primary" @click="increment(10)">Increment</button>
        <button class="btn btn-primary" @click="decrement">Decrement</button>
    </div>
</template>

<script>
    import {mapMutations} from 'vuex'
    export default {
        methods: {
            ...mapMutations([
                'increment'
            ]),
            decrement() {
                this.$store.state.counter.counter--
            }
        }
    }
</script>