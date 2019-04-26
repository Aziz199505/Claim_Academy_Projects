<template>
  <div class="modal fade" id="modalAddCarForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
       aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">

        <form action="SellerCarServlet" method="post" enctype="multipart/form-data">

          <div class="modal-header text-center">
            <h4 class="modal-title w-100 font-weight-bold">Preferences</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body mx-3">

            <div class="md-form mb-4">

              <select name="seller"  class="form-control selectpicker">
                <option v-for="(v,key) in category" :value="key">{{v}}</option>

<!--                <c:forEach var="seller" items="${inventory.sellers}">

                  <option value="${seller.contact.email}">${seller.firstName} ${seller.lastName}</option>

                </c:forEach>-->
              </select>

              <label data-error="wrong" data-success="right" for="orangeForm-name">Category</label>

            </div>


            <div class="md-form mb-4">

              <input id="makeTitle" name="make" list="makes">


              <label data-error="wrong" data-success="right" for="orangeForm-name">Make</label>

            </div>




            <div class="md-form mb-4">

              <input id="results" name="model" list="models">

              <label data-error="wrong" data-success="right" for="orangeForm-name">Model</label>
            </div>

            <datalist id="models">
<!--              <c:forEach var="mycarType" items="${inventory.carTypes}">

                <%&#45;&#45; <option value="${m}">${mycarType.make}</option> &#45;&#45;%>

                <c:forEach var="m" items="${mycarType.model}">
                  <option value="${m}">${mycarType.make}</option>

                </c:forEach>
              </c:forEach>-->
            </datalist>

            <datalist id="makes">
<!--              <c:forEach var="mycarType" items="${inventory.carTypes}">
                <option value="${mycarType.make}"></option>
              </c:forEach>-->
            </datalist>




            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input name="year" type="number" value="2010" min="1990" id="orangeForm" class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm-name">Year</label>
            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input name="odometer" type="number" value="1" min="0" id="orangeForm2" class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm-name">Odometer</label>
            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input name="price" type="number" value="1" min="1" id="orangeForm3" class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm-name">Price</label>
            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <textarea name="descp" class="form-control validate" rows="5" id="comment"></textarea>

              <label data-error="wrong" data-success="right" for="orangeForm-name">Description</label>
            </div>



            <div class="md-form mb-5">
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
                </div>
                <div class="custom-file">
                  <input name="imageFile" type="file" accept="image/*" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                  <label class="custom-file-label" for="inputGroupFile01">Choose Image (Optional)</label>
                </div>
              </div>
            </div>

<!--            <div class="md-form mb-5 text-center">
              <div class="checkbox">
                <label>
                  <input type="checkbox" onclick="ChangeShip()" href="#moreabout" data-toggle="collapse" aria-expanded="false" aria-controls="moreabout" class="form-control" id="chShipAdd" name="isNewSeller" value="newSeller">
                  New Seller
                </label>
              </div>

            </div>-->
            <div id="shipadddiv">
              <div class="collapse" id="moreabout" >

                <div class="md-form mb-5">
                  <i class="fas fa-user prefix grey-text"></i>
                  <input name="firstName" type="text" id="orangeForm5" class="form-control validate">
                  <label data-error="wrong" data-success="right" for="orangeForm-name">First name</label>
                </div>

                <div class="md-form mb-5">
                  <i class="fas fa-user prefix grey-text"></i>
                  <input name="lastName" type="text" id="orangeForm6" class="form-control validate">
                  <label data-error="wrong" data-success="right" for="orangeForm-name">Last name</label>
                </div>

                <div class="md-form mb-5">
                  <i class="fas fa-envelope prefix grey-text"></i>
                  <input name="email" type="email" id="orangeForm-email" class="form-control validate">
                  <label data-error="wrong" data-success="right" for="orangeForm-email">Your email</label>
                </div>

                <div class="md-form mb-5">
                  <i class="fas fa-user prefix grey-text"></i>
                  <input name="cellPhone" type="text" id="orangeForm7" class="form-control validate w-50">
                  <label data-error="wrong" data-success="right" for="orangeForm-name">Cell Phone</label>
                </div>

                <div class="md-form mb-5">
                  <i class="fas fa-user prefix grey-text"></i>
                  <input name="street" type="text" id="orangeForm9" class="form-control validate">
                  <label data-error="wrong" data-success="right" for="orangeForm-name">Street</label>
                </div>

                <div class="md-form mb-5">
                  <i class="fas fa-user prefix grey-text"></i>
                  <input name="city" type="text" id="orangeForm10" class="form-control validate w-50">
                  <label data-error="wrong" data-success="right" for="orangeForm-name">City</label>
                </div>


                <div class="md-form mb-5">
                  <i class="fas fa-user prefix grey-text"></i>
                  <select name="state">
