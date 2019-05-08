<template>
  <div class="modal fade" id="modalAddCarForm" role="dialog" aria-labelledby="myModalLabel"
       aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">

        <div>



          <div class="modal-header text-center">
            <h4 class="modal-title w-100 font-weight-bold">Preferences</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>


          <div class="modal-body mx-3">

            <div class="md-form mb-4">

              <select name="category"  v-model="selectedCategory" class="form-control selectpicker">
                <option v-for="(v,key) in getCategory" :value="key">{{v}}</option>
              </select>

              <label data-error="wrong" data-success="right" for="orangeForm">Category</label>

            </div>


            <div class="md-form mb-4">

              <select @change="onStateChange" name="states" v-model="selectedState"  class="form-control selectpicker">
                <option v-for="(v,key) in getStates" :value="key">{{v}}</option>
              </select>

              <label data-error="wrong" data-success="right" for="orangeForm">State</label>

            </div>




            <div class="md-form mb-4">

              <select v-model="city" name="city" @change="onCityChange"  class="form-control selectpicker capitalize">
                <option class="capitalize" v-for="(item,index) in onAreas" :value="item.Description">{{item.Description}}</option>
              </select>

              <label data-error="wrong" data-success="right" for="orangeForm">City</label>
            </div>





            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
<!--
              <input  v-model="search" name="search" type="text" placeholder="Search anything..." id="orangeForm" class="form-control validate">
-->

              <vue-simple-suggest  :filter-by-query="true" :list="searches" v-model="search" placeholder="Search Anything..."></vue-simple-suggest>

              <label data-error="wrong" data-success="right" for="orangeForm">Search</label>
            </div>



            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input name="maxPrice" v-model="minPrice" type="number"  min="0"  class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm">Min Price</label>
            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <input name="minPrice" type="number" v-model="maxPrice"  min="0" class="form-control validate">
              <label data-error="wrong" data-success="right" for="orangeForm">Max Price</label>
            </div>

            <div class="md-form mb-5 form-group">
              <input v-model="options" type="checkbox" name="hasImage" id="hasImage" value="hasImage" />
              <div class="btn-group">
                <label for="hasImage" class="btn btn-outline-secondary">
                  <span><ok-icon></ok-icon></span>
                  <span></span>
                </label>
                <label for="hasImage" class="btn btn-outline-secondary active">
                  Has Image
                </label>
              </div>

              <input v-model="options" type="checkbox" name="notifyEmail" id="notifyEmail" value="notifyEmail" />
              <div class="btn-group">
                <label for="notifyEmail" class="btn btn-outline-secondary">
                  <span><ok-icon></ok-icon></span>
                  <span></span>
                </label>
                <label for="notifyEmail" class="btn btn-outline-secondary active">
                  Notify Email
                </label>
              </div>

              <input v-model="options" type="checkbox" name="notifyText" id="notifyText" value="notifyText" />
              <div class="btn-group">
                <label for="notifyText" class="btn btn-outline-secondary">
                  <span><ok-icon></ok-icon></span>
                  <span></span>
                </label>
                <label for="notifyText" class="btn btn-outline-secondary active">
                  Notify Text
                </label>
              </div>

            </div>


            <div v-if="options.includes('notifyEmail')" class="md-form mb-5 weekDays-selector">
              <h3>Email Options</h3>
              <hr>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="SUNDAY" id="weekday-sun-email"  class="weekday" />
              <label for="weekday-sun-email">S</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="MONDAY" id="weekday-mon-email"  class="weekday" />
              <label  for="weekday-mon-email">M</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="TUESDAY" id="weekday-tue-email"  class="weekday" />
              <label for="weekday-tue-email" >T</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="WEDNESDAY" id="weekday-wed-email"  class="weekday" />
              <label for="weekday-wed-email">W</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="THURSDAY"  id="weekday-thu-email" class="weekday" />
              <label for="weekday-thu-email">T</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="FRIDAY"  id="weekday-fri-email"   class="weekday" />
              <label for="weekday-fri-email">F</label>
              <input v-model="optionsEmail" type="checkbox" name="weekday-email" value="SATURDAY" id="weekday-sat-email"  class="weekday" />
              <label for="weekday-sat-email">S</label>
            </div>

            <div v-if="options.includes('notifyEmail')" class="md-form mb-5">
              <div v-for="(item,index) in optionsEmail">
                <p>{{item}} - From: <time-picker v-model="detailEmailTime[item].timeFrom"></time-picker> To: <time-picker v-model="detailEmailTime[item].timeTo"></time-picker>  <span><button @click="addDetails(item,detailEmailTime[item].timeFrom + '-' + detailEmailTime[item].timeTo,'email')" class="btn btn-sm btn-primary" >Add</button></span> </p>
                <vue-tags-input
                  v-model="tag"
                  :tags="detailEmailOpt[item]"
                  @tags-changed="newTags => tagChange(item,newTags,'email')"
                />
              </div>
            </div>

            <div v-if="options.includes('notifyText')" class="md-form mb-5 weekDays-selector">
              <h3>Text Options</h3>
              <hr>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="SUNDAY" id="weekday-sun-text"  class="weekday" />
              <label for="weekday-sun-text">S</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="MONDAY" id="weekday-mon-text" class="weekday" />
              <label for="weekday-mon-text">M</label>
              <input v-model="optionsText"  type="checkbox" name="weekday-text" value="TUESDAY" id="weekday-tue-text" class="weekday" />
              <label for="weekday-tue-text" >T</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="WEDNESDAY" id="weekday-wed-text" class="weekday" />
              <label  for="weekday-wed-text">W</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="THURSDAY" id="weekday-thu-text" class="weekday" />
              <label for="weekday-thu-text">T</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="FRIDAY" id="weekday-fri-text" class="weekday" />
              <label for="weekday-fri-text">F</label>
              <input v-model="optionsText" type="checkbox" name="weekday-text" value="SATURDAY" id="weekday-sat-text"  class="weekday" />
              <label for="weekday-sat-text">S</label>
            </div>

            <div v-if="options.includes('notifyText')" class="md-form mb-5">
              <div v-for="(item,index) in optionsText">
                <p>{{item}} - From: <time-picker v-model="detailTextTime[item].timeFrom"></time-picker> To: <time-picker v-model="detailTextTime[item].timeTo"></time-picker>  <span><button @click="addDetails(item,detailTextTime[item].timeFrom + '-' + detailTextTime[item].timeTo,'text')" class="btn btn-sm btn-primary" >Add</button></span> </p>
                <vue-tags-input
                  v-model="tag"
                  :tags="detailTextOpt[item]"
                  @tags-changed="newTags => tagChange(item,newTags,'text')"


                />
              </div>
            </div>

            <div class="md-form mb-5">
              <i class="fas fa-user prefix grey-text"></i>
              <textarea placeholder="Add Description" v-model="descp" name="descp" class="form-control validate" rows="5" id="comment"></textarea>

              <label data-error="wrong" data-success="right" for="orangeForm">Description</label>
            </div>





