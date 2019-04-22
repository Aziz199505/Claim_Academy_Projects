<template>
  <div>
    <form class="form-signin">
      <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Sign Up!</h1>

      <label for="inputFirstName" class="sr-only">First Name</label>
      <input v-model="firstName" type="text" id="inputFirstName" class="form-control" placeholder="First Name">
      <label for="inputLastName" class="sr-only">Last Name</label>
      <input v-model="lastName" type="text" id="inputLastName" class="form-control" placeholder="Last Name">
      <label for="inputCellPhone" class="sr-only">Cell Phone</label>
      <input v-model="cellPhone" type="text" id="inputCellPhone" class="form-control" placeholder="Cell Phone">
      <label for="inputEmail" class="sr-only">Email Address</label>
      <input v-model="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input v-model="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>

      <button @click.prevent="singUp" class="btn btn-lg btn-primary btn-block">Sign Up</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>


  </div>
</template>

<script>

  export default {
    data() {
      return {
        email : "",
        password : "",
        firstName : "",
        lastName : "",
        cellPhone : "",
        options : []
      }
    },
    methods : {
      singUp() {
        console.log("I clicked")

        console.log(this.email)
        console.log(this.options)
      }
    }

  }


</script>

<style scoped>

  .form-signin {
    width: 100%;
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
  }
  .form-signin .checkbox {
    font-weight: 400;
  }
  .form-signin .form-control {
    position: relative;
    box-sizing: border-box;
    height: auto;
    padding: 10px;
    font-size: 16px;
  }
  .form-signin .form-control:focus {
    z-index: 2;
  }
  .form-signin input[type="email"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
  }
  .form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
  }


</style>