<!--                    <c:forEach var="state" items="${inventory.states}">

                      <option value="${state}">${state}</option>

                    </c:forEach>-->

                  </select>

                  <label data-error="wrong" data-success="right" for="orangeForm-name">State</label>
                </div>

                <div class="md-form mb-5">
                  <i class="fas fa-user prefix grey-text"></i>
                  <input name="zipCode" type="text" id="orangeForm-name" class="form-control validate w-25">
                  <label data-error="wrong" data-success="right" for="orangeForm-name">Zip Code</label>
                </div>



              </div>

            </div>
          </div>
          <div class="modal-footer d-flex justify-content-center">
            <input type="submit" class="btn btn-deep-orange">
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    data() {
      return {
        city : "",
        StreetAddress : "",
        State : "",
        Zip : "",
        ZipPlus : "",
        category : {
          'sss' : 'all',
          'ata' : 'antiques',
          'ppa' : 'appliances',
          'ara' : 'arts+crafts',
          'sna' : 'atvs/utvs/snow',
          'pta' : 'auto parts',
            'baa' : 'baby+kids',
          'bar' : 'barter',
          'haa' : 'beauty+hlth',
          'bip' : 'bike parts',
            'bia' : 'bikes',
          'bpa' : 'boat parts',
            'boo' : 'boats',
          'bka' : 'books',
          'bfa' : 'business',
          'cta' : 'cars+trucks',
          'ema' : 'cds/dvd/vhs',
          'moa' : 'cell phones',
            'cla' : 'clothes+acc',
          'cba' : 'collectibles',
          'syp' : 'computer parts',
            'sya' : 'computers',
          'ela' : 'electronics',
          'gra' : 'farm+garden',
          'zip' : 'free stuff',
            'fua' : 'furniture',
          'gms' : 'garage sales',
            'foa' : 'general',
          'hva' : 'heavy equipment',
            'hsa' : 'household',
          'jwa' : 'jewelry',
          'maa' : 'materials',
          'mpa' : 'motorcycle parts',
            'mca' : 'motorcycles',
          'msa' : 'music instr',
            'pha' : 'photo+video',
          'rva' : 'RVs',
          'sga' : 'sporting',
          'tia' : 'tickets',
          'tla' : 'tools',
          'taa' : 'toys+games',
          'vga' : 'video gaming',
            'waa' : 'wanted'
        }
      }
    },
    created() {
      this.$getLocation()
        .then(coor => {
          console.log(coor);
          axios.get(`https://geoservices.tamu.edu/Services/ReverseGeocoding/WebService/v04_01/Rest/?lat=${coor.lat}&lon=${coor.lng}&apikey=6c436e1250d34ec9b621e9d30eee2c9a&format=json&notStore=false&version=4.10`).then((res) => {
            try {
              let addr = res.data.StreetAddresses[0]
              console.log(addr)
              this.city = addr.City
              this.StreetAddress = addr.StreetAddress
              this.State = addr.State
              this.Zip = addr.Zip
              console.log(this.city);
            }
            catch(error) {
              console.error(error);
              // expected output: ReferenceError: nonExistentFunction is not defined
              // Note - error messages will vary depending on browser
            }
          })
            .catch((err) =>  {
              console.log(err)
            })
        });
    }
  }
</script>

<style>

</style>