<!--            <div class="md-form mb-5 text-center">
              <div class="checkbox">
                <label>
                  <input type="checkbox" onclick="ChangeShip()" href="#moreabout" data-toggle="collapse" aria-expanded="false" aria-controls="moreabout" class="form-control" id="chShipAdd" name="isNewSeller" value="newSeller">
                  New Seller
                </label>
              </div>

            </div>-->

          </div>
          <div class="modal-footer d-flex justify-content-center">
           <!-- <input type="submit" class="btn btn-deep-orange">-->


            <button @click="sumbitInfo" data-toggle="modal" data-target="#modalAddCarForm" class="btn btn-deep-orange">Submit</button>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import {mapGetters} from 'vuex'
  import {CheckIcon} from 'vue-feather-icons'
  import VueSimpleSuggest from 'vue-simple-suggest'
  import 'vue-simple-suggest/dist/styles.css' // Optional CSS
  import moment from 'moment'




  moment().format();
  export default {
    data() {

      return {
        descp : "",
        stop : false,
        hostname : "anchorage",
        selectedCategory : "sss",
        searches : [],
        duplicate : false,
        timeTo : '11:59 PM',
        timeFrom : '12:00 AM',
        tag: '',
        detailEmailTime: {SUNDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},MONDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},TUESDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},WEDNESDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},THURSDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},FRIDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},SATURDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'}},
        detailTextTime : {SUNDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},MONDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},TUESDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},WEDNESDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},THURSDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},FRIDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'},SATURDAY : {timeFrom : '12:00 AM', timeTo : '11:59 PM'}},
        detailEmailOpt : {SUNDAY : [],MONDAY : [],TUESDAY : [],WEDNESDAY : [],THURSDAY : [],FRIDAY : [],SATURDAY : []},
        detailTextOpt : {SUNDAY : [],MONDAY : [],TUESDAY : [],WEDNESDAY : [],THURSDAY : [],FRIDAY : [],SATURDAY : []},
        optionsEmail : [],
        optionsText : [],
        options : [],
        search : "",
        maxPrice : 0,
        minPrice : 0,
        myCoords : {},
        selectedState : "AK",
        isLocation : false,
        city : "anchorage / mat-su",
        StreetAddress : "",
        State : "",
        Zip : "",
        ZipPlus : ""
      }
    },
    methods : {
      isEmpty(obj) {
        for(let key in obj) {
          if(obj.hasOwnProperty(key))
            return false;
        }
        return true;
      },

      assignTimeOpts(detailOpts,options,type) {
        let detailOpt = {} /*Object.assign({},this.detailEmailOpt)*/

        Object.entries(detailOpts).map((k) => {
          // console.log(k[0] + "," + k[1])
          //console.log(k)
          //console.log(k[0])
          //console.log(this.optionsEmail)

          //console.log(options.includes(k[0]))
          if(options.includes(k[0])) {
            //console.log("Work")
            let actTime = []
            detailOpts[k[0]].forEach(e =>  {

              let parsed = e.split('-')
              let timeFrom = parsed[0]
              let timeTo = parsed[1]


              timeFrom = moment(timeFrom,'HH:mm A')._d
              timeTo = moment(timeTo,'HH:mm A')._d

             // timeFrom = timeFrom.getHours() + "-" + timeFrom.getMinutes() + "-" + timeFrom.getSeconds()


              actTime.push({timeFrom,timeTo})



            })


            detailOpt[k[0]] = actTime

          }
        })

        //console.log("Details....")
        //console.log(detailOpt)

        //console.log(detailOpt)

        if(type == 'email') this.detailEmailOpt = Object.assign({},detailOpt)
        if(type == 'text') this.detailTextOpt = Object.assign({},detailOpt)
        //detailOpts = Object.assign({},detailOpt)
      },


      sumbitInfo() {


        this.assignTimeOpts(this.detailEmailOpt,this.optionsEmail,'email')
        this.assignTimeOpts(this.detailTextOpt,this.optionsText,'text')


        this.detailEmailOpt.name = "email"
        this.detailTextOpt.name = "phone"

      /*  console.log(this.detailEmailOpt)

        console.log(this.detailTextOpt)*/







        console.log("Info submitted")
        this.$store.dispatch('addPref', {
          category : this.selectedCategory,
          city : this.city,
          hasPic : this.options.includes('hasImage'),
          maxPrice : this.maxPrice,
          minPrice : this.minPrice,
          notifyEmail : this.options.includes('notifyEmail'),
          notifyPhone : this.options.includes('notifyText'),
          detailEmailOpt : this.detailEmailOpt,
          detailTextOpt : this.detailTextOpt,
          search : this.search,
          state : this.State,
          descp : this.descp,
          userId : this.getUserHashId.userId

        } )

      },
      isValidDate(d) {
            return d instanceof Date && !isNaN(d);
       },

      tagChange(item,newTags,opt) {
        let parsed = item.split('-')
        let timeFrom = parsed[0]
        let timeTo = parsed[1]

        let detailOpt = null

        if(opt == 'email') {
          detailOpt = this.detailEmailOpt
        }
        if(opt == 'text')
        {
          detailOpt = this.detailTextOpt
        }

        timeFrom = moment(timeFrom,'HH:mm A')._d
        timeTo = moment(timeTo,'HH:mm A')._d

/*        console.log("old tags length: "+this.detailEmailOpt[item].length)
        console.log("new tags length: "+newTags.length)

        console.log(item,newTags)*/

        if((this.isValidDate(timeFrom) && this.isValidDate(timeTo)) || detailOpt[item].length >= newTags.length) {
          detailOpt[item] = newTags
        }




      },
      onStateChange() {

        //this.city = this.onAreas.get(0).Description
       //console.log(this.onAreas[0])
        this.city = this.onAreas[0].Description
        this.hostname = this.onAreas[0].Hostname
      },
      onCityChange() {
        //console.log(this.city)
        //console.log(this.onAreas)
        let area = this.onAreas.filter(e => {
          if(e.Description == this.city) return e
        })[0]

        //console.log("My Area")
        //console.log(area)
        this.hostname = area.Hostname
      }
      ,
      distance(lat1, lon1, lat2, lon2) {
        let radlat1 = Math.PI * lat1/180
        let radlat2 = Math.PI * lat2/180
        let theta = lon1-lon2
        let radtheta = Math.PI * theta/180
        let dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
        if (dist > 1) {
          dist = 1;
        }
        dist = Math.acos(dist)
        dist = dist * 180/Math.PI
        dist = dist * 60 * 1.1515
        dist = dist * 1.609344
        //if (unit=="N") { dist = dist * 0.8684 }
        return dist
      },
      addDetails(item,timeFrame,opt) {
       // console.log(timeFrame)

        let temp = null
        let detailOpt = null


        if(opt == 'email') {
          detailOpt = this.detailEmailOpt
        }
        if(opt == 'text')
        {
          detailOpt = this.detailTextOpt
        }



        temp = [...detailOpt[item]]




      ///  console.log(this.detailEmailOpt)

        let parsed = timeFrame.split('-')
        let timeFrom = parsed[0]
        let timeTo = parsed[1]


        timeFrom = moment(timeFrom,'HH:mm A')._d
        timeTo = moment(timeTo,'HH:mm A')._d


/*        console.log("Time from: " + timeFrom)
        console.log("Time to: " + timeTo)*/

        let countTimeFrom = (timeFrom.getHours() * 60 * 60) + (timeFrom.getMinutes() * 60) + timeFrom.getSeconds()
        let countTimeTo = (timeTo.getHours() * 60 * 60) + (timeTo.getMinutes() * 60) + timeTo.getSeconds()

/*
        console.log("Time from: " + timeFrom.getHours())
        console.log("Time to: " + timeTo.getHours())


        console.log("Time from: " + timeFrom.getMinutes())
        console.log("Time to: " + timeTo.getMinutes())


        console.log("Time from: " + timeFrom.getSeconds())
        console.log("Time to: " + timeTo.getSeconds())

        console.log("Total time " + countTimeFrom)*/

       // console.log(temp)
       // console.log(this.detailEmailOpt[item])
        let status = false

        if(countTimeTo <= countTimeFrom) {
          status = true
        }

        temp.forEach((e,index) => {
          //console.log("My e: " + e + " My timeframe" + timeFrame)
          let parsed2 = e.split('-')
          let timeFrom2 = parsed2[0]
          let timeTo2 = parsed2[1]

          timeFrom2 = moment(timeFrom2,'HH:mm A')._d
          timeTo2 = moment(timeTo2,'HH:mm A')._d

          let countTimeFrom2 = (timeFrom2.getHours() * 60 * 60) + (timeFrom2.getMinutes() * 60) + timeFrom2.getSeconds()
          let countTimeTo2 = (timeTo2.getHours() * 60 * 60) + (timeTo2.getMinutes() * 60) + timeTo2.getSeconds()


          if(countTimeFrom >= countTimeFrom2 && countTimeTo <= countTimeTo2) {
            status = true
          }


          if(e == timeFrame) {
            status = true
          }




         /* console.log(countTimeFrom + "  " + countTimeFrom2)
          console.log(countTimeTo + "  " + countTimeTo2)*/


          if(countTimeFrom >= countTimeFrom2 && countTimeTo > countTimeTo2 && countTimeFrom < countTimeTo2) {
            detailOpt[item].splice(index, 1, parsed2[0] +  "-" + parsed[1])
            console.log("Log worked!!!: " + index)
            status = true
           // detailOpt[item].splice(index, 1)

            //detailOpt[item][index] = parsed[0] +  "-" + parsed2[1]
          }


          if(countTimeFrom < countTimeFrom2 && countTimeTo <= countTimeTo2 && countTimeTo > countTimeFrom2) {
            detailOpt[item].splice(index, 1, parsed[0] +  "-" + parsed2[1])
            //console.log("Log worked!!!: " + index)
            status = true
            // detailOpt[item].splice(index, 1)

            //detailOpt[item][index] = parsed[0] +  "-" + parsed2[1]
          }


          if(countTimeFrom < countTimeFrom2 && countTimeTo >= countTimeTo2) {
            detailOpt[item].splice(index, 1)
          }



         /* console.log(timeFrom > timeFrom2)
          console.log(timeFrom + " " + timeFrom2)
          console.log(timeTo <= timeTo2 )
          console.log(timeTo + " " + timeTo2)*/

        })



        if(!status) {
          detailOpt[item].push(timeFrame)
        }





      }
    },
    computed : {
    ...mapGetters([
        'getCors',
        'getRefAreas',
        'getStates',
        'getCategory',
        'getMyCors',
        'getUserHashId'
      ]),

      onAreas() {


          return this.getRefAreas.filter(e => {
            if(e.Region === this.selectedState) return e;
          })
      }

    },
    created() {
      this.$getLocation()
        .then(coor => {
          this.myCoords = coor
          //console.log(coor);
          axios.get(`${this.getMyCors}https://geoservices.tamu.edu/Services/ReverseGeocoding/WebService/v04_01/Rest/?lat=${coor.lat}&lon=${coor.lng}&apikey=6c436e1250d34ec9b621e9d30eee2c9a&format=json&notStore=false&version=4.10`).then((res) => {
            try {
              let addr = res.data.StreetAddresses[0]


              //console.log(addr)
              //this.city = addr.City
              this.StreetAddress = addr.StreetAddress
              this.State = addr.State
              this.selectedState = addr.State
              this.Zip = addr.Zip

              this.isLocation = true;

              //console.log(this.city);
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
    },
    components : {
      okIcon : CheckIcon,
      VueSimpleSuggest
    },
    watch : {
      timeFrom(value) {
        console.log("Time changed! to: " + value)
      },
      selectedState(value) {

        if(this.isLocation) {
          //console.log("Location is working!")
          let myArea = this.getRefAreas.filter(e => {
            if (e.Region === value) return e;
          })

          //console.log(this.myCoords)
          let closest = myArea.map(e => {

            return this.distance(this.myCoords.lat, this.myCoords.lng, e.Latitude, e.Longitude)
          })
          //console.log(closest)
          let closestIndex = closest.indexOf(Math.min(...closest))
          this.city = myArea[closestIndex].Description
         // console.log(myArea[closestIndex])
          this.hostname = myArea[closestIndex].Hostname
        }
      },
      detailEmailOpt : {
        handler(val){
/*          console.log("Changed")
          console.log(val)*/
          /*Object.entries(val).map((k,i) => {
           // console.log(k[0] + "," + k[1])
            k[1].forEach(e => {

              let parsed = e.split('-')
              let timeFrom = parsed[0]
              let timeTo = parsed[1]
              timeFrom = moment(timeFrom,'HH:mm A')._d
              timeTo = moment(timeTo,'HH:mm A')._d
             // console.log(timeFrom + " " + timeTo)



            })


          } )*/
        },
        deep: true
      },
      search(value) {
        //console.log("It is been search: " + value)
        value = this.search.split(' ').join('+')
        console.log(this.getMyCors)
        axios.get(`${this.getMyCors}https://${this.hostname}.craigslist.org/suggest?type=search&term=${value}&cat=${this.selectedCategory}`)
          .then(res => {
            //console.log(res)
            this.searches = res.data
          })
          .catch(err => {
            console.log(err)
          })
      }

    }
  }
</script>

<style scoped>
  .capitalize { text-transform: capitalize; }
  .form-group input[type="checkbox"] {
    display: none;
  }

  .form-group input[type="checkbox"] + .btn-group > label span {
    width: 20px;
  }

  .form-group input[type="checkbox"] + .btn-group > label span:first-child {
    display: none;
  }
  .form-group input[type="checkbox"] + .btn-group > label span:last-child {
    display: inline-block;
  }

  .form-group input[type="checkbox"]:checked + .btn-group > label span:first-child {
    display: inline-block;
  }
  .form-group input[type="checkbox"]:checked + .btn-group > label span:last-child {
    display: none;
  }

  .weekDays-selector input {
    display: none!important;
  }

  .weekDays-selector input[type=checkbox] + label {
    display: inline-block;
    border-radius: 6px;
    background: #dddddd;
    height: 40px;
    width: 30px;
    margin-right: 3px;
    line-height: 40px;
    text-align: center;
    cursor: pointer;
  }

  .weekDays-selector input[type=checkbox]:checked + label {
    background: #2AD705;
    color: #ffffff;
  }

</style>
