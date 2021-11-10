const { response } = require('express');
const { request } = require('http');

const mongodb = require('mongodb'),
      ObjectId = mongodb.ObjectId,
      express = require('express'),
      bcrypt = require('bcrypt'),
      app = express(),
      bodyParser = require('body-parser');
      app.use(bodyParser.urlencoded({
        extended: true
    }));
    




let MongoClient = mongodb.MongoClient;
let url ='mongodb://localhost:27017'
MongoClient.connect(url,{useNewUrlParser:true}, function(err,client){
    if (err ) {
        console.log('unable to connect',err);
    }
    else {

        app.post('/register' , async (req,res,next)=>{
            let post_data = req.body;
            let hashedpassword = await  bcrypt.hash(post_data.password, 10);
            let name = post_data.name;
            let email = post_data.email;
            let age = post_data.age;
           
            let insertJson = {
                'email':email,
                'name':name,
                'age':age,
                'password':hashedpassword
            };

            let db = client.db('endeavor');

            db.collection('user')
                .find({'email':email}).count(function(err,number){
                    if (number != 0){
                        res.json('email existe deja')
                        
                    }
                    else {
                        db.collection('user')
                            .insertOne(insertJson, function(err,res){
                                response.json('inscription effectuer');
                                console.log('inscription effectuer');
                            })
                    }
                })

        })

        //login

        app.post('/login' ,  (req,res,next)=>{ 
            let post_data = req.body;
            let email = post_data.email;
            let db = client.db('endeavor');

            
            db.collection('user').find({'email':email}).count(function(err,number){
                    if (number == 0){
                        res.json("email n'existe pas")
                        console.log("email n'existe pas");
                    }
                    else {
                        db.collection('user').findOne({'email':email}, async (err,user) =>{
                                try {

                                    if ( await bcrypt.compare(post_data.password, user.password )) {
                                        res.send('Success')
                                    }
                                    else{
                                        res.send('Not allowed');
                                    }
                                } catch {
                                    res.status(500).send()
                                }
                              
                            })
                    }
                })

        })



        app.listen(3000,()=>{
            console.log("Connected")
        })
    }
})








