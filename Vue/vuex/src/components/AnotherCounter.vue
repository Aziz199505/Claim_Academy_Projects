<template>
    <div>
        <button class="btn btn-primary" @click="increment(50)">Increment</button>
        <button class="btn btn-primary" @click="asyncDecrement">Async Decrement</button>
        <button class="btn btn-primary" @click="asyncIncrement({by : 30,timeOut : 3000})">Async Increment</button>

    </div>
</template>

<script>
    import {mapActions} from 'vuex'
    export default {
        methods: {
            ...mapActions([
                 'asyncDecrement'
            ]),
            increment(by) {
                this.$store.dispatch('increment',by)
            },
            asyncIncrement(payload) {
                this.$store.dispatch('asyncIncrement',payload)
            }
        }
    }
</script>