
var express = require("express");
const craigslist = require('node-craigslist');

var app = express();



app.get("/url", (req, res, next) => {
    const list = [];


    var
        craigslist = require('node-craigslist'),
        client = new craigslist.Client({
            city : 'seattle'
        }),
        options = {
            baseHost : '', // defaults to craigslist.org
            category : '', // defaults to sss (all)
            city : '',
            maxPrice : '200',
            minPrice : '100',
            postedToday : true
        };

    client
        .search(options, 'xbox one')
        .then((listings) => listings.forEach(   (l) => {
                list.push(
             client.details(l).then((r) => {
               // console.log(r)
                return r;
             }))

        } )).then(() => {
        Promise.all(list).then(values => {
            //console.log(values);
            res.json(values);
        });
        })

        .catch((err) => {
            console.error(err);
        });





});

app.listen(3000, () => {
    console.log("Server running on port 3000");
});